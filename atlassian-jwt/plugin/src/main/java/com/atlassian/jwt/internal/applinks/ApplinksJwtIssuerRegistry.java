package com.atlassian.jwt.internal.applinks;

import com.atlassian.applinks.api.ApplicationLink;
import com.atlassian.jwt.JwtIssuerRegistry;
import com.atlassian.jwt.applinks.JwtApplinkFinder;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Registry of JWT issuers backed by application links
 */
public class ApplinksJwtIssuerRegistry implements JwtIssuerRegistry
{
    private final JwtApplinkFinder jwtApplinkFinder;

    public ApplinksJwtIssuerRegistry(JwtApplinkFinder jwtApplinkFinder)
    {
        this.jwtApplinkFinder = jwtApplinkFinder;
    }

    @Override
    public ApplicationLinkJwtIssuer getIssuer(@Nonnull String issuer)
    {
        if (issuer == null)
        {
            return null;
        }
        ApplicationLink link = jwtApplinkFinder.find(issuer);
        return link == null ? null : new ApplicationLinkJwtIssuer(link);
    }
}
