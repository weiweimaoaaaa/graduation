package com.commity.backmethod.service;

import com.commity.backmethod.dao.UserLoginDao;
import com.commity.backmethod.pojo.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
    @Autowired
    UserLoginDao userLoginDao;
    public boolean isExist(String username) {//检测用户名是否存在
        UserLogin user = getByName(username);
        return null!=user;
    }

    public UserLogin getByName(String username) {//通过用户名获取用户信息
        return userLoginDao.findByUsername(username);
    }
    public UserLogin get(String username, String password){//通过用户名和密码获取用户信息
        return userLoginDao.getByUsernameAndPassword(username, password);
    }
    public void add(UserLogin user) {//增加用户数据记录
        userLoginDao.save(user);
    }
}
