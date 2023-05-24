package com.gao.mygao;

import com.gao.mygao.mapper.UserMapper;
import com.gao.mygao.pojo.User;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MygaoApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void testDatabaseQuery(){
        List<String> users= userMapper.getName();
        System.out.println(users);
    }

    @Test
    public void testDatabaseQueryUser(){
        List<User> users = userMapper.getAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testAddUser(){
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String mydate = sf.format(date);
        User user = new User("测试三号", "1005" , "1005" , mydate);
        int i = userMapper.addUser(user);
        System.out.println(i);
    }

    @Test
    public void testAutoDataInsert(){
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
        System.out.println(sf.format(date));
    }
}
