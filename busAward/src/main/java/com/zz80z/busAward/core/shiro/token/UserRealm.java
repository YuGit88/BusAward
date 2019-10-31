package com.zz80z.busAward.core.shiro.token;

import java.util.Date;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.zz80z.busAward.common.model.User;
import com.zz80z.busAward.core.shiro.token.manager.TokenManager;
import com.zz80z.busAward.user.service.PermissionService;
import com.zz80z.busAward.user.service.RoleService;
import com.zz80z.busAward.user.service.UserService;


public class UserRealm extends AuthorizingRealm {

	@Autowired
	UserService userService;
	@Autowired
	PermissionService permissionService;
	@Autowired
	RoleService roleService;
	
	public UserRealm() {
		super();
	}
	/**
	 *  认证信息，主要针对用户登录， 
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		//1.把AuthenticationToken强转为ShiroToken对象
		ShiroToken token = (ShiroToken) authcToken;
		//2.从ShiroToken中获取表单提交的userName,password
		//3.再根据得到的用户名,密码获取对应的一条记录
		User user = userService.login(token.getUsername(),token.getPswd());
		//4.判断该对象是否存在,若不存在抛出异常AccountException
		if(null == user){
			throw new AccountException("帐号或密码不正确！");
		/**
		 * 如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code>
		 */
		}else if(User._0.equals(user.getSatus())){
			throw new DisabledAccountException("帐号已经禁止登录！");
		}else{
			//更新登录时间 last login time
			user.setLastLoginTime(new Date());
			userService.updateByPrimaryKeySelective(user);
		}
		//最后通过根据用户的情况来构建AuthenticationInfo 对象,并返回 通常使用SimpleAuthenticationInfo对象
		//以下信息是从数据库中获取的
		//说明SimpleAuthenticationInfo(被认证的实体对象,密码,当前Realm对象的名字(调用父类的getName()方法获得))
		return new SimpleAuthenticationInfo(user,user.getUserPwd(), getName());
    }

	 /** 
     * 授权 
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {  
    	
    	Integer userId = TokenManager.getUserId();
		SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
		//根据用户ID查询角色（role），放入到Authorization里。
		Set<String> roles = roleService.findRoleByUserId(userId);
		info.setRoles(roles);
		//根据用户ID查询权限（permission），放入到Authorization里。
		Set<String> permissions = permissionService.findPermissionByUserId(userId);
		info.setStringPermissions(permissions);
        return info;  
    }  
    /**
     * 清空当前用户权限信息
     */
	public  void clearCachedAuthorizationInfo() {
		PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
	/**
	 * 指定principalCollection 清除
	 */
	public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
}
