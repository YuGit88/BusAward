package com.zz80z.busAward.common.dao;

import java.util.List;

import com.zz80z.busAward.common.model.Subject;

public interface SubjectMapper {
    int deleteByPrimaryKey(Integer subjectId);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(Integer subjectId);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);
    
    Subject selectBySubjectName(String subjectName);
    
    List<Subject> findSubjectList(Integer gradeId);
    
    List<Subject> findSubjects();

	List<String> findSubjectNames();
}