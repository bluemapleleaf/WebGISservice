package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : hongbo
 * @create 2021-11-23-13:03
 **/

@TableName("user")
@Data
public class User implements Serializable {
    @TableId(value ="id", type = IdType.AUTO)
    private Integer id;
    private String userName;
    private String realName;
    private String password;
    private String phoneNumber;
    private Integer type;
    private String address;
    private String affiliation;
}
