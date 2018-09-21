package com.lpan.controller;

import com.lpan.domain.Appointment;
import com.lpan.domain.UserInfo;
import com.lpan.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // 新增约会
    public boolean save(Appointment appointment, List<String> userIds){
        return appointmentService.save(appointment,userIds);
    }

    // 撤回约会

    // 被邀请人回应约会

    // 定时任务提醒参加约会

    // 提醒您有新的约会

}
