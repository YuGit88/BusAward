package com.zz80z.busAward.common.dao;

import java.util.List;
import java.util.Set;

import com.zz80z.busAward.common.model.Permission;
import com.zz80z.busAward.user.bo.PermissionBo;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    List<PermissionBo> selectPermissionById(Integer id);
	//根据用户ID获取权限的Set集合
	Set<String> findPermissionByUserId(Integer id);
}