package com.atlassian.jwt.writer;

import javax.annotation.Nonnull;

/**
 * Factory for {@link JwtJsonBuilder}.
 *
 * @since 1.0
 */
public interface JwtJsonBuilderFactory
{
    /**
     * @return a {@link JwtJsonBuilder}.
     */
    @Nonnull
    JwtJsonBuilder jsonBuilder();
}
