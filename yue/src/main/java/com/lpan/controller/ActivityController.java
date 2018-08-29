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
@RequestMapping("/a")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("findAll")
    public List<Activity> findAll() {
        List<Activity> all = activityService.findAll();
        return all;
    }

    @RequestMapping("test")
    public String test() {
        return "连接成功oooooook" + ":" + new Date();
    }


}
