package com.zz80z.busAward.score.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.zz80z.busAward.common.coin.service.CoinService;
import com.zz80z.busAward.common.controller.BaseController;
import com.zz80z.busAward.common.model.Award;
import com.zz80z.busAward.common.model.BRecord;
import com.zz80z.busAward.common.model.Classs;
import com.zz80z.busAward.common.model.Rank;
import com.zz80z.busAward.common.model.Score;
import com.zz80z.busAward.common.model.Semester;
import com.zz80z.busAward.common.model.Student;
import com.zz80z.busAward.common.model.Subject;
import com.zz80z.busAward.common.model.User;
import com.zz80z.busAward.common.utils.ExcelUtils;
import com.zz80z.busAward.common.utils.LoggerUtils;
import com.zz80z.busAward.common.utils.StringUtils;
import com.zz80z.busAward.core.classs.service.ClasssService;
import com.zz80z.busAward.core.mybatis.page.Pagination;
import com.zz80z.busAward.core.shiro.token.manager.TokenManager;
import com.zz80z.busAward.score.service.RankService;
import com.zz80z.busAward.score.service.ScoreService;
import com.zz80z.busAward.score.service.SubjectService;
import com.zz80z.busAward.student.service.StudentService;
import com.zz80z.busAward.system.service.AwardService;
import com.zz80z.busAward.system.service.GradeService;
import com.zz80z.busAward.system.service.SemesterService;
import com.zz80z.busAward.user.bo.ScoreBo;
import com.zz80z.busAward.user.bo.ScoreProgressBo;
import com.zz80z.busAward.user.bo.StudentScoreBo;
import com.zz80z.busAward.user.service.RoleService;

@Controller
@Scope(value = "prototype")
@RequestMapping("score")
public class ScoreController extends BaseController {

	@Autowired
	private ScoreService scoreService;
	@Autowired
	private SemesterService semesterService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private ClasssService classService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private GradeService gradeService;
	@Autowired
	private AwardService awardService;
	@Autowired
	private CoinService coinService;
	
	@Autowired
	private RankService rankService;
	/**
	 * 创建成绩导入模板
	 * 
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "creatScoreExcel", method = RequestMethod.GET)
	public void creatScoreExcel(HttpServletResponse response, HttpServletRequest request) {
		String fileName = "学生成绩表模板.xls";
		String header = "xxxx-xxxx x学期 xx考试学生成绩表";
		List<String> columns = new ArrayList<>();
		columns.add(0, "学号");
		columns.add(1, "姓名");
		columns.add(2, "语文");
		columns.add(3, "数学");
		columns.add(4, "英语");
		columns.add(5, "政治");
		columns.add(6, "历史");
		columns.add(7, "地理");
		columns.add(8, "物理");
		columns.add(9, "化学");
		columns.add(10, "生物");
		try {
			ExcelUtils.creatExcel(response, request, fileName, header, columns);
		} catch (IOException e) {
			LoggerUtils.error(ScoreController.class, "创建成绩导入模板失败" + e);
		}
	}

	/**
	 * 成绩列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "index")
	public ModelAndView scoreList(ModelMap modelMap, Integer pageNo, String findContent, String findSemester,
			String findExam, String findClass, HttpServletRequest request) {
		
		findSemester = request.getParameter("findSemester");
		findExam = request.getParameter("findExam");
		findClass = request.getParameter("findClass");

		Pagination<StudentScoreBo> page = null;
		List<String> classses = new ArrayList<>();
		String semesterId = null;
		String examName = null;
		String classMark = null;
		String userName = null;
		

		List<Semester> findSemesters = semesterService.findSemesters();
		modelMap.put("currentSemester", findSemesters.get(0));
		User token = TokenManager.getToken();

		Set<String> roles = roleService.findRoleByUserId(token.getUserId());
		if (roles.contains("政教处")) {
			classses = classService.findClassMark(userName);
		} else {
			userName = token.getUserName();
			classses = classService.findClassMark(userName);
		}

		modelMap.put("classses", classses);
		resultMap.put("findContent", findContent);

		if (null == findSemester) {
			semesterId = findSemesters.get(0).getSemesterId().toString();
		} else {
			semesterId = findSemester;
		}
		Semester selectByPrimaryKey = semesterService.selectByPrimaryKey(Integer.parseInt(semesterId));

		if (null == findExam) {
			examName = "期中考试";
		} else {
			examName = findExam;
		}

		if (null == findClass) {
			classMark = classses.get(0);
		} else {
			classMark = findClass;
		}

		modelMap.put("classMark", classMark);
		modelMap.put("findSemester", selectByPrimaryKey);
		modelMap.put("findExam", examName);

		resultMap.put("semesterId", semesterId);
		resultMap.put("examName", examName);
		resultMap.put("classMark", classMark);

		page = scoreService.findStudentAndScorePage(resultMap, pageNo, 100);
		return new ModelAndView("score/index", "page", page);
	}

	/**
	 * 导入成绩
	 */
	@RequestMapping(value = "leadScore")
	@ResponseBody
	public Map<String, Object> importScore(@RequestParam("file") MultipartFile file, HttpServletRequest re,
			Map<String, Object> map ,ModelMap modelMap) {
		
		Award award = awardService.selectByPrimaryKey(1);
		List<Rank> ranks = new ArrayList<>();
		List<Map<String, String>> list = new ArrayList<>();
		String exam = re.getParameter("examName");
		Integer gradeId = Integer.parseInt(re.getParameter("gradeId"));
		
		String gradeName = null;
		String examName = null;
		List<Score> scores = new ArrayList<>();
		Score score = null;
		Student student = null;
		
		if (1 == gradeId) {
			gradeName = "七年级";
		} else if (2 == gradeId) {
			gradeName = "八年级";
		} else {
			gradeName = "九年级";
		}
		if ("1".equals(exam)) {
			examName = "月考一";
		} else if ("2".equals(exam)) {
			examName = "期中考试";
		} else if ("3".equals(exam)) {
			examName = "月考二";
		} else {
			examName = "期末考试";
		}
		
		
		Semester semester = semesterService.findSemesters().get(0);
		
		
		List<Subject> subjects = subjectService.findSubjectList(gradeId);
		try {
			list = ExcelUtils.readExcel(file);
			for (Map map2 : list) {
				System.err.println(map2);
			}
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "解析成绩表出错..[%s]", file.toString());
		}

		map.put("reserve", 1);
		int byGrade = gradeService.selectCountByGrade(map);
		
		if (list.size() < byGrade) {
			resultMap.put("status", 500);
			resultMap.put("message", "请一次性导入"+gradeName+"所有学生的成绩，以计算、分配巴士币");
			return resultMap;
		}else {
			try {
				for (int i = 0; i < list.size(); i++) {
					System.err.println("当前学生:"+i);
					System.err.println("学号："+list.get(i).get("学号"));
					student = studentService.selectByStuNo("G"+list.get(i).get("学号"));
					for (int j = 0; j < subjects.size(); j++) {
						System.err.println(list.get(i).get(subjects.get(j).getSubjectName()));
						if (null != list.get(i).get(subjects.get(j).getSubjectName())) {
							score = new Score(student.getstuId(), subjects.get(j).getSubjectId(),
									Double.valueOf(list.get(i).get(subjects.get(j).getSubjectName())),
									semester.getSemesterId(), examName);
							System.err.println(score);
							scores.add(score);
						}
					}
				}
				scoreService.leadScore(scores);
				resultMap.put("status", 200);
				resultMap.put("message", "导入成功 ");
			} catch (Exception e) {
				System.err.println(e);
				resultMap.put("status", 500);
				resultMap.put("message", "导入失败，请刷新后再试！");
			}
			
			
			if ("期中考试".equals(examName) || "期末考试".equals(examName)) {
				List<StudentScoreBo> studentA = new ArrayList<>();
				List<StudentScoreBo> studentB = new ArrayList<>();
				List<StudentScoreBo> studentC = new ArrayList<>();
				List<ScoreBo> findBestOfSubject  = new ArrayList<>();
				List<ScoreProgressBo> progressGrade = new ArrayList<>();
				List<BRecord> records = new ArrayList<>();
				BRecord record = null;
				Map<String, List<ScoreProgressBo>> progressClass = new HashMap<>();
				
				
				map.put("examName", examName);
				map.put("gradeName", gradeId);
				map.put("semesterId", semester.getSemesterId());
				findBestOfSubject= scoreService.findBestOfSubject(map);
				modelMap.put("subjectBest", findBestOfSubject);
				
				if (gradeId == 1 || gradeId == 2) {
					map.put("category", "A");
					map.put("ranks", 11);
					studentA = scoreService.findRankByClassCategory(map);
					
					map.put("category", "B");
					map.put("ranks", 61);
					studentB = scoreService.findRankByClassCategory(map);
					
					map.put("category", "C");
					map.put("ranks", 171);
					studentC = scoreService.findRankByClassCategory(map);

				} else {
					map.put("category", "B");
					map.put("ranks", 21);
					studentB = scoreService.findRankByClassCategory(map);
					
					map.put("category", "C");
					map.put("ranks", 121);
					studentC = scoreService.findRankByClassCategory(map);
					
					
				}
				modelMap.put("studentA", studentA);
				modelMap.put("studentB", studentB);
				modelMap.put("studentC", studentC);
				
				String lastExam = StringUtils.findLastExam(semester.getSemesterName()+examName+gradeName);
				if (null == lastExam) {
					resultMap.put("progressMsg", "这是本学年的第一次考试，不能产生年级、班级进步奖！");
				}else{
					Semester lastSemester = semesterService.selectBySemesterName(lastExam.substring(0, 14));
					map.put("lastExam", lastExam.substring(14));
					map.put("lastSemesterId", lastSemester.getSemesterId());
					progressGrade = scoreService.findProgressGrade(map);
					
					modelMap.put("progressGrade", progressGrade);
					
					
					map.put("reserve", 1);
					map.put("gradeName", gradeId);
					List<Classs> findByGrade = classService.findByGrade(map);
					
					for (int i = 0; i < findByGrade.size(); i++) {
						map.put("className", findByGrade.get(i).getClassId());
						List<ScoreProgressBo> findProgressClass = scoreService.findProgressClass(map);
						progressClass.put(findByGrade.get(i).getClassId().toString(), findProgressClass);
					}
					
					modelMap.put("progressClass", progressClass);
					
					if (null != findBestOfSubject) {
						for (ScoreBo scoreBo : findBestOfSubject) {
							record = new BRecord(scoreBo.getStuId(), award.getFirstSubject(), "状元币", semester.getSemesterName()+examName+scoreBo.getSubName()+"获得单科最优奖",new Date());
							records.add(record);
						}
					}
					if (gradeId == 1 || gradeId == 2) {
						if (null != studentA) {
							for (StudentScoreBo studentScoreBo : studentA) {
								if (studentScoreBo.getRank() <= 5) {
									record = new BRecord(studentScoreBo.getStuId(), award.getFirstBest(), "状元币", semester.getSemesterName()+examName+"在实验班中获得"+studentScoreBo.getRank()+"名",new Date());
									records.add(record);
								}else {
									record = new BRecord(studentScoreBo.getStuId(), award.getFirstBetter(), "状元币", semester.getSemesterName()+examName+"在实验班中获得"+studentScoreBo.getRank()+"名",new Date());
									records.add(record);
								}
							}
						}
						if (null != studentB) {
							for (StudentScoreBo studentScoreBo : studentB) {
								if (studentScoreBo.getRank() <= 20) {
									record = new BRecord(studentScoreBo.getStuId(), award.getFirstBest(), "状元币", semester.getSemesterName()+examName+"在重点班中获得"+studentScoreBo.getRank()+"名",new Date());
									records.add(record);
								}else {
									record = new BRecord(studentScoreBo.getStuId(), award.getFirstBetter(), "状元币", semester.getSemesterName()+examName+"在重点班中获得"+studentScoreBo.getRank()+"名",new Date());
									records.add(record);
								}
							}
						}
						if (null != studentC) {
							for (StudentScoreBo studentScoreBo : studentC) {
								if (studentScoreBo.getRank() <= 100) {
									record = new BRecord(studentScoreBo.getStuId(), award.getFirstBest(), "状元币", semester.getSemesterName()+examName+"在平行班中获得"+studentScoreBo.getRank()+"名",new Date());
									records.add(record);
								}else {
									record = new BRecord(studentScoreBo.getStuId(), award.getFirstBetter(), "状元币", semester.getSemesterName()+examName+"在平行班中获得"+studentScoreBo.getRank()+"名",new Date());
									records.add(record);
								}
							}
						}
					}else {
						if (null != studentB) {
							for (StudentScoreBo studentScoreBo : studentB) {
								if (studentScoreBo.getRank() <= 10) {
									record = new BRecord(studentScoreBo.getStuId(), award.getFirstBest(), "状元币", semester.getSemesterName()+examName+"在重点班中获得"+studentScoreBo.getRank()+"名",new Date());
									records.add(record);
								}else {
									record = new BRecord(studentScoreBo.getStuId(), award.getFirstBetter(), "状元币", semester.getSemesterName()+examName+"在重点班中获得"+studentScoreBo.getRank()+"名",new Date());
									records.add(record);
								}
							}
						}
						if (null != studentC) {
							for (StudentScoreBo studentScoreBo : studentC) {
								if (studentScoreBo.getRank() <= 80) {
									record = new BRecord(studentScoreBo.getStuId(), award.getFirstBest(), "状元币", semester.getSemesterName()+examName+"在平行班中获得"+studentScoreBo.getRank()+"名",new Date());
									records.add(record);
								}else {
									record = new BRecord(studentScoreBo.getStuId(), award.getFirstBetter(), "状元币", semester.getSemesterName()+examName+"在平行班中获得"+studentScoreBo.getRank()+"名",new Date());
									records.add(record);
								}
							}
						}
					}
					
					if (null != progressGrade) {
						for (ScoreProgressBo scoreProgressBo : progressGrade) {
							record = new BRecord(scoreProgressBo.getStuId(), award.getProgressGrade(), "晋升币", semester.getSemesterName()+examName+"获得年级进步奖",new Date());
							records.add(record);
						}
					}
					if (null != progressClass) {
						
						Set<String> keys = progressClass.keySet();  
						Iterator<String> iterator = keys.iterator();
						
						while (iterator.hasNext()) {  
							   String key = iterator.next();  
							   List<ScoreProgressBo> scoreBos = progressClass.get(key); 
							   for (ScoreProgressBo scoreProgressBo : scoreBos) {
								   record = new BRecord(scoreProgressBo.getStuId(), award.getProgressClass(), "晋升币", semester.getSemesterName()+examName+"获得班级进步奖",new Date());
								   records.add(record);
							}
						}  
						
					}
					try {
						coinService.insertFromBRecord(records);
						resultMap.put("msg", semester.getSemesterName()+examName+"的巴士币分配完成！");
					} catch (Exception e) {
						resultMap.put("msg", "分配巴士币失败，请刷新后重试");
						LoggerUtils.fmtError(getClass(), e, "巴士币分配失败");
					}
				}
				
			
			}
			
			map.put("gradeName", gradeId);
			map.put("examName", examName);
			map.put("semesterId", semester.getSemesterId());
			List<StudentScoreBo> selectScoreRank = scoreService.selectScoreRank(map);
			for (StudentScoreBo studentScoreBo : selectScoreRank) {
				Rank rank = new Rank(studentScoreBo.getStuId(), semester.getSemesterId(), examName, studentScoreBo.getRank());
				ranks.add(rank);
			}
			System.err.println(selectScoreRank.toString());
			try {
				int count = rankService.insert(ranks);
				resultMap.put("rankStatus", 200);
				resultMap.put("rankMsg", "排名成功 "+count);
			} catch (Exception e1) {
				resultMap.put("rankStatus", 500);
				resultMap.put("rankMsg", "请刷新后再试！");
				
			}
			
			return resultMap;
		}
	}

	
	
	
	/**
	 * 学生查看自己的成绩信息
	 * 
	 * @param modelMap
	 * @param semExaName
	 * @return
	 */
	@RequestMapping(value = "myScore")
	public ModelAndView showStuScore(ModelMap modelMap, @Param(value = "semesterId") String semesterId,
			@Param(value = "exaName") String exaName) {
		User user = TokenManager.getToken();
		Student selectByStuNo = studentService.selectByStuNo(user.getUserName());
		resultMap.put("stuId", selectByStuNo.getstuId().toString());
		List<StudentScoreBo> scoreBos = scoreService.findMyScore(resultMap);
		modelMap.put("scoreBos", scoreBos);
		return new ModelAndView("score/myScore");
	}
	/**
	 * 学生对比三年成绩
	 * 
	 * @param modelMap
	 * @param semExaName
	 * @return
	 */
	@RequestMapping(value = "StudentScore")
	public ModelAndView StudentScore() {
		
		
		return null;
	}
}
