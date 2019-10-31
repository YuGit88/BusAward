package com.zz80z.busAward.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zz80z.busAward.common.dao.IssueMapper;
import com.zz80z.busAward.common.dao.QuesstionMapper;
import com.zz80z.busAward.common.model.Issue;
import com.zz80z.busAward.common.model.IssueQuesstion;
import com.zz80z.busAward.common.model.Quesstion;
import com.zz80z.busAward.system.service.IssueService;
@Service
public class IssueServiceImpl implements IssueService {

	@Autowired
	IssueMapper issueMapper;
	@Autowired 
	QuesstionMapper quesstionMapper;
	/**
	 * 查到用户所设置的密保问题
	 */
	@Override
	public List<IssueQuesstion> findIssueByUserId(Integer userId) {
		
		return issueMapper.selectByUserId(userId);
	}
	/**
	 * 分类查到密保问题
	 */
	@Override
	public List<Quesstion> selectByType(String type) {
		
		return quesstionMapper.selectByType(type);
	}
	@Override
	public void updateIssue(List<Issue> issueList) {
		for (Issue issue : issueList) {
			issueMapper.updateByPrimaryKeySelective(issue);
		}
		
	}
	@Override
	public void insertIssues(List<Issue> issueList) {
		for (Issue issue : issueList) {
			issueMapper.insertSelective(issue);
		}
		
	}
	@Override
	public Issue selectByPrimaryKey(Integer id) {
		return issueMapper.selectByPrimaryKey(id);
	}
	
}
