package com.zz80z.busAward.student.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.methods.multipart.StringPart;

import com.zz80z.busAward.common.model.StudentChart;

public interface StudentChartService {

	//查询当天的结果
	public Map<Integer, StudentChart> stuDayChartList(Map sqlMap);
	
	//查询周的结果
	public  Map<Integer, StudentChart>  stuWeekChartList(Map sqlMap);
	
	
	//查询月的结果
	public  Map<Integer, StudentChart> stuMothChartList(Map sqlMap);
	
	//查询学期的结果
	public  Map<Integer, StudentChart>  stuSemesterChartList(Map sqlMap);
	//查询班级下全部学生Id
		public String[] selectStuIdByClassId(String classId);
	
	//查询卫生平均分排名
	public Map<String, StudentChart> stuHealthList(Map sqlMap);
	
	//查询纪律平均分排名
	public Map<String, StudentChart> stuDisciplineList(Map sqlMap);
	
	//查询作业平均分排名
	public Map<String, StudentChart> stuTaskList(Map sqlMap);
	
	//查询班级下全部小组
	public String[] selectStuGroupByClassId(String classId);
	
}
