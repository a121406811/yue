package com.lpan.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/*
    用户收藏的用户表，这里直接存活动想去人字段。
 */
@Entity
public class UserCollectAwg {

    @Id
    @GeneratedValue(generator = "myIdStrategy")
    @GenericGenerator(name = "myIdStrategy", strategy = "uuid")
    private String id;
    private String userId;
    @OneToOne
    @JoinColumn(name = "awgId")
    private ActivityWantGo activityWantGo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ActivityWantGo getActivityWantGo() {
        return activityWantGo;
    }

    public void setActivityWantGo(ActivityWantGo activityWantGo) {
        this.activityWantGo = activityWantGo;
    }
}
