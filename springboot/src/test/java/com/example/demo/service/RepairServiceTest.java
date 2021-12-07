package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Repair;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

/**
 * @author : hongbo
 * @create 2021-12-07-23:53
 **/

@SpringBootTest
public class RepairServiceTest {
    @Autowired
    private IRepairService repairService;

    @Test
    void testSave(){
        Repair repair = new Repair();
        repair.setApplyId(1);
        repair.setRepairType(0);
        repair.setApplyDate(new Date());
        repair.setTitle("维修事件");
        repair.setContent("维修内容");
        repair.setLatitude(0);
        repair.setLongitude(0);
        repair.setPlace("信息学部3食堂");
        repair.setState(0);
        repairService.save(repair);
    }
}
