package com.commity.backmethod.dao;

import com.commity.backmethod.pojo.AdminRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRolePermissionDao extends JpaRepository<AdminRolePermission,Integer> {
    List<AdminRolePermission> findAllByRid(int rid);
    List<AdminRolePermission> findAllByRid(List<Integer> rids);
    void deleteAllByRid(int rid);
}
