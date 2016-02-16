package org.uengine.web.company;

import org.uengine.web.process.ProcessMap;

import java.util.List;

public interface CompanyService {

    int createKey();

    void createJiraCompanyIfNotExist(String clientKey);

    Company selectByAlias(String clientKey);
}
