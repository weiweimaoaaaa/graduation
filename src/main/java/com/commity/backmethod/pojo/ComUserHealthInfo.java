package com.commity.backmethod.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Entity
@Table(name="comUserHealthInfo")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class ComUserHealthInfo {
    @Id
    @Column(name="id")
    private String id;//健康登记表单ID
    private Date  date;//登记时间
    private String userId;//用户id
    private Double temperature;//体温温度
    private Integer cough;//是否咳嗽
    private Integer shortBreath;//是否气促
    private Integer goDoctor;//是否就医
    private Integer quarantine;//是否隔离
    private String  hospital;//就医医院
    private Integer diagnosis;//是否确证
    private Integer suspected;//是否疑似

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getCough() {
        return cough;
    }

    public void setCough(Integer cough) {
        this.cough = cough;
    }

    public Integer getShortBreath() {
        return shortBreath;
    }

    public void setShortBreath(Integer shortBreath) {
        this.shortBreath = shortBreath;
    }

    public Integer getGoDoctor() {
        return goDoctor;
    }

    public void setGoDoctor(Integer goDoctor) {
        this.goDoctor = goDoctor;
    }

    public Integer getQuarantine() {
        return quarantine;
    }

    public void setQuarantine(Integer quarantine) {
        this.quarantine = quarantine;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Integer getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Integer diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Integer getSuspected() {
        return suspected;
    }
    public void setSuspected(Integer suspected) {
        this.suspected = suspected;
    }
}
