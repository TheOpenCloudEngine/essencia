package org.uengine.web.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.uengine.codi.mw3.model.Company;
import org.uengine.codi.mw3.model.IProcessMap;
import org.uengine.codi.mw3.model.Session;
import org.uengine.codi.mw3.model.User;
import org.uengine.processmanager.ProcessManagerRemote;
import org.uengine.web.exception.ServiceException;
import org.uengine.web.rest.Response;
import org.uengine.web.util.ExceptionUtils;
import org.uengine.web.util.JsonUtils;

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
    ProcessMapService processService;

    @Autowired
    public ProcessManagerRemote processManager;

    /**
     * 프로세스 리스트를 불러온다.
     */
    @RequestMapping(value = "process/list", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Response list() throws Exception {
        Response response = new Response();
        try {
            List<ProcessMap> listProcessMap = processService.getListProcessMap();
            response.getList().addAll(listProcessMap);
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
