import com.scj.xingzhengquyu.dao.PingYinOtion;
import com.scj.xingzhengquyu.service.impl.ReadServiceImpl;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Tests {
    @Test
    public void test() throws IOException {
        ReadServiceImpl readService = new ReadServiceImpl();
        readService.ReadSheng("index.html",new BufferedWriter(new  FileWriter("aa")));
    }

    @Test
    public void tesgs() {

//        String[] s = PinYin4jUtils.stringToPinyin("北京");
//        System.out.println(s[0]+s[1]);
//        String[] ss = PinYin4jUtils.getHeadByString("北京");
//        System.out.println(ss[0]+ss[1]);

        PingYinOtion.stringToPinyin("区牛市区");
        String ss = PingYinOtion.simplePinYin("蓝湖区");
        System.out.println(ss);

      /*  String ss = "牛市牛区";

        String substring = ss.substring(0,ss.length()-1);
        System.out.println(substring);*/

    }
}
