package com.zz80z.busAward.common.model;

import java.io.Serializable;

import net.sf.json.JSONObject;

public class RolePermission implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer permissionId;

    private Integer roleId;

    public RolePermission() {
	}

	public RolePermission(Integer roleId, Integer permissionId) {
		super();
		this.permissionId = permissionId;
		this.roleId = roleId;
	}

	public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
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