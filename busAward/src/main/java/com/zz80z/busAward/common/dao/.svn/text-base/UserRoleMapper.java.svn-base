package com.zz80z.busAward.common.dao;

import java.util.List;
import java.util.Map;

import com.zz80z.busAward.common.model.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
    
    int deleteByUserId(Integer id);

	int deleteRoleByUserIds(Map<String, Object> resultMap);

	List<Integer> findUserIdByRoleId(Integer id);
}