package com.zz80z.busAward.score.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zz80z.busAward.common.controller.BaseController;
import com.zz80z.busAward.common.model.Semester;
import com.zz80z.busAward.core.classs.service.ClasssService;
import com.zz80z.busAward.score.service.ScoreService;
import com.zz80z.busAward.system.service.SemesterService;
import com.zz80z.busAward.user.service.RoleService;

@Controller
@Scope(value = "prototype")
@RequestMapping("score")
public class ProgressCountController extends BaseController {

	@Autowired
	private ScoreService scoreService;
	@Autowired
	private ClasssService classService;
	@Autowired
	private SemesterService semesterService;
	@Autowired
	private RoleService roleService;

	@RequestMapping
	@ResponseBody
	public Map<String, Object> progressCount(@RequestParam("class") String clazz,
			@RequestParam("timeByCategory") String timeByCategory, @RequestParam("timeByMark") String timeByMark,
			@RequestParam("gradeByCategory") String gradeByCategory, @RequestParam("category") String category,
			@RequestParam("gradeByClazz") String gradeByClazz, @RequestParam("timeByClazz") String timeByClazz,
			@RequestParam("condition") String condition) {

		List<Semester> findSemesters = semesterService.findSemesters();
		Map<String, Object> map = new HashMap<>();

		List<String> semesterIds = new ArrayList<>();
		List<String> classMarks = new ArrayList<>();
		
		if ("1".equals(condition)) {
			
		}else if ("2".equals(condition)) {
			
		}else {
			
		}
		
		
		
		scoreService.selectProgressCount(map);
		
		
		
		
		
		
		
		
		return resultMap;
	}

}
