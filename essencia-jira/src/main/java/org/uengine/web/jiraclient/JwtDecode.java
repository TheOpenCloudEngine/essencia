package org.uengine.web.jiraclient;

import org.uengine.jwt.SigningAlgorithm;
import org.uengine.jwt.core.writer.JsonSmartJwtJsonBuilder;
import org.uengine.jwt.core.writer.JwtClaimsBuilder;
import org.uengine.jwt.core.writer.NimbusJwtWriterFactory;
import org.uengine.jwt.httpclient.CanonicalHttpUriRequest;
import org.uengine.jwt.writer.JwtJsonBuilder;
import org.uengine.jwt.writer.JwtWriterFactory;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import net.minidev.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.uengine.web.exception.ServiceException;
import org.uengine.web.util.HttpUtils;
import org.uengine.web.util.JsonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by uengine on 2016. 2. 12..
 */
public class JwtDecode {

    public static void main(String[] args) throws Exception{

        String secret = "gosu23546";
        byte[] encoded = Base64.encodeBase64(secret.getBytes());
        String s = new String(encoded);
        System.out.println(s);

        byte[] byteArray = secret.getBytes("UTF-16BE");
        int sizeInBits = byteArray.length * 8;
        System.out.println(sizeInBits);

        String jwtToken = "eyAidHlwIjogIkpXVCIsICJhbGciOiAiSFMyNTYiIH0.eyAic2VyaWFsaXplZF9zZXNzaW9uIjogIntcInNlY3JldFwiOlwiMWExZWJkZGYtNThhNC00ZWM1LWI0MWUtOGUwZGQ1ZDY0MDg1XCIsXCJleHBpcnlUaW1lXCI6MTQ2MDExMTIzMDk0OCxcImxhc3RBY3Rpdml0eVRpbWVcIjoxNDYwMTA0MDMwOTQ4LFwic3RhdGVcIjpcInZhbGlkXCIsXCJwcm9wZXJ0aWVzXCI6e1wiQ2hhclNldFwiOlwiVVRGLThcIixcIlVzZXJJZFwiOlwiYmplbnNlblwiLFwiRnVsbExvZ2luVVJMXCI6XCIvb3BlbmFtL1VJL0xvZ2luP3JlYWxtPSUyRlwiLFwic3VjY2Vzc1VSTFwiOlwiL29wZW5hbS9jb25zb2xlXCIsXCJjb29raWVTdXBwb3J0XCI6XCJ0cnVlXCIsXCJBdXRoTGV2ZWxcIjpcIjBcIixcIlNlc3Npb25IYW5kbGVcIjpcInNoYW5kbGU6QVFJQzV3TTJMWTRTZmN6TVlOSlBLRXptRzk4Ym1sSmpoMGZmdWZrSEprZncyNFEuKkFBSlRTUUFDTURFQUFsTkxBQk14TXpFd01qQXpNamczTkRjMk5Ea3hPVEk0QUFKVE1RQUEqXCIsXCJVc2VyVG9rZW5cIjpcImJqZW5zZW5cIixcImxvZ2luVVJMXCI6XCIvb3BlbmFtL1VJL0xvZ2luXCIsXCJQcmluY2lwYWxzXCI6XCJiamVuc2VuXCIsXCJTZXJ2aWNlXCI6XCJsZGFwU2VydmljZVwiLFwic3VuLmFtLlVuaXZlcnNhbElkZW50aWZpZXJcIjpcImlkPWJqZW5zZW4sb3U9dXNlcixkYz1vcGVuYW0sZGM9Zm9yZ2Vyb2NrLGRjPW9yZ1wiLFwiYW1sYmNvb2tpZVwiOlwiMDFcIixcIk9yZ2FuaXphdGlvblwiOlwiZGM9b3BlbmFtLGRjPWZvcmdlcm9jayxkYz1vcmdcIixcIkxvY2FsZVwiOlwiZW5fVVNcIixcIkhvc3ROYW1lXCI6XCIxMjcuMC4wLjFcIixcIkF1dGhUeXBlXCI6XCJEYXRhU3RvcmVcIixcIkhvc3RcIjpcIjEyNy4wLjAuMVwiLFwiVXNlclByb2ZpbGVcIjpcIlJlcXVpcmVkXCIsXCJBTUN0eElkXCI6XCJmOTMyZGUwYzUxYjEyZjY0MDFcIixcImNsaWVudFR5cGVcIjpcImdlbmVyaWNIVE1MXCIsXCJhdXRoSW5zdGFudFwiOlwiMjAxNi0wNC0wOFQwODoyNzoxMFpcIixcIlByaW5jaXBhbFwiOlwiaWQ9YmplbnNlbixvdT11c2VyLGRjPW9wZW5hbSxkYz1mb3JnZXJvY2ssZGM9b3JnXCJ9LFwic2Vzc2lvbklEXCI6bnVsbCxcImNsaWVudElEXCI6XCJpZD1iamVuc2VuLG91PXVzZXIsZGM9b3BlbmFtLGRjPWZvcmdlcm9jayxkYz1vcmdcIixcImNsaWVudERvbWFpblwiOlwiZGM9b3BlbmFtLGRjPWZvcmdlcm9jayxkYz1vcmdcIixcInNlc3Npb25UeXBlXCI6XCJ1c2VyXCIsXCJtYXhJZGxlXCI6MzAsXCJtYXhDYWNoaW5nXCI6MyxcIm5ldmVyRXhwaXJpbmdcIjpmYWxzZSxcIm1heFRpbWVcIjoxMjB9IiB9.pHvn46Ftin2Uky5NmPwnEYEwvMzLi_2oV-Dcv8K0OJ4";

        String[] base64UrlEncodedSegments = jwtToken.split("\\.");
        String base64UrlEncodedHeader = base64UrlEncodedSegments[0];
        String base64UrlEncodedClaims = base64UrlEncodedSegments[1];
        String signature = base64UrlEncodedSegments[2];
        String header = base64UrlDecode(base64UrlEncodedHeader);
        String claimses = base64UrlDecode(base64UrlEncodedClaims);


        Map claimsMap = JsonUtils.marshal(claimses);
        //String iss = claimsMap.get("iss").toString();
        System.out.println(claimses);



//        JWSVerifier verifier = new MACVerifier("Z29zdTIzNTQ2");
//        JWTClaimsSet claimsSet = read(jwtToken, verifier);
//        JSONObject jsonObject = claimsSet.toJSONObject();
//        System.out.println(jsonObject);


        SignedJWT signedJWT = SignedJWT.parse(jwtToken);
        JWSVerifier verifier = new MACVerifier(secret);
        boolean verify = signedJWT.verify(verifier);
        System.out.println(verify);

    }

    public static String base64UrlDecode(String input) {
        System.out.println(Base64.class.getProtectionDomain().getCodeSource().getLocation());
        byte[] bytes = Base64.decodeBase64(input);
        return new String(bytes);
    }

    public static JWTClaimsSet read(String jwt, JWSVerifier verifier) throws ParseException, JOSEException {
        JWSObject jwsObject = JWSObject.parse(jwt);

        if (!jwsObject.verify(verifier)) {
            throw new IllegalArgumentException("Fraudulent JWT token: " + jwt);
        }

        JSONObject jsonPayload = jwsObject.getPayload().toJSONObject();
        return JWTClaimsSet.parse(jsonPayload);
    }

}
