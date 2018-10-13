package com.lpan.domain;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
/*
活动表
 */

@Entity
@Table(name = "activityInfo")
public class Activity {

    @Id
    @GeneratedValue(generator = "myIdStrategy")
    @GenericGenerator(name = "myIdStrategy", strategy = "uuid")
    private String id;
    @OneToOne
    @JoinColumn(name = "userId")
    private UserInfo userInfo;
    private String activityName;
    //类型ID
    @OneToOne
    @JoinColumn(name = "activityTypeId")
    private ActivityType activityType;
    //地点
    private String place;
    //活动人数
    private String peopleNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;
    // 活动持续时间
    private String activityTime;
    //是否需要门票
    private String isTicket;
    private double ticketPrice;
    //活动详细信息
    private String myExplain;


//    @OneToMany(mappedBy = "activity.id")


    //级联保存、更新、删除、刷新;延迟加载。当删除用户，会级联删除该用户的所有文章
    //拥有mappedBy注解的实体类为关系被维护端
    //mappedBy="author"中的author是Article中的author属性
//    @OneToMany(mappedBy = "activityId",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//    private List<ActivityWantGo> activityWantGos;


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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
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

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getMyExplain() {
        return myExplain;
    }

    public void setMyExplain(String myExplain) {
        this.myExplain = myExplain;
    }

//    public List<ActivityWantGo> getActivityWantGos() {
//        return activityWantGos;
//    }
//
//    public void setActivityWantGos(List<ActivityWantGo> activityWantGos) {
//        this.activityWantGos = activityWantGos;
//    }
}
