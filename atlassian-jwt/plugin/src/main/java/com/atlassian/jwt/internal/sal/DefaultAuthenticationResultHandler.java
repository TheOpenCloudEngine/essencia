package com.atlassian.jwt.internal.sal;

import com.atlassian.jwt.Jwt;
import com.atlassian.jwt.core.http.auth.AuthenticationResultHandler;
import com.atlassian.sal.api.auth.Authenticator.Result;
import com.atlassian.sal.api.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;

/**
 * Handles authentication results for requests relating a registered JWT issuer
 */
public class DefaultAuthenticationResultHandler implements AuthenticationResultHandler<HttpServletResponse, Result>
{
    private static final Logger log = LoggerFactory.getLogger(DefaultAuthenticationResultHandler.class);

    @Override
    public Result createAndSendInternalError(Exception e, HttpServletResponse response, String externallyVisibleMessage)
    {
        // the internal error could give away runtime details that could be useful in an attack, so don't display it externally
        return createAndSendError(e, response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, externallyVisibleMessage);
    }

    @Override
    public Result createAndSendBadRequestError(Exception e, HttpServletResponse response, String externallyVisibleMessage)
    {
        // the message will probably be seen by add-on vendors during add-on development
        return createAndSendError(e, response, HttpServletResponse.SC_BAD_REQUEST, externallyVisibleMessage);
    }

    @Override
    public Result createAndSendUnauthorisedFailure(Exception e, HttpServletResponse response, String externallyVisibleMessage)
    {
        // the jwt has good syntax but was rejected, and was not rejected due to the user or issuer specifically
        return createAndSendFailure(e, response, HttpServletResponse.SC_UNAUTHORIZED, externallyVisibleMessage);
    }

    @Override
    public Result createAndSendForbiddenError(Exception e, HttpServletResponse response)
    {
        // this is the default error response, so the message is quite general
        return createAndSendError(e, response, HttpServletResponse.SC_FORBIDDEN, "Access to this resource is forbidden without successful authentication. Please supply valid credentials.");
    }

    @Override
    public Result success(String message, Principal principal, Jwt authenticatedJwt)
    {
        return new Result.Success(createMessage(message), principal);
    }

    private static Result.Error createAndSendError(Exception e, HttpServletResponse response, int httpResponseCode, String externallyVisibleMessage)
    {
        log.debug("Error during JWT authentication: ", e);
        sendErrorResponse(response, httpResponseCode, externallyVisibleMessage);
        return new Result.Error(createMessage(e.getLocalizedMessage()));
    }

    private static Result.Failure createAndSendFailure(Exception e, HttpServletResponse response, int httpResponseCode, String externallyVisibleMessage)
    {
        log.debug("Failure during JWT authentication: ", e);
        sendErrorResponse(response, httpResponseCode, externallyVisibleMessage);
        return new Result.Failure(createMessage(e.getLocalizedMessage()));
    }

    private static void sendErrorResponse(HttpServletResponse response, int httpResponseCode, String externallyVisibleMessage)
    {
        response.reset();

        try
        {
            response.sendError(httpResponseCode, externallyVisibleMessage);
        }
        catch (IOException doubleFacePalm)
        {
            log.error("Encountered IOException while trying to report an authentication failure.", doubleFacePalm);
            response.reset();
            response.setStatus(httpResponseCode); // no error message, but hopefully the response code will still be useful
        }
    }

    private static Message createMessage(final String message)
    {
        return new Message()
        {
            @Override
            public String getKey()
            {
                return message;
            }

            @Override
            public Serializable[] getArguments()
            {
                return null;
            }

            @Override
            public String toString()
            {
                return message;
            }
        };
    }

}
