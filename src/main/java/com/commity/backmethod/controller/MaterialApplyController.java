package com.commity.backmethod.controller;

import com.commity.backmethod.pojo.MaterialApply;
import com.commity.backmethod.result.Result;
import com.commity.backmethod.result.ResultFactory;
import com.commity.backmethod.service.MaterialApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MaterialApplyController {
    @Autowired
    MaterialApplyService materialApplyService;

    /**
     * 获取用户的物资申请的信息
     * @param id 用户id
     * @return 物资信息
     */
    @PostMapping(value="/api/getMaterialApplyInfo")
    @ResponseBody
    public  MaterialApply getApplyInfo(@RequestBody String id ){
        return materialApplyService.getApply(id);
    }

    /**
     * 提交物资申请
     * @param materialApply 物资信息
     * @return 物资申请后的实体信息
     */
    @PostMapping(value="/api/registerMaterialApply")
    public Result registerMaterialApply(@RequestBody MaterialApply materialApply){
        MaterialApply material=materialApplyService.registerMaterialInfo(materialApply);
        if(null==material){
            return ResultFactory.buildFailResult("申请失败");
        }
        else return ResultFactory.buildSuccessResult(material);
    }

}
