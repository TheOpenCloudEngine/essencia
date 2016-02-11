package com.atlassian.jwt.core.http;

import com.atlassian.jwt.CanonicalHttpRequest;

/**
 * An interface for objects capable of extracting a Jwt String from a request of type REQ
 * @param <REQ> the type of request that the extractor works with
 */
public interface JwtRequestExtractor<REQ>
{
    /**
     * Extracts a JWT string from the given request. The JWT string may be provided either as a request parameter (called 'jwt') or as
     * an Authorization header. If both are provided then the request parameter takes precedence.

     * @param request the request
     * @return the JWT String or null if no JWT in the request
     */
    String extractJwt(REQ request);

    /**
     * Returns a canonical form of the request
     * @param request the request
     * @return the canonical form
     */
    CanonicalHttpRequest getCanonicalHttpRequest(REQ request);
}
