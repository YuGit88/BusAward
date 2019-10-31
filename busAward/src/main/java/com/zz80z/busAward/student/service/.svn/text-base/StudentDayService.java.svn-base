package com.zz80z.busAward.student.service;

import java.util.List;
import java.util.Map;

import com.zz80z.busAward.common.model.BRecord;
import com.zz80z.busAward.common.model.Semester;
import com.zz80z.busAward.common.model.StuDay;
import com.zz80z.busAward.common.model.Student;

public interface StudentDayService {

	//学生日常批量插入
	public void insertStuDayList(List<StuDay>studaylist);
	
	//统计上周学生日常
	public List<StuDay> countLastWeekStuDay(Map<String,String> countDate);
	
	//获取学期列表
	public List<Semester> semesterList();
	
	//获取选择的周  是当前周的前几周
	public Map<Integer,Integer> getNWeek(int n);
	
    //获取前台查询展示Map
    public Map getMap(int nWeek);
    
    //查询当前学生是否已经分配星级币
    public List<Student> selectBrcord(Map sqlMap);
    
    //查询当前周星级币分配的数量
    public List<BRecord> selectBrcordList(Map sqlMap);
}
