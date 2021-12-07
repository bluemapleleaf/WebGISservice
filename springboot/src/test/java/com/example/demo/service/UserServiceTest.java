package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author : hongbo
 * @create 2021-12-07-20:10
 **/

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private IUserService userService;

    @Test
    void testGetById(){
        System.out.println(userService.getById(2));
    }

    @Test
    void testSave(){
        User user = new User();
        user.setUserName("测试数据用户名");
        user.setRealName("测试数据真实名");
        user.setPassword("123456");
        user.setPhoneNumber("12345678");
        user.setType(1);
        user.setAddress("信息学部竹园8舍");
        user.setAffiliation("");
        userService.save(user);
    }

    @Test
    void testUpdate(){
        User user = new User();
        user.setId(4);
        user.setUserName("测试数据修改用户名");
        user.setRealName("测试数据修改真实名");
        user.setPassword("123456");
        user.setPhoneNumber("12345678");
        user.setType(1);
        user.setAddress("信息学部竹园7舍");
        user.setAffiliation("");
        userService.updateById(user);
    }

    @Test
    void testDelete(){
        userService.removeById(5);
    }

    @Test
    void testGetAll(){
        userService.list();
    }

    @Test
    void testGetPage(){
        IPage<User> page = userService.getPage(1,5);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
}
