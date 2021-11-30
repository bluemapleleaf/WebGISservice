package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author : hongbo
 * @create 2021-11-23-13:03
 **/

@TableName("user")
@Data
public class User {
    @TableId(value ="id", type = IdType.AUTO)
    private Integer id;
    private String username;
    private String nickName;
    private String password;
    private Integer age;
    private String sex;
    private String address;

}
