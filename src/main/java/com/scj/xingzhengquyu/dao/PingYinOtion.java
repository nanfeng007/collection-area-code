package com.scj.xingzhengquyu.dao;

public class PingYinOtion {

    /**
     * 将区域名转为拼音，并且去除后缀
     *
     * @param string
     * @return
     */
    public static String stringToPinyin(String string) {
        String deleteLastChar = deleteLastChar(string);
        String[] strings = PinYin4jUtils.stringToPinyin(deleteLastChar);
        String pinYin = "";
        for (String s : strings) {
            //首字母大写
            pinYin = pinYin + " " + s.substring(0, 1).toUpperCase() + s.substring(1);
        }
        System.out.println(pinYin);
        return pinYin;
    }

    /**
     * 区域名获取首字母，并且去除后缀
     *
     * @param String
     * @return
     */
    public static String simplePinYin(String String) {
        String deleteLastChar = PingYinOtion.deleteLastChar(String);
        String[] headByString = PinYin4jUtils.getHeadByString(deleteLastChar);

        return PinYin4jUtils.stringArrayToString(headByString);
    }

    /**
     * 去除后缀名，如：省、市、区、镇、自治区
     * 目前仅可以删除最后一位
     *
     * @param s
     * @return
     */
    public static String deleteLastChar(String s) {
        if ( s.endsWith("自治区")){
            String ss=  s.replace("自治区", "");
            return ss;

        }
        if ( s.endsWith("自治州")){
            String ss=  s.replace("自治州", "");
            return ss;

        }


        if ( s.endsWith("管委会")){
            String ss=  s.replace("管委会", "");
            return ss;

        }
        if (s.length()==1){
            return s;
        }

        String substring = s.substring(0, s.length() - 1);
        return substring;
    }

}
