package com.atlassian.jwt.core.writer;

import com.atlassian.jwt.CanonicalHttpRequest;
import com.atlassian.jwt.JwtConstants;
import com.atlassian.jwt.core.HttpRequestCanonicalizer;
import com.atlassian.jwt.writer.JwtJsonBuilder;
import org.junit.Test;

import javax.annotation.Nonnull;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JwtClaimsBuilderTest
{
    @Test
    public void appendHttpRequestClaims() throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        CanonicalHttpRequest request = createRequest();
        JwtJsonBuilder jsonBuilder = new JsonSmartJwtJsonBuilder();
        JwtClaimsBuilder.appendHttpRequestClaims(jsonBuilder, request);

        assertThat(jsonBuilder.build(), is(new JsonSmartJwtJsonBuilder().claim(JwtConstants.Claims.QUERY_HASH, HttpRequestCanonicalizer.computeCanonicalRequestHash(request)).build()));
    }

    @Test(expected = NullPointerException.class)
    public void rejectsNullHttpRequest() throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        JwtClaimsBuilder.appendHttpRequestClaims(new JsonSmartJwtJsonBuilder(), null);
    }

    @Test(expected = NullPointerException.class)
    public void rejectsNullJsonBuilder() throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        JwtClaimsBuilder.appendHttpRequestClaims(null, createRequest());
    }

    private CanonicalHttpRequest createRequest()
    {
        return new CanonicalHttpRequest()
        {
            @Nonnull
            @Override
            public String getMethod()
            {
                return "GET";
            }

            @Override
            public String getRelativePath()
            {
                return "/path";
            }

            @Nonnull
            @Override
            public Map<String, String[]> getParameterMap()
            {
                return Collections.singletonMap("foo", new String[]{"bah"});
            }
        };
    }
}
