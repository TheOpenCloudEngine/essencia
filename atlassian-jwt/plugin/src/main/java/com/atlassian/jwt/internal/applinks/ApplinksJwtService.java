package com.atlassian.jwt.internal.applinks;

import com.atlassian.applinks.api.ApplicationLink;
import com.atlassian.applinks.api.TypeNotInstalledException;
import com.atlassian.jwt.Jwt;
import com.atlassian.jwt.SigningAlgorithm;
import com.atlassian.jwt.applinks.ApplinkJwt;
import com.atlassian.jwt.applinks.JwtApplinkFinder;
import com.atlassian.jwt.applinks.JwtService;
import com.atlassian.jwt.applinks.exception.NotAJwtPeerException;
import com.atlassian.jwt.exception.JwtIssuerLacksSharedSecretException;
import com.atlassian.jwt.exception.JwtParseException;
import com.atlassian.jwt.exception.JwtSigningException;
import com.atlassian.jwt.exception.JwtUnknownIssuerException;
import com.atlassian.jwt.exception.JwtVerificationException;
import com.atlassian.jwt.reader.JwtClaimVerifier;
import com.atlassian.jwt.reader.JwtReaderFactory;
import com.atlassian.jwt.writer.JwtWriter;
import com.atlassian.jwt.writer.JwtWriterFactory;

import java.util.Map;

import static com.atlassian.jwt.JwtConstants.AppLinks.SHARED_SECRET_PROPERTY_NAME;

@SuppressWarnings("deprecation")
@Deprecated
public class ApplinksJwtService implements JwtService
{
    private final JwtReaderFactory jwtReaderFactory;
    private final JwtWriterFactory jwtWriterFactory;
    private final JwtApplinkFinder jwtApplinkFinder;

    public ApplinksJwtService(JwtReaderFactory jwtReaderFactory, JwtWriterFactory jwtWriterFactory,
                              JwtApplinkFinder jwtApplinkFinder)
    {
        this.jwtReaderFactory = jwtReaderFactory;
        this.jwtWriterFactory = jwtWriterFactory;
        this.jwtApplinkFinder = jwtApplinkFinder;
    }

    @Override
    public boolean isJwtPeer(ApplicationLink applicationLink)
    {
        return applicationLink.getProperty(SHARED_SECRET_PROPERTY_NAME) != null;
    }

    @Override
    public ApplinkJwt verifyJwt(String jwt, Map<String, ? extends JwtClaimVerifier> claimVerifiers) throws NotAJwtPeerException, JwtParseException, JwtVerificationException, TypeNotInstalledException, JwtIssuerLacksSharedSecretException, JwtUnknownIssuerException
    {
        Jwt verifiedJwt = jwtReaderFactory.getReader(jwt).readAndVerify(jwt, claimVerifiers);
        ApplicationLink applicationLink = jwtApplinkFinder.find(verifiedJwt.getIssuer());
        return new SimpleApplinkJwt(verifiedJwt, applicationLink);
    }

    private String requireSharedSecret(ApplicationLink applicationLink)
    {
        String sharedSecret = (String) applicationLink.getProperty(SHARED_SECRET_PROPERTY_NAME);
        if (sharedSecret == null)
        {
            throw new NotAJwtPeerException(applicationLink);
        }
        return sharedSecret;
    }

    @Override
    public String issueJwt(String jsonPayload, ApplicationLink applicationLink) throws NotAJwtPeerException, JwtSigningException
    {
        return getJwtWriter(applicationLink).jsonToJwt(jsonPayload);
    }

    @Override
    public String issueJwt(String jsonPayload, String secret) throws JwtSigningException
    {
        return getJwtWriter(secret).jsonToJwt(jsonPayload);
    }

    private JwtWriter getJwtWriter(ApplicationLink applicationLink)
    {
        return getJwtWriter(requireSharedSecret(applicationLink));
    }

    private JwtWriter getJwtWriter(String sharedSecret)
    {
        return jwtWriterFactory
                .macSigningWriter(SigningAlgorithm.HS256, sharedSecret);
    }
}
