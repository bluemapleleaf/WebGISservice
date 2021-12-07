package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Announcement;
import com.example.demo.entity.Repair;

/**
 * @author : hongbo
 * @create 2021-12-07-20:04
 **/
public interface IAnnouncementService extends IService<Announcement> {

    //自己添加的方法
    IPage<Announcement> getPage(int currentPage, int pageSize);
}
