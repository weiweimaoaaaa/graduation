package com.commity.backmethod.service;


import com.commity.backmethod.dao.ComUserHealthInfoDao;
import com.commity.backmethod.pojo.ComUserHealthInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public List<ComUserHealthInfo> addTodayInfoAll(List<ComUserHealthInfo> comUserHealthInfos){
        return comUserHealthInfoDao.saveAll(comUserHealthInfos);
    }
    /**
     * 获取用户的当日的健康信息
     * @param id 人员ID
     * @return  人员信息
     */
    public ComUserHealthInfo getTodayInfo(String id, Date date){
        return comUserHealthInfoDao.getComUserHealthInfoByUserIdAndDate(id,date);
    }


    /**
     * 获取咳嗽的人数
     * @param date 时间
     * @param cough 咳嗽与否
     * @return 咳嗽人数
     */
    public Integer  getCountCough(Date date,Integer cough){//获取咳嗽的人述
        return comUserHealthInfoDao.findComUserHealthInfoByDateAndCough(date,cough).size();
    }

    /**
     * 获取气促的人数
     * @param date 时间
     * @param shortBreath 气促与否
     * @return 气促人数
     */
    public Integer getCountShortBreath(Date date,Integer shortBreath){
        return comUserHealthInfoDao.findComUserHealthInfoByDateAndShortBreath(date,shortBreath).size();
    }

    /**
     * 获取就医人数量
     * @param date 时间
     * @param goDoctor 是否就医
     * @return 就医人数
     */
    public Integer getCountGoDoctor(Date date,Integer goDoctor){
        return comUserHealthInfoDao.findComUserHealthInfoByDateAndGoDoctor(date,goDoctor).size();
    }

    /**
     * 当日隔离人数
     * @param date 日期
     * @param quarantine 是否隔离
     * @return 隔离人数
     */

    public Integer getCountQuarantine(Date date,Integer quarantine){
        return comUserHealthInfoDao.findComUserHealthInfoByDateAndQuarantine(date,quarantine).size();
    }


    /**
     * 确诊人数
     * @param date 日期
     * @param diagnose 确诊
     * @return 确诊人数
     */
    public Integer getCountDiagnose(Date date,Integer diagnose){
        return comUserHealthInfoDao.findComUserHealthInfoByDateAndDiagnosis(date,diagnose).size();
    }

    /**
     * 疑似人数
     * @param date 时间
     * @param suspected 疑似与否。
     * @return 疑似人数
     */
    public Integer getCountSuspected(Date date,Integer suspected){
        return comUserHealthInfoDao.findComUserHealthInfoByDateAndSuspected(date,suspected).size();
    }
}
