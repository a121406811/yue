package com.lpan.repository;

import com.lpan.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,String> {

    @Query(value = "select * from appointment  where userId = ?1 ", nativeQuery = true)
    public List<Appointment> findMyByUserId(String userId);

    @Query(value = "select a.* from appointment a,appointment_inviter ai where a.id=ai.appointmentId and ai.inviterId=?1", nativeQuery = true)
    public List<Appointment> findMyInviter(String userId);

}
