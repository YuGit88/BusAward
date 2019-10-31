package com.zz80z.busAward.student.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz80z.busAward.common.dao.StudentMapper;
import com.zz80z.busAward.common.model.StudentChart;
import com.zz80z.busAward.student.service.StudentChartService;
@Service
public class StudentChartServiceImpl implements StudentChartService{
	@Autowired
	StudentMapper studentMapper;
	@Override
	public Map<Integer, StudentChart> stuDayChartList(Map sqlMap) {
		Map<Integer, StudentChart> stuDayCharts=new HashMap<>();
		List<StudentChart> studentCharts=studentMapper.stuDayChartList(sqlMap);
		for (StudentChart studentChart : studentCharts) {
			stuDayCharts.put(studentChart.getStuId(), studentChart);
		}
		return stuDayCharts;
	}
	@Override
	public Map<Integer, StudentChart> stuWeekChartList(Map sqlMap) {
		Map<Integer, StudentChart> stuDayCharts=new HashMap<>();
		List<StudentChart> studentCharts=studentMapper.stuWeekChartList(sqlMap);
		for (StudentChart studentChart : studentCharts) {
			stuDayCharts.put(studentChart.getStuId(), studentChart);
		}
		return stuDayCharts;
	}
	@Override
	public Map<Integer, StudentChart> stuMothChartList(Map sqlMap) {
		Map<Integer, StudentChart> stuDayCharts=new HashMap<>();
		List<StudentChart> studentCharts=studentMapper.stuMothChartList(sqlMap);
		for (StudentChart studentChart : studentCharts) {
			stuDayCharts.put(studentChart.getStuId(), studentChart);
		}
		return stuDayCharts;
	}
	@Override
	public Map<Integer, StudentChart> stuSemesterChartList(Map sqlMap) {
		Map<Integer, StudentChart> stuDayCharts=new HashMap<>();
		List<StudentChart> studentCharts=studentMapper.stuSemesterChartList(sqlMap);
		for (StudentChart studentChart : studentCharts) {
			stuDayCharts.put(studentChart.getStuId(), studentChart);
		}
		return stuDayCharts;
	}
	@Override
	public Map<String, StudentChart>stuHealthList(Map sqlMap) {
		Map<String, StudentChart> stuDayCharts=new HashMap<>();
		List<StudentChart> studentCharts=studentMapper.stuHealthList(sqlMap);
		for (StudentChart studentChart : studentCharts) {
			stuDayCharts.put(studentChart.getStuGroup(), studentChart);
		}
		return stuDayCharts;
	}
	@Override
	public Map<String, StudentChart> stuDisciplineList(Map sqlMap) {
		Map<String, StudentChart> stuDayCharts=new HashMap<>();
		List<StudentChart> studentCharts=studentMapper.stuDisciplineList(sqlMap);
		for (StudentChart studentChart : studentCharts) {
			stuDayCharts.put(studentChart.getStuGroup(), studentChart);
		}
		return stuDayCharts;
	}
	@Override
	public Map<String, StudentChart> stuTaskList(Map sqlMap) {
		Map<String, StudentChart> stuDayCharts=new HashMap<>();
		List<StudentChart> studentCharts= studentMapper.stuTaskList(sqlMap);
		for (StudentChart studentChart : studentCharts) {
			stuDayCharts.put(studentChart.getStuGroup(), studentChart);
		}
		return stuDayCharts;
	}
	@Override
	public String[] selectStuGroupByClassId(String classId) {
		// TODO 自动生成的方法存根
		return studentMapper.selectStuGroupByClassId(classId);
	}
	@Override
	public String[] selectStuIdByClassId(String classId) {
		// TODO 自动生成的方法存根
		return studentMapper.selectStuIdByClassId(classId);
	}


}
