package com.zz80z.busAward.system.service.impl;

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
	public Award selectByPrimaryKey(Integer awardId) {

		return awardMapper.selectByPrimaryKey(awardId);

	}

	@Override
	public int updateByPrimaryKeySelective(Award record) {
		record.setAwardId(1);
		return awardMapper.updateByPrimaryKeySelective(record);

	}

}
