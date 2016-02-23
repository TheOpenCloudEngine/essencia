package org.uengine.web.employee;

import org.uengine.codi.mw3.model.Company;
import org.uengine.codi.mw3.model.Employee;
import org.uengine.codi.mw3.model.Session;

import javax.servlet.http.HttpServletRequest;

public interface EmployeeService {

    Employee createJiraEmployeeIfNotExist(HttpServletRequest request, String userKey) throws Exception;

    Employee findByEmailAndGlobalCom(String email, String userKey, String comCode) throws Exception;
}
