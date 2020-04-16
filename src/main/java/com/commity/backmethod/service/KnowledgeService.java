package com.commity.backmethod.service;


import com.commity.backmethod.dao.KnowledgeDao;
import com.commity.backmethod.pojo.Knowledge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KnowledgeService {
    @Autowired
    KnowledgeDao knowledgeDao;

    /**
     * 保存新闻到数据库
     * @param knowledge 新闻对象呢
     * @return 返回成功保存后的新闻对象
     */
    @Transactional
    public Knowledge save(Knowledge knowledge){
        return knowledgeDao.save(knowledge);
    }

    //@Override
    public List<Knowledge> findAll(Knowledge item) {
        //声明查询条件
        org.springframework.data.domain.Example<Knowledge> example = Example.of(item);
        //依据查询条件来查询数据
       return  this.knowledgeDao.findAll(example);
    }
}
