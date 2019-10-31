<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8" http-equiv="Content-Type" content="multipart/form-data" ;/>
<title>我的成绩—成绩信息</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
<link rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="${basePath}/favicon.ico" />
<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet" />
<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet" />
<script src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
<script src="${basePath}/js/common/layer/layer.js"></script>
<script src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="${basePath}/js/shiro.demo.js"></script>
</head>
<body data-target="#one" data-spy="scroll">
	<@_top.top 6/>
	<div class="container"
		style="padding-bottom: 15px; min-height: 300px; margin-top: 40px;">
		<div class="row">
			<@_left.score 1/>
			<div class="col-md-10">
				<h2>成绩列表</h2>
				<hr />
				<table class="table table-bordered">
					<tr>
						<th>考试名字</th>
						<th>姓名</th>
						<th>语文</th>
						<th>数字</th>
						<th>英语</th>
						<th>政治</th>
						<th>历史</th>
						<th>地理</th>
						<th>物理</th>
						<th>化学</th>
						<th>生物</th>
						<th>总分</th>
						<th>平均分</th>
					</tr>
					<#if scoreBos?exists && scoreBos?size gt 0 > <#list scoreBos as it>	
					<tr>
						<td><#if it.semesterName ??>${it.semesterName}<#else>未录入</#if><#if it.examName??>${it.examName}<#else></#if></td>
						<td><#if it.realName ??>${it.realName}<#else>未录入</#if></td>
						<td><#if it.chineseScore ??>${it.chineseScore}<#else>未录入</#if></td>
						<td><#if it.mathScore ??>${it.mathScore}<#else>未录入</#if></td>
						<td><#if it.englishScore ??>${it.englishScore}<#else>未录入</#if></td>
						<td><#if it.politicsScore ??>${it.politicsScore}<#else>未录入</#if></td>
						<td><#if it.historyScore ??>${it.historyScore}<#else>未录入</#if></td>
						<td><#if it.geographyScore ??>${it.geographyScore}<#else>未录入</#if></td>
						<td><#if it.physicsScore ??>${it.physicsScore}<#else>未录入</#if></td>
						<td><#if it.chemistryScore ??>${it.chemistryScore}<#else>未录入</#if></td>
						<td><#if it.biologyScore ??>${it.biologyScore}<#else>未录入</#if></td>
						<td><#if it.sumScore ??>${it.sumScore}<#else>未录入</#if></td>
						<td><#if it.avgScore ??>${it.avgScore?string("#.##")}<#else>未录入</#if></td>
					</tr>
						</#list> <#else>
					<tr>
						<td class="text-center danger" colspan="4">没有找到成绩信息</td>
					</tr>
					</#if>
				</table>
				</form>
			</div>
		</div>
</body>
</html>
