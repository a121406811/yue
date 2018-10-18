package com.lpan.repository;

import com.lpan.domain.AppointmentProtect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentProtectRepository extends JpaRepository<AppointmentProtect, String> {

    @Query(value = "select * from appointment_protect where state=?1", nativeQuery = true)
    public List<AppointmentProtect> findAllByState(int state);

    // 查询所有状态为被保护期间（state=0）而且时间已过需要发送短信联系紧急联系人的 约会保护
    @Query(value = "select * from appointment_protect where SYSDATE()>=endtime and state = 0", nativeQuery = true)
    public List<AppointmentProtect> findAllByStateAndTime();
}
