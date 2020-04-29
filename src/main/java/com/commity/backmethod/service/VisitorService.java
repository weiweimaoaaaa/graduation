package com.commity.backmethod.service;


import com.commity.backmethod.dao.VisitorDao;
import com.commity.backmethod.pojo.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorService {
    @Autowired
    VisitorDao visitorDao;


    /**
     * 列表展示外来人员信息
     * 支持按照日期排序
     * @return 外来人员列表
     */
    public List<Visitor> listVisitorsInfo(){
        return visitorDao.findVisitorByIdIsNotNull();
    }
    /**
     * 外来人员登记
     * @param visitor 外来人员信息
     * @return 成功登记后的外来人员的信息
     */
    public Visitor register(Visitor visitor){
        return visitorDao.save(visitor);
    }

    /**
     * 删除外来人员信息
     * @param visitor 外来人员
     */
    public void delete(Visitor visitor){
         visitorDao.delete(visitor);
    }
    public Visitor update(Visitor visitor){
        return visitorDao.save(visitor);
    }
}
