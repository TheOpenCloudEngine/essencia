package com.atlassian.jwt.exception;

/**
 * Thrown if an incoming JWT is signed using an unsupported algorithm.
 *
 * @since 1.0
 */
public class JwsUnsupportedAlgorithmException extends JwtVerificationException
{
    public JwsUnsupportedAlgorithmException(String message)
    {
        super(message);
    }

    public JwsUnsupportedAlgorithmException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public JwsUnsupportedAlgorithmException(Throwable cause)
    {
        super(cause);
    }
}
