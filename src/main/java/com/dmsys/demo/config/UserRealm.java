package com.dmsys.demo.config;

import com.dmsys.demo.bean.User;
import com.dmsys.demo.service.Login_service;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;

public class UserRealm extends AuthorizingRealm {
    //授权

    @Autowired
    Login_service login_service;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权进行-->");

        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

        User user = (User) SecurityUtils.getSubject().getPrincipal();

        //String role=login_service.Login_auth(user);

        //info.addStringPermission(role);

        return info;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证进行-->");

        UsernamePasswordToken usertoken=(UsernamePasswordToken)token;

        User user=login_service.Login_op(usertoken.getUsername());

        if(user==null){
            return null;
        }

        if(user.getLocked()==0){
            throw new ExcessiveAttemptsException();
        }

        //记得返回封装好的user,否则认证成功但令牌仍将为空
        //1登录对象 2登录对象密码 3加密盐 4当前使用Realm名
        return new SimpleAuthenticationInfo(user
                ,user.getPassword()
                ,ByteSource.Util.bytes(user.getSalt())
                ,getName());
    }
}
