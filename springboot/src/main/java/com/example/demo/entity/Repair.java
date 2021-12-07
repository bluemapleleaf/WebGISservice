package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author : hongbo
 * @create 2021-12-07-20:00
 **/
@TableName("repair")
@Data
public class Repair {
    @TableId(value ="id", type = IdType.AUTO)
    private Integer id;
    private Integer repairId;
    private Integer applyId;
    private String title;
    private String content;
    private double latitude;
    private double longitude;
    private String place;
    private Date applyDate;
    private Date finishDate;
    private Integer repairType;
    private Integer state;
}
