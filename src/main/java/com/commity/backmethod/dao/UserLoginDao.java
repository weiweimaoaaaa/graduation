package com.commity.backmethod.dao;
import com.commity.backmethod.pojo.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginDao extends JpaRepository<UserLogin,String> {
    UserLogin findByUsername(String username);
    UserLogin getByUsernameAndPassword(String username,String password);
}
