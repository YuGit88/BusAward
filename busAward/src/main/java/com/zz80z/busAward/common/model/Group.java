package com.zz80z.busAward.common.model;

import net.sf.json.JSONObject;

public class Group {

	private String groupName;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	 public String toString(){
	    	return JSONObject.fromObject(this).toString();
	    }
}
