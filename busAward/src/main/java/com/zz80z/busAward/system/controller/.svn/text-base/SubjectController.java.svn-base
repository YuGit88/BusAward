package com.zz80z.busAward.system.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zz80z.busAward.common.controller.BaseController;
import com.zz80z.busAward.common.model.Subject;
import com.zz80z.busAward.common.utils.LoggerUtils;
import com.zz80z.busAward.score.service.SubjectService;
import com.zz80z.busAward.system.service.GradeService;
import com.zz80z.busAward.user.bo.GradeAndSubject;
import com.zz80z.busAward.user.bo.SubjectBo;

@Controller
@Scope(value = "prototype")
@RequestMapping("sys")
public class SubjectController extends BaseController {

	@Autowired
	private SubjectService subjectService;
	@Autowired
	private GradeService gradeService;

	/**
	 * 新增科目
	 */
	@RequestMapping(value = "subject", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addSubject(Subject subject) {
		boolean b = subjectService.checkSubject(subject.getSubjectName());
		if (b) {
			try {
				int count = subjectService.insertSelective(subject);
				resultMap.put("status", 200);
				resultMap.put("successCount", count);
			} catch (Exception e) {
				resultMap.put("status", 500);
				resultMap.put("message", "添加失败，请刷新后再试！");
				LoggerUtils.fmtError(getClass(), e, "添加科目报错。source[%s]", subject.toString());
			}
		}else {
			resultMap.put("status", 500);
			resultMap.put("message", subject.getSubjectName()+"已存在，请不要重复添加");
		}
		
		return resultMap;
	}
	@RequestMapping(value="addSubject2Grade")
	@ResponseBody 
	public Map<String,Object> addSubject2Grade(Integer gradeId,String ids){
		return subjectService.addSubject2Grade(gradeId,ids);
	}
	
	
	/**
	 * 根据年级ID查询科目
	 * @param id
	 * @return
	 */
	@RequestMapping(value="selectSubjectByGradeId")
	@ResponseBody
	public List<SubjectBo> selectSubjectByGradeId(Integer gradeId){
		List<SubjectBo> grades = gradeService.selectSubjectByGradeId(gradeId);
		return grades;
	}
	@RequestMapping(value = "alotSubject")
	public ModelAndView alotSubject(ModelMap modelMap) {
		List<GradeAndSubject> gradeAndSubjects = gradeService.findGradeAndSubject();
		List<Subject> subjects = subjectService.findSubjects();
		modelMap.put("subjects", subjects);
		return new ModelAndView("sys/alotSubject", "grades", gradeAndSubjects);
	}
}
