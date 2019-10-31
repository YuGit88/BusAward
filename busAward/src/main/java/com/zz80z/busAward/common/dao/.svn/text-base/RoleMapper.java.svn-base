package com.zz80z.busAward.common.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zz80z.busAward.common.model.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    Set<String> findRoleByUserId(Integer id);

	List<Role> findNowAllPermission(Map<String, Object> map);
	
	void initData();
}