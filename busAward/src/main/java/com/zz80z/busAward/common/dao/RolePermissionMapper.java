package com.zz80z.busAward.common.dao;

import java.util.List;
import java.util.Map;

import com.zz80z.busAward.common.model.RolePermission;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);
    
    List<RolePermission> findRolePermissionByPid(Integer id);
	
	List<RolePermission> findRolePermissionByRid(Integer id);
	
	List<RolePermission> find(RolePermission entity);
	
	int deleteByPid(Integer id);
	
	int deleteByRid(Integer id);
	
	int delete(RolePermission entity);

	int deleteByRids(Map<String,Object> resultMap);
}