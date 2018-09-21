package com.lpan.service;

import com.lpan.domain.Appointment;
import com.lpan.domain.AppointmentInviter;
import com.lpan.repository.AppointmentInviterRepository;
import com.lpan.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)// 指在遇到Exception时就会回滚，而如果不标注rollbackOn，只会在抛RuntimeException时回滚。
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentInviterRepository appointmentInviterRepository;

    public boolean save(Appointment appointment, List<String> userIds) {
        String uuid = UUID.randomUUID().toString();
        appointment.setId(uuid);
        List<AppointmentInviter> list = new ArrayList<AppointmentInviter>();
        for (String userId : userIds) {
            AppointmentInviter appointmentInviter = new AppointmentInviter(UUID.randomUUID().toString(), uuid, userId);
            list.add(appointmentInviter);
        }
        try {
            appointmentRepository.save(appointment);
            appointmentInviterRepository.saveAll(list);
            int i = 1 / 0;
        } catch (Exception e) {
//            throw new RuntimeException("添加失败！");
//             手动回滚，这样上层就无需去处理异常
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        return true;
    }

//    public static void main(String[] args) {
//        System.out.println(test());
//    }
//
//    public static boolean test() {
//        try {
//            int i = 1 / 0;
//        } catch (Exception e) {
//            throw new RuntimeException("添加失败！");
//        } finally {
//            System.out.println(111);
//        }
//        return true;
//    }
}
