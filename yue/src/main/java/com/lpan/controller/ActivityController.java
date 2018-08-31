package com.lpan.controller;

import com.lpan.domain.Activity;
import com.lpan.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("findAll")
    public List<Activity> findAll() {
        List<Activity> all = activityService.findAll();
        return all;
    }

    // 无条件分页查询首页展示信息
    @RequestMapping("findHomePageMsg")
    public List<Activity> findHomePageMsg(int page, int size){
        return activityService.findHomePageMsg(page,size);
    }

    // 根据用户输入关键字查询活动
//    public List<Activity> find

    @RequestMapping("test")
    public List<Map<String, String>> test() {
//        return "连接成功oooooook" + ":" + new Date();
        List<Map<String, String>> test = activityService.test();
        return test;
    }


}
