package com.zz80z.busAward.system.service;

import java.util.List;
import java.util.Map;
import com.zz80z.busAward.common.model.Grade;
import com.zz80z.busAward.user.bo.GradeAndSubject;
import com.zz80z.busAward.user.bo.SubjectBo;

public interface GradeService {
	
	List<GradeAndSubject> findGradeAndSubject();

	List<SubjectBo> selectSubjectByGradeId(Integer gradeId);
	
	Grade selectByGradeName(String gradeName);
	
	int selectCountByGrade(Map<String, Object> map);
}
