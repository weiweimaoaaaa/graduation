package com.commity.backmethod.controller;


import com.commity.backmethod.pojo.Visitor;
import com.commity.backmethod.result.Result;
import com.commity.backmethod.result.ResultFactory;
import com.commity.backmethod.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class VisitorController {

    @Autowired
    VisitorService visitorService;


    /**
     * 显示外来人员信息
     * @return 外来人员的信息列表
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping(value="/api/listVisitorsInfo")
    public Result listVisitorsInfo(){
        List<Visitor> info=visitorService.listVisitorsInfo();
        if(null==info||info.size()==0){
            return ResultFactory.buildFailResult("获取外来人员信息失败");
        }
        return ResultFactory.buildSuccessResult(info);
    }
    @CrossOrigin
    @ResponseBody
    @PostMapping(value="/api/visitorRegister")
    public Result register(@RequestBody Visitor visitor){
        Visitor visitor1=visitorService.register(visitor);
        if(visitor1==null){
            return ResultFactory.buildFailResult("注册失败");
        }
        return ResultFactory.buildSuccessResult(visitor1);
    }
}
