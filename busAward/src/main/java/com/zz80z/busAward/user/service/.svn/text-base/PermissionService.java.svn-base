package com.zz80z.busAward.user.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zz80z.busAward.common.model.Permission;
import com.zz80z.busAward.core.mybatis.page.Pagination;
import com.zz80z.busAward.user.bo.PermissionBo;

public interface PermissionService {

	int deleteByPrimaryKey(Integer id);

	Permission insert(Permission record);

    Permission insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

	Map<String, Object> deletePermissionById(String ids);

	Pagination<Permission> findPage(Map<String,Object> resultMap, Integer pageNo,
			Integer pageSize);
	List<PermissionBo> selectPermissionById(Integer id);

	Map<String, Object> addPermission2Role(Integer roleId,String ids);

	Map<String, Object> deleteByRids(String roleIds);
	//根据用户ID查询权限（permission），放入到Authorization里。
	Set<String> findPermissionByUserId(Integer userId);
}
