package com.commity.backmethod.controller;


import com.commity.backmethod.pojo.UserLogin;
import com.commity.backmethod.result.Result;
import com.commity.backmethod.result.ResultFactory;
import com.commity.backmethod.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LoginController {
    @Autowired
    UserLoginService userLoginService;
    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody UserLogin requestUser) {
        //从前端获取登录信息
        System.out.print(requestUser);
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        //调用Service层的服务来进行用户匹配，查询用户信息。返回状态码
        UserLogin user = userLoginService.get(username, requestUser.getPassword());
        if (null == user) {
            return new Result(400,"登录失败",null);
        } else {
            return new Result(200,"成功登录",user);
        }
    }
    @CrossOrigin
    @PostMapping(value = "/api/signin")
    @ResponseBody
    public Result register (@RequestBody UserLogin requestUser)
    {
             System.out.println("控制层"+requestUser);
        int status=userLoginService.register(requestUser);
        switch (status){
          case  0: return  ResultFactory.buildFailResult("用户名和密码不能为空");
          case  2: return ResultFactory.buildFailResult("用户已存在");
          case  1: return ResultFactory.buildSuccessResult("注册成功");
          default:return ResultFactory.buildSuccessResult("未知错误");
        }
    }
}
