<head>
		<meta charset="utf-8" />
		<title>学期设置</title>
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
		<link   rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
		<link   rel="shortcut icon" href="${basePath}/favicon.ico" />
		<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet"/>
		<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet"/>
		<script  src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
		<script  src="${basePath}/js/common/jquery/jquery.form-2.82.js"></script>
		<script  src="${basePath}/js/common/layer/layer.js"></script>
		<script  src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script  src="${basePath}/js/shiro.demo.js"></script>
		<script src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
</head>

<body >
<#--引入头部-->
		<@_top.top 2/>
				
<table border="1">
					
					<tr>
					<th>选择</th>
					<th>学期名</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>休息时间</th>
					<th>操作</th>
					</tr>
					<#list sem as semeste>
					<tr>	
					<th><input type="checkbox" value="${semeste.semesterId}"></th>					
					<th>${semeste.semesterName}</th>	
					<th>${semeste.creatTime?string('yyyy-MM-dd HH:mm:ss')}</th>	
					<th>${semeste.recessTime?string('yyyy-MM-dd HH:mm:ss')}</th>	
					<th>${semeste.reserve}</th>
					<th>
					<a href="#">编辑</a>
					</th>
					<th>
					<a href="#">删除</a>
					</th>
					</tr>
					</#list>

</body>