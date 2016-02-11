package com.atlassian.jwt.core.reader;

/**
 * States whether or not the specified issuer is valid.
 * Commonly, "valid" means that the JWT "iss" claim refers to an entity with an established relationship with this code
 * (for example, one has been installed as an add-on to the other).
 * Along with {@link JwtIssuerSharedSecretService} this interface disambiguates a valid issuer that does not have a
 * shared secret from an unknown issuer (which would also not have a shared secret).
 *
 * @since 1.0
 */
public interface JwtIssuerValidator
{
    /**
     * @param issuer the issuer as specified in the JWT "iss" claim
     * @return true if the issuer is "valid", false otherwise
     */
    boolean isValid(String issuer);
}
