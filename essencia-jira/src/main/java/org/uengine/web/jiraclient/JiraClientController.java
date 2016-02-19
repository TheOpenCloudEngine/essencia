package org.uengine.web.jiraclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Properties;

/**
 * Created by uengine on 2016. 1. 29..
 */

@Controller
@RequestMapping("/handshake")
public class JiraClientController {

    @Autowired
    JiraClientService jiraClientService;

    /**
     * Jira 플러그인이 인스톨되었을때의 처리.
     *
     * @return ResponseEntity
     */
    @RequestMapping(value = "/installed", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity installed(@RequestBody Map payload) {
        try {
            jiraClientService.install(payload);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Jira 플러그인이 언인스톨되었을때의 처리.
     *
     * @return ResponseEntity
     */
    @RequestMapping(value = "/uninstalled", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity uninstalled(@RequestBody Map payload) {
        try {
            jiraClientService.uninstalled(payload);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Jira 플러그인이 Enabled 되었을때의 처리.
     *
     * @return ResponseEntity
     */
    @RequestMapping(value = "/enabled", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity enabled(@RequestBody Map payload) {
        try {
            jiraClientService.enabled(payload);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Jira 플러그인이 Disabled 되었을때의 처리.
     *
     * @return ResponseEntity
     */
    @RequestMapping(value = "/disabled", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity disabled(@RequestBody Map payload) {
        try {
            jiraClientService.disabled(payload);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
