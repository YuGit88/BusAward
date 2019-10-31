package com.zz80z.busAward.common.model;

import java.io.Serializable;

import net.sf.json.JSONObject;

public class UserRole implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer userId;

    private Integer roleId;

    public UserRole() {
	}

	public UserRole(Integer userId, Integer roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}