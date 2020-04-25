package com.commity.backmethod.dao;

import com.commity.backmethod.pojo.AdminUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminUserRoleDao extends JpaRepository<AdminUserRole,Integer> {
    List<AdminUserRole> findAllByUid(String uid);
    void deleteAllByUid(String uid);
}
