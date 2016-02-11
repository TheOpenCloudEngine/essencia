package com.atlassian.jwt;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @since 1.3
 */
public interface JwtIssuerRegistry
{
    @Nullable
    JwtIssuer getIssuer(@Nonnull String issuer);
}
