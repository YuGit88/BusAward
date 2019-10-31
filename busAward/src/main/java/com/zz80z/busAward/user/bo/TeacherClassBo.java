package com.zz80z.busAward.user.bo;

import java.io.Serializable;

public class TeacherClassBo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer tchId;
	private String tchName;
	private String tchNo;
	private String tchPhone;
	private String tchSubject;
	private String classNames;
	private String classIds;
	
	public Integer getTchId() {
		return tchId;
	}
	public void setTchId(Integer tchId) {
		this.tchId = tchId;
	}
	public String getTchName() {
		return tchName;
	}
	public void setTchName(String tchName) {
		this.tchName = tchName;
	}
	public String getClassNames() {
		return classNames;
	}
	public void setClassNames(String classNames) {
		this.classNames = classNames;
	}
	public String getClassIds() {
		return classIds;
	}
	public void setClassIds(String classIds) {
		this.classIds = classIds;
	}
	public String getTchNo() {
		return tchNo;
	}
	public void setTchNo(String tchNo) {
		this.tchNo = tchNo;
	}
	public String getTchPhone() {
		return tchPhone;
	}
	public void setTchPhone(String tchPhone) {
		this.tchPhone = tchPhone;
	}
	public String getTchSubject() {
		return tchSubject;
	}
	public void setTchSubject(String tchSubject) {
		this.tchSubject = tchSubject;
	}
	
}
