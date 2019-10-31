package com.zz80z.busAward.common.dao;

import com.zz80z.busAward.common.model.GradeSubject;

public interface GradeSubjectMapper {
    int insert(GradeSubject record);

    int insertSelective(GradeSubject record);
    
    void deleteByGradeId(Integer gradeId);
}