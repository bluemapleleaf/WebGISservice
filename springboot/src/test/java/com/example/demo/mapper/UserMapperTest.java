package com.example.demo.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author : hongbo
 * @create 2021-12-07-21:35
 **/
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testGetById(){
        System.out.println(userMapper.selectById(1));
    }
}
