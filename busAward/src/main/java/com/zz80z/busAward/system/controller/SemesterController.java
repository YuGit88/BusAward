package com.zz80z.busAward.system.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zz80z.busAward.common.controller.BaseController;
import com.zz80z.busAward.common.model.Award;
import com.zz80z.busAward.common.model.Semester;
import com.zz80z.busAward.common.model.Teacher;
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
	//添加新学期
	@RequestMapping(value="addsemester")
	@ResponseBody
	public Map<String, Object> addsem(Semester semester) {
		
				try {
					int count=semesterService.insertSelective(semester);
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!"+count);
						resultMap.put("status", 200);
						resultMap.put("successCount", count);
						resultMap.put("scuess", "添加成功");
				} catch (Exception e) {
					
					resultMap.put("status", 500);
					resultMap.put("message", "添加失败，请刷新后再试！");

									}

		return resultMap;
		
	}
	//查询单条
	@RequestMapping(value = "selectsemesterById",method=RequestMethod.POST)
	@ResponseBody
	public Map<String , Object> selectTchById(String semesterId){
		Semester semester = semesterService.selectByPrimaryKey(Integer.parseInt(semesterId));
		resultMap.put("status", 200);
		resultMap.put("semester", semester);
		return resultMap;
		
	}
	//更新
	@RequestMapping(value = "updatesemesterById")
	@ResponseBody
	public Map<String , Object> updatesemester(Semester semester,HttpServletRequest request){
			System.out.println("11111111111111"+semester);
			try {
				request.setCharacterEncoding("UTF-8");
				int count = semesterService.updateByPrimaryKey(semester);
				System.out.println("555555555"+count);
				resultMap.put("status", 200);
				resultMap.put("successCount", count);
				resultMap.put("message", "修改成功！");
			} catch (Exception e) {
				resultMap.put("status", 500);
				resultMap.put("message", "修改失败，请刷新后再试！");
				System.out.println("555555555修改中出现的错误信息"+e);
			}
		
		return resultMap;
	}
	
	@RequestMapping(value = "deletesemester",method=RequestMethod.GET)
	@ResponseBody
	public Map<String , Object> deleteTch(Integer semesterId){
		System.out.println("*************"+semesterId);
			try {
				int count = semesterService.updateByPrimaryKey(semesterId);
				resultMap.put("status", 200);
				resultMap.put("successCount", count);
				resultMap.put("message", "删除成功");
			} catch (Exception e) {
				resultMap.put("status", 500);
				resultMap.put("message", "删除失败，请刷新后再试！");
			}
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
	public Map<String, Object> showSemester() {
		
		List<Semester> semester = semesterService.findSemesters();
		
		resultMap.put("sem", semester);
		
		return resultMap;
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