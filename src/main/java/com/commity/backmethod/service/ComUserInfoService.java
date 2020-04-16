package com.commity.backmethod.service;

import com.commity.backmethod.dao.ComUserInfoDao;
import com.commity.backmethod.pojo.ComUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComUserInfoService  {

    @Autowired
    ComUserInfoDao comUserInfoDao;//用户信息查询的接口
    public Boolean isExist(String id)//当前用户是否存在
    {
        return null!=comUserInfoDao.getComUserInfoById(id);
    }
    /**
     * 待具体详细实现
     * @param comUserInfo 用户信息列表
     * @return 返回用户的信息表
     */
    @Transactional
    public ComUserInfo register(ComUserInfo comUserInfo){//注册当前的用户
           return comUserInfoDao.save(comUserInfo);
    }
    public List<ComUserInfo> getFamilyInfo(String address){//同住人信息的获取
      //  return comUserInfoDao.get
        return comUserInfoDao.findComUserInfoByAddress(address);
    }
    @Transactional
    public void delete(ComUserInfo comUserInfo)//删除人员。确诊或者是就医。
    {
         comUserInfoDao.delete(comUserInfo);
    }
    public Integer count(ComUserInfo comUserInfo){//统计同住人的数量
        return   comUserInfoDao.findComUserInfoByAddress(comUserInfo.getAddress()).size();
    }
    public ComUserInfo update(ComUserInfo comUserInfo){//由于设置主键，所以直接就实现了对数据的更新
         return comUserInfoDao.save(comUserInfo);
    }
    public ComUserInfo getInfo(String id )
    {
        return comUserInfoDao.getComUserInfoById(id );
    }

}
