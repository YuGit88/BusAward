package com.zz80z.busAward.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz80z.busAward.common.dao.SemesterMapper;
import com.zz80z.busAward.common.model.Semester;
import com.zz80z.busAward.system.service.SemesterService;
@Service
public class SemesterServiceImpl implements SemesterService {

	@Autowired
	private SemesterMapper semesterDao;
	@Override
	public Semester selectByCurrent() {
		return semesterDao.selectByCurrent();
	}
	
	@Override
	public int insertSelective(Semester record) {
		return semesterDao.insertSelective(record);
	}

	@Override
	public List<Semester> findSemesters() {
		return semesterDao.findSemesters();
	}

	@Override
	public Semester selectBySemesterName(String semesterName) {
		return semesterDao.selectBySemesterName(semesterName);
	}

	@Override
	public List<Semester> selectBySemesterNames(List<String> semesterNames) {
		return semesterDao.selectBySemesterNames(semesterNames);
	}

	@Override
	public Semester selectByPrimaryKey(Integer semesterId) {
		return semesterDao.selectByPrimaryKey(semesterId);
	}

	@Override
	public List<Semester> selectByYear(String semesterYear) {
		return semesterDao.selectByYear(semesterYear);
	}

}
