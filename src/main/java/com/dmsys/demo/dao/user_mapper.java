package com.dmsys.demo.dao;

import com.dmsys.demo.bean.User;
import com.dmsys.demo.bean.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface user_mapper {
    public User getuserbyname(String username);
    public Admin getme(String username);
}
