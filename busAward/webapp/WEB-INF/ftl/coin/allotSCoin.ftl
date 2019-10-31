<head>
		<meta charset="utf-8" />
		<title>巴士币——学生</title>
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
				
	</head>
	<body data-target="#one" data-spy="scroll">
		<@_top.top 7/>
		<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 40px;">
			<div class="row">
				<@_left.coin 1/>
				<div class="col-md-10">
			 <#assign group= stuCoinMap["group"]/>
					<h2>${group}小组</h2>
					<hr>
					<@shiro.hasAnyRoles name='班主任,政教处'>
					<form method="post" action="" id="formId" class="form-inline">
						<div clss="well">
					      <div class="form-group">
					      <#assign semester= stuCoinMap["semester"]/>
						  <#assign classList= stuCoinMap["classList"]/>	
						  <#assign sTGList= stuCoinMap["sTGList"]/>
						   <#assign weekMap= stuCoinMap["weekMap"]/>
						   <#assign nWeek= stuCoinMap["nWeek"]/>
						   <#assign classMark= stuCoinMap["classMark"]/>		      
					        <span>${semester.semesterName}</span>&nbsp&nbsp
					        <select class="form-control"  onchange="groupChange()" id="group" name="coinGroup">
					        <option value="先进">先进小组</option>
					        <option value="进步">进步小组</option>
					        </select>&nbsp&nbsp
					        <script>	
					        $("#group").val("${group}");
					        </script>
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
					        <#if classMark??>
					        <script>					      
					        $("#classs").val(${classMark});
					        </script>
					        </#if>
					        </select>
					      </div>
					     <span class="">
					     		
				         		<button type="submit"  class="btn btn-primary">查询</button>	
				         		 <button id="groupButton" class="btn btn-primary" type="button"  onclick="insertCoin()">分配${group}币</button>	
				       		
				        </span>    
				        </div>     
				        </form>
				       
					<script>
					function groupChange(){
					var group=$("#group").val();
					$("#groupButton").text("分配"+group+"币");
					}
					</script>
					
					 <script>
					function insertCoin(){
					var group=$("#group").val();
					var data=group+","+${nWeek}+","+${classMark};
    				$.getJSON('${basePath}/coin/insertAdvanced.shtml',{data:data},function(data,textStatus,jqXHR){
    				console.log(data);
    				alert(data.result); 
    				 window.location.reload();
					});
    				
					}
					</script>
				
					<hr>
					
				    
						</@shiro.hasAnyRoles>	
					<table class="table table-bordered">
					
					
					<#if sTGList?exists && sTGList?size gt 0 >
					<#if group=="进步">
					<#if sTGList!="0">
					<tr>
					<th>班级</th>
					<th>小组</th>
					<th>平均分</th>
					<th>进步分数</th>
					<th>日期</th>
					</tr>
					
					<th>
					<#if sTGList.gradeName==1>
					七年级
					</#if>
					<#if sTGList.gradeName==2>
					八年级
					</#if>
					<#if sTGList.gradeName==3>
					九年级
					</#if>
					${sTGList.className}</th>							
					<th>${sTGList.stuGroup}</th>
					<th>${sTGList.total?string("#.##")}</th>
					<th>${sTGList.advancedScore}</th>
					<th>${nWeek}周</th>
					</#if>
					</#if>
					
					<#if group=="先进">
					<tr>
					<th>班级</th>
					<th>小组</th>
					<th>平均分</th>
					<th>名次</th>
					<th>日期</th>
					</tr>
					<#list sTGList as item>
					<tr>
					<th>
					<#if item.gradeName==1>
					七年级
					</#if>
					<#if item.gradeName==2>
					八年级
					</#if>
					<#if item.gradeName==3>
					九年级
					</#if>
					${item.className}	</th>							
					<th>${item.stuGroup}</th>
					<th>${item.total?string("#.##")}</th>
					<th>${item.rank}</th>
					<th>${nWeek}周</th>
					</tr>
					</#list> 
					</#if>
					
					<#else>
						<tr>
							<td class="text-center danger" colspan="4">没有找到日常信息</td>
						</tr>
					</#if>
					</table>
				

	
			
			</div>
			<#--/row-->
		</div>

	</body>
