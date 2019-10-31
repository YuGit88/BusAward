package com.zz80z.busAward.common.dao;

import com.zz80z.busAward.common.model.Issue;
import com.zz80z.busAward.common.model.IssueExample;
import com.zz80z.busAward.common.model.IssueQuesstion;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IssueMapper {
    long countByExample(IssueExample example);

    int deleteByExample(IssueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Issue record);

    int insertSelective(Issue record);

    List<Issue> selectByExample(IssueExample example);

    Issue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Issue record, @Param("example") IssueExample example);

    int updateByExample(@Param("record") Issue record, @Param("example") IssueExample example);

    int updateByPrimaryKeySelective(Issue record);

    int updateByPrimaryKey(Issue record);
    
    List<IssueQuesstion> selectByUserId(Integer userId);
}