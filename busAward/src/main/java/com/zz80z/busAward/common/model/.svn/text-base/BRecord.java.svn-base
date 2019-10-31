package com.zz80z.busAward.common.model;

import java.util.Date;

import net.sf.json.JSONObject;

public class BRecord {

	private Integer id;


    private Integer stuId;


    private Integer points;


    private String coinType;


    private int week;
    
    private String description;
    
    public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public BRecord(Integer id, Integer stuId, Integer points, String coinType, int week, Date createTime) {
		super();
		this.id = id;
		this.stuId = stuId;
		this.points = points;
		this.coinType = coinType;
		this.week = week;
		this.createTime = createTime;
	}

    public BRecord(Integer stuId, Integer points, String coinType, String description, Date createTime) {
		super();
		this.stuId = stuId;
		this.points = points;
		this.coinType = coinType;
		this.description = description;
		this.createTime = createTime;
	}


	public BRecord(Integer stuId, Integer points, String coinType,Date createTime) {
		this.stuId = stuId;
		this.points = points;
		this.coinType = coinType;
		this.createTime = createTime;
	}

	public BRecord() {
	}

	public int getWeek() {
		return week;
	}


	public void setWeek(int week) {
		this.week = week;
	}


	private Date createTime;

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

 
    public Integer getStuId() {
        return stuId;
    }

  
    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

   
    public Integer getPoints() {
        return points;
    }

 
    public void setPoints(Integer points) {
        this.points = points;
    }

 
    public String getCoinType() {
        return coinType;
    }

   
    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

   
    public Date getCreateTime() {
        return createTime;
    }

   
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}