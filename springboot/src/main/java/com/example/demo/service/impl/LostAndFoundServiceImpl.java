package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.LostAndFound;
import com.example.demo.mapper.LostAndFoundMapper;
import com.example.demo.service.ILostAndFoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : hongbo
 * @create 2021-12-07-20:05
 **/

@Service
public class LostAndFoundServiceImpl extends ServiceImpl<LostAndFoundMapper, LostAndFound> implements ILostAndFoundService {

    @Autowired
    private LostAndFoundMapper lostAndFoundMapper;

    @Override
    public IPage<LostAndFound> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        lostAndFoundMapper.selectPage(page,null);
        return page;
    }
}
