package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author : hongbo
 * @create 2021-12-07-19:47
 **/

@TableName("announcement")
@Data
public class Announcement {
    @TableId(value ="id", type = IdType.AUTO)
    private Integer id;
    private String title;
    private String content;
    private String comment;
    private Integer applyId;
    private Integer checkId;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date applyDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date publishDate;
    private Integer state;
}
