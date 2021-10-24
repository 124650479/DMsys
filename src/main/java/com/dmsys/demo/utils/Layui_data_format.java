package com.dmsys.demo.utils;

import com.dmsys.demo.bean.Form;

import java.util.ArrayList;
import java.util.HashMap;

public class Layui_data_format {
    public static HashMap<String,Object> Format(ArrayList<Form> list){
        HashMap<String,Object> map=new HashMap<String, Object>();
        map.put("data",list);
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        return map;
    }
}
