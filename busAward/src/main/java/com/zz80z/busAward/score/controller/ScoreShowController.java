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
import com.zz80z.busAward.common.model.Classs;
import com.zz80z.busAward.common.model.Semester;
import com.zz80z.busAward.common.utils.StringUtils;
import com.zz80z.busAward.core.classs.service.ClasssService;
import com.zz80z.busAward.core.shiro.token.manager.TokenManager;
import com.zz80z.busAward.score.service.ScoreService;
import com.zz80z.busAward.system.service.SemesterService;
import com.zz80z.busAward.user.bo.SubjectData;
import com.zz80z.busAward.user.service.RoleService;

@Controller
@Scope(value = "prototype")
@RequestMapping("score")
public class ScoreShowController extends BaseController {

	@Autowired
	private ScoreService scoreService;
	@Autowired
	private ClasssService classService;
	@Autowired
	private SemesterService semesterService;
	@Autowired
	private RoleService roleService;

	@RequestMapping("showScore")
	public ModelAndView showScore(ModelMap modelMap, Map<String, Object> map) {

		List<String> classMarks = new ArrayList<>();
		Set<String> roles = roleService.findRoleByUserId(TokenManager.getUserId());
		if (roles.contains("政教处") || roles.contains("教务处")) {
			classMarks = classService.findClassMark(null);
		} else {
			classMarks = classService.findClassMark(TokenManager.getUserName());
		}
		modelMap.put("classMarks", classMarks);
		return new ModelAndView("score/showScore");
	}

	/**
	 * 各班各学科的当学期、当年、三年的平均分、及格率、优秀率的数据 同年级、同类别班级各学科的当学期、当年、三年的平均分、及格率、优秀率
	 * 各年级、各学科的当学期、当年、三年的平均分、及格率、优秀率
	 */
	@RequestMapping("subjectInfo")
	@ResponseBody
	public Map<String, Object> subjectInfo(@RequestParam("class") String clazz,
			@RequestParam("timeByCategory") String timeByCategory, @RequestParam("timeByMark") String timeByMark,
			@RequestParam("gradeByCategory") String gradeByCategory, @RequestParam("category") String category,
			@RequestParam("gradeByClazz") String gradeByClazz, @RequestParam("timeByClazz") String timeByClazz,
			@RequestParam("condition") String condition) {

		List<Semester> findSemesters = semesterService.findSemesters();
		Map<String, Object> map = new HashMap<>();

		List<String> semesterIds = new ArrayList<>();
		List<String> classMarks = new ArrayList<>();

		if ("1".equals(condition)) {
			classMarks.add(clazz);
			map.put("classMarks", classMarks);
			if ("本学期".equals(timeByMark)) {
				semesterIds.add(findSemesters.get(0).getSemesterId().toString());
				map.put("semesterIds", semesterIds);

			} else if ("本学年".equals(timeByMark)) {
				Semester semester = findSemesters.get(0);
				String semesterYear = semester.getSemesterName().substring(0, 11);
				List<Semester> selectByYear = semesterService.selectByYear(semesterYear);
				for (Semester semester2 : selectByYear) {
					semesterIds.add(semester2.getSemesterId().toString());
				}
				map.put("semesterIds", semesterIds);
			} else {
				List<String> semesterNames = StringUtils.findSemester(clazz);
				for (String semesterName : semesterNames) {
					Semester semester = semesterService.selectBySemesterName(semesterName);
					if (null != semester) {
						semesterIds.add(semester.getSemesterId().toString());
					}
				}
				map.put("semesterIds", semesterIds);
			}
			resultMap.put("tittle", clazz + timeByMark + "各科成绩平均分,及格率，优秀率");
		} else if ("2".equals(condition)) {
			map.put("reserve", 1);
			map.put("gradeName", gradeByCategory);
			map.put("category", category);
			List<Classs> selectClassMarkByStr = classService.selectClassMarkByStr(map);
			for (Classs classs : selectClassMarkByStr) {
				classMarks.add(classs.getStuClassMark());
			}

			if ("本学期".equals(timeByCategory)) {
				semesterIds.add(findSemesters.get(0).getSemesterId().toString());
				map.put("semesterIds", semesterIds);

			} else if ("本学年".equals(timeByCategory)) {
				Semester semester = findSemesters.get(0);
				String semesterYear = semester.getSemesterName().substring(0, 11);
				List<Semester> selectByYear = semesterService.selectByYear(semesterYear);
				for (Semester semester2 : selectByYear) {
					semesterIds.add(semester2.getSemesterId().toString());
				}
				map.put("semesterIds", semesterIds);
			} else {

				List<String> semesterNames = StringUtils.findSemester(selectClassMarkByStr.get(0).getStuClassMark());
				for (String semesterName : semesterNames) {
					Semester semester = semesterService.selectBySemesterName(semesterName);
					if (null != semester) {
						semesterIds.add(semester.getSemesterId().toString());
					}
				}
				map.put("semesterIds", semesterIds);
			}

			map.put("classMarks", classMarks);
			resultMap.put("tittle", gradeByCategory + category + "各科成绩平均分,及格率，优秀率");
		} else {
			Integer gradeName = null;
			if ("七年级".equals(gradeByCategory)) {
				gradeName = 1;
			} else if ("八年级".equals(gradeByCategory)) {
				gradeName = 2;
			} else {
				gradeName = 3;
			}
			map.put("reserve", 1);
			map.put("gradeName", gradeName);
			List<Classs> findByGrade = classService.selectClassMarkByStr(map);
			for (Classs classs : findByGrade) {
				classMarks.add(classs.getStuClassMark());
			}
			map.put("classMarks", classMarks);
			if ("本学期".equals(timeByClazz)) {
				semesterIds.add(findSemesters.get(0).getSemesterId().toString());
				map.put("semesterIds", semesterIds);

			} else if ("本学年".equals(timeByClazz)) {
				Semester semester = findSemesters.get(0);
				String semesterYear = semester.getSemesterName().substring(0, 11);
				List<Semester> selectByYear = semesterService.selectByYear(semesterYear);
				for (Semester semester2 : selectByYear) {
					semesterIds.add(semester2.getSemesterId().toString());
				}
				map.put("semesterIds", semesterIds);
			} else {
				List<String> semesterNames = StringUtils.findSemester(findByGrade.get(0).getStuClassMark());
				for (String semesterName : semesterNames) {
					Semester semester = semesterService.selectBySemesterName(semesterName);
					if (null != semester) {
						semesterIds.add(semester.getSemesterId().toString());
					}
				}
				map.put("semesterIds", semesterIds);
			}

			resultMap.put("tittle", gradeByClazz + timeByClazz + "各科成绩平均分,及格率，优秀率");

		}

		List<SubjectData> subjectInfo = scoreService.findSubjectInfoByClassMark(map);
		resultMap.put("subjectInfo", subjectInfo);
		return resultMap;
	}

	@RequestMapping("firstCount")
	public ModelAndView firstCount(ModelMap modelMap, Map<String, Object> map) {

		List<String> classMarks = new ArrayList<>();
		Set<String> roles = roleService.findRoleByUserId(TokenManager.getUserId());
		if (roles.contains("政教处") || roles.contains("教务处")) {
			classMarks = classService.findClassMark(null);
		} else {
			classMarks = classService.findClassMark(TokenManager.getUserName());
		}
		modelMap.put("classMarks", classMarks);
		return new ModelAndView("score/firstCount");
	}

	/**
	 * 各班学生当学期、当年、三年的状元、进步人数 同年级、同类别班级学生当学期、当年、三年的状元、进步人数 各年级、各学科学生当学期、当年、三年的状元、进步人数
	 */
	@RequestMapping("firstCountInfo")
	@ResponseBody
	public Map<String, Object> showGrade1(@RequestParam("class") String clazz,
			@RequestParam("timeByCategory") String timeByCategory, @RequestParam("timeByMark") String timeByMark,
			@RequestParam("gradeByCategory") String gradeByCategory, @RequestParam("category") String category,
			@RequestParam("gradeByClazz") String gradeByClazz, @RequestParam("timeByClazz") String timeByClazz,
			@RequestParam("condition") String condition) {
		List<Semester> findSemesters = semesterService.findSemesters();
		Map<String, Object> map = new HashMap<>();

		List<String> semesterIds = new ArrayList<>();
		List<String> classMarks = new ArrayList<>();

		if ("1".equals(condition)) {
			classMarks.add(clazz);
			map.put("classMarks", classMarks);
			if ("本学期".equals(timeByMark)) {
				semesterIds.add(findSemesters.get(0).getSemesterId().toString());
				map.put("semesterIds", semesterIds);

			} else if ("本学年".equals(timeByMark)) {
				Semester semester = findSemesters.get(0);
				String semesterYear = semester.getSemesterName().substring(0, 11);
				List<Semester> selectByYear = semesterService.selectByYear(semesterYear);
				for (Semester semester2 : selectByYear) {
					semesterIds.add(semester2.getSemesterId().toString());
				}
				map.put("semesterIds", semesterIds);
			} else {
				List<String> semesterNames = StringUtils.findSemester(clazz);
				for (String semesterName : semesterNames) {
					Semester semester = semesterService.selectBySemesterName(semesterName);
					if (null != semester) {
						semesterIds.add(semester.getSemesterId().toString());
					}
				}
				map.put("semesterIds", semesterIds);
			}
			resultMap.put("tittle", clazz + timeByMark + "各科成绩平均分,及格率，优秀率");
		} else if ("2".equals(condition)) {
			Integer gradeName = null;
			if ("七年级".equals(gradeByCategory)) {
				gradeName = 1;
			} else if ("八年级".equals(gradeByCategory)) {
				gradeName = 2;
			} else {
				gradeName = 3;
			}
			map.put("reserve", 1);
			map.put("gradeName", gradeName);
			map.put("category", category);
			List<Classs> selectClassMarkByStr = classService.selectClassMarkByStr(map);
			for (Classs classs : selectClassMarkByStr) {
				classMarks.add(classs.getStuClassMark());
			}

			if ("本学期".equals(timeByCategory)) {
				semesterIds.add(findSemesters.get(0).getSemesterId().toString());
				map.put("semesterIds", semesterIds);

			} else if ("本学年".equals(timeByCategory)) {
				Semester semester = findSemesters.get(0);
				String semesterYear = semester.getSemesterName().substring(0, 11);
				List<Semester> selectByYear = semesterService.selectByYear(semesterYear);
				for (Semester semester2 : selectByYear) {
					semesterIds.add(semester2.getSemesterId().toString());
				}
				map.put("semesterIds", semesterIds);
			} else {

				List<String> semesterNames = StringUtils.findSemester(selectClassMarkByStr.get(0).getStuClassMark());
				for (String semesterName : semesterNames) {
					Semester semester = semesterService.selectBySemesterName(semesterName);
					if (null != semester) {
						semesterIds.add(semester.getSemesterId().toString());
					}
				}
				map.put("semesterIds", semesterIds);
			}

			map.put("classMarks", classMarks);
			resultMap.put("tittle", gradeByCategory + category + "各科成绩平均分,及格率，优秀率");
		} else {
			Integer gradeName = null;
			if ("七年级".equals(gradeByCategory)) {
				gradeName = 1;
			} else if ("八年级".equals(gradeByCategory)) {
				gradeName = 2;
			} else {
				gradeName = 3;
			}
			map.put("reserve", 1);
			map.put("gradeName", gradeName);
			List<Classs> findByGrade = classService.selectClassMarkByStr(map);
			for (Classs classs : findByGrade) {
				classMarks.add(classs.getStuClassMark());
			}
			map.put("classMarks", classMarks);
			if ("本学期".equals(timeByClazz)) {
				semesterIds.add(findSemesters.get(0).getSemesterId().toString());
				map.put("semesterIds", semesterIds);

			} else if ("本学年".equals(timeByClazz)) {
				Semester semester = findSemesters.get(0);
				String semesterYear = semester.getSemesterName().substring(0, 11);
				List<Semester> selectByYear = semesterService.selectByYear(semesterYear);
				for (Semester semester2 : selectByYear) {
					semesterIds.add(semester2.getSemesterId().toString());
				}
				map.put("semesterIds", semesterIds);
			} else {
				List<String> semesterNames = StringUtils.findSemester(findByGrade.get(0).getStuClassMark());
				for (String semesterName : semesterNames) {
					Semester semester = semesterService.selectBySemesterName(semesterName);
					if (null != semester) {
						semesterIds.add(semester.getSemesterId().toString());
					}
				}
				map.put("semesterIds", semesterIds);
			}

			resultMap.put("tittle", gradeByClazz + timeByClazz + "各科成绩平均分,及格率，优秀率");

		}

		List<SubjectData> subjectInfo = scoreService.findSubjectInfoByClassMark(map);
		resultMap.put("subjectInfo", subjectInfo);
		

		return resultMap;
	}


}
