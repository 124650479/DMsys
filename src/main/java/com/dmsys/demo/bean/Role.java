package com.dmsys.demo.bean;

import java.io.Serializable;

public class Role implements Serializable {
    private int role_id;
    private String name;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Roles{" +
                "role_id=" + role_id +
                ", name='" + name + '\'' +
                '}';
    }
}
