package com.lpan.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
    约会被邀请人表
 */

@Entity
@Table(name = "appointment_inviter")
public class AppointmentInviter {

    @Id
    @GeneratedValue(generator = "my")
    @GenericGenerator(name = "my", strategy = "uuid")
    private String id;
    private String appointmentId;
    // 被邀请人ID
    private String inviterId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getInviterId() {
        return inviterId;
    }

    public void setInviterId(String inviterId) {
        this.inviterId = inviterId;
    }

    public AppointmentInviter() {
    }

    public AppointmentInviter(String id, String appointmentId, String inviterId) {
        this.id = id;
        this.appointmentId = appointmentId;
        this.inviterId = inviterId;
    }
}
