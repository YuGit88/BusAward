package com.zz80z.busAward.user.bo;

import net.sf.json.JSONObject;

public class ScoreBo {

	private Integer subId;
	
	private String subName;
	
	private Integer score;
	
	private Integer stuId;
	
	private String realName;

	private String stuNo;

	public Integer getSubId() {
		return subId;
	}


	public void setSubId(Integer subId) {
		this.subId = subId;
	}


	public String getSubName() {
		return subName;
	}


	public void setSubName(String subName) {
		this.subName = subName;
	}


	public Integer getScore() {
		return score;
	}


	public void setScore(Integer score) {
		this.score = score;
	}


	public Integer getStuId() {
		return stuId;
	}


	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}


	public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}


	public String getStuNo() {
		return stuNo;
	}


	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}


	public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
    
}
