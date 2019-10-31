<head>
		<meta charset="utf-8" />
		<title>班级日常——管理</title>
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
		<link   rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
		<link   rel="shortcut icon" href="${basePath}/favicon.ico" />
		<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet"/>
		<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet"/>
		<script  src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
		<script  src="${basePath}/js/common/layer/layer.js"></script>
		<script  src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script  src="${basePath}/js/shiro.demo.js"></script>
		<style type="text/css">  
        .centerdiv {  
            position:absolute;  
            top:50%;  
            left:50%;  
            margin:-100px 0 0 -150px !important;  
            width:300px;  
            height:200px;  
            border:1px;  
        }  
    	</style>  	
	<script>
		function addClasssDay(){
				var excelupfile = document.getElementById("excelupfile").files[0]; 
				var formFile = new FormData();
               	formFile.append("file", excelupfile); 
				<#--loding-->
				var data = formFile;
				$.ajax({
                   url: "${basePath}/classs/upfile.shtml",
                   data: data,
                   type: "Post",
                   contentType: "application/x-www-form-urlencoded; charset=utf-8",  
                   cache: false,<#--上传文件无需缓存-->
                   processData: false,<#--用于对data参数进行序列化处理 这里必须false-->
                   contentType: false, 
                   success: function (result) {
                   if(result=="1"){
                   alert("添加成功");
                   window.location.reload();
                   }else{
                   alert("添加失败，请检查模板后重试");
                   window.location.reload();
                   }
					
                   },
               });
		     }
	</script>
	<script>
  	function byclass(){
 	    var classs=$('#classs').val();
  		var	week=$('#week').val();
 		window.location.href="${basePath}/classs/classsDay.shtml?classMark="+classs+"&nWeek="+week;
  	}
   </script>
	</head>
	<body data-target="#one" data-spy="scroll">
		<@_top.top 5/>
		<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 40px;">
			<div class="row">
				<@_left.class 1/>
				<div class="col-md-10">
					<h2>班级日常列表</h2>
					<hr>
					<@shiro.hasAnyRoles name='班主任,政教处'>
				   	 <#assign semester= ClassDayMap["semester"]/>
					      	 <#assign weekMap= ClassDayMap["weekMap"]/>
					      	 <#assign classList= ClassDayMap["classList"]/>
					      	  <#assign nWeek= ClassDayMap["nWeek"]/>
					      	  <#assign classMark= ClassDayMap["classMark"]/>
					<form method="post" action=""${basePath}/classs/classsDay.shtml" id="formId" class="form-inline">
						<div clss="well">
					      <div class="form-group">
							 <span>${semester.semesterName}</span>&nbsp&nbsp
							  <span>第</span>
					        <select class="form-control" id="week" name="nWeek">
					        <#list weekMap?keys as key>
					        <option value="${key}">${key}</option>
					        </#list>
					        </select>
					      
					        <span>周</span>&nbsp&nbsp
					        <select class="form-control" id="classs" name="classMark">
					        <#list classList as item>
					        <option value=${item.classId}>
							 <#if item.gradeName==1>
							七年级
							</#if>
							<#if item.gradeName==2>
							八年级
							</#if>
							<#if item.gradeName==3>
							九年级
							</#if>
					        ${item.className}</option>
					        </#list>
					      
					        <input type="hidden" class="form-control"  style="width: 300px;" 
					        			 id="findContent" placeholder="">
					      </div>
					     <span class="">
				         		<button type="button" class="btn btn-primary"  onclick="byclass()" >查询</button>
				         		<a class="btn btn-primary" onclick="javascript:window.open('${basePath}/classs/creatClasssDayExcel.shtml')">下载导入模板</a>
								<a class="btn  btn-danger" onclick="$('#addexcel').modal();" >导入日常信息</a>				         		
				         </span>    
				        </div>     
				        </form>
				          <#if nWeek??>
					        <script>
					        $("#week").val(${nWeek});
					        </script>
					        </#if>
					          <#if classMark??>
					        <script>					      
					        $("#classs").val(${classMark});
					        </script>
					        </#if>
					<hr>
					
				    
						</@shiro.hasAnyRoles>
						<#assign pageInfo= ClassDayMap["pageInfo"]/>
						<#assign whatWeek= ClassDayMap["whatWeek"]/>
					<table class="table table-bordered">
					<tr>
					<th>选择</th>
					<th>班级</th>
					<th>纪律</th>
					<th>卫生</th>
					<th>团队活动</th>
					<th>日常活动</th>
					<th>日期</th>
					</tr>
					<#if pageInfo?exists && pageInfo.list?size gt 0 >
					<#list pageInfo.list as classDay>
					<tr>
					<th><input type="checkBox" value="${classDay.classdayId}"></th>
					<th>
					<#if classDay.classs.gradeName==1>
					七年级
					</#if>
					<#if classDay.classs.gradeName==2>
					八年级
					</#if>
					<#if classDay.classs.gradeName==3>
					九年级
					</#if>
					${classDay.classs.className}</th>
					<th>${classDay.discipline}分</th>
					<th>${classDay.health}分</th>
					<th>${classDay.teamActivity}分</th>
					<th>${classDay.dutyActivity}分</th>
					<#assign nWeek= ClassDayMap["nWeek"]/>
					<th>${nWeek}周</th>
					</tr>
					</#list>
					 <#else>
						<tr>
							<td class="text-center danger" colspan="4">没有找到日常信息</td>
						</tr>
						</#if>
					</table>
					
							<div style="margin-top: 50px">
				    <span>当前显示第&nbsp;${pageInfo.getPageNum()}&nbsp;页,共&nbsp${pageInfo.getTotal()}&nbsp条记录</span>
				<div class="pagination pagination-centered">
				  <ul >
				  <#if  pageInfo.isFirstPage==true>
				  <a href="${basePath}/classs/classsDay.shtml?pn=${pageInfo.prePage}&classMark=${classMark}&nWeek=${nWeek}">上页</a>
				  </#if>
						<#list pageInfo.navigatepageNums as item>
						<a href="${basePath}/classs/classsDay.shtml?pn=${item}&classMark=${classMark}&nWeek=${nWeek}">${item}</a>
						</#list>
						
						  <#if  pageInfo.hasNextPage==true>
				  <a href="${basePath}/classs/classsDay.shtml?pn=${pageInfo.nextPage}&classMark=${classMark}&nWeek=${nWeek}">下页</a>
				  </#if>
					  </ul>
					  </div>
					  </div>
								<#--导入Excel弹框-->
			<div class="modal fade bs-example-modal-sm"  id="addexcel" tabindex="-1" role="dialog" aria-labelledby="selectPermissionLabel">
			  <div class="modal-dialog modal-sm" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title">添加班级日常信息</h4>
			      </div>
			      <div class="modal-body">
					<form action="${basePath}/classs/upfile.shtml" encType="multipart/form-data" method="post" >
						<input id="excelupfile" type="file" name="excel" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel" />					
						</form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="button" onclick="addClasssDay()" class="btn btn-primary">Save</button>
			      </div>
			    </div>
			  </div>
			</div>
			<#--/弹框-->
			</div>
			<#--/row-->
		</div>

	</body>
