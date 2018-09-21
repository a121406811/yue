package com.lpan.service;

import com.lpan.domain.AppointmentProtect;
import com.lpan.repository.AppointmentProtectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentProtectService {

    @Autowired
    private AppointmentProtectRepository appointmentProtectRepository;

    public boolean save(AppointmentProtect appointmentProtect) {
        try {
            appointmentProtectRepository.save(appointmentProtect);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
