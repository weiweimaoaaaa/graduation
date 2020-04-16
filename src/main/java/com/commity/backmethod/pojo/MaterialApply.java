package com.commity.backmethod.pojo;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="materialapply")
public class MaterialApply {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主码的产生方式
    private String id;//物资申请id
    private String user;//申请人ID
    @Column(name="applyDate")
    private Date applyDate;//申请时间
    private String category;//物资分类
    private String name;//物资名字
    private String number;//物资数量
    private Integer finished;//完成度

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }
}
