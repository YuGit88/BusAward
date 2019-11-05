<head>
		<meta charset="utf-8" />
		<title>奖励信息</title>
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
					<h2>奖励列表</h2>
					<hr>
					<form method="post" action="${basePath}/sys/awardId.shtml" class="form-inline">
						<div clss="well">
					        <input type="text" class="form-control" name="awardId" placeholder="请输入奖励编号" />
						     <span class="">
					         	<button type="submit" class="btn btn-primary">查询</button>
					         		<a class="btn btn-success" onclick="$('#insertAwd').modal();">新增奖励内容</a>
					         </span>    
				        </div>
				    </form>
			  
				<hr>
<table class="table table-bordered">
	<tr>
		<th>全选<br><input type="checkbox" id="checkAll"/></th>
		<th>奖励编号</th>
		<th>先进小组</th>
		<th>进步小组</th>
		<th>达标</th>
		<th>年级第一</th>
		<th>优秀</th>
		<th>单科状元</th>
		<th>先进年级</th>
		<th>先进班级</th>
		<th>活动</th>
		<th>活动第一名</th>
		<th>活动第二名</th>
		<th>活动第三名</th>
		<th>周币</th>
		<th>操作</th>
	</tr>
	<#if pageInfo?exists && pageInfo.list?size gt 0 >
	<#list pageInfo.list as it>
		<tr>
				<td><input value="${it.awardId}" type="checkbox"  name="ids"/></td>
				<td>${it.awardId}</td>
				<td>${it.advancedGroup}</td>
				<td>${it.progressGroup}</td>
				<td>${it.level}</td>
				<td>${it.firstBest}</td>
				<td>${it.firstBetter}</td>
				<td>${it.firstSubject}</td>
				<td>${it.progressGrade}</td>
				<td>${it.progressClass}</td>
				<td>${it.activiytDuty}</td>
				<td>${it.activiytFirst}</td>
				<td>${it.activiytSecond}</td>
				<td>${it.activiytThird}</td>
				<td>${it.weekCoin}</td>
				<td>&nbsp;
					<a class="btn btn-danger" onclick="deleteAwd(${it.awardId})" >删除</a>
				</td>
		</tr>
	</#list>
	</#if>
</table>

	<div class="col-md-6" style="margin-top: 50px">
    	<span>当前显示第&nbsp;${pageInfo.getPageNum()}&nbsp;页,共&nbsp${pageInfo.getTotal()}&nbsp条记录,共&nbsp;${pageInfo.getPages()}&nbsp;页</span>
		<div class="pagination pagination-centered" >
		   <ul class="bottom" >
			  	<a href="${basePath}/sys/awdUp.shtml?pn=1">首页</a>
			  <#if  pageInfo.isFirstPage==false>
			  		<a href="${basePath}/sys/awdUp.shtml?pn=${pageInfo.prePage}">上一页</a>
			  	</#if>
					<#list pageInfo.navigatepageNums as item>
						<a href="${basePath}/sys/awdUp.shtml?pn=${item}">${item}</a>
					</#list>
				<#if  pageInfo.hasNextPage==true>
			  		<a  href="${basePath}/sys/awdUp.shtml?pn=${pageInfo.nextPage}">下一页</a>
			  </#if>
			  		<a href="${basePath}/sys/awdUp.shtml?pn=${pageInfo.getPages()}">末页</a>
			</ul>
		</div>
	</div>	
		</div>
			</div>
		</div>
			<!-- 添加奖励信息 -->		  
			<div class="modal fade bs-example-modal-sm"  id="insertAwd" tabindex="-1" role="dialog" aria-labelledby="selectPermissionLabel">
			  <div class="modal-dialog modal-sm" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title">添加奖励信息</h4>
			      </div>
			      <div class="modal-body">
			    <form method="post" action="" id="addAward">
			      <ul>
					<li>先进小组：<br><input type="text" name="advancedGroup" id="advancedGroup"/></li>
					<li>进步小组：<br><input type="text" name="progressGroup" id="progressGroup"/></li>
					<li>达标：<br><input type="text" name="level" id="level"/></li>
					<li>年级第一：<br><input type="text" name="firstBest" id="firstBest"/></li>
					<li>优秀：<br><input type="text" name="firstBetter" id="firstBetter"/></li>
					<li>单科状元：<br><input type="text" name="firstSubject" id="firstSubject"/></li>
					<li>先进年级：<br><input type="text" name="progressGrade" id="progressGrade"/></li>
					<li>先进班级：<br><input type="text" name="advancedClass" id="advancedClass"/></li>
					<li>进步班级：<br><input type="text" name="progressClass" id="progressClass"/></li>
					<li>活动：<br><input type="text" name="activiytDuty" id="activiytDuty"/></li>
					<li>活动第一名：<br><input type="text" name="activiytFirst" id="activiytFirst"/></li>
					<li>活动第二名：<br><input type="text" name="activiytSecond" id="activiytSecond"/></li>
					<li>活动第三名：<br><input type="text" name="activiytThird" id="activiytThird"/></li>
					<li>周币：<br><input type="text" name="weekCoin" id="weekCoin"/></li>
				  </ul>
				</form>
			   </div>
			    <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="button" onclick="addAwd()" class="btn btn-primary">Save</button>
			      </div>
			    </div>
			  </div>
			</div>
			
			<!-- 添加奖励信息的ajax请求 -->
			 <script>
				   function addAwd(){
						$.getJSON('${basePath}/sys/addAwd.shtml',$('#addAward').serialize(),function(data,textStatus,jqXHR){
				    		console.log(data);
				    		alert(data.message); 
				    		 window.location.reload();
							});
				   }
   			</script>
   			<!-- 删除奖励信息的ajax请求 -->
   			<script>
				    function deleteAwd(awardId){   
				        confirm_ = confirm('您确定要删除该条奖励信息数据,请谨慎考虑.');
				        if(confirm_){
				        	 $.ajax({
				                 type:"GET",
				                 url:'${basePath}/sys/deleteAwd.shtml?awardId='+awardId,
				                 datatype:"json",
				                 success:function(data){
				                     alert(data.message);
				                     window.location.reload();
				                 }
				             });
				        }
				    };
				    
				    function UPAwd(awardId){
				    	alert(awardId);  
				    	$("#upId").val("");
				    	$("#upId").attr("value",awardId);
				    	$('#updateAwrd').modal("show");
				    };
			</script>
</body>