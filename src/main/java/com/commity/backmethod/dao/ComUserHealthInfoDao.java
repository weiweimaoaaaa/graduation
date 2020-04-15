package com.commity.backmethod.dao;

import com.commity.backmethod.pojo.ComUserHealthInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.beans.IntrospectionException;
import java.util.Date;
import java.util.List;

public interface ComUserHealthInfoDao extends JpaRepository<ComUserHealthInfo,String> {
    List<ComUserHealthInfo> findComUserHealthInfosByUserIdAndCoughAndDate(String id, Integer cough, Date date);//获取当天咳嗽的人的信息
    ComUserHealthInfo getComUserHealthInfoDaoByDate(Date date);//获取当天的用户信息
    ComUserHealthInfo getComUserHealthInfoByTemperature(Double temperature);//获取温度
    ComUserHealthInfo getComUserHealthInfoByCough(Integer cough);
    ComUserHealthInfo getComUserHealthInfoByUserIdAndDate(String id,Date date);//获取当天的用户的健康信息
    List<ComUserHealthInfo> findComUserHealthInfoByDateAndCough(Date date,Integer cough);//获取当天咳嗽的人的信息
    List<ComUserHealthInfo> findComUserHealthInfoByDateAndDiagnosis(Date date,Integer diagnose);//获取当天确诊人数
    List<ComUserHealthInfo> findComUserHealthInfoByDateAndSuspected(Date date, Integer suspected);//获取当天疑似人述
    List<ComUserHealthInfo> findComUserHealthInfoByDateAndShortBreath(Date date,Integer shortBreath);//获取当天的气促的人述
    List<ComUserHealthInfo> findComUserHealthInfoByDateAndQuarantine(Date date,Integer quarantine);//获取当天的隔离的人述
    List<ComUserHealthInfo> findComUserHealthInfoByDateAndGoDoctor(Date date,Integer goDoctor);//获取当天的就医人述
}
