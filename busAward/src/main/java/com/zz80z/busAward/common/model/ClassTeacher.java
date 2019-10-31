package com.zz80z.busAward.common.model;

import net.sf.json.JSONObject;

public class ClassTeacher {
    private Integer classId;

    private Integer tchId;

    public ClassTeacher() {
	}

	public ClassTeacher(Integer classId, Integer tchId) {
		super();
		this.classId = classId;
		this.tchId = tchId;
	}

	public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getTchId() {
        return tchId;
    }

    public void setTchId(Integer tchId) {
        this.tchId = tchId;
    }
    public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}