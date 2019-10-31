package com.zz80z.busAward.score.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.zz80z.busAward.common.coin.service.CoinService;
import com.zz80z.busAward.common.controller.BaseController;
import com.zz80z.busAward.common.model.Award;
import com.zz80z.busAward.common.model.BRecord;
import com.zz80z.busAward.common.utils.LoggerUtils;
import com.zz80z.busAward.score.service.ScoreService;
import com.zz80z.busAward.system.service.AwardService;
import com.zz80z.busAward.user.bo.ScoreBo;
import com.zz80z.busAward.user.bo.StudentScoreBo;

@Controller
@Scope(value = "prototype")
@RequestMapping("score")
public class ScoreAllotCoinController extends BaseController{

	@Autowired
	private ScoreService scoreService;
	@Autowired
	private CoinService coinService;
	@Autowired
	private AwardService awardService;
	
	
	
	@RequestMapping("allotScoreCoin")
	public ModelAndView allotScoreCoin(ModelMap modelMap,Map<String, Object> map,@Param(value="examName")String examName){
		
		
		return new ModelAndView("score/allotScoreCoin");
	}

	/**
	 * 查询出年级进步和班级进步奖励巴士币
	 */
	public Map<String, Object> allotProgressCoin(Map<String, Object> map) {
		
		return resultMap;
	}

	/**
	 * 查询出单科成绩最好的学生给予奖励
	 */
	public void allotBestCoin(Map<String, Object> map) {
		Award award = awardService.selectByPrimaryKey(1);
		List<BRecord> records = new ArrayList<>();
		BRecord record = new BRecord();
		List<ScoreBo> scoreBos = scoreService.findBestOfSubject(map);
		for (int i = 0; i < scoreBos.size(); i++) {
			record.setStuId(scoreBos.get(i).getStuId());
			record.setCoinType("单科最优-状元币");
			record.setCreateTime(new Date());
			record.setPoints(award.getFirstBest());
			records.add(record);
		}
		try {
			coinService.insertFromBRecord(records);
			resultMap.put("bestMsg", "正在查询单科成绩最好的学生，并分配巴士币。");
		} catch (Exception e) {
			resultMap.put("bestMsg", "分配单科最优巴士币失败，请重新导入。。");
			LoggerUtils.fmtError(getClass(), e, "并分配单科最优巴士币失败");
		}

	}

	/**
	 * 获得不同层次班级学生名次，以分配成绩的巴士币
	 */
	public void allotRankCoin(Map<String, Object> map) {
		Award award = awardService.selectByPrimaryKey(1);
		List<BRecord> records = new ArrayList<>();
		BRecord record = new BRecord();
		Integer gradeName = (Integer) map.get("gradeName");
		if (gradeName == 1 || gradeName == 2) {
			map.put("category", "A");
			map.put("ranks", 11);
			List<StudentScoreBo> studentA = scoreService.findRankByClassCategory(map);
			for (int i = 0; i < studentA.size(); i++) {
				if (i < 5) {
					record.setCoinType("前5名(实验班)-状元币");
					record.setCreateTime(new Date());
					record.setPoints(award.getFirstBest());
					record.setStuId(studentA.get(i).getStuId());
					records.add(record);
				} else {
					record.setCoinType("6-10名(实验班)-状元币");
					record.setCreateTime(new Date());
					record.setPoints(award.getFirstBetter());
					record.setStuId(studentA.get(i).getStuId());
					records.add(record);
				}
			}
			map.put("category", "B");
			map.put("ranks", 61);
			List<StudentScoreBo> studentB = scoreService.findRankByClassCategory(map);
			for (int i = 0; i < studentB.size(); i++) {
				if (i < 21) {
					record.setCoinType("前20名(重点班)-状元币");
					record.setCreateTime(new Date());
					record.setPoints(award.getFirstBest());
					record.setStuId(studentB.get(i).getStuId());
					records.add(record);
				} else {
					record.setCoinType("21-60名(重点班)-状元币");
					record.setCreateTime(new Date());
					record.setPoints(award.getFirstBetter());
					record.setStuId(studentB.get(i).getStuId());
					records.add(record);
				}
			}
			map.put("category", "C");
			map.put("ranks", 171);
			List<StudentScoreBo> studentC = scoreService.findRankByClassCategory(map);
			for (int i = 0; i < studentC.size(); i++) {
				if (i < 101) {
					record.setCoinType("前100名(重点班)-状元币");
					record.setCreateTime(new Date());
					record.setPoints(award.getFirstBest());
					record.setStuId(studentB.get(i).getStuId());
					records.add(record);
				} else {
					record.setCoinType("101-170名(重点班)-状元币");
					record.setCreateTime(new Date());
					record.setPoints(award.getFirstBetter());
					record.setStuId(studentC.get(i).getStuId());
					records.add(record);
				}
			}

			try {
				coinService.insertFromBRecord(records);
				resultMap.put("rankMsg", "正在按班级类别查询名次，并分配巴士币。");
			} catch (Exception e) {
				resultMap.put("rankMsg", "按班级类别查询名次分配巴士币失败，请重新导入。。");
				LoggerUtils.fmtError(getClass(), e, "按班级类别查询名次分配巴士币失败");
			}

		} else {
			map.put("category", "B");
			map.put("ranks", 21);
			List<StudentScoreBo> studentB = scoreService.findRankByClassCategory(map);
			for (int i = 0; i < studentB.size(); i++) {
				if (i < 11) {
					record.setCoinType("前10名(重点班)-状元币");
					record.setCreateTime(new Date());
					record.setPoints(award.getFirstBest());
					record.setStuId(studentB.get(i).getStuId());
					records.add(record);
				} else {
					record.setCoinType("11-20名(重点班)-状元币");
					record.setCreateTime(new Date());
					record.setPoints(award.getFirstBetter());
					record.setStuId(studentB.get(i).getStuId());
					records.add(record);
				}
			}
			map.put("category", "C");
			map.put("ranks", 121);
			List<StudentScoreBo> studentC = scoreService.findRankByClassCategory(map);
			for (int i = 0; i < studentC.size(); i++) {
				if (i < 81) {
					record.setCoinType("前80名(重点班)-状元币");
					record.setCreateTime(new Date());
					record.setPoints(award.getFirstBest());
					record.setStuId(studentB.get(i).getStuId());
					records.add(record);
				} else {
					record.setCoinType("81-120名(重点班)-状元币");
					record.setCreateTime(new Date());
					record.setPoints(award.getFirstBetter());
					record.setStuId(studentC.get(i).getStuId());
					records.add(record);
				}
			}
			try {
				coinService.insertFromBRecord(records);
				resultMap.put("rankMsg", "正在按班级类别查询名次，并分配巴士币。");
			} catch (Exception e) {
				resultMap.put("rankMsg", "按班级类别查询名次分配巴士币失败，请重新导入。。");
				LoggerUtils.fmtError(getClass(), e, "按班级类别查询名次分配巴士币失败");
			}
		}
	}
}
