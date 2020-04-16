package com.commity.backmethod.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "comuserinfo")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class ComUserInfo {
    @Id
    @Column(name="id")
    private  String id;//身份证号
    private  String name;//性名
    private String sex;//性别
    private  String phone;//电话号码
    private String address;//家庭住址

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
