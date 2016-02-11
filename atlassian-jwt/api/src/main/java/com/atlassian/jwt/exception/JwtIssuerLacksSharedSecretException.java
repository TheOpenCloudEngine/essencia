package com.atlassian.jwt.exception;

/**
 * Thrown if a JWT requires a shared secret to sign or verify (e.g. HMAC algorithms) but the claimed issuer has no associated shared secret.
 *
 * @since 1.0
 */
public class JwtIssuerLacksSharedSecretException extends Exception
{
    public JwtIssuerLacksSharedSecretException(String issuer)
    {
        super(issuer);
    }
}
