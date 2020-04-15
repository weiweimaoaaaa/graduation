package com.commity.backmethod.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 便民卡实体
 */
@Entity
@Table(name="conveniencecard")//对应表名
public class ConvenienceCard {
    @Id
    @Column(name="id")//主码
    private String id;
    private String user;//用户ID
    @Column(name="applydate")
    private Date  applyDate;//申请时间
    @Column(name="userdate")
    private Date  userDate;//使用时间
    /**
     * 便民卡的周期应该是三个阶段：
     * 1. 申请阶段
     * 2. 使用阶段
     * 3. 使用结束阶段
     * ---------------------
     * | 申请 | 使用 |结束 |
     * -------------------
     * |   1 |  2   |  3 |
     * -------------------
     */
    private Integer finished;//便民卡完成度，所处状态。


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

    public Date getUserDate() {
        return userDate;
    }

    public void setUserDate(Date userDate) {
        this.userDate = userDate;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }
}
