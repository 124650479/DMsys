package com.dmsys.demo.controller;

import com.alibaba.fastjson.JSON;

import com.dmsys.demo.bean.User;
import com.dmsys.demo.bean.Admin;
import com.dmsys.demo.service.Login_service;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin
@ResponseBody
public class Loginop_controller {

    @Autowired
    Login_service login_service;

    @RequestMapping("/login")
    public HashMap<String,Object> Login(@RequestBody Map<String,Object> loginInfo) {
        String username = (String) loginInfo.get("username");
        String password = (String) loginInfo.get("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        HashMap<String,Object> map=new HashMap<>();
        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            HashMap<String,Object> data=new HashMap<>();
            data.put("token",user);
            map.put("code",20000);
            map.put("data",data);
        } catch (UnknownAccountException e) {
            map.put("code",60204);
            map.put("message","用户不存在");
        } catch (IncorrectCredentialsException e) {
            map.put("code",60204);
            map.put("message","密码错误");
        } catch (ExcessiveAttemptsException e) {
            map.put("code",60204);
            map.put("message","账户未启用");
        }
        return map;

    }

    @RequestMapping("/info")
    public HashMap<String, Object> Getinfo(String token){
        HashMap<String,Object> map=new HashMap<>();
        User t= JSON.parseObject(token,User.class);
        Admin data=login_service.Login_getme(t.getUsername());
        data.setRoles(t.getRole().getName());
        if(t==null){
            map.put("code",60204);
            map.put("message","登录超时");
        }
        else{
            map.put("code",20000);
            data.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            map.put("data",data);
        }
        return map;
    }
    @RequestMapping("/logout")
    public HashMap<String, Object> Logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        HashMap<String,Object> map=new HashMap<>();
        map.put("code",20000);
        return map;
    }
}
