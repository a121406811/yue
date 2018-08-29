package com.lpan.domain;

import javax.persistence.*;
/*
活动表
 */

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    private String id;
    @OneToOne
    @JoinColumn(name = "userId")
    @Column(name = "userId")
    private UserInfo userInfo;
    private String activityName;
    //类型ID
    @OneToOne
    @JoinColumn(name = "id")
    @Column(name = "activityTypeId")
    private ActivityType activityTypeId;
    //地点
    private String place;
    //活动人数
    private String peopleNum;
    private String startTime;
    private String endTime;
    // 活动持续时间
    private String activityTime;
    //是否需要门票
    private String isTicket;
    private String ticketPrice;
    //活动详细信息
    private String explain;


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

    public ActivityType getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(ActivityType activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }


    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(String peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }

    public String getIsTicket() {
        return isTicket;
    }

    public void setIsTicket(String isTicket) {
        this.isTicket = isTicket;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
