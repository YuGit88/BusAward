package com.zz80z.busAward.common.model;

import java.util.Date;

import net.sf.json.JSONObject;

public class News {
    private Integer newsId;

    private String newsTittle;

    private String newsContent;

    private String newsAuthor;

    private Date newsCreate;

    private Date newsAlter;

    private String category;

    private String reserve;

    
    public News() {
		super();
	}

	public News(Integer newsId, String newsTittle, String newsContent, String newsAuthor, Date newsCreate,
			Date newsAlter, String category, String reserve) {
		super();
		this.newsId = newsId;
		this.newsTittle = newsTittle;
		this.newsContent = newsContent;
		this.newsAuthor = newsAuthor;
		this.newsCreate = newsCreate;
		this.newsAlter = newsAlter;
		this.category = category;
		this.reserve = reserve;
	}

	public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsTittle() {
        return newsTittle;
    }

    public void setNewsTittle(String newsTittle) {
        this.newsTittle = newsTittle == null ? null : newsTittle.trim();
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }

    public String getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor == null ? null : newsAuthor.trim();
    }

    public Date getNewsCreate() {
        return newsCreate;
    }

    public void setNewsCreate(Date newsCreate) {
        this.newsCreate = newsCreate;
    }

    public Date getNewsAlter() {
        return newsAlter;
    }

    public void setNewsAlter(Date newsAlter) {
        this.newsAlter = newsAlter;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve == null ? null : reserve.trim();
    }
    public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}