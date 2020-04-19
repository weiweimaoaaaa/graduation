package ModuleTest;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlTest {
    public static String  test(String url) throws Exception{
        Connection con= Jsoup.connect(url);
        Document doc = con.get();
       // Elements title=doc.select("ul[class=\"m_siju_common_page\"]").select("li");//.select("a[href]");
        Elements type=doc.select("ul[class=\"zxxx_list\"]").select("li").select("a[href");
        String str=type.toString();
       // String string=title.toString();
        //return string+"    "+str;
        return str;
    }
    public static  void main(String []ags) throws Exception{
        System.out.println(test("http://www.nhc.gov.cn/xcs/kpzs/list_gzbd.shtml"));

    }

}
