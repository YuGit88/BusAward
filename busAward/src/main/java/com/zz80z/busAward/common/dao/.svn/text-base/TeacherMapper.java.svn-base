package com.zz80z.busAward.common.dao;


import java.util.List;
import java.util.Map;

import com.zz80z.busAward.common.model.Teacher;
import com.zz80z.busAward.user.bo.TeacherClassBo;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer tchId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer tchId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
    
    Teacher selectByTchNo(String tchNo);
    
    void leadTeacher(List<Teacher> teachers);
    
  //查询教师和科目
  	List<Teacher> selectTeacherAndSubject();
  	
    List<TeacherClassBo> selectTeacherAndClass();
    
	//查询当前班级下教师和学科信息
	List<Teacher> selectTeacherAndSubjectByClassId(int classId);
    
}