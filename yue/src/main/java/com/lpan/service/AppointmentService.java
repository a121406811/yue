package com.lpan.service;

import com.lpan.domain.Appointment;
import com.lpan.domain.AppointmentInviter;
import com.lpan.domain.UserInfo;
import com.lpan.repository.AppointmentInviterRepository;
import com.lpan.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)// 指在遇到Exception时就会回滚，而如果不标注rollbackOn，只会在抛RuntimeException时回滚。
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentInviterRepository appointmentInviterRepository;

    public boolean save(String userId, Date startTime, String place, String[] userIds) {
        String uuid = UUID.randomUUID().toString();
        Appointment appointment = new Appointment(uuid, userId, startTime, place, new Date(), 1);
        List<AppointmentInviter> list = new ArrayList<AppointmentInviter>();
        for (String AIuserId : userIds) {
            AppointmentInviter appointmentInviter = new AppointmentInviter(UUID.randomUUID().toString(), uuid, AIuserId);
            list.add(appointmentInviter);
        }
        try {
            appointmentInviterRepository.saveAll(list);
            appointmentRepository.save(appointment);
//            int i = 1 / 0;
        } catch (Exception e) {
//            throw new RuntimeException("添加失败！");
//             手动回滚，这样上层就无需去处理异常
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        return true;
    }

    public boolean updateRevoke(int state, String id) {
        try {
            Appointment one = appointmentRepository.getOne(id);
            one.setState(state);
            appointmentRepository.save(one);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public List<Appointment> findMyByUserId(String userId) {
        return appointmentRepository.findMyByUserId(userId);
    }

    public List<Appointment> findMyInviter(String userId) {
        return appointmentRepository.findMyInviter(userId);
    }

    public Appointment getOne(String id) {
        return appointmentRepository.getOne(id);
    }


    public static void main(String[] args) {

    }
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

