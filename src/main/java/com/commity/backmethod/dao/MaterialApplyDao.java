package com.commity.backmethod.dao;

import com.commity.backmethod.pojo.MaterialApply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface MaterialApplyDao extends JpaRepository<MaterialApply,Long> {
    MaterialApply getMaterialApplyByUser(String id);
    List<MaterialApply> findByUser(String id);
    List<MaterialApply> findByUserAndCategory(String userId,String category);//按照用户id和类型来获取信息。
    List<MaterialApply> findByCategoryAndName(String category,String name);//按照类型获取物资信息。
    List<MaterialApply> findByUserAndCategoryAndName(String userId,String category,String name);//获取用户的具体的商品的信息。
    List<MaterialApply> findMaterialApplyByApplyDate(Date applyDate);
    List<MaterialApply> findMaterialApplyByApplyDateAndNameLike(Date applyDate, String name);
    List<MaterialApply> findByApplyDate(Date applyDate);
}
