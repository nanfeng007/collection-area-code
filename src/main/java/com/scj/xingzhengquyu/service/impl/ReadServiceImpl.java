package com.scj.xingzhengquyu.service.impl;

import com.scj.xingzhengquyu.dao.HttpClientOption;
import com.scj.xingzhengquyu.dao.PingYinOtion;
import com.scj.xingzhengquyu.dao.WriteSQL;
import com.scj.xingzhengquyu.pojo.XingzhengCode;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class ReadServiceImpl {

    public static final String baseUrl = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/";
    public static final String CHARSET = "GBK";
    public static StringBuffer result = new StringBuffer();
    //设置数据库主键，每次调用+1
    public static int id = 1;
    WriteSQL riteSQL;

    public XingzhengCode ReadSheng() throws IOException, InterruptedException {

        String url = baseUrl + "index.html";
        String str = HttpClientOption.getContent(new HttpGet(url)).toUpperCase();
        String[] arrs = str.split("<A");
        //一级区域
        int region_level = 1;
        for (String s : arrs) {
            if (s.indexOf("HREF") != -1 && s.indexOf(".HTML") != -1) {
                XingzhengCode x = new XingzhengCode();
                riteSQL = new WriteSQL();
                String urls = s.substring(7, s.indexOf("'>"));
                String name = s.substring(s.indexOf("'>") + 2, s.indexOf("<BR/>"));
                String code = urls.substring(0, 2) + "0000000000";

                // String sql = "INSERT INTO `china_cantons` VALUES (1, '110000', '', '北京市(京)', 0);";
                x.setId(id);
                x.setRegionCode(code);
                x.setRegionName(name);
                x.setRegionLevel(region_level);
                x.setParentId(0);
                x.setPinYin(PingYinOtion.stringToPinyin(name));
                x.setJianPin(PingYinOtion.simplePinYin(name));
                x.setStatus(0);
                Date date = new Date();
                Timestamp timeStamep = new Timestamp(date.getTime());
                x.setCreateDate(timeStamep);
                System.out.println(x.toString());
                boolean write = riteSQL.Write(x);
                System.out.println("是否打印sql：" + write);
                id = id + 1;
                ReadShi(urls, x.getId());

            }

        }

        return null;
    }

    public XingzhengCode ReadShi(String url, int parentId) throws IOException, InterruptedException {
        String content = HttpClientOption.getContent(new HttpGet(baseUrl + url)).toUpperCase();
        //System.out.println(content);
        String[] citys = content.split("CITYTR");

        //'><TD><A HREF='11/1101.HTML'>110100000000</A></TD><TD><A HREF='11/1101.HTML'>市辖区</A></TD></td><TR CLASS='
        //二级区域
        int region_level = 2;
        for (int c = 1, len = citys.length; c < len; c++) {
            System.out.println(citys[c]);
            String[] strs = citys[c].split("<A HREF='");
            String cityUrl = null;
            String cityCode = null;
            String name = null;
            XingzhengCode x = null;
            riteSQL = new WriteSQL();
            for (int si = 1; si < 3; si++) {
                x = new XingzhengCode();
                if (si == 1) {
                    System.out.println(strs[si]);
                    //取链接和编码
                    cityUrl = strs[si].substring(0, strs[si].indexOf("'>"));
                    cityCode = strs[si].substring(strs[si].indexOf("'>") + 2, strs[si].indexOf("</A>"));

                } else {
                    name = strs[si].substring(strs[si].indexOf("'>") + 2, strs[si].indexOf("</A>"));
                }

            }
            x.setId(id);
            x.setRegionCode(cityCode);
            x.setRegionName(name);
            x.setRegionLevel(region_level);
            x.setParentId(parentId);
            x.setPinYin(PingYinOtion.stringToPinyin(name));
            x.setJianPin(PingYinOtion.simplePinYin(name));
            x.setStatus(0);
            Date date = new Date();
            Timestamp timeStamep = new Timestamp(date.getTime());
            x.setCreateDate(timeStamep);
            System.out.println(x.toString());
            boolean write = riteSQL.Write(x);
            System.out.println("是否打印sql：" + write);
            id = id + 1;
            ReadQu(cityUrl.substring(0, cityUrl.indexOf("/") + 1), cityUrl, x.getId());

        }
        return null;
    }

    public XingzhengCode ReadQu(String prix, String url, int parentId) throws IOException, InterruptedException {
        String content = HttpClientOption.getContent(new HttpGet(baseUrl + url)).toUpperCase();
        String[] citys = content.split("COUNTYTR");
        for (int i = 1; i < citys.length; i++) {
            String cityUrl = null;
            String code = null;
            String name = null;
            //发现石家庄有一个县居然没超链接，特殊处理
            if (citys[i].indexOf("<A HREF='") == -1) {

                code = citys[i].substring(6, 18);
                name = citys[i].substring(citys[i].indexOf("</TD><TD>") + 9, citys[i].lastIndexOf("</TD>"));
            } else {
                String[] strs = citys[i].split("<A HREF='");
                for (int si = 1; si < 3; si++) {
                    if (si == 1) {
                        //获取链接和编码
                        cityUrl = strs[si].substring(0, strs[si].indexOf("'>"));
                        code = strs[si].substring(strs[si].indexOf("'>") + 2, strs[si].indexOf("</A>"));
                    } else {
                        //获取区域名称
                        name = strs[si].substring(strs[si].indexOf("'>") + 2, strs[si].indexOf("</A>"));
                    }
                }
            }
            //三级区域
            int region_level = 3;

            if (null != cityUrl) {
                Thread.sleep((int) (Math.random() + 0.1) * 1000);
                //readZhen(prix, cityUrl, bw);
            }
            XingzhengCode x = new XingzhengCode();
            x.setId(id);
            x.setRegionCode(code);
            x.setRegionName(name);
            x.setRegionLevel(region_level);
            x.setParentId(parentId);
            x.setPinYin(PingYinOtion.stringToPinyin(name));
            x.setJianPin(PingYinOtion.simplePinYin(name));
            x.setStatus(0);
            Date date = new Date();
            Timestamp timeStamep = new Timestamp(date.getTime());
            x.setCreateDate(timeStamep);
            System.out.println(x.toString());
            boolean write = riteSQL.Write(x);
            System.out.println("是否打印sql：" + write);
            id = id + 1;
        }
        return null;
    }

    public XingzhengCode giveCode(XingzhengCode xcode) {
        String regionCode = xcode.getRegionCode();
        String regionName = xcode.getRegionName();

        return null;
    }

}

