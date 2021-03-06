package org.uengine.web.jiraclient;

import org.uengine.jwt.SigningAlgorithm;
import org.uengine.jwt.core.writer.JsonSmartJwtJsonBuilder;
import org.uengine.jwt.core.writer.JwtClaimsBuilder;
import org.uengine.jwt.core.writer.NimbusJwtWriterFactory;
import org.uengine.jwt.httpclient.CanonicalHttpUriRequest;
import org.uengine.jwt.writer.JwtJsonBuilder;
import org.uengine.jwt.writer.JwtWriterFactory;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.uengine.web.util.HttpUtils;
import org.uengine.web.util.JsonUtils;
import org.uengine.web.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by uengine on 2016. 2. 12..
 */
public class JiraTest {

    public static void main(String[] args) throws Exception{
        String jwtToken = createJwtToken();
        System.out.println(jwtToken);

//        String url = "http://localhost:2990/jira/rest/api/2/issue/10621/comment?jwt="+jwtToken;
//        HttpResponse response = new HttpUtils().makeRequest("GET", url, null, null);
//        HttpEntity entity = response.getEntity();
//        String resultString = EntityUtils.toString(entity);
//        System.out.println(resultString);

//        String url = "http://localhost:2990/jira/rest/api/2/project/10510/role?jwt="+jwtToken;
//        HttpResponse response = new HttpUtils().makeRequest("GET", url, null, null);
//        HttpEntity entity = response.getEntity();
//        String resultString = EntityUtils.toString(entity);
//        System.out.println(resultString);

        File file = new File("/Users/uengine/IdeaProjects/essencia/essencia-jira/src/main/resources/jira/template/comment.json");
        FileInputStream fisTargetFile = new FileInputStream(file);

        String targetFileStr = IOUtils.toString(fisTargetFile, "UTF-8");


        Map<String,String> headers = new HashMap();
        headers.put("Authorization","JWT " + jwtToken);
        headers.put("Content-Type", "application/json");

        String url = "http://localhost:2990/jira/rest/api/2/issue/10621/comment";
        HttpResponse response = new HttpUtils().makeRequest("POST", url, targetFileStr, headers);
        HttpEntity entity = response.getEntity();

        String resultString = EntityUtils.toString(entity);
        System.out.println(resultString);

    }


    public static String createJwtToken()
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        long issuedAt = System.currentTimeMillis() / 1000L;
        long expiresAt = issuedAt + 180L;
        String key = "essencia-jira"; //the key from the add-on descriptor
        String sharedSecret = "01cb3c9c-5f70-4504-a096-4c2d2ab3ca05";    //the sharedsecret key received
        //during the addon installation handshake
        String method = "POST";
        //String baseUrl = "http://localhost:2990/jira";
        String contextPath = "/jira";
        //String apiPath = "/rest/api/2/project/10510/role";
        //String apiPath = "/rest/api/2/issue/10621/comment";
        String apiPath = "/rest/api/2/issue/10621/comment";
        //String apiPath = "/rest/api/2/project/10000";

        JwtJsonBuilder jwtBuilder = new JsonSmartJwtJsonBuilder()
                .issuedAt(issuedAt)
                .expirationTime(expiresAt)
                .issuer(key);

//        Map map = new HashMap();
//        map.put("username", new String[]{"user1"});
        CanonicalHttpUriRequest canonical = new CanonicalHttpUriRequest(method,
                apiPath, contextPath, new HashMap());
        JwtClaimsBuilder.appendHttpRequestClaims(jwtBuilder, canonical);

        JwtWriterFactory jwtWriterFactory = new NimbusJwtWriterFactory();
        String jwtbuilt = jwtBuilder.build();
        String jwtToken = jwtWriterFactory.macSigningWriter(SigningAlgorithm.HS256,
                sharedSecret).jsonToJwt(jwtbuilt);

        //String apiUrl = baseUrl + apiPath + "?jwt=" + jwtToken;
        return jwtToken;
    }
}
