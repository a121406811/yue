package com.lpan.controller;

import com.lpan.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/a")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("queryAll")
    public static Map<String, Object> queryAll() {
        return null;
    }

    @RequestMapping("test")
    public static String test() {
        return "连接成功oooooook" + ":" + new Date();
    }


}
