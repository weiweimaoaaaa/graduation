package com.commity.backmethod.service;


import com.commity.backmethod.dao.AdminUserRoleDao;
import com.commity.backmethod.pojo.AdminRole;
import com.commity.backmethod.pojo.AdminUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminUserRoleService {
    @Autowired
    AdminUserRoleDao adminUserRoleDAO;

    //返回该用户对应的所有的角色id。
    public List<AdminUserRole> listAllByUid(String uid) {
        return adminUserRoleDAO.findAllByUid(uid);
    }

    @Transactional
    public void saveRoleChanges(String uid, List<AdminRole> roles) {
        adminUserRoleDAO.deleteAllByUid(uid);
        List<AdminUserRole> urs = new ArrayList<>();
        roles.forEach(r -> {
            AdminUserRole ur = new AdminUserRole();
            ur.setUid(uid);
            ur.setRid(r.getId());
            urs.add(ur);
        });
        adminUserRoleDAO.saveAll(urs);
    }
}

