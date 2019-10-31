<head>
		<meta charset="utf-8" />
		<title>我的班级</title>
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
		<link   rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
		<link   rel="shortcut icon" href="${basePath}/favicon.ico" />
		<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet"/>
		<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet"/>
		<script  src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
		<script  src="${basePath}/js/common/layer/layer.js"></script>
		<script  src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script  src="${basePath}/js/shiro.demo.js"></script>
	
	</head>
	<script>

	</script>
	<script>
		function flagChart(){
		var classMark=$("#classs").val();
		alert(classMark);
				$.ajax({
					type:"POST",
					url:"${basePath}/StuDayChart/returnStuDayChart.shtml",
					contentType:"application/json;charset=utf-8",
					data:classMark,
					success:function(data){
					alert(data);
					}
					})
			}
		</script>
	<body data-target="#one" data-spy="scroll">
		<@_top.top 4/>
		<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 40px;">
			<div class="row">
				<@_left.stu 3/>
				<div class="col-md-10">
					<h2>我的班级</h2>
					<hr>
					<@shiro.hasAnyRoles name='学生'>
					<form method="post" action="" id="formId" class="form-inline">
						<div clss="well" >
					      <div class="form-group">
						<div>
						<table class="table table-bordered">
						<tr>
						<th>班级名称</th>
						<th>班级类别</th>
						</tr>
						<tr>
						<th><#if classs.gradeName==1>
							七年级
							</#if>
							<#if classs.gradeName==2>
							八年级
							</#if>
							<#if classs.gradeName==3>
							九年级
							</#if>${classs.className}</th>
							<th><#if classs.classCategory=='A'>
									实验班
										</#if>
										<#if classs.classCategory=='B'>
									重点班
										</#if>
										<#if classs.classCategory=='C'>
									平行班
										</#if></th>
						</tr>
						<tr>
						
						</tr>
						</table>
						</div>
					      </div>
					     <span class="">
				         		
				        </div>     
				        </form>
					<hr>
						</@shiro.hasAnyRoles>

	</body>
