package com.zz80z.busAward.score.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz80z.busAward.common.dao.BRecordMapper;
import com.zz80z.busAward.common.model.BRecord;
import com.zz80z.busAward.score.service.RecordService;
@Service
public class RecordServiceImpl implements RecordService{

	@Autowired
	private BRecordMapper recordMapper;
	
	@Override
	public int countByExample(BRecord example) {
		return recordMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BRecord example) {
		return recordMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return recordMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(BRecord record) {
		
		return recordMapper.insert(record);
	}

	@Override
	public int insertSelective(BRecord record) {
		return recordMapper.insertSelective(record);
	}

	@Override
	public List<BRecord> selectByExample(BRecord example) {
		return recordMapper.selectByExample(example);
	}

	@Override
	public BRecord selectByPrimaryKey(Integer id) {
		return recordMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(BRecord record, BRecord example) {
		return recordMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BRecord record, BRecord example) {
		return recordMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BRecord record) {
		return recordMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BRecord record) {
		return recordMapper.updateByPrimaryKey(record);
	}

}
