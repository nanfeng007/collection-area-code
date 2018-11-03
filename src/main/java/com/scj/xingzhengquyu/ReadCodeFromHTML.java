package com.scj.xingzhengquyu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

public class ReadCodeFromHTML {
    public static final String baseUrl = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/";
    public static final String CHARSET = "GBK";
    public static StringBuffer result = new StringBuffer();

    /**
     * 获取省
     * @param url “2017/”后的链接
     * @param bw
     * @throws Exception
     */
    public static void readSheng(String url, BufferedWriter bw) throws Exception {
        String content = getContent(baseUrl + url).toUpperCase();
        String[] arrs = content.split("<A");
        for (String s : arrs){
            if (s.indexOf("HREF")!=-1 && s.indexOf(".HTML")!=-1){
                String arrsUrl = s.substring(7, s.indexOf("'>"));
                String arrsName = s.substring(s.indexOf("'>") + 2, s.indexOf("<BR/>"));
                System.out.println("爬取："+arrsUrl + "\t" + arrsName);
            }
        }
    }

    /**
     * 获取市
     *
     * @param url “2017/”后的链接
     * @param bw
     * @throws Exception
     */
    public static void readShi(String url, BufferedWriter bw) throws Exception {
        String content = getContent(baseUrl + url).toUpperCase();
        String[] citys = content.split("CITYTR");
        //'><TD><A HREF='11/1101.HTML'>110100000000</A></TD><TD><A HREF='11/1101.HTML'>市辖区</A></TD></td><TR CLASS='
        for (int c = 1, len = citys.length; c < len; c++) {
            String[] strs = citys[c].split("<A HREF='");
            String cityUrl = null;
            for (int si = 1; si < 3; si++) {
                if (si == 1) {
                    //取链接
                    cityUrl = strs[si].substring(0, strs[si].indexOf("'>"));
                    //取编码
                    String cityCode = strs[si].substring(strs[si].indexOf("'>") + 2, strs[si].indexOf("</A>"));

//                    bw.write("<tr><td>");
//                    bw.write(cityCode);
//                    bw.write("</td>");
                    System.out.print("爬取：" + cityUrl + "\t" + cityCode + "\t");
                } else {
                    String cityName = strs[si].substring(strs[si].indexOf("'>") + 2, strs[si].indexOf("</A>"));
//                    bw.write("<td></td><td>");
//                    bw.write(strs[si].substring(strs[si].indexOf("'>")+2, strs[si].indexOf("</A>")));
//                    bw.write("</td><td></td><td></td><td></td><td></td></tr>");
                    System.out.print(cityName);
                }
            }
//            bw.newLine();
            // readXian(cityUrl.substring(0, cityUrl.indexOf("/")+1),cityUrl,bw);
        }
    }

    /**
     * 读县的数据
     *
     * @param url “2017/”后的链接
     * @throws Exception
     */
    public static void readXian(String prix, String url, BufferedWriter bw) throws Exception {
        String content = getContent(baseUrl + url).toUpperCase();
        String[] citys = content.split("COUNTYTR");
        for (int i = 1; i < citys.length; i++) {
            String cityUrl = null;

            //发现石家庄有一个县居然没超链接，特殊处理
            if (citys[i].indexOf("<A HREF='") == -1) {
                bw.write("<tr><td>");
                bw.write(citys[i].substring(6, 18));
                bw.write("</td>");

                bw.write("<td></td><td></td><td>");
                bw.write(citys[i].substring(citys[i].indexOf("</TD><TD>") + 9, citys[i].lastIndexOf("</TD>")));
                bw.write("</td><td></td><td></td><td></td></tr>");
            } else {
                String[] strs = citys[i].split("<A HREF='");
                for (int si = 1; si < 3; si++) {
                    if (si == 1) {//取链接和编码
                        cityUrl = strs[si].substring(0, strs[si].indexOf("'>"));
                        String cityCode = strs[si].substring(strs[si].indexOf("'>") + 2, strs[si].indexOf("</A>"));

                        bw.write("<tr><td>");
                        bw.write(cityCode);
                        bw.write("</td>");
                    } else {
                        bw.write("<td></td><td></td><td>");
                        bw.write(strs[si].substring(strs[si].indexOf("'>") + 2, strs[si].indexOf("</A>")));
                        bw.write("</td><td></td><td></td><td></td></tr>");
                    }
                }
            }
            bw.newLine();
            if (null != cityUrl) {
//                readZhen(prix,cityUrl,bw);
            }
        }
    }

    /**
     * 获取网页的内容
     *
     * @param strUrl
     * @return
     * @throws Exception
     */
    public static String getContent(String strUrl) throws Exception {
        StringBuffer stringBuffer = new StringBuffer("");
        try {
            URL url = new URL(strUrl);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName(CHARSET)));
            String s = "";

            while ((s = bufferedReader.readLine()) != null) {
                stringBuffer.append(s);
            }
            bufferedReader.close();
            return stringBuffer.toString();
        } catch (Exception e) {
            System.out.println("获取页面内容失败");
        }
        return stringBuffer.toString();
    }

    /**
     * 设置代理
     *
     * @param host
     * @param port
     */
    public static void initProxy(String host, String port) {
        System.setProperty("http.proxyType", "4");
        System.setProperty("http.proxyPort", "port");
        System.setProperty("http.proxyHost", "host");
        System.setProperty("http.proxySet", "true");
    }

}
