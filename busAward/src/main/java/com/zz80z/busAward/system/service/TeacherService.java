package com.zz80z.busAward.system.service;

import java.util.List;
import java.util.Map;
import com.zz80z.busAward.common.model.Teacher;
import com.zz80z.busAward.core.mybatis.page.Pagination;
import com.zz80z.busAward.user.bo.TeacherClassBo;

public interface TeacherService {

	Teacher selectByTchNo(String tchNo);
	
	int deleteByPrimaryKey(Integer tchId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer tchId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
    
    List<Integer> findClassTeacherByTchId(Integer tchId);
    
    Pagination<TeacherClassBo> findTchPage(
    		Map<String, Object> resultMap, Integer pageNo, Integer pageSize);
    
    List<TeacherClassBo> selectTeacherAndClass();
    
    void leadTeacher(List<Teacher> teachers);
    
    Map<String, Object> addClass2Teacher(Integer tchId,String ids);

	int updateTchByTchNo(Teacher teacher);
}
