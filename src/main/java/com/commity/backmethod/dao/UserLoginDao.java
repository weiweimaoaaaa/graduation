package com.commity.backmethod.dao;
import com.commity.backmethod.pojo.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserLoginDao extends JpaRepository<UserLogin,String>
{
    UserLogin getByUsername(String username);//用户名查找
    UserLogin getByUsernameAndPassword(String username,String password);//用户名与密码进行查找用户
    List<UserLogin> getByIdCard(String idCard);
    List<UserLogin> findByUsername(String name);
}
