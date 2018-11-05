import com.scj.xingzhengquyu.service.impl.ReadServiceImpl;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Tests {

    @Test
    public void tesgs() throws IOException, InterruptedException {
        ReadServiceImpl readServiceImpl = new ReadServiceImpl();
        readServiceImpl.ReadSheng("index.html", new BufferedWriter(new FileWriter("adfa")));

        //    readServiceImpl.ReadShi("11.HTML", new BufferedWriter(new FileWriter("a")), 1);
////
        /*String ss = PingYinOtion.stringToPinyin("西藏自治区");
         System.out.println(ss);*/

    }
    @Test
    public void test1(){
        String s = "县";
        System.out.println(s.length());
    }

}
