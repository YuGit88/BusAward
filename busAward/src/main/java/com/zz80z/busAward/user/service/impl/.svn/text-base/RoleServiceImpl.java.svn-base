package com.zz80z.busAward.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz80z.busAward.common.dao.RoleMapper;
import com.zz80z.busAward.common.dao.RolePermissionMapper;
import com.zz80z.busAward.common.dao.UserMapper;
import com.zz80z.busAward.common.model.Role;
import com.zz80z.busAward.common.utils.LoggerUtils;
import com.zz80z.busAward.core.mybatis.BaseMybatisDao;
import com.zz80z.busAward.core.mybatis.page.Pagination;
import com.zz80z.busAward.core.shiro.token.manager.TokenManager;
import com.zz80z.busAward.user.bo.RolePermissionAllocationBo;
import com.zz80z.busAward.user.service.RoleService;

@Service
@SuppressWarnings("unchecked")
public class RoleServiceImpl extends BaseMybatisDao<RoleMapper> implements RoleService {

	@Autowired
	RoleMapper roleMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	RolePermissionMapper rolePermissionMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Role record) {
		return roleMapper.insert(record);
	}

	@Override
	public int insertSelective(Role record) {
		return roleMapper.insertSelective(record);
	}

	@Override
	public Role selectByPrimaryKey(Integer id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		return roleMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		return roleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Pagination<Role> findPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}

	@Override
	public Pagination<RolePermissionAllocationBo> findRoleAndPermissionPage(Map<String, Object> resultMap,
			Integer pageNo, Integer pageSize) {
		return super.findPage("findRoleAndPermission", "findCount", resultMap, pageNo, pageSize);
	}

	@Override
	public Map<String, Object> deleteRoleById(String ids) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			int count = 0;
			String resultMsg = "删除成功。";
			String[] idArray = new String[] {};
			if (StringUtils.contains(ids, ",")) {
				idArray = ids.split(",");
			} else {
				idArray = new String[] { ids };
			}

			c: for (String idx : idArray) {
				Integer id = new Integer(idx);
				if (new Integer(1).equals(id)) {
					resultMsg = "操作成功，But'系统管理员不能删除。";
					continue c;
				} else {
					count += this.deleteByPrimaryKey(id);
				}
			}
			resultMap.put("status", 200);
			resultMap.put("count", count);
			resultMap.put("resultMsg", resultMsg);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "根据IDS删除用户出现错误，ids[%s]", ids);
			resultMap.put("status", 500);
			resultMap.put("message", "删除出现错误，请刷新后再试！");
		}
		return resultMap;
	}

	@Override
	public Set<String> findRoleByUserId(Integer userId) {
		return roleMapper.findRoleByUserId(userId);
	}

	@Override
	public List<Role> findNowAllPermission() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", TokenManager.getUserId());
		return roleMapper.findNowAllPermission(map);
	}


}
