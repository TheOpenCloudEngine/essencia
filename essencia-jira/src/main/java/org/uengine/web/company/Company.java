package org.uengine.web.company;

/**
 * Created by uengine on 2016. 2. 15..
 */
public class Company {

    private String comCode;
    private String comName;
    private String description;
    private String isDeleted;
    private String repMail;
    private String repMlHst;
    private String repMlPwd;
    private String alias;
    private String logoPath;

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getRepMail() {
        return repMail;
    }

    public void setRepMail(String repMail) {
        this.repMail = repMail;
    }

    public String getRepMlHst() {
        return repMlHst;
    }

    public void setRepMlHst(String repMlHst) {
        this.repMlHst = repMlHst;
    }

    public String getRepMlPwd() {
        return repMlPwd;
    }

    public void setRepMlPwd(String repMlPwd) {
        this.repMlPwd = repMlPwd;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    @Override
    public String toString() {
        return "Company{" +
                "comCode='" + comCode + '\'' +
                ", comName='" + comName + '\'' +
                ", description='" + description + '\'' +
                ", isDeleted='" + isDeleted + '\'' +
                ", repMail='" + repMail + '\'' +
                ", repMlHst='" + repMlHst + '\'' +
                ", repMlPwd='" + repMlPwd + '\'' +
                ", alias='" + alias + '\'' +
                ", logoPath='" + logoPath + '\'' +
                '}';
    }
}
