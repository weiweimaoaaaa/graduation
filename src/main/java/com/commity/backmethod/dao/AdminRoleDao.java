package com.commity.backmethod.dao;

import com.commity.backmethod.pojo.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRoleDao  extends JpaRepository<AdminRole,Integer> {
     //AdminRole findById(Integer id);
     AdminRole getById(Integer id);

}
