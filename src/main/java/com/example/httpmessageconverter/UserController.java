package com.example.httpmessageconverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * ClassName: UserController
 * Description: TODO
 * Author : Administrator
 * Date : 2019/8/7 17:00
 * Version : 1.0
 **/
@Controller
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @RequestMapping(method = RequestMethod.POST,value = "/user",produces = "application/x-x")
    @ResponseBody
    public User getUser(@RequestBody User user){
        logger.info(user.toString());
        return user;
    }
}
