package com.dmsys.demo;

import com.dmsys.demo.bean.User;
import com.dmsys.demo.bean.Admin;
import com.dmsys.demo.dao.user_mapper;
import com.dmsys.demo.service.Login_service;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    Login_service login_service;

    @Autowired
    user_mapper user_mapper;

    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        connection.close();
    }

    @Test
    void testsql(){
        User data=login_service.Login_op("119583010111");
        System.out.println(data);
    }

    @Test
    void testMD5(){
        //密码+admin+散列次数
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();
        System.out.println(salt);
        Md5Hash md5Hash=new Md5Hash("123456",salt,2);
        System.out.println(md5Hash.toHex());
    }

    @Test
    void testadd(){

    }
}
