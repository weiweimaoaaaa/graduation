package com.commity.backmethod.controller;


import com.commity.backmethod.pojo.UserLogin;
import com.commity.backmethod.result.Result;
import com.commity.backmethod.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LoginController {

    @Autowired
    UserLoginService userLoginService;
    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody UserLogin requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        UserLogin user = userLoginService.get(username, requestUser.getPassword());
        if (null == user) {
            return new Result(400,null,null);
        } else {
            return new Result(200,null,null);
        }
    }
}
