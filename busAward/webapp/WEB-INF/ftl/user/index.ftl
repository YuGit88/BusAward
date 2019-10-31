<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8" />
<title>${tch.tchName?default('未录入')}—个人中心</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
<link rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="${basePath}/favicon.ico" />
<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet" />
<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet" />
<script src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
<script src="${basePath}/js/common/layer/layer.js"></script>
<script src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="${basePath}/js/shiro.demo.js"></script>
</head>
<body data-target="#one" data-spy="scroll">
	<@_top.top 1/>
	<div class="container"
		style="padding-bottom: 15px; min-height: 300px; margin-top: 40px;">
		<div class="row">
			<@_left.user 2/>
			<div class="col-md-10">
				<h2>个人资料</h2>
				<hr>
				<table class="table table-bordered">
					<tr>
						<th>工号</th>
						<td>${token.userName?default('未设置')}</td>
					</tr>
					<tr>
						<th>姓名</th>
						<td>${tch.tchName?default('未录入')}</td>
					</tr>
					<tr>
						<th>联系方式</th>
						<td>${tch.tchPhone?default('未录入')}</td>
					</tr>
					<tr>
						<th>所教科目</th>
						<td>${tch.subject.subjectName?default('未录入')}</td>
					</tr>
					<tr>
						<th>上次登录时间</th>
						<td>${token.lastLoginTime?string('yyyy-MM-dd HH:mm')}</td>
					</tr>
				</table>
				<#if res>
					<button class="btn btn-large btn-primary" type="button" data-toggle="modal" data-target="#validate_password">修改密保问题</button>
				<#else>
					<h5>您还未设置密保问题，为了安全请您</h5>
					<button class="btn btn-large btn-primary" type="button" data-toggle="modal" data-target="#validate_password">设置密保问题</button>
				</#if>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div id="validate_password" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="" >
			<div class="modal-dialog" role="document">
				<div class="modal-content">
			<div class="modal-header">
			    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			    <h3 id="myModalLabel">验证密码</h3>
			 </div>
			  <div class="modal-body">
			    <form class="form-horizontal">
				  <div class="control-group">
				    <label class="control-label" for="updateIssue">请输入密码验证：</label>
				    <div class="controls">
				      <input type="password" id="password" class="form-control"placeholder="***********">
				    </div>
				  </div>
				</form>
			  </div>
			  <div class="modal-footer">
			    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			    <button class="btn btn-primary"  onclick="validatePwd();">验证</button>
			</div>
		</div>
	</div>
	</div>	
	<!-- Modal -->
	<div id="update_issue_btn" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="addroleLabel" >
			<div class="modal-dialog" role="document">
				<div class="modal-content">
			<div class="modal-header">
			    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			    <h3 id="myModalLabel">修改密保问题</h3>
			 </div>
			  <div class="modal-body">
			    <form class="form-horizontal">
				  <div class="control-group">
				    <label class="control-label" for="updateIssue">密保问题一：</label>
				    <div class="controls">
				      <select class="form-control" id="updateIssue">
				      <#if queIsu1??>
							<option value="1">${queIsu1.quesstion}</option>
					  </#if>		
					  </select>
				    </div>
				  </div>
				  <div class="control-group">
				    <label class="control-label" for="updateAnswer">请填入答案：</label>
				    <div class="controls">
				      <input type="text" id="updateAnswer1" class="form-control"placeholder="答案">
				    </div>
				  </div>
				  
				  <div class="control-group">
				    <label class="control-label" for="updateIssue">密保问题二：</label>
				    <div class="controls">
				      <select class="form-control" id="updateIssue">
				      		<#if queIsu2??>
								<option value="1">${queIsu2.quesstion}</option>
							</#if>
						</select>
				    </div>
				  </div>
				  <div class="control-group">
				    <label class="control-label" for="updateAnswer">请填入答案：</label>
				    <div class="controls">
				      <input type="text" id="updateAnswer2" class="form-control"placeholder="答案">
				    </div>
				  </div>
				</form>
			  </div>
			  <div class="modal-footer">
			    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			    <button class="btn btn-primary" onclick = "updatIssue();">更新</button>
			</div>
			</div>
			</div>
	</div>	
	<!-- Modal -->
	<div id="add_issue_btn" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="addroleLabel" >
		<div class="modal-dialog" role="document">
				<div class="modal-content">
		<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    <h3 id="myModalLabel">设置密保问题</h3>
		  </div>
		  <div class="modal-body">
		    <form class="form-horizontal">
			  <div class="control-group">
			    <label class="control-label" for="addIssue">请选择密保问题一：</label>
			    <div class="controls">
			      <select class="form-control" id="addQuesstion1">
			      		<#list que1 as it>
						<option value="${it.id}}">${it.quesstion}</option>
						</#list>
					</select>
			    </div>
			  </div>
			  <div class="control-group">
			    <label class="control-label" for="addAnswer">请填入答案：</label>
			    <div class="controls">
			      <input type="text" id="addAnswer1" maxlength="6" class="form-control" placeholder="答案(长度不要超过6位)">
			    </div>
			  </div>
			  <div class="control-group">
			    <label class="control-label" for="addIssue">请选择密保问题二：</label>
			    <div class="controls">
			      <select class="form-control" id="addQuesstion2">
						<#list que2 as it>
						<option value="${it.id}}">${it.quesstion}</option>
						</#list>
					</select>
			    </div>
			  </div>
			  <div class="control-group">
			    <label class="control-label" for="addAnswer">请填入答案：</label>
			    <div class="controls">
			      <input type="text" id="addAnswer2" class="form-control" maxlength="6" placeholder="答案(长度不要超过6位)">
			    </div>
			  </div>
			</form>
		  </div>
		  <div class="modal-footer">
		    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		    <button class="btn btn-primary" onclick="addIssue();">保存</button>
		</div>
		</div>
		</div>
	</div>
	<script>
		function validatePwd(){
			var password = $("#password").val();
			if(password == '') {
			    layer.msg("请输入密码");
			    return false;
			}
			$.post("${basePath}/u/validate.shtml",{password:$("#password").val()},function(result){
			        if(result && result.status != 200){
				    	layer.msg(result.message);
				    	return;
				    }else{
				    	if(result.is == 100){
				    		$("#update_issue_btn").modal();
				    	}else{
				    		$("#add_issue_btn").modal();
				    	}
				    }
				},'json');
		}
		function updatIssue(){
			var answer1 = $("#updateAnswer1").val();
			var answer2 = $("#updateAnswer2").val();
			if(answer1 == '' || answer2 =='') {
			    layer.msg("答案不能为空");
			    return false;
			}
			$.post("${basePath}/user/updateIssue.shtml",{answer1:answer1,answer2:answer2},function(result){
			
			        if(result && result.status != 200){
				    	layer.msg(result.message);
				    	return;
				    }else{
				    	layer.msg(result.message);
				    }
				    location.reload();
				},'json');
			
		}
		
		function addIssue(){
			var quesstion1 = $("#addQuesstion1").val();
			var quesstion2 = $("#addQuesstion2").val();
			
			var answer1 = $("#addAnswer1").val();
			var answer2 = $("#addAnswer2").val();
			
			if(answer1 == '' || answer2 =='') {
			    layer.msg("答案不能为空");
			    return false;
			}
			$.post("${basePath}/user/addIssue.shtml",{quesstion1:quesstion1,quesstion2:quesstion2,answer1:answer1,answer2:answer2},function(result){
			
			        if(result && result.status != 200){
				    	layer.msg(result.message);
				    	return;
				    }else{
				    	layer.msg(result.message);
				    }
				    location.reload();
				},'json');
		}
	</script>			
</body>
</html>