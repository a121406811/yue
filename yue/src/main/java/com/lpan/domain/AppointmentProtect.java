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
//    @OneToOne
//    @JoinColumn(name = "appointmentId")
    private String appointmentId;
    // 申请防护人
//    @OneToOne
//    @JoinColumn(name = "userId")
    private String userId;
    // 防护开始时间
    private Date startTime;
    // 防护截止时间
    private Date endTime;
    // 申请保护时间
    private Date applyTime;
    // 紧急联系人
//    @OneToOne
//    @JoinColumn(name = "urgentLinkmanId")
    private String userAndUrgentLinkmanId;
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

    public String getUserAndUrgentLinkmanId() {
        return userAndUrgentLinkmanId;
    }

    public void setUserAndUrgentLinkmanId(String userAndUrgentLinkmanId) {
        this.userAndUrgentLinkmanId = userAndUrgentLinkmanId;
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

    public AppointmentProtect() {
    }

    public AppointmentProtect(String id, String appointmentId, String userId, Date startTime, Date endTime, String userAndUrgentLinkmanId, int state, String remarks) {
        this.id = id;
        this.appointmentId = appointmentId;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.userAndUrgentLinkmanId = userAndUrgentLinkmanId;
        this.state = state;
        this.remarks = remarks;
    }
}
