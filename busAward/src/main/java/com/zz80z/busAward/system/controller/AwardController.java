package com.zz80z.busAward.system.controller;

import java.util.ArrayList;

import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zz80z.busAward.common.controller.BaseController;
import com.zz80z.busAward.common.model.Award;
import com.zz80z.busAward.common.utils.LoggerUtils;
import com.zz80z.busAward.system.service.AwardService;

@Controller
@Scope(value="prototype")
@RequestMapping("sys")
public class AwardController extends BaseController{

	@Autowired
	private AwardService awardService;
	
	/**
	 * 奖励系数信息列表
	 * @return
	 */
	@RequestMapping(value = "awdUp")
	public ModelAndView awardList(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pageNo, 10);
		List<Award> awards = awardService.selectAll();
		PageInfo<Award> page = new PageInfo<Award>(awards, 5);
		return new ModelAndView("sys/awdUp","pageInfo", page);
	}
	
	/**
	 * 添加奖励系数信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="addAwd")
	public Map<String , Object> addAwd(Award award,HttpServletResponse response){
		response.setContentType("application/json;charset=utf-8");
		Award awd = awardService.selectByPrimaryKey(award.getAwardId());
		System.out.println(awd);
		if (null == awd) {
			try {
				int count = awardService.insert(award);
				resultMap.put("status", 200);
				resultMap.put("successCount", count);
				resultMap.put("message", "添加成功");
			} catch (Exception e) {
				resultMap.put("status", 500);
				resultMap.put("message", "添加失败，请刷新后再试！");
				LoggerUtils.fmtError(getClass(), e, "添加奖励系数信息报错。source[%s]", award.toString());
			}
		}else {
			resultMap.put("status", 500);
			resultMap.put("message", "编号"+award.getAwardId()+"已存在,请不要重复增加！");
		}
		return resultMap;
	}
	
	/**
	 * 获取查询奖励系数信息
	 * @param award
	 * @return
	 */
	@RequestMapping(value="awardId")
	public ModelAndView teacherList(
		@RequestParam(value="awardId",defaultValue="",required=false)Integer awardId,
		@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		System.out.println(awardId);
		PageHelper.startPage(pn, 10);
		PageInfo pageInfo =null;
				Award award =awardService.selectByPrimaryKey(awardId);	
				  List<Award> awards = new ArrayList<Award>();
				  if(award != null){
					  awards.add(award);
					  pageInfo = new PageInfo(awards,5);
				  }else{
					  System.out.println("没有查到该条奖励信息");
				  }
		return new ModelAndView("sys/awdUp","pageInfo",pageInfo);
	}
	
	/**
	 * 删除奖励系数信息
	 * @return
	 */
	@RequestMapping(value="deleteAwd",method=RequestMethod.GET)
	@ResponseBody
	public Map<String , Object> deleteAwd(Integer awardId){
			try {
				int count = awardService.deleteByPrimaryKey(awardId);
				resultMap.put("status", 200);
				resultMap.put("successCount", count);
				resultMap.put("message", "删除成功");
			} catch (Exception e) {
				resultMap.put("status", 500);
				resultMap.put("message", "删除失败，请刷新后再试！");
			}
		return resultMap;
	}
}
