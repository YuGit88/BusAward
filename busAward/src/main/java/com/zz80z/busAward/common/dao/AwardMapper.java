package com.zz80z.busAward.common.dao;

import java.util.List;

import com.zz80z.busAward.common.model.Award;

public interface AwardMapper {
	
	List<Award> selectAll();
	
    int deleteByPrimaryKey(Integer awardId);

    int insert(Award record);

    int insertSelective(Award record);

    Award selectByPrimaryKey(Integer awardId);

    int updateByPrimaryKeySelective(Award record);

    int updateByPrimaryKey(Award record);
}