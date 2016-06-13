package org.uengine.jwt.exception;

import java.util.Date;

/**
 * Thrown if the JWT's timestamps show that it has expired.
 *
 * @since 1.0
 */
public class JwtExpiredException extends JwtVerificationException
{
    public JwtExpiredException(Date expiredAt, Date now, final int leewaySeconds)
    {
        super(String.format("Expired at %s and time is now %s (%d seconds leeway is allowed)", expiredAt, now, leewaySeconds));
    }
}
