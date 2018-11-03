import com.scj.xingzhengquyu.ReadCodeFromHTML;
import org.junit.Test;

public class ReadCode {
    @Test
    public void readCode(){
        try {
            String content = ReadCodeFromHTML.getContent("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/61.html");
            System.out.println(content);
            String url = "61.html";
            //BufferedWriter bufferedWriter = new BufferedWriter();
            ReadCodeFromHTML.readShi(url,null);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
