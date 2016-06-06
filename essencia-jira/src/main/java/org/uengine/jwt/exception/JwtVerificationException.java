package org.uengine.jwt.exception;

/**
 * Indicates a JWT was well-formed, but failed to validate.
 *
 * @since 1.0
 */
public abstract class JwtVerificationException extends Exception
{

    protected JwtVerificationException()
    {
    }

    protected JwtVerificationException(String message)
    {
        super(message);
    }

    protected JwtVerificationException(String message, Throwable cause)
    {
        super(message, cause);
    }

    protected JwtVerificationException(Throwable cause)
    {
        super(cause);
    }

}
