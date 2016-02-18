package org.uengine.web.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uengine.web.process.ProcessMap;
import org.uengine.web.process.ProcessMapRepository;
import org.uengine.web.process.ProcessMapService;

import java.util.List;
import java.util.Properties;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    @Qualifier("config")
    private Properties config;

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public int createKey() {
        return companyRepository.createKey();
    }

    @Override
    public void createJiraCompanyIfNotExist(String clientKey) {

        //TODO Mybatis 안쓰고 기존의 Metawork Dao 로 컴퍼니 만들기.....
        Company company = companyRepository.selectByAlias(clientKey);
        if (company == null) {
            int key = companyRepository.createKey();
            company = new Company();
            company.setComCode(key + "");
            company.setComName(clientKey);
            company.setAlias(clientKey);
            company.setIsDeleted("0");
            companyRepository.insert(company);
        }
    }

    @Override
    public Company selectByAlias(String clientKey) {
        return companyRepository.selectByAlias(clientKey);
    }
}
