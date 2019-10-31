<head>
		<meta charset="utf-8" />
		<title>教师信息</title>
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
					<h2>教师列表</h2>
					<hr>
					<form method="post" action="${basePath}/sys/teacherUp.shtml" class="form-inline">
						<div clss="well">
					        <input type="text" class="form-control" name="teacherNo" placeholder="教师工号" />
						     <span class="">
					         	<button type="submit" class="btn btn-primary">查询</button>
					         		<a class="btn btn-success" onclick="$('#insertTeacher').modal();">新增教师</a>
					         </span>    
				        </div>
				    </form>
			  
				<hr>
<table class="table table-bordered">
	<tr>
		<th>全选<br><input type="checkbox" id="checkAll"/></th>
		<th>教师工号</th>
		<th>教师名字</th>
		<th>教师电话</th>
		<th>课程名称</th>
		<th>班级名字</th>
		<th>班级编号</th>
		<th>操作</th>
	</tr>
	<#if pageInfo?exists && pageInfo.list?size gt 0 >
	<#list pageInfo.list as it>
		<tr>
				<td><input value="${it.tchId}" type="checkbox"  name="ids"/></td>
				<td>${it.tchNo}</td>
				<td>${it.tchName}</td>
				<td>${it.tchPhone}</td>
				<td>${it.tchSubject}</td>
					
				<#if it.classNames?exists >
					<td>${it.classNames}</td>
				<#else>
						<td>没有找到相关班级信息</td>
				</#if>
				<#if it.classIds?exists >
					<td>${it.classIds}</td>
				<#else>
						<td>没有找到相关班级信息</td>
				</#if>
				<td>&nbsp;
					<a class="btn btn-success" onclick="$('#updateTeacher').modal();">修改</a>
					<a class="btn btn-danger" onclick="deleteTea(${it.tchId})" >删除</a>
				</td>
		</tr>
	</#list>
	<#else>
		<tr>
		       <td>没有</td>
		       <td>找</td>
		       <td>到</td>
		       <td>相</td>
		       <td>关</td>
		       <td>教</td>
		       <td>师</td>
		       <td>信</td>
		       <td>息</td>
		</tr>
	</#if>
</table>

	<div class="col-md-6" style="margin-top: 50px">
    	<span>当前显示第&nbsp;${pageInfo.getPageNum()}&nbsp;页,共&nbsp${pageInfo.getTotal()}&nbsp条记录,共&nbsp;${pageInfo.getPages()}&nbsp;页</span>
		<div class="pagination pagination-centered" >
		   <ul class="bottom" >
			  	<a href="${basePath}/sys/teacherUp.shtml?pn=1">首页</a>
			  <#if  pageInfo.isFirstPage==false>
			  		<a href="${basePath}/sys/teacherUp.shtml?pn=${pageInfo.prePage}">上一页</a>
			  	</#if>
					<#list pageInfo.navigatepageNums as item>
						<a href="${basePath}/sys/teacherUp.shtml?pn=${item}">${item}</a>
					</#list>
				<#if  pageInfo.hasNextPage==true>
			  		<a  href="${basePath}/sys/teacherUp.shtml?pn=${pageInfo.nextPage}">下一页</a>
			  </#if>
			  		<a href="${basePath}/sys/teacherUp.shtml?pn=${pageInfo.getPages()}">末页</a>
			</ul>
		</div>
	</div>	
		</div>
			</div>
		</div>
					  
			<div class="modal fade bs-example-modal-sm"  id="insertTeacher" tabindex="-1" role="dialog" aria-labelledby="selectPermissionLabel">
			  <div class="modal-dialog modal-sm" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title">添加教师信息</h4>
			      </div>
			      <div class="modal-body">
			    <form method="post" action="" id="addTeacher">
			      <ul>
					<li>教师序号：<input type="text" name="tchNo" id="tchNo"/></li>
					<li>教师名字：<input type="text" name="tchName" id="name"/></li>
					<li>教师电话：<input type="text" name="tchPhone" id="phone"/></li>
					<li>课程编号：<input type="text" name="tchSubject" id="subject"/></li>
				  </ul>
				</form>
			   </div>
			    <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="button" onclick="addTch()" class="btn btn-primary">Save</button>
			      </div>
			    </div>
			  </div>
			</div>
			
			<div class="modal fade bs-example-modal-sm"  id="updateTeacher" tabindex="-1" role="dialog" aria-labelledby="selectPermissionLabel">
			  <div class="modal-dialog modal-sm" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title">修改教师信息</h4>
			      </div>
			      <div class="modal-body">
			    <form method="post" action="" id="upTch">
			      <ul>
					<li>教师序号：<input type="text" name="tchNo" id="tchNo"/></li>
					<li>教师名字：<input type="text" name="tchName" id="name"/></li>
					<li>教师电话：<input type="text" name="tchPhone" id="phone"/></li>
					<li>课程编号：<input type="text" name="tchSubject" id="subject"/></li>
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
			<!-- 添加教师信息的ajax请求 -->
			 <script>
				   function addTch(){
				    var tchName=$("#name").val();
				    var phone=$("#phone").val();
				    var tchNo=$("#tchNo").val();
				    var subject1=$("#subject").val();
					if(tchName=="" || phone=="" || tchNo=="" || subject1==""){
							alert("请将数据补充完整");
					}else{
						$.getJSON('${basePath}/sys/addTch.shtml',$('#addTeacher').serialize(),function(data,textStatus,jqXHR){
				    		console.log(data);
				    		alert(data.scuess); 
				    		 window.location.reload();
							});
					}
				   }
   			</script>
   			<!-- 修改教师信息的ajax请求 -->
			<script>
			 
				   function updateTch(){
					   
					   alert("请谨慎修改您的信息,并且教师工号和课程ID必须一样才可以修改");
						$.getJSON('${basePath}/sys/updateTchByTchNo.shtml',$('#upTch').serialize(),function(data,textStatus,jqXHR){
				    		console.log(data);
				    		alert(data.message); 
				    		 window.location.reload();
							});
					}
   			</script>
   			<!-- 删除教师信息的ajax请求 -->
   			<script>
				    function deleteTea(tcheId){   
				        confirm_ = confirm('您确定要删除该条教师数据,请谨慎考虑.');
				        if(confirm_){
				        	 $.ajax({
				                 type:"GET",
				                 url:'${basePath}/sys/deleteTch.shtml?tcheId='+tcheId,
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
