package com.zz80z.busAward.user.bo;

import java.io.Serializable;
/**
 * 权限分配 查询列表BO
 *
 */
public class RolePermissionAllocationBo implements Serializable {
	private static final long serialVersionUID = 1L;
	//角色ID
	private Integer roleId;
	//角色Name
	private String roleName;
	//权限Name列转行，以,分割
	private String permissionNames;
	//权限Id列转行，以‘,’分割
	private String permissionIds;
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
		this.roleName = roleName;
	}
	public String getPermissionNames() {
		return permissionNames;
	}
	public void setPermissionNames(String permissionNames) {
		this.permissionNames = permissionNames;
	}
	public String getPermissionIds() {
		return permissionIds;
	}
	public void setPermissionIds(String permissionIds) {
		this.permissionIds = permissionIds;
	}

	
}
