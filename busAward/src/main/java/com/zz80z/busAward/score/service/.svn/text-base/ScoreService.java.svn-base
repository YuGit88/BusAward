package com.zz80z.busAward.score.service;

import java.util.List;
import java.util.Map;

import com.zz80z.busAward.common.model.ClassRankCount;
import com.zz80z.busAward.common.model.GroupScore;
import com.zz80z.busAward.common.model.ProgressCount;
import com.zz80z.busAward.common.model.Score;
import com.zz80z.busAward.core.mybatis.page.Pagination;
import com.zz80z.busAward.user.bo.ScoreBo;
import com.zz80z.busAward.user.bo.ScoreProgressBo;
import com.zz80z.busAward.user.bo.StudentScoreBo;
import com.zz80z.busAward.user.bo.SubjectData;

public interface ScoreService {

	int deleteByPrimaryKey(Integer scoreId);

	int insert(Score record);

	int insertSelective(Score record);

	Score selectByPrimaryKey(Integer scoreId);

	int updateByPrimaryKeySelective(Score record);

	int updateByPrimaryKey(Score record);

	// 导入学生成绩
	int leadScore(List<Score> scores);

	// 显示成绩列表
	Pagination<StudentScoreBo> findStudentAndScorePage(Map<String, Object> resultMap,Integer pageNo,Integer pageSize);

	// 获得不同层次班级学生名次，以分配成绩的巴士币
	List<StudentScoreBo> findRankByClassCategory(Map<String, Object> map);

	List<ScoreBo> findBestOfSubject(Map<String, Object> map);
	
	/**
     * 获得本次考试 与上次考试（如果有的话）总分之差按年级 
     * @return
     */
    List<ScoreProgressBo> findProgressGrade(Map<String, Object> map);
    /**
     * 获得本次考试 与上次考试（如果有的话）总分之差按班级
     * @return
     */
    List<ScoreProgressBo> findProgressClass(Map<String, Object> map);
    
    List<StudentScoreBo> findMyScore(Map<String, Object> map);

    List<SubjectData> findSubjectInfoByClassMark(Map<String, Object> map);
    
    List<StudentScoreBo> selectScoreRank(Map<String, Object> map);
    
    StudentScoreBo selectStuScoreRank(Map<String, Object> map);
    
    List<ClassRankCount> selectCountRankByClass(Map<String, Object> map);

	GroupScore findScoreByGroup(Map<String, Object> map);

	ProgressCount selectProgressCount(Map<String, Object> map);

}
