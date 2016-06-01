package org.uengine.jwt.core.http.auth;

import org.uengine.jwt.Jwt;

import java.security.Principal;

/**
 * Handler for results of Jwt authentication for response objects of type R and status objects of type S
 *
 * @param <R> the type of the response object
 * @param <S> the type of the status object
 */
public interface AuthenticationResultHandler<R, S>
{
    /**
     * Creates and sends an internal error response and returns a corresponding status
     *
     * @param e                        the exception that occurred
     * @param response                 the response object to send the error response to
     * @param externallyVisibleMessage the message to be passed in the response
     * @return the status object reflecting the error
     */
    S createAndSendInternalError(Exception e, R response, String externallyVisibleMessage);

    /**
     * Creates and sends an bad request response and returns a corresponding status
     *
     * @param e                        the exception that occurred
     * @param response                 the response object to send the error response to
     * @param externallyVisibleMessage the message to be passed in the response
     * @return the status object reflecting the error
     */
    S createAndSendBadRequestError(Exception e, R response, String externallyVisibleMessage);

    /**
     * Creates and sends an authorisation failure response and returns a corresponding status
     *
     * @param e                        the exception that occurred
     * @param response                 the response object to send the error response to
     * @param externallyVisibleMessage the message to be passed in the response
     * @return the status object reflecting the error
     */
    S createAndSendUnauthorisedFailure(Exception e, R response, String externallyVisibleMessage);

    /**
     * Creates and sends a forbidden response and returns a corresponding status
     *
     * @param e        the exception that occurred
     * @param response the response object to send the error response to
     * @return the status object reflecting the error
     */
    S createAndSendForbiddenError(Exception e, R response);

    /**
     * Handles a successful authentication
     *
     * @param message a message indicating the successful outcome
     * @param principal the authenticated principal
     * @param authenticatedJwt the authenticated JWT result
     * @return a success status
     */
    S success(String message, Principal principal, Jwt authenticatedJwt);
}
