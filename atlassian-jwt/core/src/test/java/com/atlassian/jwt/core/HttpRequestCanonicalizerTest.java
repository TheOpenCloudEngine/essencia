package com.atlassian.jwt.core;

import com.atlassian.jwt.CanonicalHttpRequest;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.atlassian.jwt.core.HttpRequestCanonicalizer.canonicalize;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class HttpRequestCanonicalizerTest
{
    @Test
    public void computeCorrectCanonicalizedQuery() throws UnsupportedEncodingException
    {
        assertThat(canonicalize(REQUEST), is(EXPECTED));
    }

    @Test
    public void computeCorrectCanonicalQueryWhenThereIsNoContextPath() throws UnsupportedEncodingException
    {
        assertThat(canonicalize(REQUEST_WITH_NO_CONTEXT_PATH), is(EXPECTED_WHEN_THERE_IS_NO_CONTEXT_PATH));
    }

    @Test
    public void computeCorrectCanonicalizedQueryWhenThereAreRepeatedParameters() throws UnsupportedEncodingException
    {
        assertThat(canonicalize(REQUEST_WITH_REPEATED_PARAMS), is(EXPECTED_WHEN_THERE_ARE_REPEATED_PARAMS));
    }

    @Test
    public void computeCorrectCanonicalizedQueryWhenThereAreNoParameters() throws UnsupportedEncodingException
    {
        assertThat(canonicalize(REQUEST_WITH_NO_PARAMS), is(EXPECTED_WHEN_THERE_ARE_NO_PARAMS));
    }

    @Test
    public void computeCorrectCanonicalizedQueryWhenThereAreManyParameters() throws UnsupportedEncodingException
    {
        assertThat(canonicalize(REQUEST_WITH_MANY_PARAMS), is(EXPECTED_WHEN_THERE_ARE_MANY_PARAMS));
    }
    
    @Test
    public void computeCorrectCanonicalizedQueryWhenSpaceInParameter() throws UnsupportedEncodingException
    {
        assertThat(canonicalize(createGetRequest("/some/path", Collections.singletonMap("foo", new String[]{"bah bah"}))), is("GET&/some/path&foo=bah%20bah"));
    }

    @Test
    public void computeCorrectCanonicalizedQueryWhenPlusInParameter() throws UnsupportedEncodingException
    {
        assertThat(canonicalize(createGetRequest("/some/path", Collections.singletonMap("foo", new String[]{"bah+bah"}))), is("GET&/some/path&foo=bah%2Bbah"));
    }

    @Test
    public void computeCanonicalRequestHashFromValidRequest() throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        CanonicalHttpRequest request = createGetRequest("/path", Collections.singletonMap("foo", new String[]{"bah"}));
        assertThat(HttpRequestCanonicalizer.computeCanonicalRequestHash(request), is(JwtUtil.computeSha256Hash(canonicalize(request))));
    }

    @Test(expected = NullPointerException.class)
    public void willNotComputeHashForNullHttpRequest() throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        HttpRequestCanonicalizer.computeCanonicalRequestHash(null);
    }

    @Test
    public void ampersandsInPathDoNotResultInCollidingCanonicalQueries() throws UnsupportedEncodingException
    {
        CanonicalHttpRequest request1 = createGetRequest("/rest/api/2/project&a=b", ImmutableMap.of("x", new String[]{"y"}));
        CanonicalHttpRequest request2 = createGetRequest("/rest/api/2/project", ImmutableMap.of("a", new String[]{"b"}, "x", new String[]{"y"}));
        assertThat(canonicalize(request1), is(not(canonicalize(request2))));
    }

    @Test
    public void ampersandsInPathAreNotRegardedAsQueryParams() throws UnsupportedEncodingException
    {
        CanonicalHttpRequest request1 = createGetRequest("/rest/api/2/project&a=b");
        CanonicalHttpRequest request2 = createGetRequest("/rest/api/2/project", ImmutableMap.of("a", new String[]{"b"}));
        assertThat(canonicalize(request1), is(not(canonicalize(request2))));
    }

    @Test
    public void ampersandsInPathAreEncoded() throws UnsupportedEncodingException
    {
        assertThat(canonicalize(createGetRequest("/some/path&a=b")), is("GET&/some/path%26a=b&"));
    }

    @Test
    public void ampersandsInCanonicalQueryParamsStringAreNotEncoded() throws UnsupportedEncodingException
    {
        assertThat(canonicalize(createGetRequest("/some/path&a=b", ImmutableMap.of("x", new String[]{"y"}))), is("GET&/some/path%26a=b&x=y"));
    }

    private final static String EXPECTED = "GET&/and/more&foo=bah";
    private final static String EXPECTED_WHEN_THERE_IS_NO_CONTEXT_PATH = "PUT&/simple&foo=bah";
    private final static String EXPECTED_WHEN_THERE_ARE_REPEATED_PARAMS = "POST&/simple&foo=bah,humbug";
    private final static String EXPECTED_WHEN_THERE_ARE_NO_PARAMS = "GET&/simple&";
    private final static String EXPECTED_WHEN_THERE_ARE_MANY_PARAMS = "GET&/and/more&first=param1&foo=bah,humbug&last=param%201,param%202";

    private CanonicalHttpRequest createGetRequest(final String path)
    {
        return createGetRequest(path, ImmutableMap.<String, String[]>of());
    }

    private CanonicalHttpRequest createGetRequest(final String path, final Map<String, String[]> params)
    {
        return new CanonicalHttpRequest()
        {
            @Nonnull
            @Override
            public String getMethod()
            {
                return "GET";
            }

            @Nullable
            @Override
            public String getRelativePath()
            {
                return path;
            }

            @Nonnull
            @Override
            public Map<String, String[]> getParameterMap()
            {
                return params;
            }
        };
    }

    private final static CanonicalHttpRequest REQUEST = new CanonicalHttpRequest()
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
            return "/and/more";
        }

        @Nonnull
        @Override
        public Map<String, String[]> getParameterMap()
        {
            return Collections.singletonMap("foo", new String[]{"bah"});
        }
    };

    private static final CanonicalHttpRequest REQUEST_WITH_NO_CONTEXT_PATH = new CanonicalHttpRequest()
    {
        @Nonnull
        @Override
        public String getMethod()
        {
            return "PUT";
        }

        @Override
        public String getRelativePath()
        {
            return "/simple";
        }

        @Nonnull
        @Override
        public Map<String, String[]> getParameterMap()
        {
            return Collections.singletonMap("foo", new String[]{"bah"});
        }
    };

    private static final CanonicalHttpRequest REQUEST_WITH_REPEATED_PARAMS = new CanonicalHttpRequest()
    {
        @Nonnull
        @Override
        public String getMethod()
        {
            return "POST";
        }

        @Override
        public String getRelativePath()
        {
            return "/simple";
        }

        @Nonnull
        @Override
        public Map<String, String[]> getParameterMap()
        {
            return Collections.singletonMap("foo", new String[]{ "humbug", "bah" });
        }
    };

    private static final CanonicalHttpRequest REQUEST_WITH_NO_PARAMS = new CanonicalHttpRequest()
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
            return "/simple";
        }

        @Nonnull
        @Override
        public Map<String, String[]> getParameterMap()
        {
            return Collections.emptyMap();
        }
    };

    private static final CanonicalHttpRequest REQUEST_WITH_MANY_PARAMS = new CanonicalHttpRequest()
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
            return "/and/more/";
        }

        @Nonnull
        @Override
        public Map<String, String[]> getParameterMap()
        {
            Map<String, String[]> params = new HashMap<String, String[]>();
            params.put("foo", new String[]{ "humbug", "bah" });
            params.put("first", new String[]{ "param1" });
            params.put("last", new String[]{ "param 2", "param 1" });
            return params;
        }
    };
}
