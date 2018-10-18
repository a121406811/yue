package com.lpan.controller;

import com.lpan.domain.Appointment;
import com.lpan.domain.UserInfo;
import com.lpan.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // 新增约会
    @RequestMapping("save")
    public boolean save(String userId, Date startTime, String place, String[] userIds) {
        return appointmentService.save(userId, startTime, place, userIds);
    }

    // 改变约会的状态
    public boolean updateRevoke(int state, String id) {
        return appointmentService.updateRevoke(state, id);
    }

    // 定时任务提醒参加约会

    // 提醒您有新的约会

    // 前端如何定时调用   以达到消息提醒的效果

}
