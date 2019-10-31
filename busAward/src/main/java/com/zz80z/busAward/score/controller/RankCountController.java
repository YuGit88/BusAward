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
import com.zz80z.busAward.common.model.ClassRankCount;
import com.zz80z.busAward.common.model.ClassRankCountBo;
import com.zz80z.busAward.core.classs.service.ClasssService;
import com.zz80z.busAward.core.shiro.token.manager.TokenManager;
import com.zz80z.busAward.score.service.ScoreService;
import com.zz80z.busAward.user.service.RoleService;

@Controller
@Scope(value = "prototype")
@RequestMapping("score")
public class RankCountController extends BaseController {
	@Autowired
	private ScoreService scoreService;
	@Autowired
	private ClasssService classService;
	@Autowired
	private RoleService roleService;

	@RequestMapping("rankCount")
	public ModelAndView showScore(ModelMap modelMap, Map<String, Object> map) {

		List<String> classMarks = new ArrayList<>();
		Set<String> roles = roleService.findRoleByUserId(TokenManager.getUserId());
		if (roles.contains("政教处") || roles.contains("教务处")) {
			classMarks = classService.findClassMark(null);
		} else {
			classMarks = classService.findClassMark(TokenManager.getUserName());
		}
		modelMap.put("classMarks", classMarks);
		return new ModelAndView("score/rankCount");
	}

	@RequestMapping("countRank")
	@ResponseBody
	public Map<String, Object> selectCountByclassMark(@RequestParam("classMark") String classMark,
			@RequestParam("semesterId") String semesterId) {
		Map<String,Object> map = new HashMap<>();
		List<ClassRankCountBo> classRankCountBos = new ArrayList<>();
		map.put("classMark", classMark);
		map.put("semesterId", semesterId);
		map.put("examName", "月考一");
		map.put("rank1", 10);
		map.put("rank2", 20);
		map.put("rank3", 50);
		map.put("rank4", 100);
		map.put("rank5", 150);
		map.put("rank6", 200);
		map.put("rank7", 300);
		List<ClassRankCount> rankByClass1 = scoreService.selectCountRankByClass(map);
		
		ClassRankCountBo classRankCountBo1 = new ClassRankCountBo((String)map.get("examName"), Integer.parseInt(semesterId), classMark, 
				rankByClass1.get(0).getCount(), rankByClass1.get(0).getNames(), rankByClass1.get(1).getCount(), rankByClass1.get(1).getNames(), 
				rankByClass1.get(2).getCount(), rankByClass1.get(2).getNames(), rankByClass1.get(3).getCount(), rankByClass1.get(3).getNames(), 
				rankByClass1.get(4).getCount(), rankByClass1.get(4).getNames(), rankByClass1.get(5).getCount(), rankByClass1.get(5).getNames(), 
				rankByClass1.get(6).getCount(), rankByClass1.get(6).getNames());
		classRankCountBos.add(classRankCountBo1);
		
		
		map.put("examName", "期中考试");
		List<ClassRankCount> rankByClass2 = scoreService.selectCountRankByClass(map);
		
		ClassRankCountBo classRankCountBo2 = new ClassRankCountBo((String)map.get("examName"), Integer.parseInt(semesterId), classMark, 
				rankByClass2.get(0).getCount(), rankByClass2.get(0).getNames(), rankByClass2.get(1).getCount(), rankByClass2.get(1).getNames(), 
				rankByClass2.get(2).getCount(), rankByClass2.get(2).getNames(), rankByClass2.get(3).getCount(), rankByClass2.get(3).getNames(), 
				rankByClass2.get(4).getCount(), rankByClass2.get(4).getNames(), rankByClass2.get(5).getCount(), rankByClass2.get(5).getNames(), 
				rankByClass2.get(6).getCount(), rankByClass2.get(6).getNames());
		classRankCountBos.add(classRankCountBo2);
		
		
		map.put("examName", "月考二");
		List<ClassRankCount> rankByClass3 = scoreService.selectCountRankByClass(map);
		
		ClassRankCountBo classRankCountBo3 = new ClassRankCountBo((String)map.get("examName"), Integer.parseInt(semesterId), classMark, 
				rankByClass3.get(0).getCount(), rankByClass3.get(0).getNames(), rankByClass3.get(1).getCount(), rankByClass3.get(1).getNames(), 
				rankByClass3.get(2).getCount(), rankByClass3.get(2).getNames(), rankByClass3.get(3).getCount(), rankByClass3.get(3).getNames(), 
				rankByClass3.get(4).getCount(), rankByClass3.get(4).getNames(), rankByClass3.get(5).getCount(), rankByClass3.get(5).getNames(), 
				rankByClass3.get(6).getCount(), rankByClass3.get(6).getNames());
		classRankCountBos.add(classRankCountBo3);
		
		map.put("examName", "期末考试");
		List<ClassRankCount> rankByClass4 = scoreService.selectCountRankByClass(map);
		
		ClassRankCountBo classRankCountBo4 = new ClassRankCountBo((String)map.get("examName"), Integer.parseInt(semesterId), classMark, 
				rankByClass4.get(0).getCount(), rankByClass4.get(0).getNames(), rankByClass4.get(1).getCount(), rankByClass4.get(1).getNames(), 
				rankByClass4.get(2).getCount(), rankByClass4.get(2).getNames(), rankByClass4.get(3).getCount(), rankByClass4.get(3).getNames(), 
				rankByClass4.get(4).getCount(), rankByClass4.get(4).getNames(), rankByClass4.get(5).getCount(), rankByClass4.get(5).getNames(), 
				rankByClass4.get(6).getCount(), rankByClass4.get(6).getNames());
		classRankCountBos.add(classRankCountBo4);
		
		resultMap.put("rankCounts", classRankCountBos);
		return resultMap;
	}
}
