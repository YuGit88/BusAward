<head>
		<meta charset="utf-8" />
		<title>学期信息</title>
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
		
</head>
<body data-spy="scroll">
		<script>
		  $(function() {
		         $("#checkAll").click(function() {
		        /*     alert($("#checkAll").prop("checked")); */
		            if ($("#checkAll").prop("checked")== true) {
		                // 上面的复选框已被选中
		                $(":checkbox[name='ids']").prop("checked", true);
		            } else {
		                // 上面的复选框没被选中
		                $(":checkbox[name='ids']").prop("checked", false);
		            }
		        });
		    });
		</script>
        <#--引入头部-->
		<@_top.top 2/>
		<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 40px;">
			<div class="row">
				<#--引入左侧菜单-->
				<@_left.sys 4/>
				<div class="col-md-10">
					<h2>学期列表</h2>
					<hr>
					<a class="btn btn-success" onclick="$('#addsemester').modal();">新增学期</a>
<table class="table table-bordered" align="center">
<tr>
					<th>选择</th>
					<th>学期名</th>
					<th>开始时间</th>
					<th>结束时间</th>	
					<th colspan="2">操作  </th>
					</tr>
	
					<#list sem as semeste>
					<tr>	
					<th><input type="checkbox" value="${semeste.semesterId}"></th>					
					<th>${semeste.semesterName}</th>	
					<th>${semeste.creatTime?string('yyyy-MM-dd')}</th>	
					<th>${semeste.recessTime?string('yyyy-MM-dd')}</th>	
					
					<th>
					<!-- Button trigger modal -->
<a class="btn btn-success" onclick="$('#updatesemesterById').modal();">修改</a>


					</th>
					<th>
				<a class="btn btn-danger" onclick="deletesemester(${semeste.semesterId})" >删除</a>
					</th>
					</tr>
					</#list>


</table>


<div class="modal fade bs-example-modal-sm"  id="addsemester" tabindex="-1" role="dialog" aria-labelledby="selectPermissionLabel">
			  <div class="modal-dialog modal-sm" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title">添加信息</h4>
			      </div>
			      <div class="modal-body">
			    <form method="post" action="" id="addsemester">
			      <ul>
					<li>学期名：<input type="text" name="semesterName" id="semesterName"/></li>
					<li>开始时间：<input type="date" name="creatTime" id="creatTime"/></li>
					<li>结束时间：<input type="date" name="recessTime" id="recessTime"/></li>
				  </ul>
				</form>
			   </div>
			    <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="button" onclick="addsemester()" class="btn btn-primary">Save</button>
			      </div>
			    </div>
			  </div>
			</div>
			
			 <div class="modal fade bs-example-modal-sm"  id="updatesemesterById" tabindex="-1" role="dialog" aria-labelledby="selectPermissionLabel">
			  <div class="modal-dialog modal-sm" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title">修改信息</h4>
			      </div>
			      <div class="modal-body">
			    <form method="post" action="" id="updatesemesterById">
			      <ul>
					<li>学期名：<input type="text" name="semesterName" id="semesterName"/></li>
					<li>开始时间：<input type="date" name="creatTime" id="creatTime"/></li>
					<li>结束时间：<input type="date" name="recessTime" id="recessTime"/></li>
				  </ul>
				</form>
			   </div>
			    <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="button" onclick="updateTch()" class="btn btn-primary">Save</button>
			      </div>
			    </div>
			  </div>
			</div> 
			<!-- 添加信息的ajax请求 -->
			 <script>
				   function addsemester(){
				    var semesterName=$("#semesterName").val();
				    var creatTime=$("#creatTime").val();
				    var recessTime=$("#recessTime").val();
					if(semesterName=="" || creatTime=="" || recessTime=="" ){
							alert("请将数据补充完整");
					}else{
						$.getJSON('${basePath}/sys/addsemester.shtml',$('#addsemester').serialize(),function(data,textStatus,jqXHR){
				    		console.log(data);
				    		alert(data.scuess); 
				    		 window.location.reload();
							});
					}
				   }
   			</script>
   			<!-- 修改教师信息的ajax请求 -->
			<script>
			 
				   function updatesemesterById(){
					   
					   alert("请谨慎修改您的信息");
						$.getJSON('${basePath}/sys/updatesemesterById.shtml',$('#updatesemesterById').serialize(),function(data,textStatus,jqXHR){
				    		console.log(data);
				    		alert(data.message); 
				    		 window.location.reload();
							});
					}
   			</script>
   			<!-- 删除教师信息的ajax请求 -->
   			<script>
				    function deletesemester(semesterId){   
				        confirm_ = confirm('您确定要删除该条数据?请谨慎考虑.');
				        if(confirm_){
				        	 $.ajax({
				                 type:"GET",
				                 url:'${basePath}/sys/deletesemester.shtml?semesterId='+semesterId,
				                 datatype:"json",
				                 success:function(data){
				                     alert(data.message);
				                     window.location.reload();
				                 }
				             });
				        }
				    };
			</script>
</body>
