package org.uengine.web.jiraclient;

/**
 * Created by cloudine on 2015. 6. 12..
 */
public class JiraClient {

    private Long id;

    private String addonKey;

    private String clientKey;

    private String publicKey;

    private String sharedSecret;

    private String serverVersion;

    private String pluginsVersion;

    private String baseUrl;

    private String productType;

    private String description;

    private String serviceEntitlementNumber;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddonKey() {
        return addonKey;
    }

    public void setAddonKey(String addonKey) {
        this.addonKey = addonKey;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getSharedSecret() {
        return sharedSecret;
    }

    public void setSharedSecret(String sharedSecret) {
        this.sharedSecret = sharedSecret;
    }

    public String getServerVersion() {
        return serverVersion;
    }

    public void setServerVersion(String serverVersion) {
        this.serverVersion = serverVersion;
    }

    public String getPluginsVersion() {
        return pluginsVersion;
    }

    public void setPluginsVersion(String pluginsVersion) {
        this.pluginsVersion = pluginsVersion;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServiceEntitlementNumber() {
        return serviceEntitlementNumber;
    }

    public void setServiceEntitlementNumber(String serviceEntitlementNumber) {
        this.serviceEntitlementNumber = serviceEntitlementNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JiraClient{" +
                "id=" + id +
                ", addonKey='" + addonKey + '\'' +
                ", clientKey='" + clientKey + '\'' +
                ", publicKey='" + publicKey + '\'' +
                ", sharedSecret='" + sharedSecret + '\'' +
                ", serverVersion='" + serverVersion + '\'' +
                ", pluginsVersion='" + pluginsVersion + '\'' +
                ", baseUrl='" + baseUrl + '\'' +
                ", productType='" + productType + '\'' +
                ", description='" + description + '\'' +
                ", serviceEntitlementNumber='" + serviceEntitlementNumber + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
