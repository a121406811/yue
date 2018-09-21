package com.lpan.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "appointment_protect")
public class AppointmentProtect {

    @Id
    @GeneratedValue(generator = "my")
    @GenericGenerator(strategy = "uuid", name = "my")
    private String id;
    private String appointmentId;
    // 申请防护人
    private String userId;
    //防护截止时间
    private Date time;
    // 紧急联系人
    private String urgentLinkmanId;
    // 安全状态
    private int state;
    // 约会对象名字
    private String appointmentName;
    // 约会对象电话
    private String appointmentTel;
    // 备注
    private String remarks;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUrgentLinkmanId() {
        return urgentLinkmanId;
    }

    public void setUrgentLinkmanId(String urgentLinkmanId) {
        this.urgentLinkmanId = urgentLinkmanId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAppointmentName() {
        return appointmentName;
    }

    public void setAppointmentName(String appointmentName) {
        this.appointmentName = appointmentName;
    }

    public String getAppointmentTel() {
        return appointmentTel;
    }

    public void setAppointmentTel(String appointmentTel) {
        this.appointmentTel = appointmentTel;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
