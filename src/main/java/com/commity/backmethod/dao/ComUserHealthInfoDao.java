package com.commity.backmethod.dao;

import com.commity.backmethod.pojo.ComUserHealthInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

public interface ComUserHealthInfoDao extends JpaRepository<ComUserHealthInfo,String> {
    <List>ComUserHealthInfo getComUserHealthInfosByUserIdAndCoughAndDate(String id,Integer cough,Date date);//获取当天咳嗽的人的信息
    ComUserHealthInfo getComUserHealthInfoDaoByDate(Date date);//获取当天的用户信息
    ComUserHealthInfo getComUserHealthInfoByTemperature(Double temperature);//获取温度
    ComUserHealthInfo getComUserHealthInfoByCough(Integer cough);

}
