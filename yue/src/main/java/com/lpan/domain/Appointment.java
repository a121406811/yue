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
    private int state;

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
}
