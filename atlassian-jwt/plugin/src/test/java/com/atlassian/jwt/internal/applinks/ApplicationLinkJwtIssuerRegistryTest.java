package com.atlassian.jwt.internal.applinks;

import com.atlassian.applinks.api.ApplicationLink;
import com.atlassian.applinks.api.ApplicationLinkService;
import com.atlassian.jwt.JwtConstants;
import com.atlassian.jwt.applinks.JwtApplinkFinderImpl;
import com.atlassian.jwt.exception.JwtIssuerLacksSharedSecretException;
import com.atlassian.jwt.exception.JwtUnknownIssuerException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

import static com.atlassian.jwt.JwtConstants.AppLinks.SHARED_SECRET_PROPERTY_NAME;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationLinkJwtIssuerRegistryTest
{
    private ApplinksJwtIssuerRegistry registry;
    @Mock private ApplicationLinkService applicationLinkService;
    @Mock private ApplicationLink applicationLink;
    @Mock private ApplicationLink unrelatedNoAuthApplicationLink;
    @Mock private ApplicationLink unrelatedOAuthApplicationLink;

    private static final String ADD_ON_KEY = "add-on key, uses JWT";
    private static final String NO_AUTH_ADD_ON_KEY = "no auth method on app link";
    private static final String OAUTH_ADD_ON_KEY = "app link says to use OAUTH1";
    private static final String APP_LINK_ID = UUID.randomUUID().toString();
    private static final String SHARED_SECRET = "shared secret";

    @Test
    public void validAddOnKeyIsValidIssuerId()
    {
        assertThat(registry.getIssuer(ADD_ON_KEY), notNullValue());
    }

    @Test
    public void validApplinkIdIsInvalidIssuerId()
    {
        assertThat(registry.getIssuer(APP_LINK_ID), nullValue());
    }

    @Test
    public void nullIsInvalidIssuerId()
    {
        assertThat(registry.getIssuer(null), nullValue());
    }

    @Test
    public void addOnWithNonJwtAuthenticationIsInvalidIssuer()
    {
        assertThat(registry.getIssuer(OAUTH_ADD_ON_KEY), nullValue());
    }

    @Test
    public void addOnWithNullAuthenticationPropertyIsInvalidIssuer()
    {
        assertThat(registry.getIssuer(NO_AUTH_ADD_ON_KEY), nullValue());
    }

    @Test
    public void validAddOnKeyHasSharedSecret() throws JwtUnknownIssuerException, JwtIssuerLacksSharedSecretException
    {
        ApplicationLinkJwtIssuer issuer = registry.getIssuer(ADD_ON_KEY);
        assertThat(issuer, notNullValue());
        assertThat(issuer.getSharedSecret(), is(SHARED_SECRET));
    }
    @Before
    public void beforeEachTest()
    {
        when(unrelatedOAuthApplicationLink.getProperty(JwtConstants.AppLinks.ADD_ON_ID_PROPERTY_NAME)).thenReturn(OAUTH_ADD_ON_KEY);

        when(unrelatedNoAuthApplicationLink.getProperty(JwtConstants.AppLinks.ADD_ON_ID_PROPERTY_NAME)).thenReturn(NO_AUTH_ADD_ON_KEY);
        when(unrelatedNoAuthApplicationLink.getProperty(JwtConstants.AppLinks.AUTH_METHOD_PROPERTY_NAME)).thenReturn("OAUTH1");

        when(applicationLink.getProperty(JwtConstants.AppLinks.ADD_ON_ID_PROPERTY_NAME)).thenReturn(ADD_ON_KEY);
        when(applicationLink.getProperty(SHARED_SECRET_PROPERTY_NAME)).thenReturn(SHARED_SECRET);
        when(applicationLink.getProperty(JwtConstants.AppLinks.AUTH_METHOD_PROPERTY_NAME)).thenReturn(JwtConstants.AppLinks.JWT_AUTH_METHOD_NAME);

        when(applicationLinkService.getApplicationLinks()).thenReturn(asList(applicationLink, unrelatedNoAuthApplicationLink, unrelatedOAuthApplicationLink));

        registry = new ApplinksJwtIssuerRegistry(new JwtApplinkFinderImpl(applicationLinkService));
    }
}
