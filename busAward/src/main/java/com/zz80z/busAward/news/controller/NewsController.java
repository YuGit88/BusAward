package com.zz80z.busAward.news.controller;

import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zz80z.busAward.common.controller.BaseController;
import com.zz80z.busAward.common.model.News;
import com.zz80z.busAward.common.utils.LoggerUtils;
import com.zz80z.busAward.core.mybatis.page.Pagination;
import com.zz80z.busAward.news.service.NewsService;

@Controller
@Scope(value="prototype")
@RequestMapping("news")
public class NewsController extends BaseController{

	@Autowired
	NewsService newsService;
	
	
	/**
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="deleteNewsById")
	public Map<String, Object> deleteNewsById(@RequestParam("newsId")Integer id) {
		try {
			int count = newsService.deleteByPrimaryKey(id);
			resultMap.put("status", 200);
			resultMap.put("message", count);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "发布失败，请刷新后再试！");
			LoggerUtils.fmtError(getClass(), e, "新闻删除失败。source[%s]",id);
		}
		return resultMap;
	}
	/**
	 * 校园资讯列表
	 */
	@RequestMapping(value="index")
	public ModelAndView showNewsList(ModelMap modelMap,HttpServletRequest request) {
		String category = request.getParameter("category");
		resultMap.put("category", category);
		modelMap.put("category", category);
		Pagination<News> news = newsService.findPage(resultMap, pageNo, pageSize);
		return new ModelAndView("user/new_index","page",news);
	}
	/**
	 * 快讯单条显示
	 * @param newsId
	 * @return
	 */
	@RequestMapping(value="showNews")
	public ModelAndView showNews(Integer newsId) {
		News news = newsService.selectByPrimaryKey(newsId);
		return new ModelAndView("user/showNews","new",news);
	}
	
	@RequestMapping(value="showNew")
	@ResponseBody
	public Map<String, Object> showNew(@RequestParam("newsId")Integer newsId) {
		News news = newsService.selectByPrimaryKey(newsId);
		resultMap.put("news", news);
		return resultMap;
	}
	
	@RequestMapping(value="newAdd")
	public ModelAndView newAdd() {
		return new ModelAndView("news/newAdd");
		
	}
	
	@ResponseBody
	@RequestMapping("updateNew")
	public Map<String, Object> updateNew(News news ){
		try {
			news.setNewsAlter(new Date());
			
			int count = newsService.updateByPrimaryKeySelective(news);
			resultMap.put("status", 200);
			resultMap.put("message", count);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "更新失败，请刷新后再试！");
			LoggerUtils.fmtError(getClass(), e, "新闻发布失败。source[%s]",news.toString());
		}
		return resultMap;
	}
	/**
	 * 资讯管理
	 */
	@RequestMapping(value = "manageNews")
	public ModelAndView manageNews(ModelMap modelMap) {
		Pagination<News> news = newsService.findPage(resultMap, pageNo, pageSize);
		modelMap.put("page", news);
		return new ModelAndView("news/manageNews");
	}
	/**
	 * 发布校园资讯
	 */
	@RequestMapping(value="addNews")
	@ResponseBody
	public Map<String,Object> addNews(News news,@RequestParam("push")String push) {
		
		try {
			news.setNewsCreate(new Date());
			int count = newsService.insertSelective(news);
			resultMap.put("status", 200);
			resultMap.put("message", count);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "发布失败，请刷新后再试！");
			LoggerUtils.fmtError(getClass(), e, "新闻发布失败。source[%s]",news.toString());
		}
		return resultMap;
	}
}
