package com.zz80z.busAward.common.model;

import net.sf.json.JSONObject;

public class Issue {
    private Integer id;

    private Integer quesstion;

    private String answer;

    private Integer user;

    private String remark;

    public Issue(Integer id, Integer quesstion, String answer, Integer user, String remark) {
		super();
		this.id = id;
		this.quesstion = quesstion;
		this.answer = answer;
		this.user = user;
		this.remark = remark;
	}

	public Issue() {
	}

	public Issue(Integer quesstion, String answer, Integer user) {
		super();
		this.quesstion = quesstion;
		this.answer = answer;
		this.user = user;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuesstion() {
        return quesstion;
    }

    public void setQuesstion(Integer quesstion) {
        this.quesstion = quesstion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}