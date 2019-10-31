package com.zz80z.busAward.common.dao;

import java.util.List;
import java.util.Map;

import com.zz80z.busAward.common.model.Grade;
import com.zz80z.busAward.user.bo.GradeAndSubject;
import com.zz80z.busAward.user.bo.SubjectBo;

public interface GradeMapper {
    int deleteByPrimaryKey(Integer gradeId);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer gradeId);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
    
    List<Grade> findList();
    
    List<GradeAndSubject> findGradeAndSubject();
    
    List<SubjectBo> selectSubjectByGradeId(Integer gradeId);
    
    Grade selectByGradeName(String gradeName);
    
    int selectCountByGrade(Map<String, Object> map);
    
}