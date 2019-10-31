<head>
		<meta charset="utf-8" />
		<title>学生日常-管理</title>
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
		function addStudDay(){
				var excelupfile = document.getElementById("excelupfile").files[0]; 
				var formFile = new FormData();
               	formFile.append("file", excelupfile); 
				<#--loding-->
				var data = formFile;
				$.ajax({
                   url: "${basePath}/studay/upstyDay.shtml",
                   data: data,
                   type: "Post",
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
					function coinChange(){
					$("#Promote").hide();
					var coin=$("#coin").val();
					if(coin=="促进"){
					$("#Promote").show();
					}
					$("#coinButton").text("分配"+coin+"币");
					}
					</script>
					
					
				<script>
				function jqchk(){ //jquery获取复选框值 
				var chkValue =[]; 
				$('input[name="stuId"]:checked').each(function(){ 
				chkValue.push($(this).val()); 
				}); 
				if(chkValue.length==0){
				alert("你还没有选择任何学生");
				}else if(chkValue.length>3){
				alert("请选择3个以内的学生");
				}else{
				var data="";
				for(var i=0;i<chkValue.length;i++){
						data+=chkValue[i]+",";			
				}
					var points=$("#points").val();
					var coinType=$("#coin").val();
					if(coinType=="促进"){
					if(points>0){
					var week=$("#week").val();
					var classMark=$("#classs").val();					
					data+=points+","+week+","+classMark+","+coinType;
					$.getJSON("${basePath}/studay/insertCoin.shtml",{data:data},function(data,textStatus,jqXHR){
    				console.log(data); 
    				alert(data.result); 
    		 		window.location.reload();
						});
					
					}else{
					alert("请至少分配一个促进币");
					}
					}else{
					var week=$("#week").val();
					var classMark=$("#classs").val();					
					data+=week+","+classMark+","+coinType;
						$.getJSON("${basePath}/studay/insertCoin.shtml",{data:data},function(data,textStatus,jqXHR){
						console.log(data); 
    					alert(data.result); 
    		 			window.location.reload();
						});
					
					}
				}
				} 
			
					</script>
					
	<script>
						
		  	function bystuDay(){
		 	    var classs=$('#classs').val();
		  		var	week=$('#week').val();
		 		window.location.href="${basePath}/studay/stuDay.shtml?classMark="+classs+"&nWeek="+week;
		  	}
   </script>
				
	</head>
	<body data-target="#one" data-spy="scroll">
		<@_top.top 4/>
		<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 40px;">
			<div class="row">
				<@_left.stu 2/>
				<div class="col-md-10">
					<h2>学生日常</h2>
					<hr>
					<@shiro.hasAnyRoles name='班主任,政教处'>
					<form method="post" action="" id="formId" class="form-inline">
						<div clss="well" >
					      <div class="form-group">
					      <#assign semester= stuDayMap["semester"]/>
						  <#assign classList= stuDayMap["classList"]/>	
						  <#assign pageInfo= stuDayMap["pageInfo"]/>
						   <#assign weekMap= stuDayMap["weekMap"]/>
						   <#assign nWeek= stuDayMap["nWeek"]/>
						   <#assign classMark= stuDayMap["classMark"]/>	
					        <span>${semester.semesterName}</span>&nbsp&nbsp
					        <span>第</span>
					        <select class="form-control" id="week" name="nWeek">
					        <#list weekMap?keys as key>
					        <option value="${key}">${key}</option>
					        </#list>
					        </select>
					         <#if nWeek??>
					        <script>					      
					        $("#week").val(${nWeek});
					        </script>
					        </#if>
					        <span>周</span>&nbsp;&nbsp;
					        <select class="form-control" id="classs" name="classMark">
					        <#list classList as item>
					        <option value=${item.stuClassMark}>
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
					           <#if classMark??>
					        <script>					      
					        $("#classs").val(${classMark});
					        </script>
					        </#if>
					        </select>
					      </div>
					     <span class="">
					     		
				         		<button type="button" onclick="bystuDay()" class="btn btn-primary">查询</button>
				         		<a class="btn btn-primary" onclick="javascript:window.open('${basePath}/studay/creatStuDayExcel.shtml')">下载导入模板</a>
								<a class="btn  btn-danger" onclick="$('#addexcel').modal();" >导入日常信息</a>	
								 <select class="form-control" id="coin" name="cion" onchange="coinChange()">
				        		 <option value='关爱'>关爱之星</option>
				        		 <option value='服务'>服务之星</option>
				        		 <option value='正义'>正义之星</option>
				        		 <option value='诚信'>诚信之星</option>
				        		 <option value='进步'>进步之星</option>
				        		 <option value='促进'>促进奖励</option>
				       			 </select>
				       			 <span id="Promote" style="display: none;">
					       			 点数:<input id="points" type="text" value="0" style="width: 30px;" name="points">
					       		</span>
				         <button id="coinButton" class="btn btn-primary"  type="button"  onclick="jqchk()">分配关爱币</button>		
		         		
				         </span>    
				        </div>     
				        </form>
			
					<hr>
					
				    
						</@shiro.hasAnyRoles>
					<table class="table table-bordered">
					<tr>
					<th>选择</th>
					<th>学号</th>
					<th>姓名</th>
					<th>出勤</th>
					<th>仪容</th>
					<th>早读</th>
					<th>课堂纪律</th>
					<th>违纪处分</th>
					<th>语文</th>
					<th>数学</th>
					<th>英语</th>
					<th>政治</th>
					<th>历史</th>
					<th>地理</th>
					<th>生物</th>
					<th>物理</th>
					<th>化学</th>
					<th>间操</th>
					<th>集会</th>
					<th>升旗</th>
					<th>卫生</th>
					<th>小组</th>
					<th>日期</th>
					</tr>
					<from id="addCoin" action="${basePath}/studay/insertCoin.shtml">
					<#if pageInfo?exists && pageInfo.list?size gt 0 >
					<#list pageInfo.list as stuDay>
					<tr>					
					<th><input type="checkBox" name="stuId" value="${stuDay.stuId}"></th>					
					<th>${stuDay.student.stuNo}</th>
					<th>${stuDay.student.realName}</th>
					<th>${stuDay.attendance}分</th>
					<th>${stuDay.appearance}分</th>
					<th>${stuDay.morning}分</th>
					<th>${stuDay.discipline}分</th>
					<th>${stuDay.punishment}分</th>
					<th>${stuDay.chinese}分</th>
					<th>${stuDay.math}分</th>
					<th>${stuDay.english}分</th>
					<th>${stuDay.politics}分</th>
					<th>${stuDay.history}分</th>
					<th>${stuDay.geography}分</th>
					<th>${stuDay.biology}分</th>
					<th>${stuDay.physics}分</th>
					<th>${stuDay.chemistry}分</th>
					<th>${stuDay.cexercise}分</th>
					<th>${stuDay.assembly}分</th>
					<th>${stuDay.flag}分</th>
					<th>${stuDay.health}分</th>
					<th>${stuDay.student.stuGroup}</th>
					<th>${nWeek}周</th>
					</tr>
					</#list>
					 <#else>
						<tr>
							<td class="text-center danger" colspan="4">没有找到日常信息</td>
						</tr>
						</#if>
					</from>
					</table>
						
						<div id="page" style="margin-top: 50px">
				    <span>当前显示第&nbsp;${pageInfo.getPageNum()}&nbsp;页,共&nbsp${pageInfo.getTotal()}&nbsp条记录</span>
				    	<div class="pagination pagination-centered">
				  <ul >
				  <#if  pageInfo.isFirstPage==false>
				  <a href="${basePath}/studay/stuDay.shtml?pn=${pageInfo.prePage}&nWeek=${nWeek}&classMark=${classMark}">上页</a>
				  </#if>
						<#list pageInfo.navigatepageNums as item>
						<a href="${basePath}/studay/stuDay.shtml?pn=${item}&nWeek=${nWeek}&classMark=${classMark}">${item}</a>
						</#list>
						
						  <#if  pageInfo.hasNextPage==true>
				  <a href="${basePath}/studay/stuDay.shtml?pn=${pageInfo.nextPage}&nWeek=${nWeek}&classMark=${classMark}">下页</a>
				  </#if>
					  </ul>
					  </div>
						 </div>
					<#--添加学生弹框-->
			<div class="modal fade bs-example-modal-sm"  id="addStudent" tabindex="-1" role="dialog" aria-labelledby="selectPermissionLabel">
			  <div class="modal-dialog modal-sm" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title">添加学生</h4>
			      </div>
			      <div class="modal-body">
			    <form action="${basePath}/student/insert.shtml" id="insertStu">
		
			</form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="button" onclick="tj();" class="btn btn-primary">Save</button>
			      </div>
			    </div>
			  </div>
			</div>
			<#--/弹框-->
								<#--导入Excel弹框-->
			<div class="modal fade bs-example-modal-sm"  id="addexcel" tabindex="-1" role="dialog" aria-labelledby="selectPermissionLabel">
			  <div class="modal-dialog modal-sm" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title">添加日常信息</h4>
			      </div>
			      <div class="modal-body">
					<form action="${basePath}/student/upfile.shtml" encType="multipart/form-data" method="post" >
						<input id="excelupfile" type="file" name="excel" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel" />					
						</form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="button" onclick="addStudDay()" class="btn btn-primary">Save</button>
			      </div>
			    </div>
			  </div>
			</div>
			<#--/弹框-->
			</div>
			<#--/row-->
		</div>

	</body>
