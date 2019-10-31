<head>
		<meta charset="utf-8" />
		<title>巴士币——班级</title>
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
				<@_left.coin 2/>
				<div class="col-md-10">
					<h2>周先进班级</h2>
					<hr>
					<@shiro.hasAnyRoles name='班主任,政教处'>
					<form method="post" action="" id="formId" class="form-inline">
						<div clss="well" >
					      <div class="form-group">
					      </div>
					     <span class="">
					     年级：
					     		<select class="form-control" id="gradeName" name="gradeName">
				        		 <option value='1'>七年级</option>
				        		 <option value='2'>八年级</option>
				        		 <option value='3'>九年级</option>
				       			 </select>
				       		    <#assign weekMap= stuDayMap["weekMap"]/>
						  		 <#assign nWeek= stuDayMap["nWeek"]/>
						  		 <#assign classWeekAdvancedList= stuDayMap["classWeekAdvancedList"]/>
						  		  <#assign gradeName= stuDayMap["gradeName"]/>
						  		   <script>					      
					        $("#gradeName").val(${gradeName});
					        </script>
				       			 <span>第</span>
					        <select class="form-control" id="week" name="nWeek">
					        <#list weekMap?keys as key>
					        <option value="${key}">${key}</option>
					        </#list>
					        </select>
					        <span>周</span>
					         <#if nWeek??>
					        <script>					      
					        $("#week").val(${nWeek});
					        </script>
					        </#if>
					        
				         		<button type="submit"  class="btn btn-primary">查询</button>
								 
				       			 <span id="Promote" style="display: none;">
					       			 点数:<input id="points" type="text" value="0" style="width: 30px;" name="points">
					       		</span>
				         <button id="coinButton" class="btn btn-primary" type="button"   onclick="addClassCoin()">分配周先进币</button>		
		         		
				         </span>    
				        </div>     
				        </form>
			
					<hr>
					  <#if classWeekAdvancedList?exists && classWeekAdvancedList?size gt 0 >
					<table class="table table-bordered">
					<tr>
					<th>班级</th>
					<th>分数</th>
					<th>排名</th>
					</tr>
					<#list classWeekAdvancedList as item>
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
					        ${item.className}</th>
					<th>${item.total?string("#.##")}</th>
					<th>${item.rank}</th>
					<tr>
					</#list>
					
					</table>
					<#else>
						<tr>
							<td class="text-center danger" colspan="4">没有找到日常信息</td>
						</tr>
					</#if>
				<script>
				function addClassCoin(){ 
				var gradeName=$('#gradeName').val();
				var data=${nWeek}+","+gradeName;
				$.getJSON('${basePath}/coin/insertAdvancedClass.shtml',{data:data},function(data,textStatus,jqXHR){
    			alert(data.result); 
    			 window.location.reload();
			});
				}
				</script>
						</@shiro.hasAnyRoles>
					<table class="table table-bordered">
					
					</table>
							<#if page?exists>
						<div class="pagination pull-right">
							${page.pageHtml}
						</div>
					</#if>
			</div>
			<#--/row-->
		</div>

	</body>
