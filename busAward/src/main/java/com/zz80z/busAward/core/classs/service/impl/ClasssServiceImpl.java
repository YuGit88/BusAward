package com.zz80z.busAward.core.classs.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zz80z.busAward.common.dao.ClassDayMapper;
import com.zz80z.busAward.common.dao.ClassTeacherMapper;
import com.zz80z.busAward.common.dao.ClasssMapper;
import com.zz80z.busAward.common.dao.GradeMapper;
import com.zz80z.busAward.common.dao.TeacherMapper;
import com.zz80z.busAward.common.model.ClassDay;
import com.zz80z.busAward.common.model.ClassTeacher;
import com.zz80z.busAward.common.model.Classs;
import com.zz80z.busAward.common.model.Grade;
import com.zz80z.busAward.common.model.Group;
import com.zz80z.busAward.common.model.Student;
import com.zz80z.busAward.common.model.Subject;
import com.zz80z.busAward.common.model.Teacher;
import com.zz80z.busAward.core.classs.service.ClasssService;
import com.zz80z.busAward.core.mybatis.BaseMybatisDao;
import com.zz80z.busAward.core.mybatis.page.Pagination;
import com.zz80z.busAward.user.bo.SubjetTeacher;
import com.zz80z.busAward.user.bo.classAndClassDay;

@Service
public class ClasssServiceImpl  extends BaseMybatisDao<ClasssMapper>  implements ClasssService {
	@Autowired
	ClassDayMapper classDayMapper;
	@Autowired
	ClasssMapper classsMapper;
	@Autowired
	GradeMapper gradeMapper;
	@Autowired
	ClassTeacherMapper classTeacherMapper;
	@Autowired
	TeacherMapper teacherMapper;
	@Override
	public void classExcel(List<ClassDay> classDayList) {
		
		classDayMapper.classExcel(classDayList);
	}
	@Override
	public List<ClassDay> countClassDayAndClass(Map<String, String> countDate) {
		return classDayMapper.countClassDayAndClass(countDate);
	}
	@Override
	public List<Subject> subjectList(int gradeName) {
		return classDayMapper.subjectList(gradeName);
	}
	@Override
	public void updateClassMark(Map sqlMap) {
		classsMapper.updateClassMark(sqlMap);
	}
	@Override
	@SuppressWarnings("unchecked")
	public Pagination<Classs> findPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}

	@Override
	public int deleteByPrimaryKey(Integer classId) {
		return classsMapper.deleteByPrimaryKey(classId);
	}

	@Override
	public int insert(Classs record) {
		return classsMapper.insert(record);
	}

	@Override
	public int insertSelective(Classs record) {
		return classsMapper.insert(record);
	}

	@Override
	public Classs selectByPrimaryKey(Integer classId) {
		return classsMapper.selectByPrimaryKey(classId);
	}

	@Override
	public int updateByPrimaryKeySelective(Classs record) {
		return classsMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Classs> selectClassByTchId(Integer tchId) {
		
		return classsMapper.selectClassByTchId(tchId);
	}

	@Override
	public List<Grade> findList() {
		return gradeMapper.findList();
	}

	@Override
	public List<Classs> findClassList() {
		
		return classsMapper.findClassList();
	}

	@Override
	public List<String> findClassMark(String userName) {
		
		return classsMapper.findClassMark(userName);
	}

	@Override
	public List<Classs> findClassByClassName(Map<String,String> map) {
		return classsMapper.findClassByClassName(map);
	}

	@Override
	public int leadClassTeacher(List<ClassTeacher> ClassTeachers) {
		int count = 0; 
		for (int i = 0; i < ClassTeachers.size(); i++) {
			ClassTeacher classTeacher = ClassTeachers.get(i);
			count += classTeacherMapper.insert(classTeacher);
		}
		return count;
	}

	@Override
	public List<Classs> findByGrade(Map<String, Object> map) {
		return classsMapper.findByGrade(map);
	}
	@Override
	public List<Teacher> selectTeacherAndSubject() {
		return teacherMapper.selectTeacherAndSubject();
	}
	@Override
	public List<Classs> selectClassByClassMarkAndName(Classs classs) {
		return classsMapper.selectClassByClassMarkAndName(classs);
	}
	@Override
	public void insertClass(Classs classs) {
		classsMapper.insert(classs);
	}
	@Override
	public List<Teacher> selectTeacherAndSubjectByClassId(int classId) {
		return teacherMapper.selectTeacherAndSubjectByClassId(classId);
	}
	@Override
	public void insertClassTeacer(SubjetTeacher subjetTeacher) {
		classsMapper.insertClassTeacer(subjetTeacher);
	}
	@Override
	public void insertClassTeacher(Map sqlMap) {
		classsMapper.insertClassTeacher(sqlMap);
	}
	@Override
	public void updatOrInsertTchByClassId(Map sqlMap) {
		classsMapper.updatOrInsertTchByClassId(sqlMap);
	}
	@Override
	public void deleteClassTeacherByClassId(int classId) {
		classsMapper.deleteClassTeacherByClassId(classId);
	}
	@Override
	public Classs selectClassByClassId(int classId) {
		return classsMapper.selectClassByClassId(classId);
	}
	@Override
	public List<Classs> selectClassAndTeacher(Map sqlMap) {
		return classsMapper.selectClassAndTeacher(sqlMap);
	}
	@Override
	public void updateUpClass(Map sqlMap) {
		classsMapper.updateUpClass(sqlMap);	
	}
	@Override
	public void updataUpStudentClassId(Map sqlMap) {
		classsMapper.updataUpStudentClassId(sqlMap);
	}
	@Override
	public void updataUpStudentReasrveAndClassId(Map sqlMap) {
		classsMapper.updataUpStudentReasrveAndClassId(sqlMap);
	}
	@Override
	public List<Classs> selectClass() {
		return classsMapper.selectClass();
	}
	@Override
	public void updataUpClassTeacher(Map sqlMap) {
		classsMapper.updataUpClassTeacher(sqlMap);
	}
	@Override
	public void deleteClassDay() {
		classDayMapper.deleteClassDay();
	}
	@Override
	public List<classAndClassDay> selectClassChart(Map sqlMap) {
		return classDayMapper.selectClassChart(sqlMap);
	}
	@Override
	public List<Classs> selectClassMarkByStr(Map<String, Object> map) {
		return classsMapper.selectClassMarkByStr(map);
	}
	@Override
	public List<Student> selectStuByClass(String classMark) {
		return classsMapper.selectStuByClass(classMark);
	}
	@Override
	public List<Group> selecGroupByClass(String classMark) {
		return classsMapper.selecGroupByClass(classMark);
	}
	@Override
	public Classs selectClassByGradeNameAndClassName(Map sqlMap) {
		return classsMapper.selectClassByGradeNameAndClassName(sqlMap);
	}
	@Override
	public Classs selectMyClass(int stuNo) {
		return classsMapper.selectMyClass(stuNo);
	}
	
}
