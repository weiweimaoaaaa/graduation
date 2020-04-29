package com.commity.backmethod.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="visitor")
public class Visitor {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//id
    private String name;//姓名
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;//到访日期
    @JsonFormat(pattern = "HH:mm:ss")
    private Time time;//到访时间
    private String idCard;//身份证号
    private String phone;//联系电话
    private double temperature;//温度
    private String diagnose;//是否确诊或接触疑似人员
    private String item;//到访事项
    private String accessObject;//到访对象
    private String address;//到访详细地点

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getAccessObject() {
        return accessObject;
    }

    public void setAccessObject(String accessObject) {
        this.accessObject = accessObject;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", temperature=" + temperature +
                ", diagnose='" + diagnose + '\'' +
                ", item='" + item + '\'' +
                ", accessObject='" + accessObject + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
