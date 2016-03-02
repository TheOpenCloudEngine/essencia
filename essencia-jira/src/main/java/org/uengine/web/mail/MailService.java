package org.uengine.web.mail;

import javax.servlet.http.HttpServletRequest;

public interface MailService {
    void sendMail(HttpServletRequest request, String email, String subject, String contents) throws Exception;

}
