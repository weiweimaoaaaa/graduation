package com.commity.backmethod.task;

import com.commity.backmethod.pojo.Knowledge;
import com.commity.backmethod.service.KnowledgeService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
class KnowledgeTestService {
    @Autowired
    KnowledgeService knowledgeService;
    private List<Object> getUrl(String url)throws Exception{
        Connection con=Jsoup.connect(url);
        Document doc = con.get();
        Elements title=doc.select("div[class=\"scy_lbsj-right-nr\"]").select("li").select("a[href]");
        Elements dateTime=doc.select("div[class=\"scy_lbsj-right-nr\"]").select("li").select("span");
        List<Object> dataSource = new ArrayList<>();//存储数据源的数组
        for(int i=0;i<title.size();i++){
            List<String> urls=new ArrayList<>();
            String ul;//链接
            String source=title.get(i).attr("href");
            String theme=title.get(i).attr("title");//标题
            String date=dateTime.get(i).text();//时间
            if(source.contains("http")) ul = source;
            else
            {
                String str=url.substring(0,url.length()-10);
                ul=str+source;
            }
            Knowledge knowledge=new Knowledge();
            knowledge.setId(ul);
            knowledge.setUrl(ul);
            knowledge.setTitle(theme);
            knowledge.setDate(date);
            knowledgeService.save(knowledge);
            urls.add(ul);
            urls.add(theme);
            urls.add(date);
            dataSource.add(urls);
        }
        return dataSource;
    }
    public void getPage(String url){
        // String url = "http://www.moe.gov.cn/jyb_xwfb/xw_zt/moe_357/jyzt_2020n/2020_zt03/fkzs/fkzs_lb/";
        for(int i=0;i<6;i++){
            String ul="index";
            if(0==i)ul+=".html";
            else ul+="_"+i+".html";
            List<Object> urls= new ArrayList<>();
            try {
                urls = getUrl(url+ul);
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (Object o : urls) System.out.println(o);
        }
    }
}
