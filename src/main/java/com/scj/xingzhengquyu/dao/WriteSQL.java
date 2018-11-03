package com.scj.xingzhengquyu.dao;

import com.scj.xingzhengquyu.pojo.XingzhengCode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSQL {
    /**
     * @param maps
     * @throws IOException
     */
    public static boolean Write(Map<String, Object> maps) {
        XingzhengCode XCode;

        try {
            FileWriter fileWriter = new FileWriter(new File("c:/code.sql"));
            BufferedWriter bw = new BufferedWriter(fileWriter);
            XCode = new XingzhengCode();
            bw.write(
                    "INSERT INTO " +
                            "`china_cantons`(region_code,region_name,region_level，parent_id，pinyin，jianpin，status，position，create_at，modify_at)" +
                            " VALUES " +
                            "('" + XCode.getRegionCode() + "', '" + XCode.getRegionName() + "','" + XCode.getRegionLevel() + "','" +
                            XCode.getParentId() + "','" + XCode.getPinYin() + "','" + XCode.getJianPin() + "','" + XCode.getStatus() + "','" +
                            XCode.getPosition() + "','" + XCode.getCreateDate() + "','" + XCode.getModifyDate() + "');");
            bw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}
