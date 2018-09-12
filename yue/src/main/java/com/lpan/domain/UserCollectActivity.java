package com.lpan.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
/*
    用户收藏活动表
 */

@Entity
public class UserCollectActivity {

    @Id
    @GeneratedValue(generator = "myIdStrategy")
    @GenericGenerator(name = "myIdStrategy", strategy = "uuid")
    private String id;
    private String userId;
    @OneToOne
    @JoinColumn(name = "activityId")
    private Activity activity;

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

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
