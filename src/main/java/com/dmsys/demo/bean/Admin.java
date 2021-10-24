package com.dmsys.demo.bean;

public class Admin {
    String adminID;
    String realname;
    String college;
    String sex;
    String phone;


    String roles;
    String Avatar;

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminID='" + adminID + '\'' +
                ", realname='" + realname + '\'' +
                ", college='" + college + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
