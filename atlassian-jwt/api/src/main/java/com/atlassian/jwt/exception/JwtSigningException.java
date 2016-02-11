package com.atlassian.jwt.exception;

/**
 * Thrown if a problem was encountered while signing a JWT.
 *
 * @since 1.0
 */
public class JwtSigningException extends RuntimeException
{
    public JwtSigningException(Exception cause)
    {
        super(cause);
    }
}
