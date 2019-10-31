package com.zz80z.busAward.common.dao;

import java.util.List;
import java.util.Map;

import com.zz80z.busAward.common.model.ClassTeacher;

public interface ClassTeacherMapper {
    int insert(ClassTeacher record);

    int insertSelective(ClassTeacher record);

    List<ClassTeacher> findClassTeacherByTchId(Integer tchId);

    List<ClassTeacher> findClassTeacherByClassId(Integer classId);
    
    List<ClassTeacher> find(ClassTeacher entity);
    
    int deleteTchId(Integer tchId);
	
	int deleteByClassId(Integer classId);
	
	int delete(ClassTeacher entity);

	int deleteByClassIds(Map<String,Object> resultMap);
	
}