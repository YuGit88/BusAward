package com.zz80z.busAward.score.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz80z.busAward.common.dao.GradeSubjectMapper;
import com.zz80z.busAward.common.dao.SubjectMapper;
import com.zz80z.busAward.common.model.GradeSubject;
import com.zz80z.busAward.common.model.Subject;
import com.zz80z.busAward.common.utils.StringUtils;
import com.zz80z.busAward.core.mybatis.BaseMybatisDao;
import com.zz80z.busAward.score.service.SubjectService;
@Service
public class SubjectServiceImpl extends BaseMybatisDao<SubjectMapper> implements SubjectService {

	@Autowired
	private GradeSubjectMapper gradeSubjectMapper;
	@Autowired
	private SubjectMapper subjectMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer subjectId) {
		return subjectMapper.deleteByPrimaryKey(subjectId);
	}

	@Override
	public int insert(Subject record) {
		return subjectMapper.insert(record);
	}

	@Override
	public int insertSelective(Subject record) {
		return subjectMapper.insertSelective(record);
	}

	@Override
	public Subject selectByPrimaryKey(Integer subjectId) {
		return subjectMapper.selectByPrimaryKey(subjectId);
	}

	@Override
	public int updateByPrimaryKeySelective(Subject record) {
		return subjectMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Subject record) {
		return subjectMapper.updateByPrimaryKey(record);
	}

	@Override
	public Subject selectBySubjectName(String subjectName) {
		return subjectMapper.selectBySubjectName(subjectName);
	}

	@Override
	public List<Subject> findSubjectList(Integer gradeId) {
		return subjectMapper.findSubjectList(gradeId);
	}

	@Override
	public List<Subject> findSubjects() {
		return subjectMapper.findSubjects();
	}
	/**
	 * 验证subjectName是否存在
	 */
	@Override
	public boolean checkSubject(String subjectName) {
		Subject subject = subjectMapper.selectBySubjectName(subjectName);
		return subject==null;
	}

	@Override
	public Map<String, Object> addSubject2Grade(Integer gradeId, String ids) {
		gradeSubjectMapper.deleteByGradeId(gradeId);
		return executePermission(gradeId,ids);
	}

	private Map<String, Object> executePermission(Integer gradeId, String ids) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		int count = 0;
		try {
			//如果ids,permission 的id 有值，那么就添加。没值象征着：把这个角色（roleId）所有权限取消。
			if(StringUtils.isNotBlank(ids)){
				String[] idArray = null;
				
				//这里有的人习惯，直接ids.split(",") 都可以，我习惯这么写。清楚明了。
				if(StringUtils.contains(ids, ",")){
					idArray = ids.split(",");
				}else{
					idArray = new String[]{ids};
				}
				//添加新的。
				for (String sid : idArray) {
					//这里严谨点可以判断，也可以不判断。这个{@link StringUtils 我是重写了的} 
					if(StringUtils.isNotBlank(sid)){
						GradeSubject gradeSubject = new GradeSubject(gradeId,Integer.valueOf(sid));
						count += gradeSubjectMapper.insertSelective(gradeSubject);
					}
				}
			}
			resultMap.put("status", 200);
			resultMap.put("message", "操作成功");
		} catch (Exception e) {
			resultMap.put("status", 200);
			resultMap.put("message", "操作失败，请重试！");
		}
		resultMap.put("count", count);
		return resultMap;
	}

	@Override
	public List<String> findSubjectNames() {
		return subjectMapper.findSubjectNames();
	}
	
}
