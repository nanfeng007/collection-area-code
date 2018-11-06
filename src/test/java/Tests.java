import com.baidu.EntCoordSyncJob;
import com.scj.xingzhengquyu.dao.PingYinOtion;
import com.scj.xingzhengquyu.service.impl.ReadServiceImpl;
import org.junit.Test;

import java.io.IOException;

public class Tests {

    @Test
    public void executeCode() throws IOException, InterruptedException {
        ReadServiceImpl readServiceImpl = new ReadServiceImpl();
        readServiceImpl.ReadSheng();

        //    readServiceImpl.ReadShi("11.HTML", new BufferedWriter(new FileWriter("a")), 1);
////
        /*String ss = PingYinOtion.stringToPinyin("西藏自治区");
         System.out.println(ss);*/

    }
    @Test
    public void testMap(){
        String job = EntCoordSyncJob.convertAddress("西安市市图书馆", "5Qm4cryDTnyq2aeYOG3SYhertAAyuer5");
        System.out.println(job);
    }
    @Test
    public void  testPinyin(){
        String s = PingYinOtion.stringToPinyin("北京市");
        System.out.println(s);

    }

}
