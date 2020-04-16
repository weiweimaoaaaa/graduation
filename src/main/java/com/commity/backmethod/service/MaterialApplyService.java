package com.commity.backmethod.service;


import com.commity.backmethod.dao.MaterialApplyDao;
import com.commity.backmethod.pojo.MaterialApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * 物资申请保存
     * @param materialApply 物资申请实体
     * @return 返回注册后的实体
     */
    @Transactional
    public MaterialApply registerMaterialInfo(MaterialApply materialApply){
        return materialApplyDao.save(materialApply);
    }
}
