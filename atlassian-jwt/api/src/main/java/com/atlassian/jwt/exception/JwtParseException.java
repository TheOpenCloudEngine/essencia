package com.atlassian.jwt.exception;

/**
 * Indicates that the JWT was not well-formed, e.g. the JWT JSON is invalid.
 *
 * @since 1.0
 */
public class JwtParseException extends Exception
{
    public JwtParseException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public JwtParseException(Exception cause)
    {
        super(cause);
    }

    public JwtParseException(String reason)
    {
        super(reason);
    }
}
