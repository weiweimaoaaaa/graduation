package com.commity.backmethod.dao;

import com.commity.backmethod.pojo.AdminPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminPermissionDao  extends JpaRepository<AdminPermission,Integer> {
    AdminPermission findById(int id);
}
