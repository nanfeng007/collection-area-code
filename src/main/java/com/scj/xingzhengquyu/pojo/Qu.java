package com.scj.xingzhengquyu.pojo;

public class Qu extends Shi{
    public String code;
    public String url;
    public String name;

    public Qu() {
    }

    public Qu(String code, String url, String name) {
        this.code = code;
        this.url = url;
        this.name = name;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Qu{" +
                "code='" + code + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
