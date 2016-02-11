package com.atlassian.jwt.writer;

import com.atlassian.jwt.AsymmetricSigningInfo;
import com.atlassian.jwt.SigningAlgorithm;
import com.atlassian.jwt.SymmetricSigningInfo;

import javax.annotation.Nonnull;

/**
 * Factory for {@link JwtJsonBuilderFactory}.
 *
 * @since 1.0
 */
public interface JwtWriterFactory
{
    @Nonnull
    JwtWriter macSigningWriter(@Nonnull SigningAlgorithm algorithm, @Nonnull String sharedSecret);

    @Nonnull
    JwtWriter signingWriter(@Nonnull SymmetricSigningInfo signingInfo);

    @Nonnull
    JwtWriter signingWriter(@Nonnull AsymmetricSigningInfo signingInfo);
}
