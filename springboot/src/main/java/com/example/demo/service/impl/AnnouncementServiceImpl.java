package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Announcement;
import com.example.demo.mapper.AnnouncementMapper;
import com.example.demo.service.IAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : hongbo
 * @create 2021-12-07-20:05
 **/

@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements IAnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Override
    public IPage<Announcement> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        announcementMapper.selectPage(page,null);
        return page;
    }
}
