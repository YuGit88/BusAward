package com.zz80z.busAward.news.service;

import java.util.Map;

import com.zz80z.busAward.common.model.News;
import com.zz80z.busAward.core.mybatis.page.Pagination;

public interface NewsService {

	//发布校园资讯
	int insertSelective(News record);
	
	//获得新闻资讯的列表
	Pagination<News> findPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize);
	
	News selectByPrimaryKey(Integer newsId);
	
	int deleteByPrimaryKey(Integer newsId);
	
	int updateByPrimaryKeySelective(News record);
	
}
