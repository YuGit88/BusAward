package com.zz80z.busAward.common.model;

import net.sf.json.JSONObject;

public class IssueQuesstion {
	private Integer id;

	private String answer;

	private Integer user;

	private String quesstion;

	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public String getQuesstion() {
		return quesstion;
	}

	public void setQuesstion(String quesstion) {
		this.quesstion = quesstion;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}

}
