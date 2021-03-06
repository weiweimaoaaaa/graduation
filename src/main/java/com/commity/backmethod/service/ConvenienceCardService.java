package com.commity.backmethod.service;


import com.commity.backmethod.dao.ConvenienceCardDao;
import com.commity.backmethod.pojo.ConvenienceCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ConvenienceCardService {
    @Autowired
    ConvenienceCardDao convenienceCardDao;

    //实现的操作。

    /**
     * 功能：便民卡申请提交
     * @param convenienceCard  便民卡实体
     * @return 返回申请后的便民卡信息
     */
    @Transactional
    public ConvenienceCard apply(ConvenienceCard convenienceCard)
    {
        return convenienceCardDao.save(convenienceCard);
    }
    public List<ConvenienceCard> apply(List<ConvenienceCard> convenienceCards){
        return convenienceCardDao.saveAll(convenienceCards);
    }
    public ConvenienceCard getCard(String id){
        return convenienceCardDao.getConvenienceCardByUser(id);
    }
    public ConvenienceCard getCard(String id, Date date){
        return convenienceCardDao.getConvenienceCardByUserAndApplyDate(id,date);
    }

}
