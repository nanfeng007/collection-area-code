package com.scj.xingzhengquyu.dao;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientOption {
    /**
     *  根据uri获取HTML页面内容
     *
     * @param httpGet
     * @return
     * @throws IOException
     */
    public static String getContent(HttpGet httpGet) throws IOException {
        /*
            创建HttpClient
         */
        HttpClient httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager());
        System.out.println("getContent: \n\t请求：" + httpGet.getURI());
        /*
            设置http请求头
         */
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        //httpGet.addHeader("Cookie", "_trs_uv=jnwl4odd_6_95cw; AD_RS_COOKIE=20081946");
        httpGet.addHeader("Connection", "keep-alive");
        /*
            执行get请求
         */
        HttpResponse response = httpClient.execute(httpGet);
        /*
            获取cookie，设置cookie
         */
        CookieStore cookieStore = ((DefaultHttpClient) httpClient).getCookieStore();
        ((DefaultHttpClient) httpClient).setCookieStore(cookieStore);

        String result = null;
        if (response != null) {
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "GBK").toUpperCase();
            System.out.println("\t获取内容！！");
            return result;
        }

        return result;

    }
}
