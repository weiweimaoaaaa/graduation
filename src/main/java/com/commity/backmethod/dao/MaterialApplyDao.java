package com.commity.backmethod.dao;

import com.commity.backmethod.pojo.MaterialApply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MaterialApplyDao extends JpaRepository<MaterialApply,Long> {
    MaterialApply getByApplyDate(Date date);
    MaterialApply getMaterialApplyById(String id);
    List<MaterialApply> findByUser(String id);

}
