package com.zz80z.busAward.core.classs.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zz80z.busAward.common.model.ClassDay;
import com.zz80z.busAward.common.model.ClassTeacher;
import com.zz80z.busAward.common.model.Classs;
import com.zz80z.busAward.common.model.Grade;
import com.zz80z.busAward.common.model.Group;
import com.zz80z.busAward.common.model.Student;
import com.zz80z.busAward.common.model.Subject;
import com.zz80z.busAward.common.model.Teacher;
import com.zz80z.busAward.core.mybatis.page.Pagination;
import com.zz80z.busAward.user.bo.SubjetTeacher;
import com.zz80z.busAward.user.bo.classAndClassDay;

public interface ClasssService {

	//Excel导入班级日常
	public void classExcel(List<ClassDay> classDayList);
	
	//统计班级日常和班级信息
	public List<ClassDay> countClassDayAndClass(Map<String, String> countDate);
	
	//查询当前年级下学科
	public List<Subject> subjectList(int gradeName);
	
	//修改班级唯一标识---班级升级操作
	public void updateClassMark(Map sqlMap);
	
	int deleteByPrimaryKey(Integer classId);

    int insert(Classs record);

    int insertSelective(Classs record);

    Classs selectByPrimaryKey(Integer classId);

    int updateByPrimaryKeySelective(Classs record);
	
	Pagination<Classs> findPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize);
	
	List<Classs> selectClassByTchId(Integer tchId);

	List<Grade> findList();
	
	List<Classs> findClassList();
	
	List<String> findClassMark(String userName);
	
	List<Classs> findClassByClassName(Map<String,String> map);
	
	int leadClassTeacher(List<ClassTeacher> ClassTeachers);
	
	List<Classs> findByGrade(Map<String, Object> map);
	
	//查询教师和科目
	List<Teacher> selectTeacherAndSubject();
			
	//根据班级名称和唯一标识查询信息是否有重复
	List<Classs> selectClassByClassMarkAndName(Classs classs);
	
	//添加班级
	void insertClass(Classs classs);
	
	//查询当前班级下教师和学科信息
	List<Teacher> selectTeacherAndSubjectByClassId(int classId);
	
	//添加班级教师
	void insertClassTeacer(SubjetTeacher subjetTeacher);
	
	//添加班主任或修改
	void updatOrInsertTchByClassId(Map sqlMap);
	
	//修改or增加班级教师
	void insertClassTeacher(Map sqlMap);

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
	 
	 //删除班级日常信息
	 void deleteClassDay();
	 
	//查询班级日常统计
		public List<classAndClassDay> selectClassChart(Map sqlMap);
	
	List<Classs> selectClassMarkByStr(Map<String, Object> map);

	public List<Student> selectStuByClass(String classMark);

	public List<Group> selecGroupByClass(String classMark);
	
	Classs selectClassByGradeNameAndClassName(Map sqlMap);
	
	public Classs selectMyClass(int stuNo);
}
