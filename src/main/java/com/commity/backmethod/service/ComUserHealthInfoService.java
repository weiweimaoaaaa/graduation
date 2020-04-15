package com.commity.backmethod.service;


import com.commity.backmethod.dao.ComUserHealthInfoDao;
import com.commity.backmethod.pojo.ComUserHealthInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ComUserHealthInfoService {
    @Autowired
    ComUserHealthInfoDao comUserHealthInfoDao;
    /**
     * 这里有待补充业务逻辑
     */
    public ComUserHealthInfo addTodayInfo(ComUserHealthInfo comUserHealthInfo){
        return comUserHealthInfoDao.save(comUserHealthInfo);
    }

    /**
     * 获取用户的当日的健康信息
     * @param id
     * @return
     */
    public ComUserHealthInfo getTodayInfo(String id, Date date){
        return comUserHealthInfoDao.getComUserHealthInfoByUserIdAndDate(id,date);
    }
}
