<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8" />
<title>我的首页 - 校园资讯</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
<link rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="${basePath}/favicon.ico" />
<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet" />
<link href="${basePath}/css/news.css" rel="stylesheet" />
<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet" />
<script src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
<script src="${basePath}/js/common/layer/layer.js"></script>
<script src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="${basePath}/js/shiro.demo.js"></script>
<script>
	</head>
	<body data-target="#one" data-spy="scroll">
		<#--引入头部-->
		<@_top.top 1/>
		<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 40px;">
			<div class="row">
				<#--引入左侧菜单-->
				<@_left.user 1/>
				<div class="col-md-8 ">
					<h4>校园动态</h4>
					<#if category??>
					<span>  ${category}</span>
					</#if>
					<table class="table ">
						<#if page?exists && page.list?size gt 0 >
							<#list page.list as it>
								<tr>
									<td><a href="${basePath}/news/showNews.shtml?newsId=${it.newsId}">${it.newsTittle?default('-')}</a></td>
									<td>${it.newsCreate?string('yyyy-MM-dd HH:mm')}</td>
								</tr>
							</#list>
						<#else>
							<tr>
								<td class="text-center danger" colspan="4">校园快讯还没有内容,去看看其它的吧..</td>
							</tr>
						</#if>
					</table>
					<#if page?exists>
						<div class="pagination pull-right">
							${page.pageHtml}
						</div>
					</#if>
				</div>
				<div class="col-md-2">
					<h4 >校园动态</h4>
						<ul>
							<li><a href="${basePath}/news/index.shtml?category=通知公告">通知公告</a></li>
							<li><a href="${basePath}/news/index.shtml?category=校园快讯">校园快讯</a></li>
							<li><a href="${basePath}/news/index.shtml?category=工作安排">工作安排</a></li>
							<li><a href="${basePath}/news/index.shtml?category=大事记">大事记</a></li>
						</ul>
				</div>
			</div>
			
			</div>
			
	</body>
</html>