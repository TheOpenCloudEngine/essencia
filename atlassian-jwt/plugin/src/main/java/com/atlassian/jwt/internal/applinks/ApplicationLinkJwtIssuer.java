package com.atlassian.jwt.internal.applinks;

import com.atlassian.applinks.api.ApplicationLink;
import com.atlassian.jwt.JwtIssuer;

import javax.annotation.Nonnull;

import static com.atlassian.jwt.JwtConstants.AppLinks.ADD_ON_ID_PROPERTY_NAME;
import static com.atlassian.jwt.JwtConstants.AppLinks.SHARED_SECRET_PROPERTY_NAME;

/**
 * JWT issuer that is backed by an ApplicationLink
 */
public class ApplicationLinkJwtIssuer implements JwtIssuer
{
    private final ApplicationLink applicationLink;

    public ApplicationLinkJwtIssuer(ApplicationLink applicationLink)
    {
        this.applicationLink = applicationLink;
    }

    @Nonnull
    @Override
    public String getName()
    {
        return getProperty(ADD_ON_ID_PROPERTY_NAME);
    }

    @Override
    public String getSharedSecret()
    {
        return getProperty(SHARED_SECRET_PROPERTY_NAME);
    }

    private String getProperty(String propertyName)
    {
        Object property = applicationLink.getProperty(propertyName);
        return (property instanceof String) ? (String) property : null;
    }
}
