package com.zz80z.busAward.system.service;

import java.util.List;

import com.zz80z.busAward.common.model.Semester;

public interface SemesterService {

	Semester selectByCurrent();

	int insertSelective(Semester record);

	List<Semester> findSemesters();
	
	Semester selectBySemesterName(String semesterName);
	
	List<Semester> selectBySemesterNames(List<String> semesterNames);
	
	Semester selectByPrimaryKey(Integer semesterId);
	
	List<Semester> selectByYear(String semesterYear);
	
}
