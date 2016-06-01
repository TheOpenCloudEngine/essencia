package org.uengine.jwt.core.http.auth;

/**
 * An authenticator of requests secured by JWT claims for requests of type REQ.
 *
 * @param <REQ> The type of the request
 * @param <RES> The type of the response
 * @param <S>   The type of the status object
 */
public interface JwtAuthenticator<REQ, RES, S>
{
    /**
     * Authenticate the incoming request, returning the status if possible.
     * On bad input or internal failure return a non-success status and return a non-success HTTP response code to
     * {@code response}.
     * Response codes match OAuth:
     * <ul>
     *     <li>parse error / garbled --&gt; 400 bad request</li>
     *     <li>good syntax but purposefully rejected --&gt; 401 unauthorised</li>
     *     <li>failure to compute a result --&gt; 500 internal server error</li>
     *     <li>rate limiting (not handled here) --&gt; 503 service unavailable</li>
     *     <li>default --&gt; 403 forbidden</li>
     * </ul>
     *
     * @param request  the request to be vetted
     * @param response the response to be send error code if and only if the authentication is unsuccessful
     * @return a status value representing the success, failure or error of the authentication attempt
     */
    S authenticate(REQ request, RES response);
}
