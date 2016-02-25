package org.uengine.web.jiraissue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.uengine.web.jiraclient.JiraClientService;
import org.uengine.web.process.ProcessMapService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by uengine on 2016. 1. 29..
 */

@Controller
@RequestMapping("/issue")
public class JiraIssueController {

    @Autowired
    JiraClientService jiraClientService;

    @Autowired
    JiraIssueService issueService;

    @Autowired
    ProcessMapService processMapService;

    /**
     * Jira 이슈가 업데이트 되었을때의 처리
     *
     * @return ResponseEntity
     */
    @RequestMapping(value = "/updated", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity updated(HttpServletRequest request, @RequestBody Map payload) {
        try {
            String clientKey = jiraClientService.getClientKeyFromRequest(request);
            issueService.updated(clientKey, payload);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
