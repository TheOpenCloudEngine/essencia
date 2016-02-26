package org.uengine.web.company;

import org.uengine.codi.mw3.model.Company;

public interface CompanyService {

    void createJiraCompanyIfNotExist(String clientKey) throws Exception;

    Company selectByAlias(String clientKey) throws Exception;

}
