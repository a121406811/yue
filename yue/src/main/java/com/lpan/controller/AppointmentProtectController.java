package com.lpan.controller;

import com.lpan.domain.AppointmentProtect;
import com.lpan.service.AppointmentProtectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/appointmentProtect")
public class AppointmentProtectController {

    @Autowired
    private AppointmentProtectService appointmentProtectService;

    @RequestMapping("save")
    public boolean save(AppointmentProtect appointmentProtect) {
        return appointmentProtectService.save(appointmentProtect);
    }

    // 定时任务起到保护作用
    public int protect() {

        return 0;
    }


}
