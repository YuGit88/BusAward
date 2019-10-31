package com.zz80z.busAward.system.service;

import java.util.List;

import com.zz80z.busAward.common.model.Issue;
import com.zz80z.busAward.common.model.IssueQuesstion;
import com.zz80z.busAward.common.model.Quesstion;

public interface IssueService {

	List<IssueQuesstion> findIssueByUserId(Integer userId);
	
	List<Quesstion> selectByType(String type);

	void updateIssue(List<Issue> issueList);

	void insertIssues(List<Issue> issueList);
	
	Issue selectByPrimaryKey(Integer id);

}
