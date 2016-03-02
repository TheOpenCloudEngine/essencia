package org.uengine.web.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.uengine.codi.mw3.model.Company;
import org.uengine.codi.mw3.model.ProcessMap;
import org.uengine.kernel.Role;
import org.uengine.processmanager.ProcessManagerRemote;
import org.uengine.web.company.CompanyService;
import org.uengine.web.jiraapi.JiraApi;
import org.uengine.web.jiraapi.JiraServiceFactory;
import org.uengine.web.jiraclient.JiraClientService;
import org.uengine.web.process.ProcessMapService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
    public ModelAndView index(HttpServletRequest request, HttpSession session) {

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
            ProcessMap processMap = processMapService.getProcessMapByMapId(mapId);
            view.addObject("processMap", processMap);

            List<Role> roles = processMapService.getRoles(processMap.getDefId(), processMap.getComCode());
            view.addObject("roles", roles);

            JiraApi jiraApi = serviceFactory.create(request);
            List<Map> projectTypes = jiraApi.projectTypes();
            view.addObject("projectTypes", projectTypes);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return view;
    }

    @RequestMapping(value = "/getting-started", method = RequestMethod.GET)
    public ModelAndView gettingStarted(HttpServletRequest request, HttpSession session) {

        return new ModelAndView("page/getting-started");
    }
}
