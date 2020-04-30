package com.commity.backmethod.service;

import com.commity.backmethod.dao.AdminPermissionDao;
import com.commity.backmethod.dao.AdminRolePermissionDao;
import com.commity.backmethod.pojo.AdminPermission;
import com.commity.backmethod.pojo.AdminRole;
import com.commity.backmethod.pojo.AdminRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdminPermissionService {
    @Autowired
    AdminPermissionDao adminPermissionDAO;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminRoleService adminRoleService;
    @Autowired
    AdminRolePermissionService adminRolePermissionService;
    @Autowired
    AdminRolePermissionDao adminRolePermissionDAO;
    @Autowired
    UserLoginService userService;

    public List<AdminPermission> list() {return adminPermissionDAO.findAll();}

    /**
     * 当前的用户请求接口是否在权限列表中，
     * Determine whether client requires permission when requests
     * a certain API.
     * @param requestAPI API requested by client
     * @return true when requestAPI is found in the DB
     */
    public boolean needFilter(String requestAPI) {
        List<AdminPermission> ps = adminPermissionDAO.findAll();
        for (AdminPermission p: ps) {
            // match prefix
            if (requestAPI.startsWith(p.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据角色id寻找权限id。
     * @param rid 角色id
     * @return 权限id
     */
    public List<AdminPermission> listPermsByRoleId(int rid) {
        List<Integer> pids = adminRolePermissionService.findAllByRid(rid)
                .stream().map(AdminRolePermission::getPid).collect(Collectors.toList());
        return adminPermissionDAO.findAllById(pids);
    }

    /**
     * 根据用户名来获取当前用户的权限列表
     * 也就是权限的url.
     * @param username 用户名
     * @return 权限url
     */
    public Set<String> listPermissionURLsByUser(String username) {
        //根据用户名获取角色id表
        List<Integer> rids = adminRoleService.listRolesByUser(username)
                .stream().map(AdminRole::getId).collect(Collectors.toList());

        //根据角色获取权限id
        List<Integer> pids = adminRolePermissionDAO.findAllByRidIn(rids)
                .stream().map(AdminRolePermission::getPid).collect(Collectors.toList());

        //根据权限id获取权限的url
        List<AdminPermission> perms = adminPermissionDAO.findAllById(pids);

        Set<String> URLs = perms.stream().map(AdminPermission::getUrl).collect(Collectors.toSet());

        return URLs;
    }
}
