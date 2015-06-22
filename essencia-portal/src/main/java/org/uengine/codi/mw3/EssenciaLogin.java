package org.uengine.codi.mw3;

import org.metaworks.*;
import org.metaworks.Loader;
import org.metaworks.dao.TransactionContext;
import org.oce.garuda.multitenancy.TenantContext;
import org.uengine.codi.mw3.admin.TopPanel;
import org.uengine.codi.mw3.common.MainPanel;
import org.uengine.codi.mw3.model.*;
import org.uengine.codi.mw3.model.Application;
import org.uengine.codi.mw3.model.Session;
import org.uengine.essencia.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class EssenciaLogin extends Login{

    @Override
    public Object[] login() throws Exception {
        Session session = loginService();

        return login(session);
    }

    @Override
    public Object[] login(Session session) throws Exception {
        session.fillSession();
        session.fillUserInfoToHttpSession();

        storeIntoServerSession(session);

        HttpServletRequest httpServletRequest = TransactionContext.getThreadLocalInstance().getRequest();

        String ipAddress = httpServletRequest.getRemoteAddr();

        CodiLog log = new CodiLog();
        log.setId(log.createNewId());
        log.setEmpcode(session.getEmployee().getEmpCode());
        log.setComCode(session.getEmployee().getGlobalCom());
        log.setType("login");
        log.setDate(new Date());
        log.setIp(ipAddress);
        log.createDatabaseMe();

        MainPanel mainPanel;

        if(session !=null && session.getCompany()!=null && TenantContext.getThreadLocalInstance().getTenantId() == null){
            new TenantContext(session.getCompany().getComCode());
        }

        EssenciaApplication app = null;

        if (app == null){
            app = new EssenciaApplication();

            org.uengine.essencia.Loader loader = new org.uengine.essencia.Loader();
            loader.setUserId(session.getUser().getUserId());
            Essencia essencia = (Essencia) loader.run();

            app.setEssencia(essencia);
        }


        TopPanel topPanel = new TopPanel(session);
        topPanel.setTopCenterTitle("Practice Composer");

        if (!SNS.isPhone())
            topPanel.setTopCenterPanel(app.loadTopCenterPanel(session));

        mainPanel = new MainPanel(topPanel, app);

        if (SNS.isPhone()) {
            mainPanel.setPerspectivePanel(new PerspectivePanel(session));
        }

        Locale locale = new Locale();
        locale.setLanguage(session.getEmployee().getLocale());
        locale.load();

        System.out.println(getSsoService() + "   <====================================================  ");

        if (getSsoService() != null)
            return new Object[]{new org.metaworks.Forward(getSsoService())};

        return new Object[]{new Refresh(session), new Refresh(locale), new Refresh(mainPanel, false, true)};
    }
}