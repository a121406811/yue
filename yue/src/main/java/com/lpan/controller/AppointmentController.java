package com.lpan.controller;

import com.lpan.domain.Appointment;
import com.lpan.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // 新增约会
    @RequestMapping("save")
    public boolean save(String userId, String startTime, String place, String[] userIds) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(startTime);
        return appointmentService.save(userId, date, place, userIds);
    }

    // 改变约会的状态
    @RequestMapping("updateRevoke")
    public boolean updateRevoke(int state, String id) {
        return appointmentService.updateRevoke(state, id);
    }

    // 查询我发起的约会
    @RequestMapping("findMyByUserId")
    public List<Appointment> findMyByUserId(String userId) {
        return appointmentService.findMyByUserId(userId);
    }

    // 查询我接收的约会
    @RequestMapping("findMyInviter")
    public List<Appointment> findMyInviter(String userId) {
        return appointmentService.findMyInviter(userId);
    }

    // 定时任务提醒参加约会

    // 提醒您有新的约会

    // 前端如何定时调用   以达到消息提醒的效果

}
