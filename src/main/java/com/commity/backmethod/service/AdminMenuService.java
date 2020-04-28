package com.commity.backmethod.service;


import com.commity.backmethod.dao.AdminMenuDao;
import com.commity.backmethod.pojo.AdminMenu;
import com.commity.backmethod.pojo.AdminRoleMenu;
import com.commity.backmethod.pojo.AdminUserRole;
import com.commity.backmethod.pojo.UserLogin;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminMenuService {
    @Autowired
    AdminMenuDao adminMenuDAO;
    @Autowired
    UserLoginService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminRoleMenuService adminRoleMenuService;

    public List<AdminMenu> getAllByParentId(int parentId) {
        return adminMenuDAO.findAllByParentId(parentId);
    }

    public List<AdminMenu> getMenusByCurrentUser() {
        // Get current user in DB.
        System.out.println("菜单的加载初始化函数");
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        System.out.println("加载菜单时，获取当前用户的姓名:"+username);
        UserLogin user = userService.findByUsername(username);
        System.out.println("加载菜单时，从数据库获取用户的信息："+user);

        // Get roles' ids of current user.
        List<Integer> rids = adminUserRoleService.listAllByUid(user.getIdCard())
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());
        System.out.println(rids);
        // Get menu items of these roles.
        List<Integer> menuIds = adminRoleMenuService.findAllByRid(rids)
                .stream().map(AdminRoleMenu::getMid).collect(Collectors.toList());
        List<AdminMenu> menus = adminMenuDAO.findAllById(menuIds).stream().distinct().collect(Collectors.toList());

        // Adjust the structure of the menu.
        handleMenus(menus);
        System.out.println("加载菜单时，菜单列表"+menus);
        return menus;
    }

    public List<AdminMenu> getMenusByRoleId(int rid) {
        List<Integer> menuIds = adminRoleMenuService.findAllByRid(rid)
                .stream().map(AdminRoleMenu::getMid).collect(Collectors.toList());
        List<AdminMenu> menus = adminMenuDAO.findAllById(menuIds);

        handleMenus(menus);
        return menus;
    }

    /**
     * Adjust the Structure of the menu.
     *
     * @param menus Menu items list without structure
     */
    public void handleMenus(List<AdminMenu> menus) {
        menus.forEach(m -> {
            List<AdminMenu> children = getAllByParentId(m.getId());
            m.setChildren(children);
        });

        menus.removeIf(m -> m.getParentId() != 0);
    }
}
