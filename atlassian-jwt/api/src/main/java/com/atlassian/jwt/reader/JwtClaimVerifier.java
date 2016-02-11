package com.atlassian.jwt.reader;

import com.atlassian.jwt.exception.JwtParseException;
import com.atlassian.jwt.exception.JwtVerificationException;

import javax.annotation.Nonnull;

/**
 * Interface for asserting that a JWT claim is valid.
 * Implementations include straightforward equality checking and verification of signatures.
 *
 * @since 1.0
 */
public interface JwtClaimVerifier
{
    /**
     * Assert that the claimed value is valid.
     * @param claim The value of the JWT claim.
     * @throws JwtVerificationException if the claim is invalid or could not be verified
     * @throws JwtParseException if the claim cannot be parsed
     */
    public void verify(@Nonnull Object claim) throws JwtVerificationException, JwtParseException;
}
