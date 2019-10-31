package com.zz80z.busAward.user.bo;

import java.io.Serializable;

import com.zz80z.busAward.common.model.Subject;
import com.zz80z.busAward.common.utils.StringUtils;

public class SubjectBo extends Subject implements Serializable{
	private static final long serialVersionUID = 1L;

	private String gradeId;
	private String marker;
	
	public boolean isCheck(){
		return StringUtils.equals(gradeId,marker);
	}
	public String getGradeId() {
		return gradeId;
	}
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	public String getMarker() {
		return marker;
	}
	public void setMarker(String marker) {
		this.marker = marker;
	}
	
	
}
