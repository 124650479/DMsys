package com.dmsys.demo.service.imp;

import com.dmsys.demo.bean.Role;
import com.dmsys.demo.bean.User;
import com.dmsys.demo.bean.Admin;
import com.dmsys.demo.dao.user_mapper;
import com.dmsys.demo.service.Login_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Login_serviceimp implements Login_service {

    @Autowired
    user_mapper user_mapper;
    @Override
    public User Login_op(String username) {
        return user_mapper.getuserbyname(username);
    }

    @Override
    public Admin Login_getme(String username) {
        return user_mapper.getme(username);
    }
}
