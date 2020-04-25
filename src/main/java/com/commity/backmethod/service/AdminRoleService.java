package com.commity.backmethod.service;


import com.commity.backmethod.dao.AdminRoleDao;
import com.commity.backmethod.pojo.AdminMenu;
import com.commity.backmethod.pojo.AdminPermission;
import com.commity.backmethod.pojo.AdminRole;
import com.commity.backmethod.pojo.AdminUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminRoleService {
    @Autowired
    AdminRoleDao adminRoleDao;
    @Autowired
    UserLoginService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminPermissionService adminPermissionService;
    @Autowired
    AdminRolePermissionService adminRolePermissionService;
    @Autowired
    AdminMenuService adminMenuService;

    public List<AdminRole> listWithPermsAndMenus() {
        List<AdminRole> roles = adminRoleDao.findAll();
        List<AdminPermission> perms;
        List<AdminMenu> menus;
        for (AdminRole role : roles) {
            perms = adminPermissionService.listPermsByRoleId(role.getId());
            menus = adminMenuService.getMenusByRoleId(role.getId());
            role.setPerms(perms);
            role.setMenus(menus);
        }
        return roles;
    }

    public List<AdminRole> findAll() {
        return adminRoleDao.findAll();
    }


    public void addOrUpdate(AdminRole adminRole) {
        adminRoleDao.save(adminRole);
    }

    public List<AdminRole> listRolesByUser(String username) {
        String uid = userService.findByUsername(username).getIdCard();
        List<Integer> rids = adminUserRoleService.listAllByUid(uid)
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());
        return adminRoleDao.findAllById(rids);
    }


    //这里存在findById的问题
    public AdminRole updateRoleStatus(AdminRole role) {
        AdminRole roleInDB = adminRoleDao.getById(role.getId());
        roleInDB.setEnabled(role.isEnabled());
        return adminRoleDao.save(roleInDB);
    }

    public void editRole(@RequestBody AdminRole role) {
        adminRoleDao.save(role);
        adminRolePermissionService.savePermChanges(role.getId(), role.getPerms());
    }
}
