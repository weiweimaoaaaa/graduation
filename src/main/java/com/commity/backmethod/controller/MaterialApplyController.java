package com.commity.backmethod.controller;

import com.commity.backmethod.pojo.Apply;
import com.commity.backmethod.pojo.MaterialApply;
import com.commity.backmethod.result.Result;
import com.commity.backmethod.result.ResultFactory;
import com.commity.backmethod.service.MaterialApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

import static com.commity.backmethod.pojo.Apply.TISSUE;
import static com.commity.backmethod.pojo.Apply.TOOTHPASTE;

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

    /**
     * 物资信息报表
     * @return 物资信息报表
     */
    @ResponseBody
    @GetMapping(value="/api/materialInfoList")
    public Result MaterialInfoList(){
        java.util.Date date1=new java.util.Date();
        java.sql.Date date=new java.sql.Date(date1.getTime());
        //当日物资信息
        List<MaterialApply> materialApplies=materialApplyService.getMaterialByDate(date);
        for (MaterialApply materialApply : materialApplies) materialApply.setFinished(2);
        materialApplyService.registerMaterialsInfo(materialApplies);
        System.out.print("当前日期:"+date);
        System.out.println("   当日物资信息:"+materialApplies);
        Integer[] detailed =new Integer[17];//存放各种物资的数量的数组
        String [] names={"卫生纸（袋）","牙膏（支）","洗发液（瓶）","沐浴露（瓶）","消毒液","酒精","棉签","999感冒灵","板蓝根","布洛芬","米","盐","油","萝卜","白菜","辣椒酱","茄子"};
        for(int i=0;i<17;i++){
            detailed[i]=materialApplyService.getMaterialByDateAndName(date,names[i]);
        }
        System.out.println("物资统计信息");
        System.out.println(TISSUE.getName()+" "+detailed[TISSUE.getIndex()]);
        System.out.println(TOOTHPASTE.getName()+" "+detailed[TOOTHPASTE.getIndex()]);
        Object[] info={materialApplies,detailed};
        return ResultFactory.buildSuccessResult(info);
    }

}
