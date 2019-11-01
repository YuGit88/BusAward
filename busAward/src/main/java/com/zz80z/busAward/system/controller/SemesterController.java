package com.zz80z.busAward.system.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zz80z.busAward.common.controller.BaseController;
import com.zz80z.busAward.common.model.Award;
import com.zz80z.busAward.common.model.Semester;
import com.zz80z.busAward.common.utils.LoggerUtils;
import com.zz80z.busAward.common.utils.StringUtils;
import com.zz80z.busAward.system.service.AwardService;
import com.zz80z.busAward.system.service.SemesterService;

@Controller
@Scope(value="prototype")
@RequestMapping("/sys")
public class SemesterController extends BaseController{
	@Autowired
	private SemesterService semesterService;
	@Autowired
	private AwardService awardService;
	
	@RequestMapping(value="award")
	public ModelAndView showAward() {
		
		Award award = awardService.selectByPrimaryKey(new Integer(1));
		
		return new ModelAndView("/sys/award","award",award);
	}
	/**
	 * 获得某个班级的所在的学期
	 * @param classMark
	 * @return
	 */
	@RequestMapping(value="selectSemesterByClassMark")
	@ResponseBody
	public Map<String, Object> selectSemesterByClassMark(@Param(value="classMark")String classMark){
		List<String> semesterNames = StringUtils.findSemester(classMark);
		List<Semester> semesters = new ArrayList<>();
		for (String semesterName : semesterNames) {
			Semester semester = semesterService.selectBySemesterName(semesterName);
			if (null != semester) {
				semesters.add(semester);
			}
		}
		resultMap.put("semesters", semesters);
		return resultMap;
	}
	/**
	 * 修改奖励系数
	 * @param award
	 * @return
	 */
	@RequestMapping(value="modifyAward")
	@ResponseBody
	public Map<String , Object> modifyAward(Award award) {
		try {
			awardService.updateByPrimaryKeySelective(award);
			resultMap.put("status", 200);
			resultMap.put("message", "更新完成！");
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "更新失败，请刷新后再试！");
			LoggerUtils.fmtError(getClass(), e, "修改奖励系数报错。source[%s]", award.toString());
		}
		return resultMap;
	}	
	
	/**
	 * 获得当前日期所在的学期信息
	 * @return
	 */
	@RequestMapping(value="index")
	public ModelAndView showSemester() {
		
		Semester semester = semesterService.selectByCurrent();
		return new ModelAndView("/sys/index","semester",semester);
		
	}
	
	@RequestMapping(value="semester")
	public ModelAndView semester() {
		
		return new ModelAndView("sysmester");
	}
	/**
	 * 设定新学期的开学时间等相关信息
	 * @return
	 */
	@RequestMapping(value="setSemester")
	@ResponseBody
	public Map<String,Object> setSemester(String semesterName,String creatTime, String recessTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Semester semester = null;
		try {
			semester = new Semester(semesterName, sdf.parse(creatTime), sdf.parse(recessTime));
		} catch (ParseException e) {
			LoggerUtils.error(getClass(), "日期转化失败，设置新学期失败，刷新后再试");
		}
		
		Semester selectBySemesterName = semesterService.selectBySemesterName(semesterName);
		if (null != selectBySemesterName) {
			resultMap.put("status", 300);
			resultMap.put("message", "请不要重复设置");
		}else {
			int i = semesterService.insertSelective(semester);
			if (i==1) {
				resultMap.put("status", 200);
				resultMap.put("message", "设置成功！");
			}else {
				resultMap.put("status", 300);
				resultMap.put("message", "设置新的学期信息失败，请刷新后再次尝试！");
				LoggerUtils.error(SemesterController.class, "设置新的学期信息失败");
			}
		}
		return resultMap;
	}
	
}