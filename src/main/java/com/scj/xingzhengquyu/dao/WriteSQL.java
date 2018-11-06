package com.scj.xingzhengquyu.dao;

import com.scj.xingzhengquyu.pojo.XingzhengCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteSQL {
    /**
     * @param XCode
     * @throws IOException
     */
    public boolean Write(XingzhengCode XCode) {

        try {
//            FileWriter fileWriter = new FileWriter(new File("c:/code.sql"));
//            BufferedWriter bw = new BufferedWriter(fileWriter);

            String sql = "INSERT INTO \"public\".\"t_region\"(\"id\", \"region_code\", \"region_name\", \"region_level\", \"parent_id\", \"pinyin\", \"jianpin\", \"status\", \"create_at\") VALUES" +
                    "('" + XCode.getId() + "', '" + XCode.getRegionCode() + "', '" + XCode.getRegionName() + "','" + XCode.getRegionLevel() + "','" +
                    XCode.getParentId() + "','" + XCode.getPinYin() + "','" + XCode.getJianPin() + "','" + XCode.getStatus() + "','" +
                    XCode.getCreateDate() + "'); \n";

            Files.write(Paths.get("e:/area_code.sql"), sql.getBytes(), StandardOpenOption.APPEND);

//            bw.write(
//                    "INSERT INTO " +
//                            "`t_region_copy1`(region_code,region_name,region_level，parent_id，pinyin，jianpin，status，position，create_at，modify_at)" +
//                            " VALUES " +
//                            "('" + XCode.getRegionCode() + "', '" + XCode.getRegionName() + "','" + XCode.getRegionLevel() + "','" +
//                            XCode.getParentId() + "','" + XCode.getPinYin() + "','" + XCode.getJianPin() + "','" + XCode.getStatus() + "','" +
//                            XCode.getPosition() + "','" + XCode.getCreateDate() + "','" + XCode.getModifyDate() + "');");
//            bw.newLine();
//            bw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}
