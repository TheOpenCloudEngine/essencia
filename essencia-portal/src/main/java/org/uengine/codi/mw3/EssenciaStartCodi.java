package org.uengine.codi.mw3;

import org.metaworks.Refresh;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dao.TransactionContext;
import org.oce.garuda.multitenancy.TenantContext;
import org.uengine.codi.mw3.model.*;
import org.uengine.sso.BaseAuthenticate;
import org.uengine.sso.CasAuthenticate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by hoo.lim on 6/18/2015.
 */
public class EssenciaStartCodi extends StartCodi{

    @Override
    public Object load() throws Exception{

        HttpSession httpSession = TransactionContext.getThreadLocalInstance().getRequest().getSession();
        if("1".equals(USE_CAS)){
            String ssoService = getSsoService();

            BaseAuthenticate ssoAuth = new CasAuthenticate();
            if(ssoAuth.vaild()){
                return login();
            }
        }else{
            String loggedUserId = (String)httpSession.getAttribute("loggedUserId");

            if(loggedUserId != null)
                return login();

            String tenantId = TenantContext.getThreadLocalInstance().getTenantId();

            if(tenantId != null){
                Company findCompany = new Company();
                findCompany.setAlias(tenantId);
                ICompany company = findCompany.findByAlias();

                if(company != null){
                    EssenciaLogin login = new EssenciaLogin();
                    login.setCompanyName(company.getComName());
                    return new Refresh(login, false, true);
                }
            }
        }

        if("login".equals(this.getKey()) || this.getLastVisitPage() != null || ssoService != null){

            EssenciaLogin login = new EssenciaLogin();
            if(ssoService != null)
                login.setSsoService(ssoService);

            return new Refresh(login, false, true);

        }else{
            return new Refresh(new EssenciaSignUp(), false, true);
        }

    }

    @Override
    public Object[] login() throws Exception {
        HttpSession httpSession = TransactionContext.getThreadLocalInstance().getRequest().getSession();
        String loggedUserId = (String)httpSession.getAttribute("loggedUserId");

        Employee emp = new Employee();
        emp.setEmpCode(loggedUserId);
        IEmployee findEmp = emp.findMe();

        Session session = new Session();
        session.setEmployee(findEmp);

        EssenciaLogin login = new EssenciaLogin();
        login.lastVisitPage = this.getLastVisitPage();
        login.lastVisitValue = this.getLastVisitValue();

        System.out.println("ssoService == " + getSsoService());
        if(ssoService != null && ssoService.endsWith("callbackAuthorize"))
            login.setSsoService(ssoService+"?ticket=" + (String)httpSession.getAttribute("SSO-ST") );

        try{
            return login.login(session);
        }catch(Exception e){
            e.printStackTrace();
        }

        return new Object[]{new Refresh(new EssenciaSignUp(), false, true)};
    }

    @Override
    public SignUp logout() throws Exception {
        this.getSession().removeUserInfoFromHttpSession();

        EssenciaLogin login = new EssenciaLogin();
        login.getMetaworksContext().setHow("logout");
        login.fireServerSession(this.getSession());

        HttpServletRequest httpServletRequest = TransactionContext.getThreadLocalInstance().getRequest();

        String ipAddress = httpServletRequest.getRemoteAddr();

        CodiLog  log = new CodiLog();

        log.setId(log.createNewId());
        log.setEmpcode(this.getSession().getEmployee().getEmpCode());
        log.setComCode(this.getSession().getEmployee().getGlobalCom());
        log.setType("logout");
        log.setDate(new Date());
        log.setIp(ipAddress);
        log.createDatabaseMe();

        return new EssenciaSignUp();
    }
}
