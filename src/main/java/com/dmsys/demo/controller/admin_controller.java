package com.dmsys.demo.controller;

import com.alibaba.fastjson.JSON;
import com.dmsys.demo.bean.Form;
import com.dmsys.demo.service.form_service;
import com.dmsys.demo.utils.Layui_data_format;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class admin_controller {

    @Autowired
    form_service form_service;

    @RequestMapping("/create_form")
    @ResponseBody
    public String create_form(String myset, String htmlbody, String title) {
        List<String> str = JSON.parseArray(myset, String.class);
        int i=form_service.addform(title,htmlbody);
        if(i>0)
        return "success";
        else{
            return "fails";
        }
    }
    @RequestMapping("/get_form")
    @ResponseBody
    public HashMap<String,Object> get_form(int page,int limit){
        ArrayList<Form> forms=form_service.getform(page, limit);
        return Layui_data_format.Format(forms);
    }

    @RequestMapping("/delete_form")
    @ResponseBody
    public String delete_form(String delete){
        List<String> str = JSON.parseArray(delete, String.class);
        int i=form_service.deleteform(str);
        if(i>0)
            return "success";
        else{
            return "fails";
        }
    }
}
