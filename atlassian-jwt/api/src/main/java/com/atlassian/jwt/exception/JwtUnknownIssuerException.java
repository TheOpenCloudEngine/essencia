package com.atlassian.jwt.exception;

/**
 * Thrown if the issuer is not known (e.g. on receipt of a JWT containing an "iss" claim with an unrecognized value).
 *
 * @since 1.0
 */
public class JwtUnknownIssuerException extends Exception
{
    public JwtUnknownIssuerException(String issuer)
    {
        super(issuer);
    }
}
