package com.atlassian.jwt.writer;

import javax.annotation.Nonnull;

/**
 * Interface for writing a (custom) claim to a JWT.
 *
 * @since 2.0
 */
public interface JwtClaimWriter {
    /**
     * @param builder the builder to write the claim to
     */
    void write(@Nonnull JwtJsonBuilder builder);
}
