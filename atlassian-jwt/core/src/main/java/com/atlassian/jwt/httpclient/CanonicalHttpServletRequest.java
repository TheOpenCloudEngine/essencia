package com.atlassian.jwt.httpclient;

import com.atlassian.jwt.CanonicalHttpRequest;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class CanonicalHttpServletRequest implements CanonicalHttpRequest
{
    private final HttpServletRequest request;

    public CanonicalHttpServletRequest(final HttpServletRequest request)
    {
        this.request = request;
    }

    @Nonnull
    @Override
    public String getMethod()
    {
        return request.getMethod();
    }

    @Override
    public String getRelativePath()
    {
        return StringUtils.removeStart(request.getRequestURI(), request.getContextPath());
    }

    @Nonnull
    @Override
    @SuppressWarnings("unchecked") // the javadoc on HttpServletRequest.getParameterMap() says that the return type is Map<String, String[]>
    public Map<String, String[]> getParameterMap()
    {
        return request.getParameterMap();
    }
}
