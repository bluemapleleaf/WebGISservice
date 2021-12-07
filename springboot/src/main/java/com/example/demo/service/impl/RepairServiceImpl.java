package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Repair;
import com.example.demo.mapper.RepairMapper;
import com.example.demo.service.IRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : hongbo
 * @create 2021-12-07-20:05
 **/

@Service
public class RepairServiceImpl extends ServiceImpl<RepairMapper, Repair> implements IRepairService {

    @Autowired
    private RepairMapper repairMapper;

    @Override
    public IPage<Repair> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        repairMapper.selectPage(page,null);
        return page;
    }
}
