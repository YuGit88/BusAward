<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8" http-equiv="Content-Type" content="multipart/form-data" ;/>
<title>成绩巴士币分配—成绩信息</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
<link rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="${basePath}/favicon.ico" />
<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet" />
<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet" />
<script src="${basePath}/js/common/jquery/jquery-3.2.1.js"></script>
<script src="${basePath}/js/common/layer/layer.js"></script>
<script src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="${basePath}/js/shiro.demo.js"></script>
</head>
<body data-target="#one" data-spy="scroll">
	<@_top.top 7/>
	<div class="container"style="padding-bottom: 15px; min-height: 300px; margin-top: 40px;">
		<div class="row">
			<@_left.coin 3/>
			<div class="col-md-10">
			<h3>巴士币分配</h3>
			<hr/>
			<h3>${examName}考试成绩计算结果:</h3>
			<div class="col-md-10">
				<h5>本次考试获得单科最优奖励的学生及其成绩为:</h5>
				<table class="table table-hover">
					<tr>
						<th>科目</th>
						<th>分数</th>
						<th>姓名</th>
						<th>学号</th>
					</tr>
					
				<#list subjectBest as it>
					<tr>
						<td>${it.subName}</td>
						<td>${it.score}</td>
						<td>${it.realName}</td>
						<td>${it.stuNo}</td>				
					</tr>
				</#list>
			</div>	
			
			</div>
			 <button class="btn btn-primary" type="button">确认分配此次巴士币</button>
		</div>
	</div>	
</body>
</html>
