package com.dmsys.demo.service;

import com.dmsys.demo.bean.Role;
import com.dmsys.demo.bean.User;
import com.dmsys.demo.bean.Admin;

public interface Login_service {
    public User Login_op(String username);
    public Admin Login_getme(String username);
}
