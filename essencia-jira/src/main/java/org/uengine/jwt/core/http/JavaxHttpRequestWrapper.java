package org.uengine.jwt.core.http;

import org.uengine.jwt.CanonicalHttpRequest;
import org.uengine.jwt.httpclient.CanonicalHttpServletRequest;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Enumeration;

/**
 * An implementation of HttpRequestWrapper for javax.servlet.http.HttpServletRequest
 */
// trying to avoid name conflict with javax.servlet.HttpServletRequestWrapper
public class JavaxHttpRequestWrapper implements HttpRequestWrapper
{
    private final HttpServletRequest request;

    public JavaxHttpRequestWrapper(HttpServletRequest request)
    {
        this.request = request;
    }

    @Override
    public String getParameter(String parameterName)
    {
        return request.getParameter(parameterName);
    }

    @Nonnull
    @Override
    @SuppressWarnings(value = "unchecked")
    public Iterable<String> getHeaderValues(String headerName)
    {
        /*
         * TODO: consider moving to CanonicalHttpRequest as part of ACDEV-375 / ACDEV-374
         */
        Enumeration headers = request.getHeaders(headerName);
        return headers != null ? Collections.list(headers) : Collections.emptyList();
    }

    @Nonnull
    @Override
    public CanonicalHttpRequest getCanonicalHttpRequest()
    {
        return new CanonicalHttpServletRequest(request);
    }
}
