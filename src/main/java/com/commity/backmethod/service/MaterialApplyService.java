package com.commity.backmethod.service;


import com.commity.backmethod.dao.MaterialApplyDao;
import com.commity.backmethod.pojo.MaterialApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.util.List;

@Service
public class MaterialApplyService {
    @Autowired
    MaterialApplyDao materialApplyDao;
    /**
     * 获取物资申请信息
     * @param id 用户ID
     * @return 用户物资申请信息
     */
    public MaterialApply getApply(String id){
        return materialApplyDao.getMaterialApplyByUser(id);
    }
    /**
     * 获取用户的申请物资信息表
     * @param id 用户的id
     * @return 用户的申请物资信息
     */
    public List<MaterialApply> getApplies(String id){
        return materialApplyDao.findByUser(id);
    }

    /**
     * 物资申请保存
     * @param materialApply 物资申请实体
     * @return 返回注册后的实体
     */
    @Transactional
    public MaterialApply registerMaterialInfo(MaterialApply materialApply){
        return materialApplyDao.save(materialApply);
    }

    /**
     * 保存用户的申请的物资信息，包括各类物资信息
     * @param materialApplies 保存的物资申请
     * @return 返回保存后的物资信息
     */
    @Transactional
    public List<MaterialApply> registerMaterialsInfo(List<MaterialApply> materialApplies){
        return materialApplyDao.saveAll(materialApplies);
    }

    /**
     * 获取用户的各类商品的物资信息
     * @param userId 用户ID
     * @param category 分类
     * @return 用户各类物资信息
     */
    public List<MaterialApply> getMaterialByUserAndCategory(String userId,String category){
       return  materialApplyDao.findByUserAndCategory(userId,category);
    }
    /**
     * 获取每个用户的各类物资里面各种物资的信息。
     * 比如获取id=1的用户的生活用品中卫生纸的信息。
     * @param userId 用户id
     * @param category 分类
     * @param name 物资名称
     * @return  每个用户的各类物资里面各种物资的信息。
     */
    public List<MaterialApply> getMaterialByUserAndCategoryAndName(String userId,String category,String name){
        return materialApplyDao.findByUserAndCategoryAndName(userId, category, name);
    }
    /**
     *获取每一类中具体的商品的信息
     * @param category 类别
     * @param name 名称
     * @return 每一类中具体的商品的信息
     */
    public List<MaterialApply> getMaterialByCategoryAndName(String category,String name){
        return materialApplyDao.findByCategoryAndName(category, name);
    }

    /**
     * 获取当日的物资申请信息
     * @param date 当前日期
     * @param name 名称
     * @return 返回当前日期的各种东西的数量
     */
    public Integer getMaterialByDateAndName(Date date, String name){
        Integer number=0;
        List<MaterialApply>materialApplies= materialApplyDao.findMaterialApplyByApplyDateAndNameLike(date,name);
        for (MaterialApply materialApply : materialApplies) {
            number += materialApply.getNumber();
        }
        return number;
    }

    /**
     * 获取当前的物资信息列表
     * @param date 日期
     * @return 物资信息列表
     */
    public List<MaterialApply> getMaterialByDate(Date date){
        return materialApplyDao.findMaterialApplyByApplyDate(date);
    }

}
