package com.commity.backmethod.task;

import com.commity.backmethod.Utils.HttpUtils;
import com.commity.backmethod.service.KnowledgeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class KnowledgeTask {
    @Autowired
    private HttpUtils httpUtils;
    @Autowired
    private KnowledgeService knowledgeService;
    //解析json的工具类
    private static final ObjectMapper MAPPER=new ObjectMapper();

    @Scheduled(fixedDelay = 100*1000)
    public void knowledgeTask() throws Exception{
        //设置解析的初始地址
        String url="https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&enc=utf-8&wq=%E6%89%8B%E6%9C%BA&pvid=b1a43153d64f4920a10f8ca31aa6fa6b";

        for(int i=0;i<100;i+=2){
            String html=httpUtils.DoGetHtml(url+i);
            if(html!=null){
                this.parse(html);
            }
        }

    }
    private void parse(String html)throws Exception{
        Document document= Jsoup.parse(html);
    }

}
