package com.commity.backmethod.dao;

import com.commity.backmethod.pojo.ComUserHealthInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.beans.IntrospectionException;
import java.sql.Date;
import java.util.List;

public interface ComUserHealthInfoDao extends JpaRepository<ComUserHealthInfo, Long> {
    //List<ComUserHealthInfo> findComUserHealthInfosByUserIdAndCoughAndDate(String id, String cough, Date date);//获取当天咳嗽的人的信息
    ComUserHealthInfo getComUserHealthInfoByDate(Date date);//获取当天的用户信息
    ComUserHealthInfo getComUserHealthInfoByTemperature(Double temperature);//获取温度
    ComUserHealthInfo getComUserHealthInfoByCough(String cough);
    List<ComUserHealthInfo> findComUserHealthInfoByDateAndGoDoctorAndDiagnosis(Date date,String diagnosis,String goDoctor);
    ComUserHealthInfo getComUserHealthInfoByUserId(String id);
    ComUserHealthInfo getComUserHealthInfoByUserIdAndDate(String id,Date date);//获取当天的用户的健康信息
    List<ComUserHealthInfo> findComUserHealthInfoByDateAndCough(Date date,String cough);//获取当天咳嗽的人的信息
    List<ComUserHealthInfo> findComUserHealthInfoByDateAndDiagnosis(Date date,String diagnose);//获取当天确诊人数
    List<ComUserHealthInfo> findComUserHealthInfoByDateAndSuspected(Date date, String suspected);//获取当天疑似人述
    List<ComUserHealthInfo> findComUserHealthInfoByDateAndShortBreath(Date date,String shortBreath);//获取当天的气促的人述
    List<ComUserHealthInfo> findComUserHealthInfoByDateAndQuarantine(Date date,String quarantine);//获取当天的隔离的人述
    List<ComUserHealthInfo> findComUserHealthInfoByDateAndGoDoctor(Date date,String goDoctor);//获取当天的就医人述
    List<ComUserHealthInfo> findComUserHealthInfoByDate(Date date);//获取当天的填报的人员的健康信息表
}
