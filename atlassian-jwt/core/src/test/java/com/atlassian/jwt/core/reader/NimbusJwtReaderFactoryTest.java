package com.atlassian.jwt.core.reader;

import com.atlassian.jwt.Jwt;
import com.atlassian.jwt.core.SimpleJwt;
import com.atlassian.jwt.core.writer.NimbusJwtWriter;
import com.atlassian.jwt.exception.*;
import com.atlassian.jwt.reader.JwtReaderFactory;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.ReadOnlyJWSHeader;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jwt.JWTClaimsSet;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static com.atlassian.jwt.core.reader.JwtClaimVerifiersBuilder.NO_REQUIRED_CLAIMS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NimbusJwtReaderFactoryTest
{
    private static final JWSAlgorithm SUPPORTED_ALGORITHM = JWSAlgorithm.HS256;
    private static final JWSAlgorithm UNSUPPORTED_ALGORITHM = JWSAlgorithm.PS256;
    private static final String VALID_ISSUER = "valid";
    private static final String ISSUER_WITHOUT_SECRET = "setup in progress?";
    private static final String SUBJECT = "subject";
    private static final String SHARED_SECRET = "secret";
    private static final JWSSigner SIGNER = new MACSigner(SHARED_SECRET);

    @Mock JwtIssuerValidator jwtIssuerValidator;
    @Mock JwtIssuerSharedSecretService jwtIssuerSharedSecretService;

    private JwtReaderFactory factory;

    @Before
    public void before() throws JwtIssuerLacksSharedSecretException, JwtUnknownIssuerException
    {
        when(jwtIssuerValidator.isValid(VALID_ISSUER)).thenReturn(true);
        when(jwtIssuerValidator.isValid(ISSUER_WITHOUT_SECRET)).thenReturn(true); // this issuer uses a signing method without a shared secret (e.g. RSA)
        when(jwtIssuerSharedSecretService.getSharedSecret(VALID_ISSUER)).thenReturn(SHARED_SECRET);
        when(jwtIssuerSharedSecretService.getSharedSecret(ISSUER_WITHOUT_SECRET)).thenThrow(new JwtIssuerLacksSharedSecretException(ISSUER_WITHOUT_SECRET));
        factory = new NimbusJwtReaderFactory(jwtIssuerValidator, jwtIssuerSharedSecretService);
    }

    @Test
    public void correctReaderClassIsReturnedForValidJwt() throws JwsUnsupportedAlgorithmException, JwtIssuerLacksSharedSecretException, JwtUnknownIssuerException, JwtInvalidClaimException, JwtParseException
    {
        assertThat(factory.getReader(createJwtFromIssuer(SUPPORTED_ALGORITHM, VALID_ISSUER)), is(CoreMatchers.instanceOf(NimbusMacJwtReader.class)));
    }

    @Test
    public void readerReturnedForValidJwtCanVerifyThatJwt() throws JwtParseException, JwtVerificationException, JwtIssuerLacksSharedSecretException, JwtUnknownIssuerException
    {
        String payload = createPayload(VALID_ISSUER);
        Jwt expected = new SimpleJwt(VALID_ISSUER, SUBJECT, payload);
        String jwt = createJwtFromPayload(SUPPORTED_ALGORITHM, payload);
        assertThat(factory.getReader(jwt).readAndVerify(jwt, NO_REQUIRED_CLAIMS), is(expected));
    }

    @Test(expected = JwtParseException.class)
    public void garbledJwtIsRejected() throws JwsUnsupportedAlgorithmException, JwtIssuerLacksSharedSecretException, JwtUnknownIssuerException, JwtInvalidClaimException, JwtParseException
    {
        factory.getReader("just.plain.wrong");
    }

    @Test(expected = JwsUnsupportedAlgorithmException.class)
    public void unsupportedAlgorithmIsRejected() throws JwsUnsupportedAlgorithmException, JwtIssuerLacksSharedSecretException, JwtUnknownIssuerException, JwtInvalidClaimException, JwtParseException
    {
        factory.getReader(createJwtFromIssuer(UNSUPPORTED_ALGORITHM, VALID_ISSUER));
    }

    @Test(expected = JwsUnsupportedAlgorithmException.class)
    public void garbledAlgorithmIsRejected() throws JwsUnsupportedAlgorithmException, JwtIssuerLacksSharedSecretException, JwtUnknownIssuerException, JwtInvalidClaimException, JwtParseException
    {
        factory.getReader(createJwtFromIssuer("fubar", VALID_ISSUER));
    }

    @Test(expected = JwtUnknownIssuerException.class)
    public void unknownIssuerIsRejected() throws JwsUnsupportedAlgorithmException, JwtIssuerLacksSharedSecretException, JwtUnknownIssuerException, JwtInvalidClaimException, JwtParseException
    {
        factory.getReader(createJwtFromIssuer(SUPPORTED_ALGORITHM, "unknown issuer"));
    }

    @Test(expected = JwtIssuerLacksSharedSecretException.class)
    public void issuerWithoutSharedSecretCannotRequestSymmetricSigning() throws JwsUnsupportedAlgorithmException, JwtIssuerLacksSharedSecretException, JwtUnknownIssuerException, JwtInvalidClaimException, JwtParseException
    {
        factory.getReader(createJwtFromIssuer(SUPPORTED_ALGORITHM, ISSUER_WITHOUT_SECRET));
    }

    private String createJwtFromIssuer(JWSAlgorithm algorithm, String issuer)
    {
        return createJwtFromPayload(algorithm, createPayload(issuer));
    }

    private String createJwtFromIssuer(String algorithm, String issuer)
    {
        return createJwtFromPayload(algorithm, createPayload(issuer));
    }

    private String createJwtFromPayload(String algorithm, String payload)
    {
        return createJwtFromPayload(JWSAlgorithm.parse(algorithm), payload);
    }

    private String createJwtFromPayload(final JWSAlgorithm algorithm, String payload)
    {
        try
        {
            return new AnyAlgorithmNimbusJwtWriter(algorithm, SIGNER).jsonToJwt(payload);
        }
        catch (JwtSigningException e)
        {
            // expected when we're using a non-existent algorithm
            JWSSigner fakeSigner = new JWSSigner()
            {
                @Override
                public Base64URL sign(ReadOnlyJWSHeader header, byte[] signingInput) throws JOSEException
                {
                    return Base64URL.encode("fake signature");
                }

                @Override
                public Set<JWSAlgorithm> supportedAlgorithms()
                {
                    HashSet<JWSAlgorithm> jwsAlgorithms = new HashSet<JWSAlgorithm>();
                    jwsAlgorithms.add(algorithm);
                    return jwsAlgorithms;
                }
            };
            return new AnyAlgorithmNimbusJwtWriter(algorithm, fakeSigner).jsonToJwt(payload);
        }
    }

    private String createPayload(String issuer)
    {
        JWTClaimsSet claims = new JWTClaimsSet();
        claims.setIssuer(issuer);
        Date now = new Date();
        claims.setIssueTime(now);
        claims.setExpirationTime(new Date(now.getTime() + 10000));
        claims.setSubject(SUBJECT);
        return claims.toJSONObject().toJSONString();
    }

    private class AnyAlgorithmNimbusJwtWriter extends NimbusJwtWriter
    {
        public AnyAlgorithmNimbusJwtWriter(JWSAlgorithm algorithm, JWSSigner signer)
        {
            super(algorithm, signer);
        }
    }
}
