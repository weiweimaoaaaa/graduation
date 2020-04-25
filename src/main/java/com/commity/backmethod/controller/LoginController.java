package com.commity.backmethod.controller;


import com.commity.backmethod.pojo.UserLogin;
import com.commity.backmethod.result.Result;
import com.commity.backmethod.result.ResultFactory;
import com.commity.backmethod.service.UserLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
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
        String username = requestUser.getUsername();
        System.out.println("登陆时,用户名："+username);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        System.out.println("登陆时,密码"+usernamePasswordToken.getPassword().toString());
        UserLogin userLogin=userLoginService.getByName(username);
        try {
            subject.login(usernamePasswordToken);
            return ResultFactory.buildSuccessResult(userLogin);
        } catch (AuthenticationException e) {
            String message = "账号密码错误";
            return ResultFactory.buildFailResult(message);
        }

//        //从前端获取登录信息
//        String username = requestUser.getUsername();
//        username = HtmlUtils.htmlEscape(username);
//        //调用Service层的服务来进行用户匹配，查询用户信息。返回状态码
//        UserLogin loginMiddle=userLoginService.getByName(username);
//        if(loginMiddle==null){
//            return new Result(400,"用户不在",null);
//        }
//        String salt=loginMiddle.getSalt();
//        int times = 2;
//        // 得到 hash 后的密码
//        String encodedPassword = new SimpleHash("md5", requestUser.getPassword(), salt, times).toString();
//        requestUser.setPassword(encodedPassword);
//        UserLogin user = userLoginService.get(username, requestUser.getPassword());
//        System.out.println("登录时候的输入密码："+requestUser.getPassword()+"登录时候用户名"+requestUser.getUsername());
//        if (null == user) {
//            return new Result(400,"登录失败",null);
//        } else {
//            return new Result(200,"成功登录",user);
//        }
    }
    @CrossOrigin
    @PostMapping(value = "/api/signin")
    @ResponseBody
    public Result register (@RequestBody UserLogin requestUser)
    {
             System.out.println("控制层"+requestUser);
        int status=userLoginService.register(requestUser);
        switch (status){
          case  2: return ResultFactory.buildFailResult("用户已存在");
          case  1: return ResultFactory.buildSuccessResult("注册成功");
          default:return ResultFactory.buildSuccessResult("未知错误");
        }
    }
    @ResponseBody
    @GetMapping("api/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message = "成功登出";
        return ResultFactory.buildSuccessResult(message);
    }
    @ResponseBody
    @GetMapping("/api/authentication")
    public String authentication() {
        return "身份认证成功";
    }
}
