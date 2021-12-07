package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.beans.Customizer;

/**
 * @author : hongbo
 * @create 2021-11-23-13:00
 **/


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/login")
    public Result<?> login(@RequestBody User user){
        User res = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserName, user.getUserName()).eq(User::getPassword, user.getPassword()));
        //User res = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUserName, user.getUserName()).eq(User::getPassword, user.getPassword()));
        if(res == null){
            return Result.error("-1","用户名或密码错误");
        }
        return Result.success(res);
    }

    @PostMapping("/register")
    public Result<?> register(@RequestBody User user){
        //User res = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUserName,user.getUserName()));
        User res = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserName,user.getUserName()));
        if(res != null){
            return Result.error("-1","用户名重复");
        }
        if(user.getPassword() == null){
            user.setPassword("123456");
        }else if(user.getType() == null){
            user.setType(1);
        }
        userService.save(user);
        return Result.success();
    }


    //不用写吗？
//    @PostMapping
//    public Result<?> save(@RequestBody User user){
//        if(user.getPassword() == null){
//            user.setPassword("123456");
//        }
//        userMapper.insert(user);
//        return Result.success();
//    }

    @PutMapping
    public Result<?> update(@RequestBody User user){
//        userMapper.updateById(user);
        userService.updateById(user);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id){
//        userMapper.deleteById(id);
        userService.removeById(id);
        return Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize ,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(User::getRealName, search);
        }

//        Page<User> userPage = userMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        Page<User> userPage = userService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(userPage);
    }

}
