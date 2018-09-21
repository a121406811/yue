package com.lpan.repository;

import com.lpan.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,String> {

}
