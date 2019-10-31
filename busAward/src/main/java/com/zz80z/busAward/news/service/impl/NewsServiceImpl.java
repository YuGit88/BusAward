package com.zz80z.busAward.news.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz80z.busAward.common.dao.NewsMapper;
import com.zz80z.busAward.common.model.News;
import com.zz80z.busAward.core.mybatis.BaseMybatisDao;
import com.zz80z.busAward.core.mybatis.page.Pagination;
import com.zz80z.busAward.news.service.NewsService;
@Service
@SuppressWarnings("unchecked")
public class NewsServiceImpl extends BaseMybatisDao<NewsMapper> implements NewsService {

	@Autowired
	NewsMapper newsMapper;

	@Override
	public int insertSelective(News record) {
		return newsMapper.insertSelective(record);
	}



	@Override
	public Pagination<News> findPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize) {
		return super.findByPageBySqlId("selectNewByCategory", resultMap, pageNo, pageSize);
	}



	@Override
	public News selectByPrimaryKey(Integer newsId) {
		return newsMapper.selectByPrimaryKey(newsId);
	}



	@Override
	public int deleteByPrimaryKey(Integer newsId) {
		
		return newsMapper.deleteByPrimaryKey(newsId);
	}



	@Override
	public int updateByPrimaryKeySelective(News record) {
		
		return newsMapper.updateByPrimaryKeySelective(record);
	}
	
	
}
