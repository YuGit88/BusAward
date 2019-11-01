<head>
		<meta charset="utf-8" />
		<title>学期设置</title>
</head>

<body>
<table >
					<tr>
					<th>选择</th>
					<th>学期名</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>休息时间</th>
					<th>操作</th>
					</tr>
					<tr>	
					<th><input type="checkbox" value="${sysmester.semesterId}"></th>					
					<th>${sysmester.semesterName}</th>	
					<th>${sysmester.creatTime}</th>	
					<th>${sysmester.recessTime}</th>	
					<th>${sysmester.reserve}</th>
					<th>
					<a href="#">编辑</a>
					</th>
					<th>
					<a href="#">删除</a>
					</th>
					</tr>

</body>