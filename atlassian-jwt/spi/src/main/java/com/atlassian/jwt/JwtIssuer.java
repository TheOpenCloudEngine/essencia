package com.atlassian.jwt;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @since 1.3
 */
public interface JwtIssuer
{
    @Nonnull
    String getName();

    @Nullable
    String getSharedSecret();
}
