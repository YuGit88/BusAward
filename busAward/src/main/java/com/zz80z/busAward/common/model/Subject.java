package com.zz80z.busAward.common.model;

import net.sf.json.JSONObject;

public class Subject {
    private Integer subjectId;

    private String subjectName;

    private String remark;

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
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