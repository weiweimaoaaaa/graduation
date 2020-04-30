package com.commity.backmethod.controller;


import com.commity.backmethod.pojo.Visitor;
import com.commity.backmethod.result.Result;
import com.commity.backmethod.result.ResultFactory;
import com.commity.backmethod.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitorController {

    @Autowired
    VisitorService visitorService;
    /**
     * 显示外来人员信息
     * @return 外来人员的信息列表
     */

    @PostMapping(value="/api/listVisitorsInfo")
    public Result listVisitorsInfo(){
        List<Visitor> info=visitorService.listVisitorsInfo();
        System.out.println(info.get(0).getDiagnose());//调试信息
        if(info.size()==0){
            return ResultFactory.buildFailResult("获取外来人员信息失败");
        }
        return ResultFactory.buildSuccessResult(info);
    }

    @PostMapping(value="/api/visitorRegister")
    public Result register(@RequestBody Visitor visitor){
        System.out.println(visitor);
        Visitor visitor1=visitorService.register(visitor);
        if(visitor1==null){
            return ResultFactory.buildFailResult("注册失败");
        }
        return ResultFactory.buildSuccessResult(visitor1);
    }

    @PostMapping(value = "/api/deleteVisitorInfo")
    public Result delete(@RequestBody Visitor visitor){
        visitorService.delete(visitor);
        return ResultFactory.buildSuccessResult("成功删除人员信息");
    }

    @PostMapping(value = "/api/updateVisitorInfo")
    public Result update(@RequestBody Visitor visitor){
        Visitor visitor1=visitorService.update(visitor);
        if(visitor1==null)return ResultFactory.buildFailResult("更新失败");
        return ResultFactory.buildSuccessResult(visitor1);
    }
}
