<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8" http-equiv="Content-Type" content="multipart/form-data" ;/>
<title>成绩列表—成绩信息</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
<link rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="${basePath}/favicon.ico" />
<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet" />
<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet" />
<script src="${basePath}/js/common/jquery/jquery-3.2.1.js"></script>
<script src="${basePath}/js/common/layer/layer.js"></script>
<script src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="${basePath}/js/shiro.demo.js"></script>
<style>
	span{color:blue}
</style>
<script>
		so.init(function(){
				//初始化全选。
				so.checkBoxInit('#checkAll','[check=box]');
				//全选
				so.id('deleteAll').on('click',function(){
					var checkeds = $('[check=box]:checked');
					if(!checkeds.length){
						return layer.msg('请选择要删除的选项。',so.default),!0;
					}
					var array = [];
					checkeds.each(function(){
						array.push(this.value);
					});
					return deleteById(array);
				});
			});
			function addScore(){
				var examName = $('#examName').val(),
					gradeId = $('#gradeId').val(),
					scoreExcel = document.getElementById("scoreExcel").files[0]; 
				var formFile = new FormData();
				if($.trim($('#scoreExcel').val()) == ''){
					return layer.msg('请选择文件吧',so.default),!1;
				}
               	formFile.append("file", scoreExcel); 
               	formFile.append("examName", examName); 
               	formFile.append("gradeId", gradeId); 
				var data = formFile;
				var load = layer.load();
				$.ajax({
                   url: "${basePath}/score/leadScore.shtml",
                   data: data,
                   type: "Post",
                   cache: false,
                   processData: false,
                   contentType: false, 
                   beforeSend:function(){
			        		layer.msg('正在导入..');
			        	},
                   success: function (result) {
                   		layer.close(load);
						if(result && result.status != 200){
							return layer.msg(result.message,so.default),!1;
						}
						layer.msg(result.message);
						if(result && result.mark == 300){
							var r=confirm("确定现在分配"+ result.semester+ result.exam+result.grade+"学生的巴士币？")
							var examName = result.semester+ result.exam+result.grade;
							if (r==true)
							    {
							    window.location.href="${basePath}/score/allotScoreCoin.shtml?examName="+examName;
							    }
						}
						setTimeout(function(){
							$('#formId').submit();
						},1000);
						return allotScoreCoin(result.examName);
                   },
               });
		     }
		     <#--获得班级所拥有的学期-->
		     window.onload=function(){
		     var classMark = $('#findClass').val();
					$.post('${basePath}/sys/selectSemesterByClassMark.shtml',{classMark:classMark}, function(data) {
						$("#findSemester").empty();
				  		$.each(data.semesters,function(){
				  			var semesterOption = $("<option></option>").append(this.semesterName).attr("value",this.semesterId);
				  			semesterOption.appendTo("#findSemester");
				  		});
				  });
			}
		     
		     $(function(){
		     	$('#findClass').change(function() {
		     		var classMark = $('#findClass').val();
					$.post('${basePath}/sys/selectSemesterByClassMark.shtml',{classMark:classMark}, function(data) {
						$("#findSemester").empty();
				  		$.each(data.semesters,function(){
				  			var semesterOption = $("<option></option>").append(this.semesterName).attr("value",this.semesterId);
				  			semesterOption.appendTo("#findSemester");
				  		});
				  });
				});
		     });
		</script>
</head>
<body data-target="#one" data-spy="scroll">
	<@_top.top 6/>
	<div class="container" style="padding-bottom: 15px; min-height: 300px; margin-top: 40px;">
		<div class="row">
			<@_left.score 1/>
			<div class="col-md-10">
				<h3>成绩列表</h3>
				<hr />
				<form method="post" action="" id="formId" class="form-inline">
					<div clss="well">
						<div class="form-group">
							<div class="form-group">
								<label for="recipient-name" class="control-label">班级:</label>
								<select class="form-control" data-style="btn-primary" name="findClass" id="findClass">
									<#list classses as it>
									<option value="${it}">${it}</option>
									</#list>
								</select>
							</div>
							<div class="form-group">
								<label for="recipient-name" class="control-label">学期:</label>
								<select class="form-control" data-style="btn-primary" name="findSemester" id="findSemester"> 
								</select>
							</div>
							<div class="form-group">
								<label for="recipient-name" class="control-label">考试:</label>
								<select class="form-control" data-style="btn-primary" name="findExam" id="findExam">
									<option value="月考一">月考一</option>
									<option value="期中考试">期中考试</option>
									<option value="月考二">月考二</option>
									<option value="期末考试">期末考试</option>
								</select>
							</div>
						</div>
						<span class="">
							<button type="submit" class="btn btn-primary">查询</button>
							<@shiro.hasPermission name="/score/creatScoreExcel.shtml">
								<a class="btn btn-success" onclick="javascript:window.open('${basePath}/score/creatScoreExcel.shtml')">下载模板</a>
							</@shiro.hasPermission>
							<@shiro.hasPermission name="/score/leadScore.shtml">
								<a class="btn  btn-danger" onclick="$('#addScore').modal();">导入成绩</a>
							</@shiro.hasPermission>
							<!-- <a class="btn btn-success" onclick="javascript:window.open('${basePath}/score/exportScoreExcel.shtml')">导出成绩</a>-->
						</span>
					</div>
					<hr>
					<h4 align="center"><span>${classMark}</span>班<span>${findSemester.semesterName}</span><span>${findExam}</span>成绩表</h4>
					<table class="table table-bordered">
						<tr>
							<th>学号</th>
							<th>姓名</th>
							<th>班级</th>
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
						<#if page?exists && page.list?size gt 0 > <#list page.list as it>
						<tr>
							<td>${it.stuNo}</td>
							<td>${it.realName}</td>
							<td>${it.gradeName}${it.className}</td>
							<td><#if it.chineseScore == (-1)>-<#else>${it.chineseScore}</#if></td>
							<td><#if it.mathScore == (-1)>-<#else>${it.mathScore}</#if></td>
							<td><#if it.englishScore == (-1)>-<#else>${it.englishScore}</#if></td>
							<td><#if it.politicsScore == (-1)>-<#else>${it.politicsScore}</#if></td>
							<td><#if it.historyScore == (-1)>-<#else>${it.historyScore}</#if></td>
							<td><#if it.geographyScore == (-1)>-<#else>${it.geographyScore}</#if></td>
							<td><#if it.physicsScore == (-1)>-<#else>${it.physicsScore}</#if></td>
							<td><#if it.chemistryScore == (-1)>-<#else>${it.chemistryScore}</#if></td>
							<td><#if it.biologyScore == (-1)>-<#else>${it.biologyScore}</#if></td>
							<td>${it.sumScore}</td>
							<td>${it.avgScore?string("#.##")}</td>
						</tr>
						</#list> <#else>
						<tr>
							<td class="text-center danger" colspan="4">没有找到成绩信息</td>
						</tr>
						</#if>
					</table>
					<#if page?exists>
					<div class="pagination pull-right">${page.pageHtml}</div>
					<div class="col-md-6">
						当前第<span>${page.pageNo}</span>页,共<span>${page.totalPage}</span>页，共<span>${page.totalCount}</span>条记录</div>
					</#if>
					
				</form>
			</div>
		</div>

		<div class="modal fade" id="addScore" tabindex="-1" role="dialog"
			aria-labelledby="addroleLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="addroleLabel">导入成绩</h4>
					</div>
					<div class="modal-body">
						<form id="boxScoreImport" enctype="multipart/form-data">
							<div class="form-group">
								<label for="recipient-name" class="control-label">当前学期:</label>
								<input type="text" class="form-control"
									value="${currentSemester.semesterName}" readonly="readonly" />
							</div>
							<div class="form-group">
								<label for="recipient-name" class="control-label">考试名字:</label>
								<select class="form-control" data-style="btn-primary"
									id="examName">
									<option value="1">月考一</option>
									<option value="2">期中考试</option>
									<option value="3">月考二</option>
									<option value="4">期末考试</option>
								</select>
							</div>
							<div class="form-group">
								<label for="recipient-name" class="control-label">选择年级:</label>
								<select class="form-control" data-style="btn-primary" name="gradeId"
									id="gradeId">
									<option value="1">七年级</option>
									<option value="2">八年级</option>
									<option value="3">九年级</option>
								</select>
							</div>
							<div class="form-group">
								<label for="recipient-name" class="control-label">请选择导入文件:</label>
								<input type="file" accept=".xlsx,.xls" id="scoreExcel"
									name="scoreExcel" />
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" onclick="addScore();"
							class="btn btn-primary">Save</button>
					</div>
				</div>
			</div>
		</div>
</body>
</html>
