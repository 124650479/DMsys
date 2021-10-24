package com.dmsys.demo.service;

import com.dmsys.demo.bean.Form;

import java.util.ArrayList;
import java.util.List;

public interface form_service {
    public int addform(String title,String html);
    public ArrayList<Form> getform(int page,int limit);
    public int deleteform(List<String> str);
}
