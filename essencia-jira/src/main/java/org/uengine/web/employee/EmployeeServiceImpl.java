package org.uengine.web.employee;

import org.metaworks.dao.TransactionAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uengine.codi.mw3.model.*;
import org.uengine.web.company.CompanyService;
import org.uengine.web.jiraapi.JiraApi;
import org.uengine.web.jiraapi.JiraServiceFactory;
import org.uengine.web.jiraclient.JiraClientService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    TransactionAdvice transactionAdvice;

    @Autowired
    JiraServiceFactory serviceFactory;

    @Autowired
    JiraClientService jiraClientService;

    @Autowired
    CompanyService companyService;

    @Override
    public Employee createJiraEmployeeIfNotExist(HttpServletRequest request, String userKey) throws Exception {
        JiraApi jiraApi = serviceFactory.create(request);
        Map user = jiraApi.getUser(userKey);

        String emailAddress = user.get("emailAddress").toString();

        String clientKey = jiraClientService.getClientKeyFromRequest(request);
        Company company = companyService.selectByAlias(clientKey);

        Employee employee = this.findByEmailAndGlobalCom(emailAddress, userKey, company.getComCode());
        if (employee == null) {
            employee = this.createJiraEmployee(emailAddress, userKey, company.getComCode());
        }
        return employee;
    }

    @Override
    public Employee findByEmailAndGlobalCom(String email, String userKey, String comCode) throws Exception {
        try {
            transactionAdvice.initiateTransaction();

            Employee employee = new Employee();
            IEmployee iemployee = employee.findByEmailAndKeyAndGlobalCom(email, userKey, comCode);
            employee.copyFrom(iemployee);
            if (iemployee == null) {
                employee = null;
            }

            transactionAdvice.commitTransaction();
            return employee;
        } catch (Exception ex) {
            transactionAdvice.rollbackTransaction();
            throw new Exception(ex);
        }
    }

    @Override
    public Employee findByEmpCode(String empCode) throws Exception {
        try {
            transactionAdvice.initiateTransaction();

            Employee employee = new Employee();

            IEmployee iemployee = employee.findByEmpCode(empCode);
            employee.copyFrom(iemployee);
            if (iemployee == null) {
                employee = null;
            }

            transactionAdvice.commitTransaction();
            return employee;
        } catch (Exception ex) {
            transactionAdvice.rollbackTransaction();
            throw new Exception(ex);
        }
    }

    private Employee createJiraEmployee(String email, String userKey, String comCode) throws Exception {
        try {
            transactionAdvice.initiateTransaction();
            Employee employee = new Employee();
            String newId = employee.createNewId();
            employee.setEmpCode(newId);
            employee.setEmpName(userKey);
            employee.setPassword(userKey);
            employee.setIsAdmin(false);
            employee.setEmail(email);
            employee.setGlobalCom(comCode);
            employee.setIsDeleted("0");
            employee.setLocale("ko");
            employee.setApproved(true);
            employee.setGuest(false);

            IEmployee iEmployee = employee.createDatabaseMe();
            employee.copyFrom(iEmployee);
            if (iEmployee == null) {
                employee = null;
            }

            transactionAdvice.commitTransaction();
            return employee;
        } catch (Exception ex) {
            transactionAdvice.rollbackTransaction();
            throw new Exception(ex);
        }
    }
}
