package org.uengine.jwt.core.http;

import org.uengine.jwt.CanonicalHttpRequest;
import org.apache.commons.lang.StringUtils;

import static org.uengine.jwt.JwtConstants.HttpRequests.AUTHORIZATION_HEADER;
import static org.uengine.jwt.JwtConstants.HttpRequests.JWT_AUTH_HEADER_PREFIX;
import static org.uengine.jwt.JwtConstants.JWT_PARAM_NAME;

/**
 * An abstract implementation of JwtRequestExtractor that supports jwt as a request parameter (called 'jwt') and as
 * an Authorization header. Subclasses need to override #wrapRequest
 *
 * @param <REQ> the type of request that the extractor works with
 */
public abstract class AbstractJwtRequestExtractor<REQ> implements JwtRequestExtractor<REQ>
{
    @Override
    public String extractJwt(REQ request)
    {
        return new JwtDefaultRequestHelper(wrapRequest(request)).extractJwt();
    }

    @Override
    public CanonicalHttpRequest getCanonicalHttpRequest(REQ request)
    {
        return wrapRequest(request).getCanonicalHttpRequest();
    }


    /**
     * Override to create the appropriate wrapper for the request
     * @param request the request
     * @return the wrapped request
     */
    protected abstract HttpRequestWrapper wrapRequest(REQ request);

    private static class JwtDefaultRequestHelper
    {
        private final HttpRequestWrapper requestWrapper;

        public JwtDefaultRequestHelper(HttpRequestWrapper requestWrapper)
        {
            this.requestWrapper = requestWrapper;
        }

        public String extractJwt()
        {
            String jwt = getJwtParameter();
            if (jwt == null)
            {
                jwt = getJwtHeaderValue();
            }
            return jwt;
        }

        private String getJwtParameter()
        {
            String jwtParam = requestWrapper.getParameter(JWT_PARAM_NAME);
            return StringUtils.isEmpty(jwtParam) ? null : jwtParam;
        }

        private String getJwtHeaderValue()
        {
            Iterable<String> headers = requestWrapper.getHeaderValues(AUTHORIZATION_HEADER);
            for (String header : headers)
            {
                String authzHeader = header.trim();
                String first4Chars = authzHeader.substring(0, Math.min(4, authzHeader.length()));
                if (JWT_AUTH_HEADER_PREFIX.equalsIgnoreCase(first4Chars))
                {
                    return authzHeader.substring(4);
                }
            }

            return null;
        }
    }
}
