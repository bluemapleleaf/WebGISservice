package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Repair;
import com.example.demo.entity.User;

/**
 * @author : hongbo
 * @create 2021-12-07-20:04
 **/
public interface IRepairService extends IService<Repair> {

    //自己添加的方法
    IPage<Repair> getPage(int currentPage, int pageSize);
}
