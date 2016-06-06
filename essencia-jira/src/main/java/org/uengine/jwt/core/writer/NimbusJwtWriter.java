package org.uengine.jwt.core.writer;

import org.uengine.jwt.SigningAlgorithm;
import org.uengine.jwt.core.NimbusUtil;
import org.uengine.jwt.exception.JwtSigningException;
import org.uengine.jwt.writer.JwtWriter;
import com.google.common.annotations.VisibleForTesting;
import com.nimbusds.jose.*;

import javax.annotation.Nonnull;

public class NimbusJwtWriter implements JwtWriter
{
    private final JWSAlgorithm algorithm;
    private final JWSSigner signer;

    private final static String JWT = "JWT";

    public NimbusJwtWriter(SigningAlgorithm algorithm, JWSSigner signer)
    {
        this(NimbusUtil.asNimbusJWSAlgorithm(algorithm), signer);
    }

    protected NimbusJwtWriter(JWSAlgorithm algorithm, JWSSigner signer)
    {
        this.algorithm = algorithm;
        this.signer = signer;
    }

    @Nonnull
    @Override
    public String jsonToJwt(@Nonnull String json) throws JwtSigningException
    {
        // Serialise JWS object to compact format
        return generateJwsObject(json).serialize();
    }

    @VisibleForTesting
    JWSObject generateJwsObject(String payload)
    {
        JWSHeader header = new JWSHeader(algorithm);
        header.setType(new JOSEObjectType(JWT));

        // Create JWS object
        JWSObject jwsObject = new JWSObject(header, new Payload(payload));

        try
        {
            jwsObject.sign(signer);
        }
        catch (JOSEException e)
        {
            throw new JwtSigningException(e);
        }
        return jwsObject;
    }
}
