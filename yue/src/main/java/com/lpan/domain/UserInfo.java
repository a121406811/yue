package com.lpan.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userInfo")
public class UserInfo {

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String userId;
    private String password;
    private int tel;
    private String wxOpenID;
    private String wxNickName;
    // 微信头像
    private String wxPortrait;
    private String nickName;
    private String portrait;
    private String birthday;
    private int sex;
    // 个性签名
    private String personDescribe;
    // 行业
    private String tradeID;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getWxOpenID() {
        return wxOpenID;
    }

    public void setWxOpenID(String wxOpenID) {
        this.wxOpenID = wxOpenID;
    }

    public String getWxNickName() {
        return wxNickName;
    }

    public void setWxNickName(String wxNickName) {
        this.wxNickName = wxNickName;
    }

    public String getWxPortrait() {
        return wxPortrait;
    }

    public void setWxPortrait(String wxPortrait) {
        this.wxPortrait = wxPortrait;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPersonDescribe() {
        return personDescribe;
    }

    public void setPersonDescribe(String personDescribe) {
        this.personDescribe = personDescribe;
    }

    public String getTradeID() {
        return tradeID;
    }

    public void setTradeID(String tradeID) {
        this.tradeID = tradeID;
    }


    public UserInfo() {
    }

    public UserInfo(String wxOpenID, String wxNickName, String wxPortrait, int sex) {
        this.wxOpenID = wxOpenID;
        this.wxNickName = wxNickName;
        this.wxPortrait = wxPortrait;
        this.sex = sex;
    }

    public UserInfo(String userId, String password, int tel, String wxOpenID, String wxNickName, String wxPortrait, String nickName, String portrait, String birthday, int sex, String personDescribe, String tradeID) {
        this.userId = userId;
        this.password = password;
        this.tel = tel;
        this.wxOpenID = wxOpenID;
        this.wxNickName = wxNickName;
        this.wxPortrait = wxPortrait;
        this.nickName = nickName;
        this.portrait = portrait;
        this.birthday = birthday;
        this.sex = sex;
        this.personDescribe = personDescribe;
        this.tradeID = tradeID;
    }
}
