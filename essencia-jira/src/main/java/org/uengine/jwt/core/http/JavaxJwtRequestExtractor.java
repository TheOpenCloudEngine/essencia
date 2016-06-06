package org.uengine.jwt.core.http;

import javax.servlet.http.HttpServletRequest;

/**
 * An implementation of JwtRequestExtractor for javax.servlet.http.HttpServletRequest
 */
public class JavaxJwtRequestExtractor extends AbstractJwtRequestExtractor<HttpServletRequest>
{
    protected JavaxHttpRequestWrapper wrapRequest(HttpServletRequest request)
    {
        return new JavaxHttpRequestWrapper(request);
    }
}
