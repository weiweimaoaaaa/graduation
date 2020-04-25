package com.commity.backmethod.pojo;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="prevention_knowledge")
public class Knowledge {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private String id;//主码
    private String title;//文章标题
    private String date;//文章创建时间
    private String url;//文章来源
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Knowledge{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", url='" + url + '\'' +
                '}';
    }
}
