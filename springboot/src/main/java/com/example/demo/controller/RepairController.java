package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Repair;
import com.example.demo.service.IRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author : hongbo
 * @create 2021-11-23-13:00
 **/


@RestController
@RequestMapping("/repairs")
public class RepairController {
    @Autowired
    IRepairService repairService;



    //维修上传，保存操作
    @PostMapping
    public Result<?> save(@RequestBody Repair repair){
        repairService.save(repair);
        return Result.success();
    }

    //维修修改
    @PutMapping
    public Result<?> update(@RequestBody Repair repair){
        repairService.updateById(repair);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id){
        repairService.removeById(id);
        return Result.success();
    }

    //找到一个
    @GetMapping("/{id}")
    public Result<?> getOne(@PathVariable Long id){
        Repair res = repairService.getById(id);
        if(res == null){
            return Result.error("-1","id不存在");
        }
        return Result.success(res);
    }


    //分页展示全部
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize ,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Repair> wrapper = Wrappers.<Repair>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(Repair::getTitle, search);
        }
        Page<Repair> repairPage = repairService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(repairPage);
    }

}
