package com.dmsys.demo.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.Random;

public class Randomstr {

    /**
     * 李平喆
     * md5加密密码工具 传入前端输入密码,与已经生成的盐
     * 2021/9/27 20:17
     */
    public String make_pwd(String password,String salt){
        //以下为md5加密,其中整数为散列次数，规定散列两次
        Md5Hash md5Hash=new Md5Hash(password,salt,2);
        return md5Hash.toHex();
    }

    /*
    * 李平喆
    * 产生随机盐
    * */
    public String make_salt() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        //填充十六位随机数字
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();
        return salt;
    }
}
