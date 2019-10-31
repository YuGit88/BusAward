package com.zz80z.busAward.score.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zz80z.busAward.common.controller.BaseController;
import com.zz80z.busAward.common.model.Semester;
import com.zz80z.busAward.common.model.Student;
import com.zz80z.busAward.common.model.Subject;
import com.zz80z.busAward.common.utils.StringUtils;
import com.zz80z.busAward.core.classs.service.ClasssService;
import com.zz80z.busAward.core.shiro.token.manager.TokenManager;
import com.zz80z.busAward.score.service.ScoreService;
import com.zz80z.busAward.score.service.SubjectService;
import com.zz80z.busAward.system.service.SemesterService;
import com.zz80z.busAward.user.bo.StudentScoreBo;
import com.zz80z.busAward.user.service.RoleService;

@Controller
@Scope(value = "prototype")
@RequestMapping("score")
public class EveryScoreController extends BaseController {

	@Autowired
	private ScoreService scoreService;
	@Autowired
	private ClasssService classService;
	@Autowired
	private SemesterService semesterService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private SubjectService subjectService;
	
	
	//初始化查三年成绩
	@RequestMapping("everyScoreByYear")
	public ModelAndView everyScoreYear(ModelMap modelMap, Map<String, Object> map){
		List<String> classMarks = new ArrayList<>();
		Set<String> roles = roleService.findRoleByUserId(TokenManager.getUserId());
		if (roles.contains("政教处") || roles.contains("教务处")) {
			classMarks = classService.findClassMark(null);
		} else {
			classMarks = classService.findClassMark(TokenManager.getUserName());
		}
		modelMap.put("classMarks", classMarks);
		return new ModelAndView("score/everyScoreByYear");
	}
	
	
	
	//查三年 给折线图赋值
	@RequestMapping("everyScoreInfo2")
	@ResponseBody
	public Map<String, Object> everyInfo2(@RequestParam("stuId")String stuId,
										@RequestParam("semesterId")Integer semesterId,
										@RequestParam("examInfo")String exanInfo) {
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("stuId", stuId);
		map.put("semesterId", semesterId);
		map.put("examName", exanInfo);
		
		//选择的考试信息
		StudentScoreBo s1 = scoreService.selectStuScoreRank(map);
		resultMap.put("scores", s1);

		//去年的考试信息
		if(semesterId-2>0){
		map.put("semesterId", semesterId-2);
			StudentScoreBo s2 = scoreService.selectStuScoreRank(map);
			resultMap.put("scores2", s2);
		}
		//前年的考试信息
		if(semesterId-4>0){
			map.put("semesterId", semesterId-4);
			StudentScoreBo s3 = scoreService.selectStuScoreRank(map);
			resultMap.put("scores3", s3);
		}
		
		//考试的课程
		List<String> subjectNames = subjectService.findSubjectNames();
		
		resultMap.put("subject", subjectNames);
		
		return resultMap;
	}
	
	
	
	@RequestMapping("selecStutByClass")
	@ResponseBody
	public Map<String, Object> selecStutByClass(@RequestParam("classMark")String classMark){
		
		//获取学生信息
		List<Student> stuInfos=classService.selectStuByClass(classMark);
		
		//获取学期
		List<String> findSemester = StringUtils.findSemester(classMark);
		List<Semester> semesters = new ArrayList<>();
		for (String semesterName : findSemester) {
			Semester semester = semesterService.selectBySemesterName(semesterName);
			if (null != semester) {
				semesters.add(semester);
			}
		}
		//返回学生和学期信息
		resultMap.put("semesters", semesters);
		resultMap.put("stuInfos", stuInfos);
		return resultMap;
	}
	
	
	@RequestMapping("everyScoreInfo")
	@ResponseBody
	public Map<String, Object> everyInfo(@RequestParam("stuId")String stuId,@RequestParam("semesterId")String semesterId) {
		
		Map<String, Object> map = new HashMap<>();
		List<StudentScoreBo> students = new ArrayList<>();
		
		map.put("stuId", stuId);
		map.put("semesterId", semesterId);
		map.put("examName", "月考一");
		
		StudentScoreBo s1 = scoreService.selectStuScoreRank(map);
		students.add(s1);
		
		map.put("examName", "期中考试");
		StudentScoreBo s2 = scoreService.selectStuScoreRank(map);
		students.add(s2);
		
		map.put("examName", "月考二");
		StudentScoreBo s3 = scoreService.selectStuScoreRank(map);
		students.add(s3);
		
		map.put("examName", "期末考试");
		StudentScoreBo s4 = scoreService.selectStuScoreRank(map);
		students.add(s4);
		
		resultMap.put("students", students);
		
		return resultMap;
	}
	
	
	
	@RequestMapping("everyScore")
	public ModelAndView showScore(ModelMap modelMap, Map<String, Object> map) {

		List<String> classMarks = new ArrayList<>();
		Set<String> roles = roleService.findRoleByUserId(TokenManager.getUserId());
		if (roles.contains("政教处") || roles.contains("教务处")) {
			classMarks = classService.findClassMark(null);
		} else {
			classMarks = classService.findClassMark(TokenManager.getUserName());
		}
		modelMap.put("classMarks", classMarks);
		return new ModelAndView("score/everyScore");
	}
	
	
}
