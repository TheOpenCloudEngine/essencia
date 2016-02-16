package org.uengine.web.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.uengine.web.jiraclient.JiraClientService;

import java.util.Map;
import java.util.Properties;

/**
 * Created by uengine on 2016. 1. 29..
 */

@Controller
@RequestMapping("/")
public class CompanyController {

    @Autowired
    @Qualifier("config")
    private Properties config;

}
