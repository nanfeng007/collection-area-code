package com.scj.xingzhengquyu.pojo;

import java.util.Date;

public class XingzhengCode {
    public int id; //主键，可以不new
    public int areaCode;//区域编码（例如：110000
    public String areaName;//区域名称（例如：北京市）
    public String pinYin;//拼音 （例如：beijing）
    public String jianPin;//简拼（bj）
    public int level;//区域级别（省、直辖市-1、地级市-2、县区-3、街道、乡、镇-4）
    public int parentId;//上级区域ID
    public int status;//自定义状态（未定义-0、启用-1、停用-2）
    public Date createDate;//创建时间
    public Date modifyDate;//修改时间
    public String lng;//经度
    public String lat;//纬度

    public XingzhengCode() {
    }

    public XingzhengCode(int areaCode, String areaName, int level, int status, Date createDate, Date modifyDate) {
        this.areaCode = areaCode;
        this.areaName = areaName;
        this.level = level;
        this.status = status;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

    public XingzhengCode(int id, int areaCode, String areaName, String pinYin, String jianPin, int level, int parentId, int status, Date createDate, Date modifyDate, String lng, String lat) {
        this.id = id;
        this.areaCode = areaCode;
        this.areaName = areaName;
        this.pinYin = pinYin;
        this.jianPin = jianPin;
        this.level = level;
        this.parentId = parentId;
        this.status = status;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.lng = lng;
        this.lat = lat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }

    public String getJianPin() {
        return jianPin;
    }

    public void setJianPin(String jianPin) {
        this.jianPin = jianPin;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "XingzhengCode{" +
                "id=" + id +
                ", areaCode=" + areaCode +
                ", areaName='" + areaName + '\'' +
                ", pinYin='" + pinYin + '\'' +
                ", jianPin='" + jianPin + '\'' +
                ", level=" + level +
                ", parentId=" + parentId +
                ", status=" + status +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                '}';
    }

}
