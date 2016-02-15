package org.uengine.web.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.uengine.web.company.Company;
import org.uengine.web.company.CompanyService;
import org.uengine.web.jiraclient.JiraClientService;
import org.uengine.web.rest.Response;
import org.uengine.web.util.ExceptionUtils;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Properties;

/**
 * Created by uengine on 2016. 1. 29..
 */

@Controller
@RequestMapping("/")
public class ProcessMapController {

    @Autowired
    @Qualifier("config")
    private Properties config;

    @Autowired
    private ProcessMapService processService;

    @Autowired
    private JiraClientService jiraClientService;

    @Autowired
    private CompanyService companyService;

    /**
     * 프로세스 리스트를 불러온다.
     */
    @RequestMapping(value = "process/list", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Response list(HttpSession session) throws Exception {
        Response response = new Response();
        try {

            //퍼블릭 프로세스맵리스트
            List<ProcessMap> publicProcessMap = processService.listPublicProcessMap();
            for (int i = 0; i < publicProcessMap.size(); i++) {
                publicProcessMap.get(i).setIsPublic(true);
                publicProcessMap.get(i).setIsNew(true);
            }
            response.getList().addAll(publicProcessMap);


            //지라 사용자 프로세스맵리스트
            String clientKey = jiraClientService.getClientKeyFromSession(session);
            Company company = companyService.selectByAlias(clientKey);
            List<ProcessMap> listProcessMap = processService.listProcessMapByComCode(company.getComCode());
            for (int i = 0; i < listProcessMap.size(); i++) {
                listProcessMap.get(i).setIsPublic(false);
                publicProcessMap.get(i).setIsNew(true);
            }

            response.getList().addAll(listProcessMap);
            response.setSuccess(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setSuccess(false);
            response.getError().setMessage(ex.getMessage());
            if (ex.getCause() != null) response.getError().setCause(ex.getCause().getMessage());
            response.getError().setException(ExceptionUtils.getFullStackTrace(ex));
        }
        return response;
    }
}
