package com.commity.backmethod.controller;

import com.commity.backmethod.pojo.Knowledge;
import com.commity.backmethod.result.Result;
import com.commity.backmethod.result.ResultFactory;
import com.commity.backmethod.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;



@Controller
public class KnowledgeController {
    @Autowired
    private  KnowledgeService knowledgeService;

    /**
     * 获取疫情知识
     * @return 疫情知识实体
     */
    @PostMapping("/api/getKnowledgeInfo")
    @ResponseBody
    public Result getKnowledgeInfo(){
       List<Knowledge> knowledgeArray = knowledgeService.getAll("2020-01-29");
       if(null==knowledgeArray)return ResultFactory.buildFailResult("获取失败");
       else return ResultFactory.buildSuccessResult(knowledgeArray);
    }
}
