package com.lpan.domain;


import javax.persistence.*;

@Entity
@Table(name = "base_area")
public class AreaInfo {

    @Id
    @Column(name = "AREA_PRI_ID")
    private String areaPriId;
    @Column(name = "AREA_ID")
    private String areaId;
    @Column(name = "AREA_PARENT_ID")
    private String areaPid;
    @Column(name = "AREA_TYPE")
    private String areaType;
    @Column(name = "AREA_NAME")
    private String areaName;
    @Column(name = "AREA_SHORT_NAME")
    private String areaShortName;
    // 经度
    @Column(name = "LONGITUDE")
    private String longitude;
    // 纬度
    @Column(name = "LATITUDE")
    private String latitude;

    public String getAreaPriId() {
        return areaPriId;
    }

    public void setAreaPriId(String areaPriId) {
        this.areaPriId = areaPriId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaPid() {
        return areaPid;
    }

    public void setAreaPid(String areaPid) {
        this.areaPid = areaPid;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaShortName() {
        return areaShortName;
    }

    public void setAreaShortName(String areaShortName) {
        this.areaShortName = areaShortName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
