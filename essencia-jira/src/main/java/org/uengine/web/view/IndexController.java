package org.uengine.web.view;

import org.oce.garuda.multitenancy.TenantContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.uengine.codi.mw3.model.Company;
import org.uengine.codi.mw3.model.IProcessMap;
import org.uengine.codi.mw3.model.Session;
import org.uengine.kernel.Role;
import org.uengine.processmanager.ProcessManagerRemote;
import org.uengine.web.process.ProcessMap;
import org.uengine.web.process.ProcessMapService;
import org.uengine.web.util.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.rmi.RemoteException;
import java.util.Properties;

@Controller
@RequestMapping("/view")
public class IndexController {

    /**
     * SLF4J Logging
     */
    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    @Qualifier("config")
    private Properties config;


    @Autowired
    private ProcessMapService processMapService;

    @Autowired
    public ProcessManagerRemote processManager;

    /**
     * 인덱스 페이지로 이동한다.
     *
     * @return Model And View
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpSession session) {

        return new ModelAndView("page/index");
    }

    @RequestMapping(value = "list-project", method = RequestMethod.GET)
    public ModelAndView listProject(HttpServletRequest request, HttpSession session) {
        return new ModelAndView("page/list-project");
    }

    @RequestMapping(value = "project-detail", method = RequestMethod.GET)
    @Transactional
    public ModelAndView projectDetail(HttpServletRequest request, HttpSession session,
                                      @RequestParam(defaultValue = "") String mapId) {

        ModelAndView view = new ModelAndView("page/project-detail");
        try {
            ProcessMap processMap = processMapService.getProcessMapByMapId(mapId);
            view.addObject("processMap", processMap);
        } finally {
            return view;
        }
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @Transactional
    public void test(HttpServletRequest request, HttpSession session) throws RemoteException {

        new TenantContext("2");
        org.uengine.kernel.ProcessDefinition definition = processManager.getProcessDefinition("Scrum Practice/KOSTA Essence.method");
        Role[] roles = definition.getRoles();
        System.out.println(roles.length);
        //System.out.println(definition.toString());

    }

}
