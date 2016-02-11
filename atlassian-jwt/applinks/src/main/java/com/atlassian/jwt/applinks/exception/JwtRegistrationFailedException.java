package com.atlassian.jwt.applinks.exception;

import com.atlassian.applinks.api.ApplicationLink;

/**
 * Thrown if issuing credentials to a {@link ApplicationLink linked application} failed.
 *
 * @since 1.0
 */
public class JwtRegistrationFailedException extends Exception
{
    public JwtRegistrationFailedException(String message)
    {
        super(message);
    }

    public JwtRegistrationFailedException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public JwtRegistrationFailedException(Throwable cause)
    {
        super(cause);
    }

}
