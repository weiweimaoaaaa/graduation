package com.commity.backmethod.controller;


import com.commity.backmethod.pojo.UserLogin;
import com.commity.backmethod.result.Result;
import com.commity.backmethod.result.ResultFactory;
import com.commity.backmethod.service.AdminUserRoleService;
import com.commity.backmethod.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    UserLoginService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;


    @GetMapping("/api/admin/user")
    public Result listUsers() {

        return ResultFactory.buildSuccessResult(userService.list());
    }


    @PutMapping("/api/admin/user/status")
    public Result updateUserStatus(@RequestBody @Valid UserLogin requestUser) {
        userService.updateUserStatus(requestUser);
        return ResultFactory.buildSuccessResult("用户状态更新成功");
    }


    @PutMapping("/api/admin/user/password")
    public Result resetPassword(@RequestBody @Valid UserLogin requestUser) {
        userService.resetPassword(requestUser);
        return ResultFactory.buildSuccessResult("重置密码成功");
    }


    @PutMapping("/api/admin/user")
    public Result editUser(@RequestBody @Valid UserLogin requestUser) {
        userService.editUser(requestUser);
        return ResultFactory.buildSuccessResult("修改用户信息成功");
    }
}
