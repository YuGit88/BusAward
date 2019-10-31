package com.zz80z.busAward.user.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zz80z.busAward.common.controller.BaseController;
import com.zz80z.busAward.common.model.Issue;
import com.zz80z.busAward.common.model.IssueQuesstion;
import com.zz80z.busAward.common.model.Quesstion;
import com.zz80z.busAward.common.model.Student;
import com.zz80z.busAward.common.model.Teacher;
import com.zz80z.busAward.common.model.User;
import com.zz80z.busAward.core.shiro.token.manager.TokenManager;
import com.zz80z.busAward.student.service.StudentService;
import com.zz80z.busAward.system.service.IssueService;
import com.zz80z.busAward.system.service.TeacherService;
import com.zz80z.busAward.user.manager.UserManager;
import com.zz80z.busAward.user.service.UserService;

@Controller
@Scope(value = "prototype")
@RequestMapping("user")
public class UserCoreController extends BaseController {

	@Resource
	UserService userService;
	@Autowired
	StudentService studentService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	IssueService issueService;
	/**
	 * 个人资料
	 * 
	 * @return
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView userIndex(ModelMap modelMap) {
		List<Quesstion> quesstionType1 = issueService.selectByType("1");
		List<Quesstion> quesstionType2 = issueService.selectByType("2");
		modelMap.put("que1", quesstionType1);
		modelMap.put("que2", quesstionType2);
		User user = TokenManager.getToken();
		
		List<IssueQuesstion> issues = issueService.findIssueByUserId(user.getUserId());
		for (IssueQuesstion issueQuesstion : issues) {
			if ("1".equals(issueQuesstion.getType())) {
				modelMap.put("queIsu1", issueQuesstion);
			}else {
				modelMap.put("queIsu2", issueQuesstion);
			}
		}
		
		boolean result = false;
		if (issues.size()>0) {
			result = true;
		}
		modelMap.put("issues", issues);
		modelMap.put("res", result);
		if (user.getType().equals("A")) {
         	Student student = studentService.selectByStuNo(user.getUserName());
			return new ModelAndView("stu/show", "stu", student);
		} else {
			
			Teacher teacher = teacherService.selectByTchNo(user.getUserName());
			return new ModelAndView("user/index", "tch", teacher);
		}
	}

	/**
	 * 通用页面跳转
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "{page}", method = RequestMethod.GET)
	public ModelAndView toPage(@PathVariable("page") String page) {
		return new ModelAndView(String.format("user/%s", page));
	}
	
	/**
	 * 设置密保问题
	 * @param answer1
	 * @param answer2
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addIssue")
	public Map<String, Object> addIssue(@Param("answer1")String answer1,@Param("answer2")String answer2,@Param("quesstion1")String quesstion1,@Param("quesstion2")String quesstion2){
		List<Issue> issueList = new ArrayList<>();
		User user = TokenManager.getToken();
		System.err.println(quesstion1+quesstion2);
		Issue issue1 = new Issue(Integer.parseInt(quesstion1), answer1, user.getUserId());
		Issue issue2 = new Issue(Integer.parseInt(quesstion2), answer2, user.getUserId());
		issueList.add(issue1);
		issueList.add(issue2);
		
		try {
			issueService.insertIssues(issueList);
			resultMap.put("status", 200);
			resultMap.put("message", "密保问题设置成功，请牢记");
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "数据错误，刷新后重试");
		}
		
		return resultMap;
	}
	
	/**
	 * 修改密保问题
	 * @param answer1
	 * @param answer2
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateIssue")
	public Map<String,Object> updateIssue(@	Param("answer1")String answer1,@Param("answer2")String answer2){
		User user = TokenManager.getToken();
		
		List<Issue> issueList = new ArrayList<>();
		
		List<IssueQuesstion> issues = issueService.findIssueByUserId(user.getUserId());
		for (IssueQuesstion issueQuesstion : issues) {
			if ("1".equals(issueQuesstion.getType())) {
				Issue issue = new Issue();
				issue.setId(issueQuesstion.getId());
				issue.setAnswer(answer1);
				issueList.add(issue);
			}else {
				
				Issue issue = new Issue();
				issue.setId(issueQuesstion.getId());
				issue.setAnswer(answer2);
				issueList.add(issue);
			}
		}
		
		try {
			issueService.updateIssue(issueList);
			resultMap.put("status", 200);
			resultMap.put("message", "密保问题更新成功");
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "数据错误，刷新后重试");
		}
		return resultMap;
	}
	
	/**
	 * 密码修改
	 * 
	 * @return
	 */
	@RequestMapping(value = "updatePswd", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updatePswd(String pswd, String newPswd) {
		// 根据当前登录的用户帐号 + 老密码，查询。
		String email = TokenManager.getToken().getUserName();
		pswd = UserManager.md5Pswd(email, pswd);
		User user = userService.login(email, pswd);

		if (null == user) {
			resultMap.put("status", 300);
			resultMap.put("message", "密码不正确！");
		} else {
			user.setUserPwd(newPswd);
			// 加工密码
			user = UserManager.md5Pswd(user);
			// 修改密码
			userService.updateByPrimaryKeySelective(user);
			resultMap.put("status", 200);
			resultMap.put("message", "修改成功!");
			// 重新登录一次
			TokenManager.login(user, Boolean.TRUE);
		}
		return resultMap;
	}

	/**
	 * 用户重置密码
	 * 
	 * @return
	 */
	@RequestMapping(value = "resetPwd", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateTch(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String userName = request.getParameter("userName");
			String realName = request.getParameter("realName");
			String birthday = request.getParameter("birthday");
			String newPwd = request.getParameter("newPwd");
			
			User user = new User();

			user.setUserName(userName);
			user.setUserPwd(newPwd);
			user = UserManager.md5Pswd(user);
			if (userName.length() == 12) {
				Student student = studentService.selectByStuNo(userName);
				if (realName.equals(student.getrealName()) && birthday.equals(sdf.format(student.getstuBirthday()))) {
					userService.updateByPrimaryKeySelective(user);
				}

			} else {
				Teacher teacher = teacherService.selectByTchNo(userName);

				if (realName.equals(teacher.getTchName())) {
					// 修改密码
					userService.updateByPrimaryKeySelective(user);
				}
				;
			}
			resultMap.put("status", 200);
			resultMap.put("message", "重置成功!");
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "信息有误重置失败!");
		}
		return resultMap;
	}

}
