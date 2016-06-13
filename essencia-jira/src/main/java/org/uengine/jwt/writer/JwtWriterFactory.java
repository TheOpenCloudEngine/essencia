package org.uengine.jwt.writer;

import org.uengine.jwt.AsymmetricSigningInfo;
import org.uengine.jwt.SigningAlgorithm;
import org.uengine.jwt.SymmetricSigningInfo;

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
