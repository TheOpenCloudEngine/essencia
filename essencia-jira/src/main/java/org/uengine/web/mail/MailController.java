package org.uengine.web.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.uengine.web.rest.Response;
import org.uengine.web.util.ExceptionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by uengine on 2016. 1. 29..
 */

@Controller
@RequestMapping("/mail")
public class MailController {

    @Autowired
    MailService mailService;

    /**
     * 지라 유저가 문의 메일 발송했을 경우 처리
     *
     * @return Response
     */
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Response send(@RequestBody Map params, HttpServletRequest request) {
        Response response = new Response();
        try {

            String email = params.get("email").toString();
            String subject = params.get("subject").toString();
            String contents = params.get("contents").toString();

            mailService.sendMail(request, email, subject, contents);
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
