package org.uengine.web.jiraclient;

import com.atlassian.jwt.SigningAlgorithm;
import com.atlassian.jwt.core.writer.JsonSmartJwtJsonBuilder;
import com.atlassian.jwt.core.writer.JwtClaimsBuilder;
import com.atlassian.jwt.core.writer.NimbusJwtWriterFactory;
import com.atlassian.jwt.httpclient.CanonicalHttpUriRequest;
import com.atlassian.jwt.writer.JwtJsonBuilder;
import com.atlassian.jwt.writer.JwtWriterFactory;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 * Created by uengine on 2016. 2. 12..
 */
public class JiraTest {

    public static void main(String[] args) throws Exception{
        String uriWithJwt = createUriWithJwt();
        System.out.println(uriWithJwt);
    }

    public static String createUriWithJwt()
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        long issuedAt = System.currentTimeMillis() / 1000L;
        long expiresAt = issuedAt + 180L;
        String key = "essencia-jira"; //the key from the add-on descriptor
        String sharedSecret = "6974c502-d4a4-44dc-8ee8-f3c8d084a4ee";    //the sharedsecret key received
        //during the addon installation handshake
        String method = "GET";
        String baseUrl = "http://localhost:2990/jira";
        String contextPath = "/jira";
        String apiPath = "/rest/api/latest/serverInfo";

        JwtJsonBuilder jwtBuilder = new JsonSmartJwtJsonBuilder()
                .issuedAt(issuedAt)
                .expirationTime(expiresAt)
                .issuer(key);

        CanonicalHttpUriRequest canonical = new CanonicalHttpUriRequest(method,
                apiPath, contextPath, new HashMap());
        JwtClaimsBuilder.appendHttpRequestClaims(jwtBuilder, canonical);

        JwtWriterFactory jwtWriterFactory = new NimbusJwtWriterFactory();
        String jwtbuilt = jwtBuilder.build();
        String jwtToken = jwtWriterFactory.macSigningWriter(SigningAlgorithm.HS256,
                sharedSecret).jsonToJwt(jwtbuilt);

        String apiUrl = baseUrl + apiPath + "?jwt=" + jwtToken;
        return apiUrl;
    }
}
