package com.zz80z.busAward.student.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz80z.busAward.common.dao.SemesterMapper;
import com.zz80z.busAward.common.dao.StuDayMapper;
import com.zz80z.busAward.common.dao.StudentMapper;
import com.zz80z.busAward.common.model.BRecord;
import com.zz80z.busAward.common.model.Classs;
import com.zz80z.busAward.common.model.Semester;
import com.zz80z.busAward.common.model.StuDay;
import com.zz80z.busAward.common.model.Student;
import com.zz80z.busAward.common.utils.WeekUtils;
import com.zz80z.busAward.student.service.StudentDayService;

@Service
public class StudentDayServiceImpl implements StudentDayService {
@Autowired
StuDayMapper stuDayMapper;
@Autowired
StudentMapper studentMapper;
@Autowired
SemesterMapper semesterMapper;

@Override
public void insertStuDayList(List<StuDay> studaylist) {
	
	stuDayMapper.insertStuDayList(studaylist);
}

@Override
public List<StuDay> countLastWeekStuDay( Map<String,String> countDate) {
	
	return stuDayMapper.countLastWeekStuDay(countDate);
}

@Override
public List<Semester> semesterList() {
	
	return stuDayMapper.semesterList();
}

@Override
public Map<Integer, Integer> getNWeek(int n) {
	int j=n;
	Map<Integer, Integer> weekMap=new HashMap<Integer,Integer>();		
	for (int i =1; i<=n; i++) {	
		weekMap.put(j,i);
		j--;
	}
	return weekMap;
}

@Override
public Map getMap(int nWeek) {
	//日期获取对象
	WeekUtils cd = new WeekUtils();
	//获取班级列表
    List<Classs> classList=studentMapper.selectClasssList();
    //获取当前学期
    List<Semester> semesters=semesterMapper.findSemesters();
  //上周
    int lastWeek=semesters.get(0).getWhatWeek()-1;
    //判断是否有查询条件
    if(nWeek==0){
    	nWeek=lastWeek;
    }
    //获取所有周  和 上N周  Key/value
    Map<Integer,Integer> weekMap=getNWeek(lastWeek);
    //获取前N周的时间段
    Map<String,String>nWeekDateMap=cd.getNTimeInterval(weekMap.get(nWeek));
    //存放所需信息
    Map Map=new HashMap();
    Map.put("whatWeek", lastWeek);
    Map.put("classList", classList);
    Map.put("semester", semesters.get(0));
    Map.put("weekMap", weekMap);
    //存储周
    Map.put("nWeek", nWeek);
    Map.put("nWeekDateMap", nWeekDateMap);
	return Map;
}

@Override
public List<Student> selectBrcord(Map sqlMap) {
	
	return stuDayMapper.selectBrcord(sqlMap);
}

@Override
public List<BRecord> selectBrcordList(Map sqlMap) {
	// TODO 自动生成的方法存根
	return stuDayMapper.selectBrcordList(sqlMap);
}
}
