package com.dmsys.demo.dao;


import com.dmsys.demo.bean.Form;
import com.dmsys.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface form_mapper {
    public int insertform(@Param("title")String title,@Param("html")String html);

    public ArrayList<Form> getform(int page,int limit);

    public int deleteform(String form_id);
}
