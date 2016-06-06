package org.uengine.jwt.core.reader;

import org.uengine.jwt.exception.JwtIssuerLacksSharedSecretException;
import org.uengine.jwt.exception.JwtUnknownIssuerException;

import javax.annotation.Nonnull;

/**
 * Retrieves the shared secret for a specified JWT issuer.
 * Along with {@link JwtIssuerValidator} this interface disambiguates a valid issuer that does not have a
 * shared secret from an unknown issuer (which would also not have a shared secret).
 *
 * @since 1.0
 */
public interface JwtIssuerSharedSecretService
{
    /**
     * @param issuer the issuer as specified in the JWT "iss" claim
     * @return the shared secret for the specified JWT issuer
     * @throws JwtIssuerLacksSharedSecretException if the issuer is not associated with a shared secret
     * @throws JwtUnknownIssuerException if the issuer is unrecognized
     */
    String getSharedSecret(@Nonnull String issuer) throws JwtIssuerLacksSharedSecretException, JwtUnknownIssuerException;
}
