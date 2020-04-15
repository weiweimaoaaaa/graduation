package com.commity.backmethod.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "comuserinfo")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class ComUserInfo {
    @Id
    @Column(name="id")
    String id;//身份证号
    String name;//性名
    Integer sex;//性别
    String phone;//电话号码
    String address;//家庭住址

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
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
