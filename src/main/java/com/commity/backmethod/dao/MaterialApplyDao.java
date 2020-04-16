package com.commity.backmethod.dao;

import com.commity.backmethod.pojo.MaterialApply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface MaterialApplyDao extends JpaRepository<MaterialApply,String> {
    MaterialApply getByApplyDate(Date date);
    MaterialApply getMaterialApplyById(String id);

}
