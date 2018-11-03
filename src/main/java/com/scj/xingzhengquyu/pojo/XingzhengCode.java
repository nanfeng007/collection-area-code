package com.scj.xingzhengquyu.pojo;

import java.util.Date;

public class XingzhengCode {
    //主键
    public int id;
    //区域编码（例如：110000
    public String regionCode;
    //区域名称（例如：北京市）
    public String regionName;
    //区域级别（省、直辖市-1、地级市-2、县区-3、街道、乡、镇-4）
    public int regionLevel;
    //上级区域ID
    public int parentId;
    //拼音 （例如：beijing）
    public String pinYin;
    //简拼（例如：bj）
    public String jianPin;
    //自定义状态（未定义-0、启用-1、停用-2）
    public int status;
    //坐标
    public Position position;
    //创建时间
    public Date createDate;
    //修改时间
    public Date modifyDate;

    public XingzhengCode() {
    }

    public XingzhengCode(int id, String regionCode, String regionName, int regionLevel, int parentId, String pinYin, String jianPin, int status, Position position, Date createDate, Date modifyDate) {
        this.id = id;
        this.regionCode = regionCode;
        this.regionName = regionName;
        this.regionLevel = regionLevel;
        this.parentId = parentId;
        this.pinYin = pinYin;
        this.jianPin = jianPin;
        this.status = status;
        this.position = position;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(int regionLevel) {
        this.regionLevel = regionLevel;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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

    @Override
    public String toString() {
        return "XingzhengCode{" +
                "id=" + id +
                ", regionCode='" + regionCode + '\'' +
                ", regionName='" + regionName + '\'' +
                ", regionLevel=" + regionLevel +
                ", parentId=" + parentId +
                ", pinYin='" + pinYin + '\'' +
                ", jianPin='" + jianPin + '\'' +
                ", status=" + status +
                ", position=" + position +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }
}
