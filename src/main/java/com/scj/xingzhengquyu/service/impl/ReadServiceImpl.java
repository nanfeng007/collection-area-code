package com.scj.xingzhengquyu.service.impl;

import com.scj.xingzhengquyu.dao.HttpClientOption;
import com.scj.xingzhengquyu.pojo.Qu;
import com.scj.xingzhengquyu.pojo.Sheng;
import com.scj.xingzhengquyu.pojo.Shi;
import com.scj.xingzhengquyu.pojo.XingzhengCode;
import com.scj.xingzhengquyu.service.ReadService;
import org.apache.http.client.methods.HttpGet;

import java.io.BufferedWriter;
import java.io.IOException;

public class ReadServiceImpl {

    public static final String baseUrl = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/";
    public static final String CHARSET = "GBK";
    public static StringBuffer result = new StringBuffer();

    public XingzhengCode ReadSheng(String url, BufferedWriter bw) throws IOException {
        System.out.println(url);
        url = baseUrl + "index.html";
        String str = HttpClientOption.getContent(new HttpGet(url)).toUpperCase();
        String[] arrs = str.split("<A");
        Sheng sheng = null;
        for (String s : arrs) {
            if (s.indexOf("HREF") != -1 && s.indexOf(".HTML") != -1) {
                XingzhengCode x = new XingzhengCode();
                String urls = s.substring(7, s.indexOf("'>"));
                String name = s.substring(s.indexOf("'>") + 2, s.indexOf("<BR/>"));

                String code = urls.substring(0, 2) + "0000000000";

                // String sql = "INSERT INTO `china_cantons` VALUES (1, '110000', '', '北京市(京)', 0);";
                x.setRegionName(name);
                x.setRegionCode(code);

                System.out.println(code + name);

            }
        }

        return sheng;
    }

    public XingzhengCode ReadShi(String url, BufferedWriter bw) throws IOException {
        String content = HttpClientOption.getContent(new HttpGet(baseUrl + url)).toUpperCase();
        String[] citys = content.split("CITYTR");
        //'><TD><A HREF='11/1101.HTML'>110100000000</A></TD><TD><A HREF='11/1101.HTML'>市辖区</A></TD></td><TR CLASS='
        for (String city : citys) {
            String[] strs = city.split("<A HREF='");
            String cityUrl = null;
            for (int si = 1; si < 3; si++) {
                if (si == 1) {
                    //取链接和编码
                    cityUrl = strs[si].substring(0, strs[si].indexOf("'>"));
                    String cityCode = strs[si].substring(strs[si].indexOf("'>") + 2, strs[si].indexOf("</A>"));

                } else {
                    String name = strs[si].substring(strs[si].indexOf("'>") + 2, strs[si].indexOf("</A>"));
                }

            }
        }
        return null;
    }

    public XingzhengCode ReadQu(String prix, String url, BufferedWriter bw) throws IOException, InterruptedException {
        String content = HttpClientOption.getContent(new HttpGet(baseUrl + url)).toUpperCase();
        String[] citys = content.split("COUNTYTR");
        for (int i = 1; i < citys.length; i++) {
            String cityUrl = null;

            //发现石家庄有一个县居然没超链接，特殊处理
            if (citys[i].indexOf("<A HREF='") == -1) {

                String code = citys[i].substring(6, 18);
                String name = citys[i].substring(citys[i].indexOf("</TD><TD>") + 9, citys[i].lastIndexOf("</TD>"));
            } else {
                String[] strs = citys[i].split("<A HREF='");
                for (int si = 1; si < 3; si++) {
                    if (si == 1) {
                        //获取链接和编码
                        cityUrl = strs[si].substring(0, strs[si].indexOf("'>"));
                        String code = strs[si].substring(strs[si].indexOf("'>") + 2, strs[si].indexOf("</A>"));
                    } else {
                        //获取区域名称
                        String name = strs[si].substring(strs[si].indexOf("'>") + 2, strs[si].indexOf("</A>"));
                    }
                }
            }
            bw.newLine();
            if (null != cityUrl) {
                Thread.sleep((int) (Math.random() + 0.1) * 1000);
                //readZhen(prix, cityUrl, bw);
            }
        }
        return null;
    }

}

