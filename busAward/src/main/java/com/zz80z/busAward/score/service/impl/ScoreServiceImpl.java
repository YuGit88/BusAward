package com.zz80z.busAward.score.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zz80z.busAward.common.dao.ScoreMapper;
import com.zz80z.busAward.common.model.ClassRankCount;
import com.zz80z.busAward.common.model.GroupScore;
import com.zz80z.busAward.common.model.ProgressCount;
import com.zz80z.busAward.common.model.Score;
import com.zz80z.busAward.core.mybatis.BaseMybatisDao;
import com.zz80z.busAward.core.mybatis.page.Pagination;
import com.zz80z.busAward.score.service.ScoreService;
import com.zz80z.busAward.user.bo.ScoreBo;
import com.zz80z.busAward.user.bo.ScoreProgressBo;
import com.zz80z.busAward.user.bo.StudentScoreBo;
import com.zz80z.busAward.user.bo.SubjectData;

@Service
@SuppressWarnings("unchecked")
public class ScoreServiceImpl extends BaseMybatisDao<ScoreMapper> implements ScoreService {

	@Autowired
	ScoreMapper scoreMapper;

	@Override
	public int deleteByPrimaryKey(Integer scoreId) {
		return scoreMapper.deleteByPrimaryKey(scoreId);
	}

	@Override
	public int insert(Score record) {
		return scoreMapper.insert(record);
	}

	@Override
	public int insertSelective(Score record) {
		return scoreMapper.insertSelective(record);
	}

	@Override
	public Score selectByPrimaryKey(Integer scoreId) {
		return scoreMapper.selectByPrimaryKey(scoreId);
	}

	@Override
	public int updateByPrimaryKeySelective(Score record) {
		return scoreMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Score record) {
		return scoreMapper.updateByPrimaryKey(record);
	}

	@Override
	public int leadScore(List<Score> scores) {

		return scoreMapper.leadScore(scores);

	}

	@Override
	public Pagination<StudentScoreBo> findStudentAndScorePage(Map<String, Object> resultMap,Integer pageNo,Integer pageSize) {
		return super.findByPageBySqlId("findStudentAndScorePage", resultMap, pageNo, pageSize);
	}

	@Override
	public List<StudentScoreBo> findRankByClassCategory(Map<String, Object> map) {
		return scoreMapper.findRankByClassCategory(map);
	}


	/**
     * 获得x学期x考试x年级 单科成绩最高的学生及其成绩
     * @return
     */
	@Override
	public List<ScoreBo> findBestOfSubject(Map<String, Object> map) {
		return scoreMapper.findBestOfSubject(map);
	}

	@Override
	public List<ScoreProgressBo> findProgressGrade(Map<String, Object> map) {
		return scoreMapper.findProgressGrade(map);
	}

	@Override
	public List<ScoreProgressBo> findProgressClass(Map<String, Object> map) {
		return scoreMapper.findProgressClass(map);
	}

	@Override
	public List<StudentScoreBo> findMyScore(Map<String, Object> map) {
		return scoreMapper.findMyScore(map);
	}

	@Override
	public List<SubjectData> findSubjectInfoByClassMark(Map<String, Object> map) {
		
		return scoreMapper.findSubjectInfoByClassMark(map);
	}

	@Override
	public List<StudentScoreBo> selectScoreRank(Map<String, Object> map) {
		return scoreMapper.selectScoreRank(map);
	}

	@Override
	public StudentScoreBo selectStuScoreRank(Map<String, Object> map) {
		return scoreMapper.selectStuScoreRank(map);
	}						

	@Override
	public List<ClassRankCount> selectCountRankByClass(Map<String, Object> map) {
		return scoreMapper.selectCountRankByClass(map);
	}

	@Override
	public GroupScore findScoreByGroup(Map<String, Object> map) {
		
		return scoreMapper.findScoreByGroup(map);
	}

	@Override
	public ProgressCount selectProgressCount(Map<String, Object> map) {
		return scoreMapper.selectProgressCount(map);
	}

}
