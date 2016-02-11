package org.uengine.web.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.uengine.web.process.ProcessMap;
import org.uengine.web.process.ProcessMapService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

}
