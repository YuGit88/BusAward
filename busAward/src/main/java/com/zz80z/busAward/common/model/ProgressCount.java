package com.zz80z.busAward.common.model;

import net.sf.json.JSONObject;

public class ProgressCount {

	private Integer count;
	
	private String realNames;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getRealNames() {
		return realNames;
	}

	public void setRealNames(String realNames) {
		this.realNames = realNames;
	}
	
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
	
}
