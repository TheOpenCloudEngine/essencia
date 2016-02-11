package com.atlassian.jwt.core.writer;

import com.atlassian.jwt.SigningAlgorithm;
import com.atlassian.jwt.core.keys.KeyUtils;
import com.atlassian.jwt.exception.JwtSigningException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import net.minidev.json.JSONObject;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.interfaces.RSAPrivateKey;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NimbusJwtWriterTest
{
    private static final String SHARED_SECRET = "secret";

    private static final String PRIVATE_KEY_FILE_NAME = "private.pem";

    private static final String PAYLOAD = "{\"iss\":\"joe\",\n"
            + " \"exp\":1300819380,\n"
            + " \"http://example.com/is_root\":true}";

    @Test
    public void shouldSetTheTypeToJWT() throws JwtSigningException
    {
        NimbusJwtWriter writer = new NimbusJwtWriter(SigningAlgorithm.HS256, new MACSigner(SHARED_SECRET));
        assertThat(writer.generateJwsObject(PAYLOAD).getHeader().getType(), is(new JOSEObjectType("JWT")));
    }

    @Test
    public void shouldSetTheAlgorithmToHS256() throws JwtSigningException
    {
        NimbusJwtWriter writer = new NimbusJwtWriter(SigningAlgorithm.HS256, new MACSigner(SHARED_SECRET));
        assertThat(writer.generateJwsObject(PAYLOAD).getHeader().getAlgorithm().getName(), is("HS256"));
    }

    @Test
    public void shouldSetTheAlgorithmToRS256() throws Exception
    {
        InputStream privateKeyInputStream = this.getClass().getClassLoader().getResourceAsStream(PRIVATE_KEY_FILE_NAME);
        RSAPrivateKey privateKey = (new KeyUtils()).readRsaPrivateKeyFromPem(new InputStreamReader(privateKeyInputStream));

        NimbusJwtWriter writer = new NimbusJwtWriter(SigningAlgorithm.RS256, new RSASSASigner(privateKey));
        assertThat(writer.generateJwsObject(PAYLOAD).getHeader().getAlgorithm().getName(), is("RS256"));
    }

    @Test
    public void shouldContainThePayload() throws JwtSigningException
    {
        NimbusJwtWriter writer = new NimbusJwtWriter(SigningAlgorithm.HS256, new MACSigner(SHARED_SECRET));
        JSONObject payloadAsJsonObject = writer.generateJwsObject(PAYLOAD).getPayload().toJSONObject();
        assertThat(payloadAsJsonObject.get("iss").toString(), is("joe"));
        assertThat(payloadAsJsonObject.get("exp").toString(), is("1300819380"));
        assertThat(payloadAsJsonObject.get("http://example.com/is_root").toString(), is("true"));
    }
}
