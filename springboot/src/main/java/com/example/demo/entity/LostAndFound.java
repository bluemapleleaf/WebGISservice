package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author : hongbo
 * @create 2021-12-07-19:54
 **/
@TableName("lost_and_found")
@Data
public class LostAndFound {
    @TableId(value ="id", type = IdType.AUTO)
    private Integer id;
    private Integer applyId;
    private Integer finishId;
    private String title;
    private String content;
    private double latitude;
    private double longitude;
    private String place;
    private Date applyDate;
    private Date finishDate;
    private Integer state;
    private Integer type;
}
