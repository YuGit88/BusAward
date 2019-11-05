package com.zz80z.busAward.system.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz80z.busAward.common.dao.AwardMapper;
import com.zz80z.busAward.common.model.Award;
import com.zz80z.busAward.system.service.AwardService;

@Service
public class AwardServiceImpl implements AwardService {

	@Autowired
	private AwardMapper awardMapper;
	
	@Override
	public List<Award> selectAll() {
		
		return awardMapper.selectAll();
	}

	@Override
	public Award selectByPrimaryKey(Integer awardId) {

		return awardMapper.selectByPrimaryKey(awardId);

	}

	@Override
	public int updateByPrimaryKeySelective(Award record) {
		record.setAwardId(1);
		return awardMapper.updateByPrimaryKeySelective(record);

	}

	@Override
	public int insert(Award record) {
		
		return awardMapper.insert(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer awardId) {
		
		return awardMapper.deleteByPrimaryKey(awardId);
	}

	@Override
	public int insertSelective(Award record) {
		
		return awardMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKey(Award record) {
		// TODO Auto-generated method stub
		return 0;
	}
}
