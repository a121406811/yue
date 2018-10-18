package com.lpan.service;

import com.lpan.domain.AppointmentProtect;
import com.lpan.repository.AppointmentProtectRepository;
import com.lpan.util.TransFormPortraitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)// 指在遇到Exception时就会回滚，而如果不标注rollbackOn，只会在抛RuntimeException时回滚。
public class AppointmentProtectService {

    @Autowired
    private AppointmentProtectRepository appointmentProtectRepository;

    public boolean save(AppointmentProtect appointmentProtect) {
        appointmentProtect.setId(UUID.randomUUID().toString());
        appointmentProtect.setApplyTime(new Date());
        try {
            appointmentProtectRepository.save(appointmentProtect);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    // 定时查询被保护人，给紧急联系人提醒
    @Scheduled(fixedRate = 5000)
    public void protect() throws Exception {
        List<AppointmentProtect> all = appointmentProtectRepository.findAllByState(2);
        for (AppointmentProtect a : all) {
            // 发送信息
            TransFormPortraitUtil.sendCode(a.getUserAndUrgentLinkman().getLinkmanTel(),a.getUser().getTrueName(),a.getAppointment().getPlace(),a.getEndTime(),a.getAppointmentTel(),a.getRemarks());
            a.setState(3);
        }
        // 更新状态
        appointmentProtectRepository.saveAll(all);
    }

    // 定时查询所有约会保护，将时间到的约会修改状态
    @Scheduled(fixedRate = 5000)
    public void updateState() throws Exception {
        // 查询时间已到的对象
        List<AppointmentProtect> list = appointmentProtectRepository.findAllByStateAndTime();
        // 将这些对象的状态改为 时间到并且为提醒紧急联系人（state=2）
        for (AppointmentProtect a : list){
            a.setState(2);
        }
        appointmentProtectRepository.saveAll(list);
    }


}
