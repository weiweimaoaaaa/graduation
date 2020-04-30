package com.commity.backmethod.dao;

import com.commity.backmethod.pojo.ComUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComUserInfoDao extends JpaRepository<ComUserInfo,String> {
    ComUserInfo getComUserInfoById(String id);
    ComUserInfo findComUserInfoById(String id);
   // ComUserInfo getComUserInfoBysAddress(String address);
    List<ComUserInfo> findComUserInfoByAddress(String address);
    List<ComUserInfo> findComUserInfosByIdIn(List<String> id);
   // ComUserInfo
    //ComUserInfo getById(String)
    List<ComUserInfo> findComUserInfoByIdIsNotIn(List<String> idList);
}
