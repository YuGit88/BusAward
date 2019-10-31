package com.zz80z.busAward.common.model;

import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONObject;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//0:禁止登录
	public static final Integer _0 = new Integer(0);
	//1:有效
	public static final Integer _1 = new Integer(1);
    private Integer userId;

    private String type;

    private String userName;

    private String userPwd;

    private Date lastLoginTime;

    private Integer satus;

    public User() {
	}
    public User(User user) {
    	this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.userPwd = user.getUserPwd();
		this.satus = user.getSatus();
		this.lastLoginTime = user.getLastLoginTime();
	}
	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getSatus() {
        return satus;
    }

    public void setSatus(Integer satus) {
        this.satus = satus;
    }
    public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}