package org.uengine.web.jiraclient;

import com.atlassian.jwt.core.http.JavaxJwtRequestExtractor;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import net.minidev.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uengine.web.company.Company;
import org.uengine.web.company.CompanyService;
import org.uengine.web.exception.ServiceException;
import org.uengine.web.util.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.Map;
import java.util.Properties;

@Service
public class JiraClientServiceImpl implements JiraClientService {

    @Autowired
    @Qualifier("config")
    private Properties config;

    @Autowired
    private JiraClientRepository clientRepository;

    @Autowired
    private JiraClientLifecycleRepository lifecycleRepository;

    @Autowired
    private CompanyService companyService;

    @Override
    public void install(Map payload) throws Exception {
        String clientKey = payload.get("clientKey").toString();
        JiraClient existClient = clientRepository.selectByClientKey(clientKey);

        //재등록일 경우
        if (existClient != null) {
            JiraClient jiraClient = this.convertJiraClient(payload);
            jiraClient.setStatus("enable");
            jiraClient.setId(existClient.getId());
            clientRepository.replaceClient(jiraClient);

            this.insertLifeCycle(jiraClient.getId(), payload);
        }
        //신규 등록일 경우
        else {
            JiraClient jiraClient = this.convertJiraClient(payload);
            jiraClient.setStatus("enable");
            clientRepository.insert(jiraClient);

            this.insertLifeCycle(jiraClient.getId(), payload);
        }
    }

    @Override
    @Transactional
    public void uninstalled(Map payload) throws Exception {
        String clientKey = payload.get("clientKey").toString();
        JiraClient existClient = clientRepository.selectByClientKey(clientKey);
        if (existClient != null) {
            clientRepository.updateStatus(existClient.getId(), "uninstalled");

            this.insertLifeCycle(existClient.getId(), payload);
        }
    }

    @Override
    public void enabled(Map payload) throws IOException {
        String clientKey = payload.get("clientKey").toString();
        JiraClient existClient = clientRepository.selectByClientKey(clientKey);
        if (existClient != null) {
            clientRepository.updateStatus(existClient.getId(), "enabled");

            this.insertLifeCycle(existClient.getId(), payload);
        }
    }

    @Override
    public void disabled(Map payload) throws IOException {
        String clientKey = payload.get("clientKey").toString();
        JiraClient existClient = clientRepository.selectByClientKey(clientKey);
        if (existClient != null) {
            clientRepository.updateStatus(existClient.getId(), "disabled");

            this.insertLifeCycle(existClient.getId(), payload);
        }
    }

    /**
     * Jira 관련 페이지 접속시 페이지 앞단에서 실행되는 로직.
     * JWT 토큰의 validation 수행
     * JWT 토큰의 세션저장
     * Jira Company 체크
     * Jira comCode 세션 저장
     *
     * @return Model And View
     */
    @Override
    public String validateAndGetClaim(HttpServletRequest request) throws Exception {
        String jwtToken = null;
        HttpSession session = request.getSession();
        jwtToken = this.getJwtToken(request);
        if (jwtToken == null) {
            if (session.getAttribute("jwtToken") != null) {
                jwtToken = session.getAttribute("jwtToken").toString();
            } else {
                throw new ServiceException("Not found jwtToken.");
            }
        } else {
            session.setAttribute("jwtToken", jwtToken);
        }

        String parseToken = this.parseToken(jwtToken);
        String clientKey = this.getClientKeyFromClaimJson(parseToken);
        companyService.createJiraCompanyIfNotExist(clientKey);
        Company company = companyService.selectByAlias(clientKey);
        if(company != null){
            session.setAttribute("comCode", company.getComCode());
        }
        return parseToken;
    }

    @Override
    public String getClientKeyFromClaimJson(String claimJson) throws Exception {
        try {
            Map claimMap = JsonUtils.unmarshal(claimJson);
            return (String) claimMap.get("iss");
        } catch (Exception e) {
            throw new ServiceException("Can not parse iss key in given clamimJson");
        }
    }

    @Override
    public String getClientKeyFromRequest(HttpServletRequest request) throws Exception {
        String claimJson = this.validateAndGetClaim(request);
        String clientKey = this.getClientKeyFromClaimJson(claimJson);
        return clientKey;
    }

    @Override
    public String getClientKeyFromSession(HttpSession session) throws Exception {
        String jwtToken = null;
        if (session.getAttribute("jwtToken") != null) {
            jwtToken = session.getAttribute("jwtToken").toString();
        } else {
            throw new ServiceException("Not found jwtToken.");
        }
        String claimJson = this.parseToken(jwtToken);
        return this.getClientKeyFromClaimJson(claimJson);
    }

    private String parseToken(String jwtToken) throws Exception {
        String[] base64UrlEncodedSegments = jwtToken.split("\\.");
        String base64UrlEncodedHeader = base64UrlEncodedSegments[0];
        String base64UrlEncodedClaims = base64UrlEncodedSegments[1];
        String signature = base64UrlEncodedSegments[2];
        String header = this.base64UrlDecode(base64UrlEncodedHeader);
        String claimses = this.base64UrlDecode(base64UrlEncodedClaims);

        Map claimsMap = JsonUtils.marshal(claimses);
        String iss = claimsMap.get("iss").toString();

        JiraClient jiraClient = clientRepository.selectByClientKey(iss);
        if (jiraClient == null) {
            throw new ServiceException("Not found plugin client :" + iss);
        }

        JWSVerifier verifier = new MACVerifier(jiraClient.getSharedSecret());
        JWTClaimsSet claimsSet = this.read(jwtToken, verifier);
        JSONObject jsonObject = claimsSet.toJSONObject();
        return jsonObject.toJSONString();
    }

    private void insertLifeCycle(Long jiraClientId, Map payload) throws IOException {
        JiraClientLifecycle clientLifecycle = new JiraClientLifecycle();
        clientLifecycle.setEventType(payload.get("eventType").toString());
        clientLifecycle.setJiraClientId(jiraClientId);
        clientLifecycle.setPayload(JsonUtils.marshal(payload));
        lifecycleRepository.insert(clientLifecycle);
    }

    private JiraClient convertJiraClient(Map payload) {
        JiraClient jiraClient = new JiraClient();

        jiraClient.setAddonKey(payload.get("key") != null ? payload.get("key").toString() : null);
        jiraClient.setClientKey(payload.get("clientKey") != null ? payload.get("clientKey").toString() : null);
        jiraClient.setPublicKey(payload.get("publicKey") != null ? payload.get("publicKey").toString() : null);
        jiraClient.setSharedSecret(payload.get("sharedSecret") != null ? payload.get("sharedSecret").toString() : null);
        jiraClient.setServerVersion(payload.get("serverVersion") != null ? payload.get("serverVersion").toString() : null);
        jiraClient.setPluginsVersion(payload.get("pluginsVersion") != null ? payload.get("pluginsVersion").toString() : null);
        jiraClient.setBaseUrl(payload.get("baseUrl") != null ? payload.get("baseUrl").toString() : null);
        jiraClient.setProductType(payload.get("productType") != null ? payload.get("productType").toString() : null);
        jiraClient.setDescription(payload.get("description") != null ? payload.get("description").toString() : null);
        jiraClient.setServiceEntitlementNumber(payload.get("serviceEntitlementNumber") != null ? payload.get("serviceEntitlementNumber").toString() : null);

        return jiraClient;
    }

    private String getJwtToken(HttpServletRequest request) {
        JavaxJwtRequestExtractor jwtRequestExtractor = new JavaxJwtRequestExtractor();
        String jwt = jwtRequestExtractor.extractJwt(request);
        return jwt;
    }

    private String base64UrlDecode(String input) {
        System.out.println(Base64.class.getProtectionDomain().getCodeSource().getLocation());
        byte[] bytes = Base64.decodeBase64(input);
        return new String(bytes);
    }

    public JWTClaimsSet read(String jwt, JWSVerifier verifier) throws ParseException, JOSEException {
        JWSObject jwsObject = JWSObject.parse(jwt);

        if (!jwsObject.verify(verifier)) {
            throw new IllegalArgumentException("Fraudulent JWT token: " + jwt);
        }

        JSONObject jsonPayload = jwsObject.getPayload().toJSONObject();
        return JWTClaimsSet.parse(jsonPayload);
    }
}
