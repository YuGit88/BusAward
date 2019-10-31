<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8" />
<title>我的首页 - 校园资讯</title>
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"
	name="viewport" />
<link rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="${basePath}/favicon.ico" />
<link
	href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}"
	rel="stylesheet" />
<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet" />
<script src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
<script src="${basePath}/js/common/layer/layer.js"></script>
<script src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="${basePath}/js/shiro.demo.js"></script>
<style>
*{
margin:0;
padding:0;
}
#fonta {
	text-align: center;
}
.rig{
width:700px ;
height: 500px;
margin-left: 190px;

}
.new{

width:200px ;
height: 200px;
position: absolute;
right:120px ;
top: 122px;
}
.new h3{
width:100px ;
color:#fafff8;
background:#08c;
}
.imga{
 width: 100%;
 height: 100%;           
 opacity: .3;
 position: fixed;
  z-index: -99;
}
ul{
list-style-type:none;
}
</style>
</head>
<body data-target="#one" data-spy="scroll" >
<img class="imga"; src="${basePath}/images/360.jpg" alt="">
	<#--引入头部--> <@_top.top 1/>
	<div class="container"
		style="padding-bottom: 15px; min-height: 300px; margin-top: 40px;">
		<div class="row">
			<#--引入左侧菜单--> <@_left.user 2/>
			<hr />
			<div class="rig">
				<h5>
					当前位置：><a href="">校园动态</a> ><a href="">${new.category}</a> ><a href="">${new.newsTittle}</a>
				</h5>
				<h3 id="fonta">${new.newsTittle}</h3>
				<p id="fonta">
					<span>责编：${new.newsAuthor}</span> <span>日期：${new.newsCreate?string('yyyy-MM-dd HH:mm')}</span>
				</p>
				<div>
					${new.newsContent}
					<div>
						
					</div>

				</div>
				<div class="new">
							<h3>校园动态</h3>
							<ul>
								<li><a href="${basePath}/news/index.shtml?category=通知公告">通知公告</a></li>
								<li><a href="${basePath}/news/index.shtml?category=校园快讯">校园快讯</a></li>
								<li><a href="${basePath}/news/index.shtml?category=工作安排">工作安排</a></li>
								<li><a href="${basePath}/news/index.shtml?category=大事记">大事记</a></li>
							</ul>
						</div>
			</div>
			
</body>
</html>