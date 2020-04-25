package com.commity.backmethod.dao;

import com.commity.backmethod.pojo.AdminRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface AdminRoleMenuDao  extends JpaRepository<AdminRoleMenu,Integer> {
    List<AdminRoleMenu> findAllByRid(int rid);
    List<AdminRoleMenu> findAllByRid(List<Integer> rids);
    void deleteAllByRid(int rid);
}
