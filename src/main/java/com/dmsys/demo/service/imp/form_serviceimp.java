package com.dmsys.demo.service.imp;

import com.dmsys.demo.bean.Form;
import com.dmsys.demo.dao.form_mapper;
import com.dmsys.demo.service.form_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class form_serviceimp implements form_service {
    @Autowired
    form_mapper form_mapper;

    @Override
    public int addform(String title, String html) {
        return form_mapper.insertform(title,html);
    }

    @Override
    public ArrayList<Form> getform(int page,int limit) {
        return form_mapper.getform(page,limit);
    }

    @Override
    public int deleteform(List<String> str) {
        int i=0;
        for(String form_id: str){
            i+=form_mapper.deleteform(form_id);
        }
        return i;
    }
}
