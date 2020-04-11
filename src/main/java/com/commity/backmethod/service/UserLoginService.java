package com.commity.backmethod.service;

import com.commity.backmethod.dao.UserLoginDao;
import com.commity.backmethod.pojo.UserLogin;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

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
    public int register(UserLogin user) {//增加用户数据记录
        String username=user.getUsername();
        String id=user.getId();
        String password=user.getPassword();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        password=HtmlUtils.htmlEscape(password);
        user.setUsername(password);
        user.setId(id);
        if(user.getPassword()==""||user.getUsername()=="")
        {
            return 0;
        }
        else if(isExist(user.getUsername()))
        {
            return 2;
        }
        // 默认生成 16 位盐
//        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
//        int times = 2;
//        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
//
//        //user.setSalt(salt);
//        user.setPassword(encodedPassword);
        userLoginDao.save(user);
        return 1;


    }//注册用户


    public void delete(UserLogin user){userLoginDao.delete(user);}//注销账户
}
