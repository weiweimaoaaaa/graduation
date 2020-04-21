package com.commity.backmethod.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;

@Entity
@Table(name="comuserhealthinfo")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class ComUserHealthInfo {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//健康登记表单ID
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date  date;//登记时间
    private String userId;//用户id
    private Double temperature;//体温温度
    private String  cough;//是否咳嗽
    private String shortBreath;//是否气促
    private String goDoctor;//是否就医
    private String quarantine;//是否隔离
    private String  hospital;//就医医院
    private String diagnosis;//是否确证
    private String suspected;//是否疑似

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoDoctor() {
        return goDoctor;
    }

    public void setGoDoctor(String goDoctor) {
        this.goDoctor = goDoctor;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getCough() {
        return cough;
    }

    public void setCough(String cough) {
        this.cough = cough;
    }

    public String getShortBreath() {
        return shortBreath;
    }

    public void setShortBreath(String shortBreath) {
        this.shortBreath = shortBreath;
    }

    public String getQuarantine() {
        return quarantine;
    }

    public void setQuarantine(String quarantine) {
        this.quarantine = quarantine;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getSuspected() {
        return suspected;
    }
    public void setSuspected(String suspected) {
        this.suspected = suspected;
    }
}
