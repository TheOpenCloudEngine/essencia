package org.uengine.web.company;

import org.metaworks.dao.TransactionContext;
import org.metaworks.spring.SpringConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uengine.codi.mw3.model.*;
import org.uengine.codi.mw3.model.Company;

@Service
public class CompanyTestImpl implements CompanyTest {

    @Autowired
    SpringConnectionFactory connectionFactory;

    @Override
    @Transactional
    public void selectTest() throws Exception{
        org.uengine.codi.mw3.model.Company company = new Company();
        company.setComCode("1");
        ICompany iCompany = company.findByCode();

        System.out.println(iCompany.toString());
    }

    @Override
    @Transactional
    public void insertTest() throws Exception{
        org.uengine.codi.mw3.model.Company company = new Company();
        String newId = company.createNewId();
        company.setComCode(newId);
        company.createDatabaseMe();
    }

    @Override
    public void insertTestWorkArround() throws Exception {
        TransactionContext tx = new TransactionContext(); //once a TransactionContext is created, it would be cached by ThreadLocal.set, so, we need to remove this after the request processing.
        tx.setManagedTransaction(false);
        tx.setAutoCloseConnection(true);

        if (connectionFactory != null)
            tx.setConnectionFactory(connectionFactory);

        org.uengine.codi.mw3.model.Company company = new Company();
        String newId = company.createNewId();
        company.setComCode(newId);
        company.createDatabaseMe();


        try {
            if (TransactionContext.getThreadLocalInstance() != null)
                TransactionContext.getThreadLocalInstance().commit();
        } catch (Exception ex) {
            if (TransactionContext.getThreadLocalInstance() != null)
                try {
                    TransactionContext.getThreadLocalInstance().rollback();
                } catch (Exception e) {

                }
        }
    }
}
