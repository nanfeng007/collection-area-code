package com.scj.xingzhengquyu.service;

import com.scj.xingzhengquyu.pojo.Qu;
import com.scj.xingzhengquyu.pojo.Sheng;
import com.scj.xingzhengquyu.pojo.Shi;

import java.io.BufferedWriter;
import java.io.IOException;

public interface ReadService {
    //读取省
    public Sheng ReadSheng(String url, BufferedWriter bw) throws IOException;

    //读取市
    public Shi ReadShi(String url, BufferedWriter bw) throws IOException;

    //读取区、县
    public Qu ReadQu(String prix, String url, BufferedWriter bw) throws IOException, InterruptedException;

}
