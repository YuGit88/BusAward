<head>
		<meta charset="utf-8" />
		<title>学生列表</title>
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
    	 <#--提交查询表单-->
		<script>
		 function disstu(str){
		 if(str==""){
		 $("#gradename").empty();
    	 $("#gradename").append("<option >--请选择--</option>");
		 }else{
		 $.ajax({
    			type:"post",
    			url:"${basePath}/student/gradeselect.shtml",
    			contentType:"application/json;charset=utf-8",
    			data:str,
    			success:function(data){
    				$("#gradename").empty();
    				$("#gradename").append("<option >--请选择--</option>");
    				data.forEach(function(item){ 				
    	                $("#gradename").append("<option value="+item.classId+">"+item.className+"</option>");
    	            }); 
    			}
    		});
     }
		 }	 
		</script>
		 <#--提交添加学生表单-->
		<script type="text/javascript">
        function tj() {     
        	var stuNo=document.getElementById("stuNo").value;
      		var realName=document.getElementById("realName").value;
      		var stuSex=$('input:radio[name="stuSex"]:checked').val();
      		var stuAddress=document.getElementById("stuAddress").value;
      		var stuBirthday=document.getElementById("stuBirthday").value;
      		var classxz=document.getElementById("classxz").value;  
      		var gradename=document.getElementById("gradename").value;
      		var numberId=$('#numberId').val();
      		var nation=$('#nation').val();
      		if(isCardNo(numberId)==false){
      		alert("身份证不合法");
      		}else
      		if(stuNo!=""&&realName!=""&&stuSex!=null&&stuAddress!=""&&stuBirthday!=""&&classxz!=""&&gradename!=""&&nation!=""){
      			$.getJSON('${basePath}/student/insert.shtml',$('#insertStu').serialize(),function(data,textStatus,jqXHR){
    			alert(data.result); 
    		 window.location.reload();
			});
      		}else{
      		alert("请将信息补充完整");
      		}
  
        }
    </script>
     <#--验证身份证号 -->
    <script>
    function isCardNo(card) 
	{ 
	 // 正则表达式 验证中国大陆身份证号码 
	 var idcardReg = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
	  if(idcardReg.test(card)) { 
  	  return true; 
 		 } else{
 		 return false;}
}
    </script>
    <#--提交查询表单-->
	<script>
  	function bystu(){
	$('#formId').submit();
  	}
   </script>
    <#--下载excel模板-->
    <script>
      	function createxcel(){
  	var filename=$("#filename").val();
  	if(filename!=""){
  	$.ajax({
  	 type: "POST",//方法类型
     dataType: "json;charset=utf-8",//预期服务器返回的数据类型
     url: "${basePath}/student/creatExcel.shtml" ,//url
     data: $('#createxcel').serialize(),
     success:function(result){
     alert(result);
                }
  	
  	})
  	}
  	}
    </script>
     <#--excel导入学生信息-->
	<script>
		function addStudent(){
				var excelupfile = document.getElementById("excelupfile").files[0]; 
				var formFile = new FormData();
               	formFile.append("file", excelupfile); 
				<#--loding-->
				var data = formFile;
				$.ajax({
                   url: "${basePath}/student/upfile.shtml",
                   data: data,
                   type: "post",
                   cache: false,<#--上传文件无需缓存-->
                   processData: false,<#--用于对data参数进行序列化处理 这里必须false-->
                   contentType: false, 
                   success: function (result) {
				  alert(result.results);
                    window.location.reload();
                   
                   },
               });
		     }
	</script>
	 <#--修改前数据回显-->
	<script>
	 function stuUpdate(str){
    $.ajax({
      		type:"POST",
      		url:"${basePath}/student/updateStudent.shtml",
      		contentType:"application/json;charset=utf-8",
      		data:str,
      		success:function(date){
      		document.getElementById("Ids").value=date.student.stuId;
      		document.getElementById("stuclassmarks").value=date.student.stuClassMark;
      		document.getElementById("stunos").value=date.student.stuNo;
      		document.getElementById("stunames").value=date.student.realName;
      		document.getElementById("stuAddresss").value=date.student.stuAddress;  
      		var newTime = new Date(date.student.stuBirthday);
			var birthday=newTime.getFullYear()+"-"+newTime.getMonth()+"-"+newTime.getDate();
			<#--$("#stuBirthdays").val(birthday);-->
   			var stusex=date.student.stuSex;
   			if(stusex=="男"){
   			$("#stumans").click();
   			}else{
   			$("#stuwomans").click();
   			}
      		var gradename=date.student.classs.gradeName;
      		var classid=date.student.classs.classId;
			document.getElementById("stuGroups").value=date.student.stuGroup; 
			$("#numberIds").val(date.student.numberId);
			$("#nations").val(date.student.nation);
			$("#stuStates").val(date.student.stuState);
			$("#problemTypes").val(date.student.problemType);
			$("#erroeTypes").val(date.student.erroeTypes);
			$('#updateStudent').modal();
			$("#gradenames").val(gradename);	
			var gradenames=gradename.toString();
			disstus(gradenames,classid);
      		}    
      })
    }
    
	</script>
		 <#--根据年级获取班级ajax-->
		<script>
		 function disstus(str,classid){
		 if(str==""){
		 $("#classnames").empty();
    	 $("#classnames").append("<option >--请选择--</option>");
		 }else{
		 $.ajax({
    			type:"post",
    			url:"${basePath}/student/gradeselect.shtml",
    			contentType:"application/json;charset=utf-8",
    			data:str,
    			success:function(data){
    				$("#classnames").empty();
    				$("#classnames").append("<option >--请选择--</option>");
    				data.forEach(function(item){ 			
    	                $("#classnames").append("<option value="+item.classId+">"+item.className+"</option>");
    	            })   	     
    	           $("#classnames").val(classid);
    			}
    		});
     }
		 }	 
		</script>
		 <#--提交修改表单 + 验证-->
			<script type="text/javascript">
        function uptj() {
        var realname=$("#stunames").val();
        var address=$("#addresss").val();
        var classname=$("#classnames").val();
        var gradename=$("#gradenames").val();
        var numberId=$("#numberIds").val();
        var nation=$("#nations").val();
        var stuState=$("#stuStates").val();
        if(isCardNo(numberId)==false){
        alert("身份证号不合法")
        }else
        if(realname!=""&&address!=""&&classname!=""&&gradename!=""&&nation!=""&&stuState!=""){
        
        	$.getJSON("${basePath}/student/updateStus.shtml",$('#updateStu').serialize(),function(data,textStatus,jqXHR){
    		alert(data.result); 
    		 window.location.reload();
			});
       	 }else{
       	 alert("请将信息补充完整");
       	 }   
        	
        }
    </script>
   
	</head>
	<body data-target="#one" data-spy="scroll">
		<@_top.top 4/>
		<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 40px;">
			<div class="row">
				<@_left.stu 1/>
				<div class="col-md-10">
					<h2>学生列表</h2>
					<hr>
					<@shiro.hasAnyRoles name='班主任,政教处'>
					<form method="post" action="${basePath}/student/stu.shtml" id="formId" class="form-inline">
						<div clss="well">
					      <div class="form-group">
					      <#assign classLists= stuAndClass["classLists"]/>
					       <#assign classId= stuAndClass["classId"]/>
					        <#assign gradeMap= stuAndClass["gradeMap"]/>
					         <select class="form-control" id="classs" name="classId">
					        <#list classLists as item>
					        <option value=${item.classId}>
					         ${gradeMap["${item.gradeName}"]}
					         ${item.className}</option>
					        </#list>
					        </select>
				        	</form>
				        	<#if classId??>
					        <script>					      
					        $("#classs").val(${classId});
					        </script>
					        </#if>
				        	 <input type="text" class="form-control" style="width: 300px;" value="${findContent?default('')}" 
					        			name="findContent" id="findContent" placeholder="输入学生姓名/学号">
					      </div>
					     <span class="">
					     		<button type="submit" onclick="bystu()" class="btn btn-primary">查询</button>
				         		
				         		<a class="btn btn-success" onclick="$('#addStudent').modal();">增加学生</a>
				         		<a class="btn btn-primary" onclick="javascript:window.open('${basePath}/student/creatStudentExcel.shtml')">下载导入模板</a>
								<a class="btn  btn-danger" onclick="$('#addexcel').modal();" >导入学生</a>				         		
				         </span>    
				        	</div>     
					<hr>
					
				    
						</@shiro.hasAnyRoles>
					<table class="table table-bordered">
					<tr>
					<th>选择</th>
					<th>学籍号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>民族</th>
					<!-- <th>生日</th>-->
					<th>班级</th>
					<th>小组</th>
					<th>班级备注</th>
					<th>学生状态</th>
					<th>操作</th>
					
					</tr>
					<#assign pageInfo= stuAndClass["pageInfo"]/>
					<#-- <#assign classList= stuAndClass["classList"]/> -->
					<#-- <#assign gradeName= stuAndClass["gradeName"]/> -->
					<#if pageInfo?exists && pageInfo.list?size gt 0 >
					<#list pageInfo.list as student>
					<tr>	
					<th><input type="checkbox" value="${student.stuId}"></th>					
					<th>${student.stuNo}</th>	
					<th>${student.realName}</th>	
					<th>${student.stuSex}</th>	
					<th>${student.nation}</th>
					<!--<th><#if student.stuBirthday??>
					 ${(student.stuBirthday)?string("yyyy-MM-dd")}
					 <#else>
						暂未设置
					</#if>
						</th>	-->
					<th>
					${gradeMap["${student.classs.gradeName}"]}
					(${student.classs.className})</th>	
					<th><#if student.stuGroup??>
					${student.stuGroup}
					 <#else>
						暂未设置
					</#if>
					</th>
					<th>${student.classs.remark}</th>
					<th>${student.stuState}</th>
					<th><button value="${student.stuId}" class="btn btn-primary" onclick="stuUpdate(this.value)">修改</th>								
					</tr>
					</#list>
					 <#else>
						<tr>
							<td class="text-center danger" colspan="4">没有找到学生信息</td>
						</tr>
						</#if>
					</table>
					
					
					<div style="margin-top: 50px">
				    <span>当前显示第&nbsp;<font color="blue">${pageInfo.getPageNum()}</font>&nbsp;页,共&nbsp<font color="blue">${pageInfo.getTotal()}</font>&nbsp条记录</span>
				 <div class="pagination pagination-centered">
				  <ul >
				  <#if  pageInfo.isFirstPage==true>
				  <a href="${basePath}/student/stu.shtml?pn=${pageInfo.prePage}&classId=${classId}">上页</a>
				  </#if>
						<#list pageInfo.navigatepageNums as item>
						<a href="${basePath}/student/stu.shtml?pn=${item}&classId=${classId}">${item}</a>
						</#list>
						
						  <#if  pageInfo.hasNextPage==true>
				  <a href="${basePath}/student/stu.shtml?pn=${pageInfo.nextPage}&classId=${classId}">下页</a>
				  </#if>
				
					  </ul>
					  </div>
					  <div>
					
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
			<li>学籍号：<input type="text" id="stuNo"  name="stuNo"/></li><br />
			<li>姓名：<input type="text" id="realName" name="realName"/></li><br />
			<li>身份证号：<input type="text" id="numberId" name="numberId"/></li><br />
			<li>性别：<input type="radio" id="stuSex" name="stuSex" value="男"/>男<input type="radio" name="stuSex" value="女"/>女</li><br />
			<li>出生年月：<input type="date" id="stuBirthday" name="stuBirthday"/></li><br />		
			<li>民族：<input type="text" id="nation" name="nation"/></li><br />
			<li>年级：<select id="classxz" onchange="disstu(this.value)" name="gradename">
							 <option value="">--请选择--</option>
							 <#list gradeMap?keys as key>
							<option value="${key}">${gradeMap[key]}</option>
							 </#list> 
					 </select></li><br />
			<li>班级：<select id="gradename" name="classId"><option value="">--请选择--</option></select></li><br />
			<li>小组：<input type="text" name="stuGroup"/></li><br />
			<li>地址：<input type="text" id="stuAddress" name="stuAddress"/></li><br />
			<li>学生状态：<input type="text" id="stuState" name="stuState"/></li><br />
			<li>问题类型：<input type="text" id="problemType" name="problemType"/></li><br />
			<li>错误类型：<input type="text" id="erroeType" name="erroeType"/></li><br />
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
			        <h4 class="modal-title">添加学生</h4>
			      </div>
			      <div class="modal-body">
					<form action="${basePath}/student/upfile.shtml" encType="multipart/form-data" method="post" >
						<input id="excelupfile" type="file" name="excel" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel" />					
						</form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="button" onclick="addStudent()" class="btn btn-primary">Save</button>
			      </div>
			    </div>
			  </div>
			</div>
			<#--/弹框-->
			</div>
							<#--修改学生弹框-->
			<div class="modal fade bs-example-modal-sm"  id="updateStudent" tabindex="-1" role="dialog" aria-labelledby="selectPermissionLabel">
			  <div class="modal-dialog modal-sm" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="selectPermissionLabel">修改学生</h4>
			      </div>
			      <div class="modal-body">
		<form action="${basePath}/student/update.shtml" id="updateStu">
			<input type="hidden" value="" id="Ids" name="stuId"/>
			<input type="hidden" value="" id="stuclassmarks" name="stuClassMark"/>
			<input  name="stuNo" type="hidden" id="stunos"/>
			<li>姓名:<input type="text" name="realName" id="stunames"/></li><br />
			<li>身份证号：<input type="text" id="numberIds" name="numberId"/></li><br />
			<li>性别:<input type="radio" name="stuSex" id="stumans" value="男"/>男<input type="radio" name="stuSex" value="女" id="stuwomans"/>女</li><br />
			<li>民族：<input type="text" id="nations" name="nation"/></li><br />
			<input type="hidden" name="stuBirthday" id="birthdays" />		
			<li>年级:<select id="gradenames" onchange="disstus(this.value,'')" name="gradename">
							  <#list gradeMap?keys as key>
							<option value="${key}">${gradeMap[key]}</option>
							 </#list> 
					 </select></li><br />
			<li>班级:<select id="classnames" name="classId" >
							<option value="">--请选择--</option>
					</select></li><br />
			<li>小组：<input type="text" id="stuGroups" name="stuGroup"/></li><br />
			<li>地址：<input type="text" id="stuAddresss" name="stuAddress"/></li><br />
			<li>学生状态：<input type="text" id="stuStates" name="stuState"/></li><br />
			<li>问题类型：<input type="text" id="problemTypes" name="problemType"/></li><br />
			<li>错误类型：<input type="text" id="erroeTypes" name="erroeType"/></li><br />
			</form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="button" onclick="uptj();" class="btn btn-primary">Save</button>
			      </div>
			    </div>
			  </div>
			</div>
			<#--/弹框-->
			<#--/row-->
		</div>

	</body>
