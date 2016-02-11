package com.atlassian.jwt.applinks;

import javax.annotation.Nonnull;

import com.atlassian.applinks.api.ApplicationLink;
import com.atlassian.applinks.api.ApplicationLinkService;

import static com.atlassian.jwt.JwtConstants.AppLinks.*;

public class JwtApplinkFinderImpl implements JwtApplinkFinder
{
    private final ApplicationLinkService applicationLinkService;

    public JwtApplinkFinderImpl(ApplicationLinkService applicationLinkService)
    {
        this.applicationLinkService = applicationLinkService;
    }

    @Override
    public ApplicationLink find(@Nonnull String addOnId)
    {
        //noinspection ConstantConditions
        if (null == addOnId)
        {
            throw new NullPointerException("Add-on id cannot be null");
        }

        for (ApplicationLink appLink : applicationLinkService.getApplicationLinks())
        {
            if (addOnId.equals(appLink.getProperty(ADD_ON_ID_PROPERTY_NAME)) &&
                    JWT_AUTH_METHOD_NAME.equals(appLink.getProperty(AUTH_METHOD_PROPERTY_NAME)))
            {
                return appLink;
            }
        }

        return null;
    }
}
