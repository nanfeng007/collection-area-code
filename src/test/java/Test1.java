import com.scj.xingzhengquyu.eg.ReadCodeFromWeb;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class Test1 {
    @Test
    public void test1() {
        String s = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/61/6101.html\">610100000000</a></td><td><a ";
        String url = s.substring(0, s.indexOf("\">"));
        String cityCode = s.substring((s.indexOf("\">") + 2), s.indexOf("</a>"));

        String name = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/61/6101.html\">????</A></td></tr>";
        String cityName = name.substring(name.indexOf("\">") + 2, name.indexOf("</A>"));

        System.out.println("padao:" + url + "\t" + cityCode + "\t" + cityName);
        System.out.println(s.indexOf("aaasdf"));
    }

    @Test
    public void HTTPClient() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.tuicool.com");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        CloseableHttpResponse response = httpClient.execute(httpGet);

        if (response != null) {
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "UTF-8");
            System.out.println("网页内容：" + result);
        }
        if (response == null) {
            response.close();
        }
        if (httpClient != null) {
            httpClient.close();
        }

    }

    /**
     * http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/61/01/02/610102001.html
     */

    @Test
    public void testt() throws IOException {
        String content = ReadCodeFromWeb.getContent(new HttpGet("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/61/01/02/610102001.html"));
        System.out.println(content);

        String content1 = ReadCodeFromWeb.getContent(new HttpGet("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/62/06/21/620621101.html"));
        System.out.println(content1);

        String content2 = ReadCodeFromWeb.getContent(new HttpGet("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/62/06/620621.html"));
        System.out.println(content2);
    }

    @Test
    public void testts() throws IOException {
        DefaultHttpClient httpclient=new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://www.tuicool.com");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        HttpPost httpPost = new HttpPost("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/62/05/620503.html");

        HttpResponse response=httpclient.execute(httpPost);
        CookieStore cookiestore=httpclient.getCookieStore();
        List<Cookie> cookies = cookiestore.getCookies();
        System.out.println(cookies);

    }




}
