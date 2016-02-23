package org.uengine.web.company;

import org.metaworks.dao.TransactionAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.uengine.codi.mw3.model.Company;
import org.uengine.codi.mw3.model.ICompany;

import java.util.Arrays;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    TransactionAdvice transactionAdvice;


    @Override
    public void createJiraCompanyIfNotExist(String clientKey) throws Exception {
        Company selectByAlias = this.selectByAlias(clientKey);
        if (selectByAlias == null) {
            this.createCompany(clientKey);
        }
    }

    private void createCompany(String clientKey) throws Exception {
        try {
            transactionAdvice.initiateTransaction();

            Company company = new Company();
            String newId = company.createNewId();
            company.setComCode(newId);
            company.setComName(clientKey);
            company.setAlias(clientKey);
            company.createDatabaseMe();

            transactionAdvice.commitTransaction();
        } catch (Exception ex) {
            transactionAdvice.rollbackTransaction();
            throw new Exception(ex);
        }
    }

    @Override
    public Company selectByAlias(String clientKey) throws Exception {
        try {
            transactionAdvice.initiateTransaction();

            Company company = new Company();
            Company result = new Company();
            company.setAlias(clientKey);
            ICompany companyByAlias = company.findByAlias();
            result.copyFrom(companyByAlias);

            transactionAdvice.commitTransaction();
            return result;
        } catch (Exception ex) {
            transactionAdvice.rollbackTransaction();
            throw new Exception(ex);
        }
    }
}
