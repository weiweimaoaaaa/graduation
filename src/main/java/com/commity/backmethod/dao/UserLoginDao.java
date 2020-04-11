package com.commity.backmethod.dao;
import com.commity.backmethod.pojo.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginDao extends JpaRepository<UserLogin,String>
{
    UserLogin findByUsername(String username);//用户名查找
    UserLogin getByUsernameAndPassword(String username,String password);//用户名与密码进行查找用户
}
