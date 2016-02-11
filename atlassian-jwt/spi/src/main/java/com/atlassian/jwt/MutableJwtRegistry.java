package com.atlassian.jwt;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface MutableJwtRegistry extends JwtIssuerRegistry
{
    @Nonnull
    JwtIssuer addIssuer(@Nonnull String issuerName, @Nonnull String sharedSecret);

    boolean removeIssuer(@Nonnull String issuerName);

    @Nullable
    JwtIssuer getIssuer(@Nonnull String issuer);
}
