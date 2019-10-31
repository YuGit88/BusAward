package com.zz80z.busAward.score.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz80z.busAward.common.dao.RankMapper;
import com.zz80z.busAward.common.model.Rank;
import com.zz80z.busAward.score.service.RankService;
@Service
public class RankServiceImpl implements RankService{

	
	@Autowired
	private RankMapper rankMapper;
	@Override
	public int insert(List<Rank> ranks) {
		int insertSelective =0;
		for (Rank rank : ranks) {
			rankMapper.insertSelective(rank);
			insertSelective++;
		}
		return insertSelective;
	}

}
