package com.lpan.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appointment_protect")
public class AppointmentProtect {

    @Id
    @GeneratedValue(generator = "my")
    @GenericGenerator(strategy = "uuid", name = "my")
    private String id;
    @OneToOne
    @JoinColumn(name = "appointmentId")
    private Appointment appointment;
    // 申请防护人
    @OneToOne
    @JoinColumn(name = "userId")
    private UserInfo user;
    // 防护开始时间
    private Date startTime;
    // 防护截止时间
    private Date endTime;
    // 申请保护时间
    private Date applyTime;
    // 紧急联系人
    @OneToOne
    @JoinColumn(name = "urgentLinkmanId")
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }
}
