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

import java.util.List;

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
     * 获取物资信息列表
     * @param id 用户id
     * @return 物资信息表
     */
    @PostMapping(value="/api/getMaterialsApplyInfo")
    @ResponseBody
    public List<MaterialApply> getAppliesInfo(@RequestBody String id){
        return materialApplyService.getApplies(id);
    }
    /**
     * 提交物资申请
     * @param materialApply 物资信息
     * @return 物资申请后的实体信息
     */
    @ResponseBody
    @PostMapping(value="/api/registerMaterialApply")
    public Result registerMaterialApply(@RequestBody MaterialApply materialApply){
        MaterialApply material=materialApplyService.registerMaterialInfo(materialApply);
        if(null==material){
            return ResultFactory.buildFailResult("申请失败");
        }
        else return ResultFactory.buildSuccessResult(material);
    }

    /**
     * 以数组的形式申请物资。
     * @param materialApplyList 物资信息表
     * @return 申请状态和物资信息
     *
     *
     * 申请状态表
     * -------------------------
     * | 申请   | 使用    |
     * ---------------------
     * |   1   |  2     |
     * --------------------------
     */
    @ResponseBody
    @PostMapping(value="/api/registerMaterialsApply")
    public Result registerMaterialsApply(@RequestBody List<MaterialApply> materialApplyList){
        for (MaterialApply materialApply : materialApplyList) {
                materialApply.setFinished(1);
                System.out.println("设置finished属性");
        }
        List<MaterialApply> materials=materialApplyService.registerMaterialsInfo(materialApplyList);
        if(null==materials){
            return ResultFactory.buildFailResult("申请失败");
        }
        return ResultFactory.buildSuccessResult(materials);//返回申请的信息
    }

}
