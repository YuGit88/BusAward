package com.zz80z.busAward.user.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authc.DisabledAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zz80z.busAward.common.controller.BaseController;
import com.zz80z.busAward.common.model.Issue;
import com.zz80z.busAward.common.model.IssueQuesstion;
import com.zz80z.busAward.common.model.Student;
import com.zz80z.busAward.common.model.Teacher;
import com.zz80z.busAward.common.model.User;
import com.zz80z.busAward.common.utils.LoggerUtils;
import com.zz80z.busAward.common.utils.StringUtils;
import com.zz80z.busAward.core.shiro.token.manager.TokenManager;
import com.zz80z.busAward.student.service.StudentService;
import com.zz80z.busAward.system.service.IssueService;
import com.zz80z.busAward.system.service.TeacherService;
import com.zz80z.busAward.user.manager.UserManager;
import com.zz80z.busAward.user.service.UserService;

@Controller
@Scope(value = "prototype")
@RequestMapping("u")
public class UserLoginController extends BaseController {

	@Resource
	UserService userService;
	@Autowired
	IssueService issueService;
	@Autowired
	StudentService studentService;
	@Autowired
	TeacherService teacherService;
	
	/**
	 * 重置密码
	 */
	@RequestMapping("rePwd")
	@ResponseBody
	public Map<String, Object> rePwd(@Param("userName")String userName,@Param("newPwd")String newPwd){
		
		User selectByUserName = userService.selectByUserName(userName);
		String md5Pswd = UserManager.md5Pswd(userName, newPwd);
		selectByUserName.setUserPwd(md5Pswd);
		try {
			userService.updateByPrimaryKeySelective(selectByUserName);
			resultMap.put("status", 200);
			resultMap.put("message", "重置成功,自动跳转至登陆页面");
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "密码更改失败");
		}
		
		return resultMap;
	}
	
	/**
	 * 验证密保问题
	 */
	@RequestMapping("validateIssue")
	@ResponseBody
	public Map<String, Object> validateIssue(@Param("issueVa")String issueVa,@Param("amswer")String amswer){
		Issue issue = issueService.selectByPrimaryKey(Integer.parseInt(issueVa));
		if (amswer.equals(issue.getAnswer())) {
			resultMap.put("status", 200);
			resultMap.put("message", "验证成功");
		}else {
			resultMap.put("status", 500);
			resultMap.put("message", "密保验证失败");
		}
		
		return resultMap;
	}
	
	/**
	 * 重置密码验证用户
	 */
	@ResponseBody
	@RequestMapping("validateUserName")
	public Map<String, Object> validateUserName(@Param("userName")String userName,@Param("realName")String realName){
		
		if (userName.length() == 12) {
			Student student = studentService.selectByStuNo(userName);
			if (student.getrealName().equals(realName)) {
				resultMap.put("status", 200);
				resultMap.put("message", "验证成功");
			}else {
				resultMap.put("status", 500);
				resultMap.put("message", "工号/学号 与姓名不匹配");
			}
		}else {
			Teacher teacher = teacherService.selectByTchNo(userName);
			if (teacher.getTchName().equals(realName)) {
				resultMap.put("status", 200);
				resultMap.put("message", "验证成功");
			}else {
				resultMap.put("status", 500);
				resultMap.put("message", "工号/学号 与姓名不匹配");
			}
			
		}
		User user = userService.selectByUserName(userName);
		List<IssueQuesstion> issues = issueService.findIssueByUserId(user.getUserId());
		if (null != issues) {
			resultMap.put("issues", issues);
		}else {
			resultMap.put("issueMsg", "由于您未设置密保问题，暂不能通过此方法找回密保，请尝试其它方法");
		}
		
		return resultMap;
	}
	
	
	/**
	 * 重置密码跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "resetPwd", method = RequestMethod.GET)
	public ModelAndView resetPwd() {

		return new ModelAndView("user/resetPwd");
	}

	/**
	 * 登录跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login() {

		return new ModelAndView("user/login");
	}

	/**
	 * 修改/设置密保问题之前的密码验证
	 */
	@RequestMapping("validate")
	@ResponseBody
	public Map<String, Object> Validate(@Param("password")String password,HttpServletResponse response ){
		response.setContentType("application/json;charset=utf-8");
		User user = TokenManager.getToken();
		String pswd = UserManager.md5Pswd(user.getUserName(), password);
		if (pswd.equals(user.getUserPwd())) {
			List<IssueQuesstion> issues = issueService.findIssueByUserId(user.getUserId());
			if (issues.size()>0) {
				resultMap.put("is", 100);
			} else {
				resultMap.put("is", 300);
			}
			
			resultMap.put("status", 200);
			resultMap.put("message", "验证成功");
		}else {
			resultMap.put("status", 500);
			resultMap.put("message", "密码错误");
		}
		return resultMap;
	}
	
	
	/**
	 * 登录提交
	 * 
	 * @param 登录的User
	 * 
	 * @param rememberMe
	 *            是否记住
	 * @param requestrequest，用来取登录之前Url地址，用来登录后跳转到没有登录之前的页面。
	 * @return
	 */
	@RequestMapping(value="submitLogin",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> submitLogin(User entity,Boolean rememberMe,HttpServletRequest request){
		
		try {
			entity = TokenManager.login(entity,rememberMe);
			resultMap.put("status", 200);
			resultMap.put("message", "登录成功");
			String url = null ;
			//如果登录之前没有地址，那么就跳转到首页。
			if(StringUtils.isBlank(url)){
				url = request.getContextPath() + "/news/index.shtml";
			}
			//跳转地址
			resultMap.put("back_url", url);
		} catch (DisabledAccountException e) {
			resultMap.put("status", 500);
			resultMap.put("message", "帐号已经禁用。");
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "帐号或密码错误");
		}
			
		return resultMap;
	}

	/**
	 * 退出
	 * 
	 * @return
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> logout() {
		try {
			TokenManager.logout();
			resultMap.put("status", 200);
		} catch (Exception e) {
			resultMap.put("status", 500);
			logger.error("errorMessage:" + e.getMessage());
			LoggerUtils.fmtError(getClass(), e, "退出出现错误，%s。", e.getMessage());
		}
		return resultMap;
	}

}
