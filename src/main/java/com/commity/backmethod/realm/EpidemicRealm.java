package com.commity.backmethod.realm;

import com.commity.backmethod.pojo.UserLogin;
import com.commity.backmethod.service.UserLoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class EpidemicRealm extends AuthorizingRealm {
    @Autowired
    private UserLoginService userLoginService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return new SimpleAuthorizationInfo();
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("realm层输出");
        String userName = authenticationToken.getPrincipal().toString();
        System.out.println("realm层,用户名"+userName);
        UserLogin user = userLoginService.getByName(userName);
        System.out.println("登陆时查询数据库用户名:"+user.getUsername());
        System.out.println("登陆时查询数据库密码："+user.getPassword());
        String passwordInDB = user.getPassword();
        String salt = user.getSalt();
        return new SimpleAuthenticationInfo(userName, passwordInDB, ByteSource.Util.bytes(salt), getName());
    }
}
