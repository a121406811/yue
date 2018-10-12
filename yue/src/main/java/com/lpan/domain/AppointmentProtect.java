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
    private Appointment appointment;
    // 申请防护人
    private UserInfo user;
    // 防护截止时间
    private Date time;
    // 紧急联系人
    private UserAndUrgentLinkman userAndUrgentLinkman;
    // 安全状态   0 被保护期间  1解除保护  2时间到未发送短信紧急联系人  3时间到已通知紧急联系人
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

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public UserAndUrgentLinkman getUserAndUrgentLinkman() {
        return userAndUrgentLinkman;
    }

    public void setUserAndUrgentLinkman(UserAndUrgentLinkman userAndUrgentLinkman) {
        this.userAndUrgentLinkman = userAndUrgentLinkman;
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
