package com.commity.backmethod.service;

import com.commity.backmethod.dao.UserLoginDao;
import com.commity.backmethod.pojo.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.Objects;

@Component
@Service
public class UserLoginService {
    @Autowired
     UserLoginDao userLoginDao;
    public boolean isExist(String username) {//检测用户名是否存在
        UserLogin user = getByName(username);
        return null!=user;
    }

    public UserLogin getByName(String username) {//通过用户名获取用户信息
        return userLoginDao.getByUsername(username);
    }

    public UserLogin get(String username, String password){//通过用户名和密码获取用户信息
        return userLoginDao.getByUsernameAndPassword(username, password);
    }

    public int register(UserLogin user) {//增加用户数据记录
        System.out.println("service "+user);
        String username=user.getUsername();
        String idCard=user.getIdCard();
        String password=user.getPassword();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        password=HtmlUtils.htmlEscape(password);
        user.setPassword(password);
        idCard=HtmlUtils.htmlEscape(idCard);
        user.setIdCard(idCard);
        if(Objects.equals(user.getPassword(), "") || Objects.equals(user.getUsername(), ""))
        {
            return 0;
        }
        else if(isExist(user.getUsername()))
        {
            return 2;
        }
        userLoginDao.save(user);
        return 1;
    }//注册用户
    public void delete(UserLogin user){userLoginDao.delete(user);}//注销账户
    public Integer getNameLike(String name){
        return userLoginDao.findByUsername(name).size();
    }
}
