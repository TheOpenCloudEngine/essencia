package org.uengine.web.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.uengine.web.jiraapi.JiraApiService;
import org.uengine.web.jiraclient.JiraClientService;
import org.uengine.web.rest.Response;
import org.uengine.web.util.ExceptionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by uengine on 2016. 1. 29..
 */

@Controller
@RequestMapping("/process")
public class ProcessMapController {

    @Autowired
    JiraClientService jiraClientService;

    @Autowired
    JiraApiService jiraApiService;

    @Autowired
    ProcessMapService processMapService;

    /**
     * 지라 플러그인에서 프로젝트를 생성하였을 때의 처리
     *
     * @return Response
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Response create(@RequestBody Map params, HttpServletRequest request) {
        Response response = new Response();
        try {

            String requestUserKey = jiraClientService.getRequestUserKey(request);
            String mapId = params.get("mapId").toString();
            String projectName = params.get("name").toString();
            String projectKey = params.get("key").toString().toUpperCase();
            String projectType = params.get("projectType").toString();
            List<Map> roleMapping = (List) params.get("roleMapping");

            boolean isAdmin = jiraApiService.isAdmin(request, requestUserKey);
            if (!isAdmin) {
                response.setSuccess(false);
                response.getError().setMessage("permission");
            } else {
                processMapService.createProcess(request, projectName, projectKey, projectType, mapId, roleMapping);
                response.setSuccess(true);
            }
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
