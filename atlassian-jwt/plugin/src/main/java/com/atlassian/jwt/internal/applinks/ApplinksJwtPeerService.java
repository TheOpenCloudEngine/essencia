package com.atlassian.jwt.internal.applinks;

import javax.annotation.Nonnull;

import com.atlassian.applinks.api.ApplicationLink;
import com.atlassian.applinks.api.CredentialsRequiredException;
import com.atlassian.applinks.api.auth.Anonymous;
import com.atlassian.applinks.host.spi.HostApplication;
import com.atlassian.jwt.SigningAlgorithm;
import com.atlassian.jwt.applinks.JwtPeerService;
import com.atlassian.jwt.applinks.exception.JwtRegistrationFailedException;
import com.atlassian.jwt.internal.security.SecretGenerator;
import com.atlassian.sal.api.net.Request;
import com.atlassian.sal.api.net.Response;
import com.atlassian.sal.api.net.ResponseException;
import com.atlassian.sal.api.net.ResponseHandler;

import static com.atlassian.jwt.JwtConstants.AppLinks.ADD_ON_ID_PROPERTY_NAME;
import static com.atlassian.jwt.JwtConstants.AppLinks.SHARED_SECRET_PROPERTY_NAME;

public class ApplinksJwtPeerService implements JwtPeerService
{
    private final HostApplication hostApplication;

    public ApplinksJwtPeerService(HostApplication hostApplication)
    {
        this.hostApplication = hostApplication;
    }

    @Override
    public void issueSharedSecret(@Nonnull ApplicationLink applicationLink, @Nonnull String path) throws JwtRegistrationFailedException
    {
        // generate secure shared secret
        String sharedSecret = SecretGenerator.generateUrlSafeSharedSecret(SigningAlgorithm.HS256);

        Object addOnKey = applicationLink.getProperty(ADD_ON_ID_PROPERTY_NAME);

        if (null == addOnKey)
        {
            throw new JwtRegistrationFailedException(String.format("Application link '%s' has no '%s' property. It should have been set during add-on installation! Please reinstall the add-on.",
                    applicationLink.getId(), ADD_ON_ID_PROPERTY_NAME));
        }

        // pass shared secret to peer
        try
        {
            applicationLink.createAuthenticatedRequestFactory(Anonymous.class)
                    .createRequest(Request.MethodType.POST, path)
                    .addRequestParameters(
                            "myId", hostApplication.getId().get(),
                            "yourId", addOnKey.toString(),
                            "secret", sharedSecret)
                    .execute(new ResponseHandler<Response>()
                    {
                        @Override
                        public void handle(Response response) throws ResponseException
                        {
                            if (!response.isSuccessful())
                            {
                                throw new ResponseException("Registration failed, received " +
                                        response.getStatusCode() + " " + response.getStatusText() +
                                        " from peer.");
                            }
                        }
                    });
        }
        catch (ResponseException e)
        {
            throw new JwtRegistrationFailedException(e);
        }
        catch (CredentialsRequiredException e)
        {
            // will not happen with an Anonymous authentication provider
            throw new IllegalStateException(e);
        }

        // store the shared secret on the application link
        applicationLink.putProperty(SHARED_SECRET_PROPERTY_NAME, sharedSecret);
    }

    @Override
    public void revokeSharedSecret(@Nonnull ApplicationLink applicationLink)
    {
        applicationLink.removeProperty(SHARED_SECRET_PROPERTY_NAME);
    }

}
