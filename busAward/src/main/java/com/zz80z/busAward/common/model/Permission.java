package com.zz80z.busAward.common.model;

import java.io.Serializable;

import net.sf.json.JSONObject;

public class Permission implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer permissionId;

    private String permissionName;

    private String url;

    private String description;

    public Permission() {
	}

	public Permission(Integer permissionId, String permissionName, String url, String description) {
		super();
		this.permissionId = permissionId;
		this.permissionName = permissionName;
		this.url = url;
		this.description = description;
	}

	public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
    public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}