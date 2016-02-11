package com.atlassian.jwt.httpclient;

import com.atlassian.jwt.CanonicalHttpRequest;
import com.atlassian.jwt.JwtConstants;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CanonicalHttpServletRequestTest
{
    @Test
    public void testMethod()
    {
        assertThat(request.getMethod(), is("GET"));
    }

    @Test
    public void testRelativePath()
    {
        assertThat(request.getRelativePath(), is(RESOURCE_PATH.substring(CONTEXT_PATH.length())));
    }

    @Test
    public void testQueryParameters()
    {
        assertThat(request.getParameterMap(), is(QUERY_PARAMS));
    }

    private static final Map<String, String[]> QUERY_PARAMS = createQueryParameters();
    private static final String RESOURCE_PATH = "/context/path/to/service/";
    private static final String CONTEXT_PATH = "/context";
    private static CanonicalHttpRequest request;

    @BeforeClass
    public static void beforeAllTests()
    {
        request = new CanonicalHttpServletRequest(createHttpServletRequest());
    }

    private static HttpServletRequest createHttpServletRequest()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getMethod()).thenReturn("GET");
        when(request.getContextPath()).thenReturn(CONTEXT_PATH);
        when(request.getRequestURI()).thenReturn(RESOURCE_PATH);
        when(request.getParameterMap()).thenReturn(QUERY_PARAMS);
        return request;
    }

    private static Map<String, String[]> createQueryParameters()
    {
        Map<String, String[]> queryParameters = new HashMap<String, String[]>();
        queryParameters.put("zee_last", new String[]{"param"});
        queryParameters.put("repeated", new String[]{"parameter 1","parameter 2"});
        queryParameters.put("first", new String[]{"param"});
        queryParameters.put(JwtConstants.JWT_PARAM_NAME, new String[]{"should.be.ignored"});
        return queryParameters;
    }
}
