package com.commity.backmethod.controller;


import com.commity.backmethod.result.Result;
import com.commity.backmethod.result.ResultFactory;
import com.commity.backmethod.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MenuController {
    @Autowired
    AdminMenuService adminMenuService;

    @ResponseBody
    @GetMapping("/api/menu")
    public Result menu() {

        return ResultFactory.buildSuccessResult(adminMenuService.getMenusByCurrentUser());
    }
    @ResponseBody
    @GetMapping("/api/admin/role/menu")
    public Result listAllMenus() {
        return ResultFactory.buildSuccessResult(adminMenuService.getMenusByRoleId(1));
    }
}
