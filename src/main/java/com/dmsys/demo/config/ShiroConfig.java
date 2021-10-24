package com.dmsys.demo.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /*cookie对象*/
    public SimpleCookie rememberMeCookie() {
        // 设置cookie名称，对应login.html页面的<input type="checkbox" name="rememberMe"/>
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        // 设置cookie的过期时间，单位为秒，这里为一天
        cookie.setMaxAge(86400);
        return cookie;
    }

    /**
     * cookie管理对象
     * @return
     */
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        // rememberMe cookie加密的密钥
        cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("shiroFilterFactoryBean") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        Map<String, String> filterMap = new LinkedHashMap<>();
        //无需权限
        filterMap.put("/static/**", "anon");
        //需要权限
        filterMap.put("http://localhost:9528", "perms[admin]");
        bean.setFilterChainDefinitionMap(filterMap);
        bean.setLoginUrl("/");
        bean.setUnauthorizedUrl("/noauth");
        return bean;
    }

    @Bean(name = "shiroFilterFactoryBean")
    public DefaultWebSecurityManager getdefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager Securitymanage = new DefaultWebSecurityManager();

        //启用加密认证
        HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();
        //采用md5解密
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        //散列次数
        hashedCredentialsMatcher.setHashIterations(2);
        //注入加密
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        //注册自定义realm
        Securitymanage.setRealm(userRealm);
        //加入记住我
        Securitymanage.setRememberMeManager(rememberMeManager());

        return Securitymanage;
    }

    @Bean
    public UserRealm userRealm() { return new UserRealm();
    }
}
