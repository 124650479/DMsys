package com.dmsys.demo.bean;

import java.io.Serializable;
import java.util.List;

//使用了 list，数据库无法识别，必须实现Serializable接口，才能序列化实体类，在产生cookie时需要用到
public class User implements Serializable {
    private int user_id;
    private String username;
    private String password;
    private Role role;
    private String salt;
    private int locked;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", salt='" + salt + '\'' +
                ", locked=" + locked +
                '}';
    }
}
