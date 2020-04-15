package com.commity.backmethod.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;




@Entity
@Table(name = "userlogin")
//@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class UserLogin {
    @Id
    @Column(name = "idcard")
    private String idCard;
    private   String username;
    private String password;

    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "idCard='" + idCard + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
