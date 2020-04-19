package com.commity.backmethod.service;


import com.commity.backmethod.dao.MaterialApplyDao;
import com.commity.backmethod.pojo.MaterialApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return materialApplyDao.getMaterialApplyById(id);
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
}
