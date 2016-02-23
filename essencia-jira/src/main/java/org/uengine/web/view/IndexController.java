package org.uengine.web.view;

import org.apache.velocity.app.VelocityEngine;
import org.oce.garuda.multitenancy.TenantContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.uengine.codi.mw3.model.*;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.kernel.Role;
import org.uengine.processmanager.ProcessManagerRemote;
import org.uengine.web.company.CompanyService;
import org.uengine.web.jiraapi.JiraApi;
import org.uengine.web.jiraapi.JiraApiService;
import org.uengine.web.jiraapi.JiraServiceFactory;
import org.uengine.web.jiraclient.JiraClientService;
import org.uengine.web.process.ProcessMapService;
import org.uengine.web.util.JsonUtils;
import org.uengine.web.util.ResourceUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.rmi.RemoteException;
import java.util.*;

@Controller
@RequestMapping("/view")
public class IndexController {

    /**
     * SLF4J Logging
     */
    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private ProcessMapService processMapService;

    @Autowired
    private JiraClientService jiraClientService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    ProcessManagerRemote processManager;

    @Autowired
    JiraServiceFactory serviceFactory;

    /**
     * 인덱스 페이지로 이동한다.
     *
     * @return Model And View
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpSession session) throws Exception {

        String s = jiraClientService.validateAndGetClaim(request);
        System.out.println(s);
        return new ModelAndView("page/index");
    }

    @RequestMapping(value = "/list-project", method = RequestMethod.GET)
    public ModelAndView listProject(HttpServletRequest request, HttpSession session) throws Exception {

        ModelAndView view = new ModelAndView("page/list-project");

        String clientKey = jiraClientService.getClientKeyFromSession(session);
        Company company = companyService.selectByAlias(clientKey);
        List<ProcessMap> processMaps = processMapService.listPublicAndOwnProcessMap(company.getComCode());

        view.addObject("processMaps", processMaps);

        return view;
    }

    @RequestMapping(value = "/project-detail", method = RequestMethod.GET)
    public ModelAndView projectDetail(HttpServletRequest request, HttpSession session,
                                      @RequestParam(defaultValue = "") String mapId) {

        ModelAndView view = new ModelAndView("page/project-detail");
        try {
            JiraApi jiraApi = serviceFactory.create(request);
            List<Map> projectTypes = jiraApi.projectTypes();
            view.addObject("projectTypes", projectTypes);

            ProcessMap processMap = processMapService.getProcessMapByMapId(mapId);
            view.addObject("processMap", processMap);

            List<Role> roles = processMapService.getRoles(processMap.getDefId(), processMap.getComCode());
            view.addObject("roles", roles);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return view;
    }

    /**
     * 이슈 액티비티 카드
     *
     * @return Model And View
     */
    @RequestMapping(value = "/activityCard", method = RequestMethod.GET)
    public ModelAndView activityCard(HttpServletRequest request, HttpSession session) {

        return new ModelAndView("page/activityCard");
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test(HttpServletRequest request, HttpSession session) throws RemoteException {

        new TenantContext("2");
        org.uengine.kernel.ProcessDefinition definition = processManager.getProcessDefinition("Scrum Practice/KOSTA Essence.method");
        Role[] roles = definition.getRoles();
        System.out.println(roles.length);
        //System.out.println(definition.toString());

    }

}
