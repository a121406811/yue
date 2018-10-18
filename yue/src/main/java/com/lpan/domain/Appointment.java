package com.lpan.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/*
    约会表
 */

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(generator = "my")
    @GenericGenerator(name = "my", strategy = "uuid")
    private String id;
    @OneToOne
    @JoinColumn(name = "userId")
    private UserInfo userInfo;
    private Date startTime;
    private String place;
    private Date makeTime;
    private int state;       // 1发出邀请，还未作出回应   2 撤回约会   3 已接受  4 不接受  5 已开始

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(Date makeTime) {
        this.makeTime = makeTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Appointment(String id, UserInfo userInfo, Date startTime, String place, Date makeTime, int state) {
        this.id = id;
        this.userInfo = userInfo;
        this.startTime = startTime;
        this.place = place;
        this.makeTime = makeTime;
        this.state = state;
    }
}
