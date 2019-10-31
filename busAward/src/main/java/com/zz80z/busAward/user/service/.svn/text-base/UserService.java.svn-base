package com.zz80z.busAward.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;

import com.zz80z.busAward.common.model.User;
import com.zz80z.busAward.core.mybatis.page.Pagination;
import com.zz80z.busAward.user.bo.RoleBo;
import com.zz80z.busAward.user.bo.UserRoleAllocationBo;

public interface UserService {

	int deleteByPrimaryKey(Integer id);

	User insert(User record);

    User insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User login(String userName ,String pswd);

	Pagination<User> findByPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize);

	Map<String, Object> deleteUserById(String ids);

	Map<String, Object> updateForbidUserById(Integer id, Integer status);

	Pagination<UserRoleAllocationBo> findUserAndRole(ModelMap modelMap,
			Integer pageNo, Integer pageSize);

	List<RoleBo> selectRoleByUserId(Integer id);

	Map<String, Object> addRole2User(Integer userId, String ids);

	Map<String, Object> deleteRoleByUserIds(String userIds);
	
	int leadUser(List<User> users);
	
	User selectByUserName(String userName);
}
