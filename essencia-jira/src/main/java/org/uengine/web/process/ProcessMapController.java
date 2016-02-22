package org.uengine.web.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.uengine.web.jiraclient.JiraClientService;
import org.uengine.web.rest.Response;
import org.uengine.web.util.ExceptionUtils;

import java.util.Map;

/**
 * Created by uengine on 2016. 1. 29..
 */

@Controller
@RequestMapping("/process")
public class ProcessMapController {

    @Autowired
    JiraClientService jiraClientService;

    /**
     * 지라 플러그인에서 프로젝트를 생성하였을 때의 처리
     *
     * @return Response
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Response create(@RequestBody Map params) {
        Response response = new Response();
        try {
            System.out.println(params);
            response.setSuccess(true);
        } catch (Exception ex) {
            response.setSuccess(false);
            response.getError().setMessage(ex.getMessage());
            if (ex.getCause() != null) response.getError().setCause(ex.getCause().getMessage());
            response.getError().setException(ExceptionUtils.getFullStackTrace(ex));
        }
        return response;
    }
}
