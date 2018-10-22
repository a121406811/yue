package com.lpan.controller;

import com.lpan.domain.ActivityWantGo;
import com.lpan.service.ActivityWantGoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/activityWantGo")
public class ActivityWantGoController {

    @Autowired
    private ActivityWantGoService activityWantGoService;

    // 添加活动想去人
    @RequestMapping("save")
    public String save(ActivityWantGo activityWantGo) {
        activityWantGo.setId(UUID.randomUUID().toString());
        boolean b = activityWantGoService.collExists(activityWantGo.getActivityId(), activityWantGo.getUserInfo().getUserId());
        String result = null;
        if (b == true) { // 该想去人已存在
            return "exists";
        } else {
            boolean save = activityWantGoService.save(activityWantGo);
            if (save == true) {
                result = "save success";
            } else {
                result = "save fail";
            }
        }
        return result;
    }

    // 查询该活动想去人数
    @RequestMapping("getCountByActivityId")
    public int getCountByActivityId(String activityId) {
        return activityWantGoService.getCountByActivityId(activityId);
    }

    // 查询活动想去人
    @RequestMapping("getUserInfoByActivityId")
    public Page<ActivityWantGo> getUserInfoByActivityId(String activityId, int page, int size) {
        return activityWantGoService.getUserInfoByActivityId(activityId, page, size);
    }

}
