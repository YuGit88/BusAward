package com.zz80z.busAward.common.dao;

import java.util.*;
import com.zz80z.busAward.common.model.Semester;

public interface SemesterMapper {
    int deleteByPrimaryKey(Integer semesterId);

    int insert(Semester record);

    int insertSelective(Semester record);

    Semester selectByPrimaryKey(Integer semesterId);

    int updateByPrimaryKeySelective(Semester record);

    int updateByPrimaryKey(Integer semesterId);
    
    //判断当前时间在哪个学期
    Semester selectByCurrent();
    
    //获得所有学期的名字，避免重复
    List<Semester> findSemesters();
    
    Semester selectBySemesterName(String semesterName);
    
    List<Semester> selectBySemesterNames(List<String> semesterNames);
    
    List<Semester> selectByYear(String semesterYear);
    
}