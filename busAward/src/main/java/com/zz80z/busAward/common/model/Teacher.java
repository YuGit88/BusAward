package com.zz80z.busAward.common.model;

import java.util.List;
import net.sf.json.JSONObject;

public class Teacher {

	private Integer tchId;

	private String tchName;

	private String tchNo;

	private String tchPhone;

	private Integer tchSubject;

	private String reserve;

	private List<Classs> clazz;
	
	private Subject subject;

	public Teacher() {
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Teacher(String tchName, String tchNo, String tchPhone, Integer tchSubject ) {
		super();
		this.tchName = tchName;
		this.tchNo = tchNo;
		this.tchPhone = tchPhone;
		this.tchSubject = tchSubject;
	}

	public Teacher(Teacher teacher) {
		this.tchId = teacher.getTchId();
		this.tchName = teacher.getTchName();
		this.tchNo = teacher.getTchNo();
		this.tchPhone = teacher.getTchPhone();
		this.tchSubject = teacher.getTchSubject();
		this.reserve = teacher.getReserve();
		this.clazz = teacher.getClazz();
	}

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
		this.tchName = tchName == null ? null : tchName.trim();
	}

	public String getTchNo() {
		return tchNo;
	}

	public void setTchNo(String tchNo) {
		this.tchNo = tchNo == null ? null : tchNo.trim();
	}

	public String getTchPhone() {
		return tchPhone;
	}

	public void setTchPhone(String tchPhone) {
		this.tchPhone = tchPhone == null ? null : tchPhone.trim();
	}

	public Integer getTchSubject() {
		return tchSubject;
	}

	public void setTchSubject(Integer tchSubject) {
		this.tchSubject = tchSubject;
	}

	public String getReserve() {
		return reserve;
	}

	public void setReserve(String reserve) {
		this.reserve = reserve == null ? null : reserve.trim();
	}

	public List<Classs> getClazz() {
		return clazz;
	}

	public void setClazz(List<Classs> clazz) {
		this.clazz = clazz;
	}

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}