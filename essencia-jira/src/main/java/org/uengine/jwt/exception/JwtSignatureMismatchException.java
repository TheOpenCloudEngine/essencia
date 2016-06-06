package org.uengine.jwt.exception;

/**
 * Indicates that the JWT's signature does not match its contents or the shared secret for the specified issuer.
 *
 * @since 1.0
 */
public class JwtSignatureMismatchException extends JwtVerificationException
{
    public JwtSignatureMismatchException(Exception cause)
    {
        super(cause);
    }

    public JwtSignatureMismatchException(String reason)
    {
        super(reason);
    }
}
