package com.scj.xingzhengquyu.service;

import com.scj.xingzhengquyu.pojo.XingzhengCode;

import java.io.BufferedWriter;
import java.io.IOException;

public interface ReadService {
    //读取省
    public XingzhengCode ReadSheng(String url, BufferedWriter bw) throws IOException;

    //读取市
    public XingzhengCode ReadShi(String url, BufferedWriter bw) throws IOException;

    //读取区、县
    public XingzhengCode ReadQu(String prix, String url, BufferedWriter bw) throws IOException, InterruptedException;

    public XingzhengCode giveCode(XingzhengCode xcode);
}
