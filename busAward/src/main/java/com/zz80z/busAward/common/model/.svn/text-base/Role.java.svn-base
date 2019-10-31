package com.zz80z.busAward.common.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import net.sf.json.JSONObject;

public class Role implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer roleId;

    private String roleName;

    
    private List<Permission> permissions =new LinkedList<>();
    
    public Role() {
	}

	public Role(Integer roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
    public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}