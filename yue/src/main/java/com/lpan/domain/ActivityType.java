package com.lpan.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/*
活动类型表
 */

@Entity
@Table(name = "activityType")
public class ActivityType {

    @Id
    private String id;
    private String activityTypeName;
    private String pid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivityTypeName() {
        return activityTypeName;
    }

    public void setActivityTypeName(String activityTypeName) {
        this.activityTypeName = activityTypeName;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
