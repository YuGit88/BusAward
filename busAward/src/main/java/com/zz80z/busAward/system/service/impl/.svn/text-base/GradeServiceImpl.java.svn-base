package com.zz80z.busAward.system.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zz80z.busAward.common.dao.GradeMapper;
import com.zz80z.busAward.common.model.Grade;
import com.zz80z.busAward.system.service.GradeService;
import com.zz80z.busAward.user.bo.GradeAndSubject;
import com.zz80z.busAward.user.bo.SubjectBo;
@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeMapper gradeMpper;
	@Override
	public List<GradeAndSubject> findGradeAndSubject() {
		return gradeMpper.findGradeAndSubject();
	}
	@Override
	public List<SubjectBo> selectSubjectByGradeId(Integer gradeId) {
		
		return gradeMpper.selectSubjectByGradeId(gradeId);
	}
	@Override
	public Grade selectByGradeName(String gradeName) {
		return gradeMpper.selectByGradeName(gradeName);
	}
	@Override
	public int selectCountByGrade(Map<String, Object> map) {
		return gradeMpper.selectCountByGrade(map);
	}

}