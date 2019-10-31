package com.zz80z.busAward.common.dao;

import java.util.List;
import java.util.Map;

import com.zz80z.busAward.common.model.User;
import com.zz80z.busAward.user.bo.RoleBo;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User login(Map<String, Object> map);

	List<RoleBo> selectRoleByUserId(Integer id);
	
	int leadUser(List<User> users);
	
	User selectByUserName(String userName);
	
}