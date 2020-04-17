package com.commity.backmethod.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Job {
    private String url="http://www.moe.gov.cn/jyb_xwfb/xw_zt/moe_357/jyzt_2020n/2020_zt03/fkzs/fkzs_lb/";
    @Autowired
    KnowledgeTestService knowledgeTestService;
    @Scheduled(fixedRate = 100000) // 5秒抓取1次
    //@Scheduled(cron = "0 0 2 * * ? ") // 每天凌晨2点抓取1次
    public void getInfo(){
        knowledgeTestService.getPage(url);
    }
}
