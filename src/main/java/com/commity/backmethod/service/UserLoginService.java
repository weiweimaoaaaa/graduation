package com.commity.backmethod.service;

import com.commity.backmethod.dao.UserLoginDao;
import com.commity.backmethod.dto.UserDTO;
import com.commity.backmethod.pojo.AdminRole;
import com.commity.backmethod.pojo.UserLogin;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@Service
public class UserLoginService {
    @Autowired
     UserLoginDao userLoginDao;
    @Autowired
    AdminRoleService adminRoleService;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    public boolean isExist(String username) {//检测用户名是否存在
        UserLogin user = getByName(username);
        return null!=user;
    }
    public UserLogin getByName(String username) {//通过用户名获取用户信息
        return userLoginDao.getByUsername(username);
    }
    public UserLogin findByUsername(String username){return userLoginDao.getByUsername(username);}
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
        if(isExist(user.getUsername())) return 2;
        // 生成盐,默认长度 16 位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 设置 hash 算法迭代次数
        int times = 2;
        // 得到 hash 后的密码
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
        // 存储用户信息，包括 salt 与 hash 后的密码
        user.setSalt(salt);
        System.out.println("盐："+user.getSalt());
        user.setPassword(encodedPassword);
        userLoginDao.save(user);
        return 1;
    }//注册用户
    public void delete(UserLogin user){userLoginDao.delete(user);}//注销账户
    public Integer getNameLike(String name){
        return userLoginDao.findByUsername(name).size();
    }
    public void updateUserStatus(UserLogin requestUser) {
        UserLogin userInDB = userLoginDao.getByUsername(requestUser.getUsername());
        userInDB.setEnabled(requestUser.isEnabled());
        userLoginDao.save(userInDB);
    }
    public List<UserDTO> list() {
        List<UserLogin> users = userLoginDao.findAll();


        List<UserDTO> userDTOS = users
                .stream().map(user -> (UserDTO) new UserDTO().convertFrom(user)).collect(Collectors.toList());

        userDTOS.forEach(u -> {
            List<AdminRole> roles = adminRoleService.listRolesByUser(u.getUsername());
            u.setRoles(roles);
        });

        return userDTOS;
    }
    public UserLogin resetPassword(UserLogin user) {
        UserLogin userInDB = userLoginDao.getByUsername(user.getUsername());
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        userInDB.setSalt(salt);
        String encodedPassword = new SimpleHash("md5", "123", salt, times).toString();
        userInDB.setPassword(encodedPassword);
        return userLoginDao.save(userInDB);
    }

    public void editUser(UserLogin user) {
        UserLogin userInDB = userLoginDao.getByUsername(user.getUsername());
        userInDB.setUsername(user.getUsername());
        userLoginDao.save(userInDB);
        adminUserRoleService.saveRoleChanges(userInDB.getIdCard(), user.getRoles());
    }

    public void deleteById(String id) {
        userLoginDao.deleteById(id);
    }


}
