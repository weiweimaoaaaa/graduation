package com.commity.backmethod.service;

import com.commity.backmethod.dao.ComUserInfoDao;
import com.commity.backmethod.pojo.ComUserInfo;
import com.commity.backmethod.pojo.HomeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComUserInfoService  {



    @Autowired
    ComUserInfoDao comUserInfoDao;
    public Boolean isExist(String id)//当前用户是否存在
    {
        return null!=comUserInfoDao.getComUserInfoById(id);
    }

    /**
     * 待具体详细实现
     * @param comUserInfo
     * @return
     */
    public ComUserInfo register(ComUserInfo comUserInfo){//注册当前的用户
        return comUserInfoDao.save(comUserInfo);
    }
    public <list>ComUserInfo getAddress(HomeAddress homeAddress){//同住人信息的获取
        return comUserInfoDao.getComUserInfoByAddress(homeAddress);
    }

}
