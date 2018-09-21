package com.lpan.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
    紧急联系人表
 */

@Entity
@Table(name = "userAndUrgentLinkman")
public class UserAndUrgentLinkman {

    @Id
    @GeneratedValue(generator = "mySelf")
    @GenericGenerator(name = "mySelf", strategy = "uuid")
    private String id;
    private String userId;
    private String linkmanName;
    private String linkmanTel;
    private int urgentRank;

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

    public String getLinkmanName() {
        return linkmanName;
    }

    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    public String getLinkmanTel() {
        return linkmanTel;
    }

    public void setLinkmanTel(String linkmanTel) {
        this.linkmanTel = linkmanTel;
    }

    public int getUrgentRank() {
        return urgentRank;
    }

    public void setUrgentRank(int urgentRank) {
        this.urgentRank = urgentRank;
    }
}
