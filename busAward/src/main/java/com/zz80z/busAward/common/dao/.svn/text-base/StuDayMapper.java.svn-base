package com.zz80z.busAward.common.dao;

import java.util.List;
import java.util.Map;

import com.zz80z.busAward.common.model.BRecord;
import com.zz80z.busAward.common.model.Semester;
import com.zz80z.busAward.common.model.StuDay;
import com.zz80z.busAward.common.model.Student;

public interface StuDayMapper {
    int deleteByPrimaryKey(Integer stuDayId);

    int insert(StuDay record);

    int insertSelective(StuDay record);

    StuDay selectByPrimaryKey(Integer stuDayId);

    int updateByPrimaryKeySelective(StuDay record);

    int updateByPrimaryKey(StuDay record);
    
	//学生日常批量插入
	public void insertStuDayList(List<StuDay>studaylist);
	
	//统计上周学生日常
	public List<StuDay> countLastWeekStuDay(Map<String,String> countDate);
	
	//获取学期列表
	public List<Semester> semesterList();
	
    //查询当前学生是否已经分配星级币
    public List<Student> selectBrcord(Map sqlMap);
    
    //查询当前周星级币分配的数量
    public List<BRecord> selectBrcordList(Map sqlMap);
}