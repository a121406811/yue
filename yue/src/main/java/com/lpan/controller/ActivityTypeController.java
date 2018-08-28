package com.lpan.controller;

import com.lpan.domain.ActivityType;
import com.lpan.service.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/activityType")
public class ActivityTypeController {

    @Autowired
    private ActivityTypeService activityTypeService;

    @RequestMapping("findAll")
    public List<ActivityType> findAll(){
        List<ActivityType> all = activityTypeService.findAll();
        return all;
    }
}
