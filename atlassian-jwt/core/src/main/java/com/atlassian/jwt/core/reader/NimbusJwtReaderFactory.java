package com.atlassian.jwt.core.reader;

import com.atlassian.jwt.SigningAlgorithm;
import com.atlassian.jwt.core.SimpleJwt;
import com.atlassian.jwt.exception.JwsUnsupportedAlgorithmException;
import com.atlassian.jwt.exception.JwtIssuerLacksSharedSecretException;
import com.atlassian.jwt.exception.JwtParseException;
import com.atlassian.jwt.exception.JwtUnknownIssuerException;
import com.atlassian.jwt.reader.JwtReader;
import com.atlassian.jwt.reader.JwtReaderFactory;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jwt.JWTClaimsSet;

import javax.annotation.Nonnull;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;

public class NimbusJwtReaderFactory implements JwtReaderFactory
{
    private final JwtIssuerValidator jwtIssuerValidator;
    private final JwtIssuerSharedSecretService jwtIssuerSharedSecretService;

    public NimbusJwtReaderFactory(JwtIssuerValidator jwtIssuerValidator, JwtIssuerSharedSecretService jwtIssuerSharedSecretService)
    {
        this.jwtIssuerValidator = jwtIssuerValidator;
        this.jwtIssuerSharedSecretService = jwtIssuerSharedSecretService;
    }

    @Nonnull
    @Override
    public JwtReader getReader(@Nonnull String jwt) throws JwtParseException, JwsUnsupportedAlgorithmException, JwtUnknownIssuerException, JwtIssuerLacksSharedSecretException
    {
        SimpleUnverifiedJwt unverifiedJwt = new NimbusUnverifiedJwtReader().parse(jwt);
        SigningAlgorithm algorithm = validateAlgorithm(unverifiedJwt);
        String issuer = validateIssuer(unverifiedJwt);

        if (algorithm.requiresSharedSecret())
        {
            return macVerifyingReader(jwtIssuerSharedSecretService.getSharedSecret(issuer));
        }

        throw new JwsUnsupportedAlgorithmException(String.format("Expected a symmetric signing algorithm such as %s, and not %s. Try a symmetric algorithm.", SigningAlgorithm.HS256, algorithm.name()));
    }

    @Nonnull
    @Override
    public JwtReader getReader(@Nonnull String jwt, RSAPublicKey publicKey) throws JwsUnsupportedAlgorithmException, JwtParseException
    {
        SimpleUnverifiedJwt unverifiedJwt = new NimbusUnverifiedJwtReader().parse(jwt);
        SigningAlgorithm algorithm = validateAlgorithm(unverifiedJwt);

        if (algorithm.requiresKeyPair())
        {
            return rsVerifyingReader(publicKey);
        }

        throw new JwsUnsupportedAlgorithmException(String.format("Expected an asymmetric signing algorithm such as %s, and not %s. Try an asymmetric algorithm.", SigningAlgorithm.RS256, algorithm.name()));
    }

    private JwtReader macVerifyingReader(String sharedSecret)
    {
        return new NimbusMacJwtReader(sharedSecret);
    }

    private JwtReader rsVerifyingReader(RSAPublicKey publicKey)
    {
        return new NimbusRsJwtReader(publicKey);
    }

    private String validateIssuer(SimpleUnverifiedJwt unverifiedJwt) throws JwtUnknownIssuerException
    {
        String issuer = unverifiedJwt.getIssuer();

        if (!jwtIssuerValidator.isValid(issuer))
        {
            throw new JwtUnknownIssuerException(issuer);
        }

        return issuer;
    }

    private SigningAlgorithm validateAlgorithm(SimpleUnverifiedJwt unverifiedJwt) throws JwsUnsupportedAlgorithmException
    {
        return SigningAlgorithm.forName(unverifiedJwt.getAlgorithm());
    }

    private static class SimpleUnverifiedJwt extends SimpleJwt
    {
        private final String algorithm;

        public SimpleUnverifiedJwt(String algorithm, String iss, String sub, String payload)
        {
            super(iss, sub, payload);
            this.algorithm = algorithm;
        }

        public String getAlgorithm()
        {
            return algorithm;
        }
    }

    private static class NimbusUnverifiedJwtReader
    {
        public SimpleUnverifiedJwt parse(String jwt) throws JwtParseException
        {
            JWSObject jwsObject = parseJWSObject(jwt);
            try
            {
                JWTClaimsSet claims = JWTClaimsSet.parse(jwsObject.getPayload().toJSONObject());
                return new SimpleUnverifiedJwt(jwsObject.getHeader().getAlgorithm().getName(), claims.getIssuer(), claims.getSubject(), jwsObject.getPayload().toString());
            }
            catch (ParseException e)
            {
                throw new JwtParseException(e);
            }
        }

        private JWSObject parseJWSObject(String jwt) throws JwtParseException
        {
            JWSObject jwsObject;

            try
            {
                jwsObject = JWSObject.parse(jwt);
            }
            catch (ParseException e)
            {
                throw new JwtParseException(e);
            }
            return jwsObject;
        }
    }
}
