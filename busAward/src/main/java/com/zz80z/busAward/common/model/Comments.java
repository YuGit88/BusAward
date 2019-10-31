package com.zz80z.busAward.common.model;

import java.util.Date;

public class Comments {
    private Integer id;

    private Integer user;

    private String text;

    private Date issuedate;

    private Integer news;

    private Integer support;

    private Integer contain;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    public Integer getNews() {
        return news;
    }

    public void setNews(Integer news) {
        this.news = news;
    }

    public Integer getSupport() {
        return support;
    }

    public void setSupport(Integer support) {
        this.support = support;
    }

    public Integer getContain() {
        return contain;
    }

    public void setContain(Integer contain) {
        this.contain = contain;
    }
}