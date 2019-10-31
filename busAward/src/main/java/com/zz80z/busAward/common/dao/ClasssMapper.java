package com.zz80z.busAward.common.dao;

import java.util.List;
import java.util.Map;

import com.zz80z.busAward.common.model.ClassDay;
import java.util.Set;

import com.zz80z.busAward.common.model.Classs;
import com.zz80z.busAward.common.model.Group;
import com.zz80z.busAward.common.model.Student;
import com.zz80z.busAward.core.mybatis.page.Pagination;
import com.zz80z.busAward.user.bo.SubjetTeacher;

public interface ClasssMapper {
	int deleteByPrimaryKey(Integer classId);

	int insert(Classs record);

	int insertSelective(Classs record);

	Classs selectByPrimaryKey(Integer classId);

	int updateByPrimaryKeySelective(Classs record);

	int updateByPrimaryKey(Classs record);

	Pagination<Classs> findPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize);

	List<Classs> selectClassByTchId(Integer tchId);

	List<Classs> findClassList();

	List<String> findClassMark(String userName);

	List<Classs> findClassByClassName(Map<String, String> map);
	
	List<Classs> findByGrade(Map<String, Object> map);
	
	//修改班级唯一标识---班级升级操作
	public void updateClassMark(Map sqlMap);
		
	//根据班级名称和唯一标识查询信息是否有重复
	List<Classs> selectClassByClassMarkAndName(Classs classs);
	
	//添加班级
	void insertClass(Classs classs);
	
	//添加班级教师
	void insertClassTeacer(SubjetTeacher subjetTeacher);
	
	//修改or增加班级教师
	void insertClassTeacher(Map sqlMap);
	
	//添加班主任
		void updatOrInsertTchByClassId(Map sqlMap);
		
	//根据班级Id删除其教师
	void deleteClassTeacherByClassId(int classId);
	
	//根据班级ID查询班主任
	Classs selectClassByClassId(int classId);
	
	//查询班级和教师关联信息
	List<Classs> selectClassAndTeacher(Map sqlMap);
	
	//修改升级前班级状态
		void updateUpClass(Map sqlMap);
		
	//修改升级后学生班级Id
	 void updataUpStudentClassId(Map sqlMap);
	 
	 //修改升级后毕业的学生状态和班级Id
	 void updataUpStudentReasrveAndClassId(Map sqlMap);
	 
	 //查询班级表
	 List<Classs> selectClass();
	 
	 //修改升级后班级教师
	 void updataUpClassTeacher(Map sqlMap);
	
	
	List<Classs> selectClassMarkByStr(Map<String, Object> map);

	List<Student> selectStuByClass(String classMark);

	List<Group> selecGroupByClass(String classMark);
	
	Classs selectClassByGradeNameAndClassName(Map sqlMap);
	
	 Classs selectMyClass(int stuNo);

}