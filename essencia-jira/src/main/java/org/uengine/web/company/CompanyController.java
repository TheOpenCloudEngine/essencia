package org.uengine.web.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by uengine on 2016. 1. 29..
 */

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyTest companyTest;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity test() {
        try {

            companyTest.selectTest();
            companyTest.insertTest();
            companyTest.insertTestWorkArround();

            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
