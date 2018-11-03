package com.scj.xingzhengquyu.pojo;

public class Shi {
    public String code;
    public String url;
    public String name;

    public Shi() {
    }

    public Shi(String code, String url, String name) {
        this.code = code;
        this.url = url;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sheng{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
