package com.zz80z.busAward.common.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zz80z.busAward.common.model.ClassDay;
import com.zz80z.busAward.common.model.Subject;
import com.zz80z.busAward.common.model.Teacher;
import com.zz80z.busAward.user.bo.classAndClassDay;

public interface ClassDayMapper {
    int deleteByPrimaryKey(Integer classdayId);

    int insert(ClassDay record);

    int insertSelective(ClassDay record);

    ClassDay selectByPrimaryKey(Integer classdayId);

    int updateByPrimaryKeySelective(ClassDay record);

    int updateByPrimaryKey(ClassDay record);
    
	//Excel导入班级日常
	public void classExcel(List<ClassDay> classDayList);

	//统计班级日常和班级信息
	public List<ClassDay> countClassDayAndClass(Map<String, String> countDate);
	
	//查询所有教师
	public List<Teacher> selectTeacherList();
	
	//查询当前年级下学科
	public List<Subject> subjectList(int gradeName);
	
	 //删除班级日常信息
	 void deleteClassDay();
	 
	//查询班级日常统计
	public List<classAndClassDay> selectClassChart(Map sqlMap);
	
}