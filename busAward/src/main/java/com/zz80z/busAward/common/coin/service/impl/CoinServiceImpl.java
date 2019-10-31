package com.zz80z.busAward.common.coin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz80z.busAward.common.coin.service.CoinService;
import com.zz80z.busAward.common.dao.CoinMapper;
import com.zz80z.busAward.common.model.Award;
import com.zz80z.busAward.common.model.BRecord;
import com.zz80z.busAward.common.model.Coin;
import com.zz80z.busAward.common.model.LastRank;
import com.zz80z.busAward.common.model.Student;
import com.zz80z.busAward.user.bo.ClassWeekAdvanced;
import com.zz80z.busAward.user.bo.StudentAdvancedGroup;

@Service
public class CoinServiceImpl implements CoinService{

	@Autowired
	CoinMapper coinMapper;

	@Override
	public List<StudentAdvancedGroup> lastWeekAdvancedGroup(Map sqlMap) {
		return coinMapper.lastWeekAdvancedGroup(sqlMap);
	}

	@Override
	public List<Student> advancedGroupStudent(Map mapSql) {
		return coinMapper.advancedGroupStudent(mapSql);
	}

	@Override
	public void insertFromCoin(List<Coin> coinList) {
		
		coinMapper.insertFromCoin(coinList);
	}

	@Override
	public void insertFromBRecord(List<BRecord> coinList) {
		
		coinMapper.insertFromBRecord(coinList);
	}

	@Override
	public List<BRecord> selectRecord(Map<String, String> sqlmap) {
		return coinMapper.selectRecord(sqlmap);
	}

	@Override
	public StudentAdvancedGroup selectLastRank(Map<String, String> sqlmap) {
		return coinMapper.selectLastRank(sqlmap);
	}

	@Override
	public List<Student> selectStudentByGroup(Map map) {
	
		return coinMapper.selectStudentByGroup(map);
	}

	@Override
	public Award selectAward() {
		return coinMapper.selectAward();
	}

	@Override
	public List<LastRank> selectLastStuDayRank(Map map) {
		return coinMapper.selectLastStuDayRank(map);
	}

	@Override
	public List<ClassWeekAdvanced> selectAdvancedClass(Map sqlMap) {
		return coinMapper.selectAdvancedClass(sqlMap);
	}

	@Override
	public List<Student> selectStudentByClassMark(String[] classMarks) {
		return coinMapper.selectStudentByClassMark(classMarks);
	}

	@Override
	public Boolean selectBrecordByStuIds(Map sqlMaps) {
		List<BRecord> bRecords=coinMapper.selectBrecordByStuIds(sqlMaps);
		if(bRecords.size()==0){
			return true;
		}else{
			return false;
		}
	
	}

}
