package org.uengine.web.jiraapi;

import com.atlassian.jwt.SigningAlgorithm;
import com.atlassian.jwt.core.writer.JsonSmartJwtJsonBuilder;
import com.atlassian.jwt.core.writer.JwtClaimsBuilder;
import com.atlassian.jwt.core.writer.NimbusJwtWriterFactory;
import com.atlassian.jwt.httpclient.CanonicalHttpUriRequest;
import com.atlassian.jwt.writer.JwtJsonBuilder;
import com.atlassian.jwt.writer.JwtWriterFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.util.EntityUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.uengine.web.exception.ServiceException;
import org.uengine.web.util.ApplicationContextRegistry;
import org.uengine.web.util.HttpUtils;
import org.uengine.web.util.JsonUtils;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by uengine on 2016. 2. 22..
 */
public class JiraApi {

    private String productContext;

    private String productBaseUrl;

    private String requestUserKey;

    private String addonKey;

    private String sharedSecret;

    private Map<String, String> headers;

    private String DEFAULT_ENCODING_FOR_URL = "UTF-8";

    public JiraApi(String productContext, String productBaseUrl, String requestUserKey,
                   String addonKey, String sharedSecret) {
        this.productContext = productContext;
        this.productBaseUrl = productBaseUrl;
        this.requestUserKey = requestUserKey;
        this.addonKey = addonKey;
        this.sharedSecret = sharedSecret;

        init();
    }

    public void init() {
        try {
            this.headers = new HashMap();
        } catch (Exception ex) {
            throw new ServiceException("Jira API를 초기화할 수 없습니다.", ex);
        }
    }

    public String createProject(String name, String key, String type, String lead) throws Exception {
        ApplicationContext context = ApplicationContextRegistry.getApplicationContext();
        VelocityEngine velocityEngine = (VelocityEngine) context.getBean(VelocityEngine.class);

        String apiPath = "/rest/api/2/project";

        Map model = new HashMap();
        model.put("name", name);
        model.put("key", key);
        model.put("type", type);
        model.put("lead", lead);

        String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "jira/template/project.json", "UTF-8", model);

        String excuted = this.excutePost(apiPath, body);
        return ((Map)JsonUtils.unmarshal(excuted)).get("id").toString();
    }

    public List<Map> projectTypes() throws Exception {
        String apiPath = "/rest/api/2/project/type";

        String excuted = this.excuteGet(apiPath, null);
        return JsonUtils.unmarshalToList(excuted);
    }

    public List<Map> getMembers(String groupName) throws Exception {
        String apiPath = "/rest/api/2/group/member";

        Map params = new HashMap();
        params.put("groupname", groupName);

        String excuted = this.excuteGet(apiPath, params);
        Map response = JsonUtils.unmarshal(excuted);
        List members = (List) response.get("values");
        return members;
    }

    public boolean isAdmin(String userKey) throws Exception {

        boolean isAdmin = false;
        List<Map> members = this.getMembers("jira-administrators");

        for (Map member : members) {
            String memberKey = (String) member.get("key");
            if (memberKey.equals(userKey)) {
                isAdmin = true;
            }
        }
        return isAdmin;
    }

    public Map getUser(String userKey) throws Exception {
        String apiPath = "/rest/api/2/user";

        Map params = new HashMap();
        params.put("key", userKey);

        String excuted = this.excuteGet(apiPath, params);
        return JsonUtils.unmarshal(excuted);
    }

    private String excutePost(String apiPath, String body) throws Exception{

        String jwtToken = this.createJwtToken("POST", apiPath, null);
        String url = this.productBaseUrl + this.productContext + apiPath;

        Map<String,String> headers = new HashMap();
        headers.put("Authorization","JWT " + jwtToken);
        headers.put("Content-Type", "application/json");

        HttpResponse response = new HttpUtils().makeRequest("POST", url, body, headers);
        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        if (statusCode != 200 && statusCode != 201 && statusCode != 204) {
            throw new ServiceException("statusCode" + statusCode + ", while excute" + url);
        }

        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity);
    }

    private String excuteGet(String apiPath, Map params) throws Exception {
        if (params == null) {
            params = new HashMap();
        }
        String jwtToken = this.createJwtToken("GET", apiPath, params);

        params.put("jwt", jwtToken);
        String queryString = this.createQueryString(params);
        String url = this.productBaseUrl + this.productContext + apiPath + queryString;

        HttpResponse response = new HttpUtils().makeRequest("GET", url, null, null);

        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();

        if (statusCode != 200) {
            throw new ServiceException("statusCode" + statusCode + ", while excute" + url);
        }

        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity);
    }

    private String createJwtToken(String method, String apiPath, Map<String, String> params)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        long issuedAt = System.currentTimeMillis() / 1000L;
        long expiresAt = issuedAt + 180L;
        String key = this.addonKey;
        String sharedSecret = this.sharedSecret;


        String contextPath = this.productContext;

        JwtJsonBuilder jwtBuilder = new JsonSmartJwtJsonBuilder()
                .issuedAt(issuedAt)
                .expirationTime(expiresAt)
                .issuer(key);

        Map canonicalMap = new HashMap();
        if (params != null) {
            Set<String> keySet = params.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String paramKey = iterator.next();
                String paramValue = params.get(paramKey);
                canonicalMap.put(paramKey, new String[]{paramValue});
            }
        }
        CanonicalHttpUriRequest canonical = new CanonicalHttpUriRequest(method,
                apiPath, contextPath, canonicalMap);
        JwtClaimsBuilder.appendHttpRequestClaims(jwtBuilder, canonical);

        JwtWriterFactory jwtWriterFactory = new NimbusJwtWriterFactory();
        String jwtbuilt = jwtBuilder.build();
        String jwtToken = jwtWriterFactory.macSigningWriter(SigningAlgorithm.HS256,
                sharedSecret).jsonToJwt(jwtbuilt);

        return jwtToken;
    }

    private String createQueryString(Map<String, String> params) {
        StringBuilder sb = new StringBuilder("");

        List<String> listOfParams = new ArrayList<String>();
        for (String param : params.keySet()) {
            listOfParams.add(param + "=" + this.encodeString(params.get(param)));
        }

        if (!listOfParams.isEmpty()) {
            String query = org.apache.commons.lang.StringUtils.join(listOfParams, "&");
            sb.append("?");
            sb.append(query);
        }

        return sb.toString();
    }

    private String encodeString(String name) throws NullPointerException {
        String tmp = null;

        if (name == null)
            return null;

        try {
            tmp = java.net.URLEncoder.encode(name, this.DEFAULT_ENCODING_FOR_URL);
        } catch (Exception e) {
        }

        if (tmp == null)
            throw new NullPointerException();

        return tmp;
    }
}
