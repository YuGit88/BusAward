package com.zz80z.busAward.system.service;

import java.util.List;

import com.zz80z.busAward.common.model.Award;

public interface AwardService {

	List<Award> selectAll();
	
	Award selectByPrimaryKey(Integer awardId);

    int updateByPrimaryKeySelective(Award record);
    
    int updateByPrimaryKey(Award record);
    
    int insert(Award record);
    
    int insertSelective(Award record);
    
    int deleteByPrimaryKey(Integer awardId);
}
