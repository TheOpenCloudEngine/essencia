package com.atlassian.jwt.applinks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.atlassian.applinks.api.ApplicationLink;

public interface JwtApplinkFinder
{
    /**
     * Find an {@link ApplicationLink} with the given add-on id that uses JWT authentication.
     *
     * @param addOnId AKA the "plugin key"
     * @return the first matching {@link ApplicationLink} or {@code null}  if there are no matches
     * @throws IllegalArgumentException if the id argument is {@code null}
     */
    @Nullable
    ApplicationLink find(@Nonnull String addOnId);
}
