package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Announcement;
import com.example.demo.entity.User;
import com.example.demo.service.IAnnouncementService;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : hongbo
 * @create 2021-11-23-13:00
 **/


@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

    @Autowired
    IAnnouncementService announcementService;

    @PostMapping
    public Result<?> save(@RequestBody Announcement announcement){
        if(announcementService.save(announcement)){
            return Result.success();
        }else{
            return Result.error("-1","插入失败");
        }
    }

    @PutMapping
    public Result<?> update(@RequestBody Announcement announcement){
        if(announcementService.updateById(announcement)){
            return Result.success();
        }else{
            return Result.error("-1","更新失败");
        }
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id){
        if(announcementService.removeById(id)){
            return Result.success();
        }else {
            return Result.error("-1", "删除失败");
        }
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize ,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Announcement> wrapper = Wrappers.<Announcement>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(Announcement::getTitle, search);
        }

//        Page<User> userPage = userMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        Page<Announcement> announcementPage = announcementService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(announcementPage);
    }

}
