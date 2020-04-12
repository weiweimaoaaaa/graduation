package com.commity.backmethod.dao;

import com.commity.backmethod.pojo.ComUserInfo;
import com.commity.backmethod.pojo.HomeAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComUserInfoDao extends JpaRepository<ComUserInfo,String> {
    ComUserInfo getComUserInfoById(String id);
    <List>ComUserInfo getComUserInfoByAddress(HomeAddress homeAddress);
}
