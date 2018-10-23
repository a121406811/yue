package com.lpan.controller;

import com.lpan.domain.AppointmentProtect;
import com.lpan.service.AppointmentProtectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/appointmentProtect")
public class AppointmentProtectController {

    @Autowired
    private AppointmentProtectService appointmentProtectService;

    @RequestMapping("save")
    public String save(String appointmentId, String userId, String startTime, String endTime, String userAndUrgentLinkmanId, int state, String remarks) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date st = sdf.parse(startTime);
        Date et = sdf.parse(endTime);
        AppointmentProtect appointment = appointmentProtectService.getByAppointmentId(appointmentId);
        String result = null;
        if (appointment == null) {
            AppointmentProtect appointmentProtect = new AppointmentProtect(UUID.randomUUID().toString(), appointmentId, userId, st, et, userAndUrgentLinkmanId, state, remarks);
            boolean save = appointmentProtectService.save(appointmentProtect);
            if (save == true) {
                result = "save success";
            } else {
                result = "save fail";
            }
        } else {
            result = "exists";
        }

        return result;
    }

    @RequestMapping("getByAppointmentId")
    public AppointmentProtect getByAppointmentId(String appointmentId) {
        return appointmentProtectService.getByAppointmentId(appointmentId);
    }

    // 取消保护
    @RequestMapping("unprotect")
    public boolean unprotect(String id) {
        return appointmentProtectService.unprotect(id);
    }

}
