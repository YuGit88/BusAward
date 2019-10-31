package com.zz80z.busAward.user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zz80z.busAward.common.controller.BaseController;
import com.zz80z.busAward.core.mybatis.page.Pagination;
import com.zz80z.busAward.user.bo.RoleBo;
import com.zz80z.busAward.user.bo.UserRoleAllocationBo;
import com.zz80z.busAward.user.service.PermissionService;
import com.zz80z.busAward.user.service.UserService;
@Controller
@Scope(value="prototype")
@RequestMapping("role")
public class UserRoleAllocationController extends BaseController {
	@Autowired
	UserService userService;
	@Autowired
	PermissionService permissionService;
	/**
	 * 用户角色权限分配
	 * @param modelMap
	 * @param pageNo
	 * @param findContent
	 * @return
	 */
	@RequestMapping(value="allotRole")
	public ModelAndView allocation(ModelMap modelMap,Integer pageNo,String findContent){
		modelMap.put("findContent", findContent);
		Pagination<UserRoleAllocationBo> boPage = userService.findUserAndRole(modelMap,pageNo,pageSize);
		return new ModelAndView("role/allotRole","page", boPage);
	}
	
	/**
	 * 根据用户ID查询权限
	 * @param id
	 * @return
	 */
	@RequestMapping(value="selectRoleByUserId")
	@ResponseBody
	public List<RoleBo> selectRoleByUserId(Integer userId){
		List<RoleBo> bos = userService.selectRoleByUserId(userId);
		return bos;
	}
	/**
	 * 操作用户的角色
	 * @param userId 	用户ID
	 * @param ids		角色ID，以‘,’间隔
	 * @return
	 */
	@RequestMapping(value="addRole2User")
	@ResponseBody
	public Map<String,Object> addRole2User(Integer userId,String ids){
		return userService.addRole2User(userId,ids);
	}
	/**
	 * 根据用户id清空角色。
	 * @param userIds	用户ID ，以‘,’间隔
	 * @return
	 */
	@RequestMapping(value="clearRoleByUserIds")
	@ResponseBody
	public Map<String,Object> clearRoleByUserIds(String userIds){
		return userService.deleteRoleByUserIds(userIds);
	}
}
