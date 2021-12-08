package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.LostAndFound;
import com.example.demo.service.ILostAndFoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : hongbo
 * @create 2021-11-23-13:00
 **/


@RestController
@RequestMapping("/lostandfounds")
public class LostAndFoundController {
    @Autowired
    ILostAndFoundService lostAndFoundService;


    //失物招领事件上传，保存操作
    @PostMapping
    public Result<?> save(@RequestBody LostAndFound lostAndFound){
        if(lostAndFoundService.save(lostAndFound)){
            return Result.success();
        }else{
            return Result.error("-1","插入失败");
        }
    }

    //修改操作
    @PutMapping
    public Result<?> update(@RequestBody LostAndFound lostAndFound){
        if(lostAndFoundService.updateById(lostAndFound)) {
            return Result.success();
        }else{
            return Result.error("-1","更新失败");
        }
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id){
        if(lostAndFoundService.removeById(id)) {
            return Result.success();
        }else{
            return Result.error("-1","删除失败");
        }
    }

    //找到一个
    @GetMapping("/{id}")
    public Result<?> getOne(@PathVariable Long id){
        LostAndFound res = lostAndFoundService.getById(id);
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
        LambdaQueryWrapper<LostAndFound> wrapper = Wrappers.<LostAndFound>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(LostAndFound::getTitle, search);
        }
        Page<LostAndFound> repairPage = lostAndFoundService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(repairPage);
    }

}
