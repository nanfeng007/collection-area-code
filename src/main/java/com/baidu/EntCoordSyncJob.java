package com.baidu;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.text.DecimalFormat;
import java.util.Map;

/**
 * @ClassName: EntCoordSyncJob
 * @Description: TODO(这里用一句话描述这个类的作用)
 */
public class EntCoordSyncJob {
    static String AK = "5Qm4cryDTnyq2aeYOG3SYhertAAyuer5"; // 百度地图密钥

    public static void main(String[] args) {
        String dom = "陕西省西安市未央区市图书馆地铁站";
        String coordinate = getCoordinate(dom);
        System.out.println("'" + dom + "'的经纬度为：" + coordinate);
        // System.err.println("######同步坐标已达到日配额6000限制，请明天再试！#####");
    }

    /**
     * 根据地理位置获取地理坐标
     * '陕西省西安市未央区市图书馆地铁站'的经纬度为：108.95359,34.32548
     * @param address
     * @return
     */
    // 调用百度地图API根据地址，获取坐标
    public static String getCoordinate(String address) {
        if (address != null && !"".equals(address)) {
            address = address.replaceAll("\\s*", "").replace("#", "栋");
            String url = "http://api.map.baidu.com/geocoder/v2/?address=" + address + "&output=json&ak=" + AK;
            String json = loadJSON(url);
            if (json != null && !"".equals(json)) {
                JSONObject obj = JSONObject.fromObject(json);
                if ("0".equals(obj.getString("status"))) {
                    double lng = obj.getJSONObject("result").getJSONObject("location").getDouble("lng"); // 经度
                    double lat = obj.getJSONObject("result").getJSONObject("location").getDouble("lat"); // 纬度
                    DecimalFormat df = new DecimalFormat("#.######");
                    return df.format(lng) + "," + df.format(lat);
                }
            }
        }
        return null;
    }

    public static String loadJSON(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return json.toString();
    }

    // 来自stackoverflow的MD5计算方法，调用了MessageDigest库函数，并把byte数组结果转换成16进制

    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    /**
     * 根据地理位置和AK获取地理坐标
     * {"status":0,"result":{"location":{"lng":108.95358803536026,"lat":34.3254817452863},"precise":0,"confidence":70,"comprehension":100,"level":"教育"}}
     * @param address
     * @param ak
     * @return
     */
    public static String convertAddress(String address, String ak) {
        URL url = null;
        HttpURLConnection urlConnection = null;
        BufferedReader rd = null;
        Double lng = null;
        Double lat = null;
        Map<String, Object> map = null;
        Map<String, Object> result = null;
        Map<String, Object> location = null;
        StringBuffer sb = null;
        address = address.trim();
        address = address.replaceAll("\\\\", "");
        String regEx = "[`~!@#$%^&*()\\-+={}':;,\\[\\].<>/?￥%…（）_+|【】‘；：”“’。，、？\\s]";
        address = address.replaceAll(regEx, "").trim();
        if (address.length() >= 25) {
            address = address.substring(0, 25);
        }
        String urlString = new StringBuilder().append("http://api.map.baidu.com/geocoder/v2/?").append("address=").append(address).append("&output=json").append("&ak=").append(ak).toString();
        try {
            URLEncoder.encode(urlString, "UTF-8");
            url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            rd = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            sb = new StringBuffer();
            String data = null;
            while ((data = rd.readLine()) != null) {
                sb.append(data);
            }
            System.out.println(sb);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
            try {
                rd.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

}