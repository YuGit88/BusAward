package com.zz80z.busAward.user.manager;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.zz80z.busAward.common.model.Permission;
import com.zz80z.busAward.common.model.Role;
import com.zz80z.busAward.common.model.User;
import com.zz80z.busAward.common.utils.MathUtil;

public class UserManager {
	
	/**
	 * 加工密码，和登录一致。
	 * @param user
	 * @return
	 */
	public static User md5Pswd(User user){
		//密码为   email + '#' + pswd，然后MD5
		user.setUserPwd(md5Pswd(user.getUserName(),user.getUserPwd()));
		return user;
	}
	/**
	 * 字符串返回值
	 * @param email
	 * @param pswd
	 * @return
	 */
	public static String md5Pswd(String email ,String pswd){
		pswd = String.format("%s#%s", email,pswd);
		pswd = MathUtil.getMD5(pswd);
		return pswd;
	}
	/**
	 * 把查询出来的roles 转换成bootstarp 的 tree数据
	 * @param roles
	 * @return
	 */
	public static List<Map<String,Object>> toTreeData(List<Role> roles){
		List<Map<String,Object>> resultData = new LinkedList<Map<String,Object>>();
		for (Role u : roles) {
			//角色列表
			Map<String,Object> map = new LinkedHashMap<String, Object>();
			map.put("text", u.getRoleName());//名称
			map.put("href", "javascript:void(0)");//链接
			List<Permission> ps = u.getPermissions();
			map.put("tags",  new Integer[]{ps.size()});//显示子数据条数
			if(null != ps && ps.size() > 0){
				List<Map<String,Object>> list = new LinkedList<Map<String,Object>>();
				//权限列表
				for (Permission up : ps) {
					Map<String,Object> mapx = new LinkedHashMap<String, Object>();
					mapx.put("text", up.getPermissionName());//权限名称
					mapx.put("href", up.getUrl());//权限url
					//mapx.put("tags", "0");//没有下一级
					list.add(mapx);
				}
				map.put("nodes", list);
			}
			resultData.add(map);
		}
		return resultData;
		
	}
	
	
}
