<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8" />
<title>密码重置</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
<link rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="${basePath}/favicon.ico" />
<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet" />
<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet" />
<script src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
<script src="${basePath}/js/common/layer/layer.js"></script>
<script src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
.imga{
 width: 100%;
 height: 100%;           
 opacity: .3;
 position: fixed;
  z-index: -99;
}
</style>

</head>
<body data-target="#one" data-spy="scroll">
<img class="imga"; src="${basePath}/images/360.jpg" alt="">
	<div class="container"
		style="padding-bottom: 15px; min-height: 300px; margin-top: 40px;">
		<div class="row">
			<div class="col-md-10">
				<h2>密码重置</h2>
				<hr>
				<div class="form-group" id="validateUserName"> 
				<h3>请填入您要重置的账户信息</h3>
					<label for="">用户名/学号/工号</label>
						<input type="text" class="form-control" autocomplete="off" id="userName" maxlength="8" name="userName"  placeholder="请输入用户名/学号/工号">
					<label for="">姓名</label>
						<input type="text" class="form-control" autocomplete="off" id="realName" maxlength="8" name="realName"  placeholder="请输入姓名">
					<button class="btn btn-large" type="button" onclick="validateUserName()">下一步</button>
				</div>
				
				<div class="form-group" style="display: none;" id="validateIssue">
				<h3>请输入密保问题进行验证</h3>
					<label for="">请选择密保问题</label>
						<select class="form-control" id ="issueVa">
							
						</select>
						<label for="">答案：</label>
							<input type="text" class="form-control" autocomplete="off" id="amswer"   placeholder="请输入答案">
					<button class="btn btn-large" type="button" onclick="validateIssue();">下一步</button>	
				</div>
				
				<div class="form-group"style="display: none;"id="resetPwd">
				<h3>请输入新密码并牢记</h3>
				<label for="">新密码</label>
					<input type="password" class="form-control" autocomplete="off" id="newPwd" maxlength="8" name="newPwd"  placeholder="请输入新密码">
				<label for="">新密码</label>
					<input type="password" class="form-control" autocomplete="off" id="anewPwd" maxlength="8" name="anewPwd"  placeholder="请新密码">
				<button class="btn btn-large" type="button" onclick="resetPwd();">提交</button>	
				</div>	
				
			</div>
		</div>
	</div>
	<script src="${basePath}/js/common/jquery/jquery.form-2.82.js?${_v}"></script>

</body>
<script>
function validateUserName(){
	var userName = $("#userName").val(),
		realName = $("#realName").val();
		
	if(userName == ''|| realName == '') {
		layer.msg("请输入信息");
		return false;
	}
	$.post("${basePath}/u/validateUserName.shtml",{userName:userName,realName:realName},function(result){
		if(result && result.status != 200){
			layer.msg(result.message);
			return;
		}else{
			layer.msg(result.message);
			$("#validateUserName").css({'display':'none'});
			$("#validateIssue").css({'display':'block'});
		}
		if(null != result.issues){
			$.each(result.issues,function(){
				var optionEle = $("<option></option>").append(this.quesstion).attr("value",this.id);
				optionEle.appendTo($("#issueVa"));		
			});
		}else{
			layer.msg(result.issueMsg);
		}
	},'json');	
		
}

function validateIssue(){
	var amswer = $("#amswer").val(),
		issueVa = $("#issueVa").val();
		
	if(amswer == '') {
		layer.msg("请输入信息");
		return false;
	}
	$.post("${basePath}/u/validateIssue.shtml",{amswer:amswer,issueVa:issueVa},function(result){
		if(result && result.status != 200){
			layer.msg(result.message);
			return;
		}else{
			layer.msg(result.message);
			$("#validateUserName").css({'display':'none'});
			$("#validateIssue").css({'display':'none'});
			$("#resetPwd").css({'display':'block'});
		}
	},'json');	
		
}


function resetPwd(){
	var userName = $("#userName").val(),
		newPwd = $("#newPwd").val(),
		anewPwd = $("#anewPwd").val();
		
	if(newPwd == ''|| anewPwd == '') {
		layer.msg("请输入密码");
		return false;
	}
	if(newPwd != anewPwd) {
		layer.msg("两次输入不一致");
		return false;
	}
	$.post("${basePath}/u/rePwd.shtml",{userName:userName,newPwd:newPwd},function(result){
		if(result && result.status != 200){
			layer.msg(result.message);
			return;
		}else{
			layer.msg(result.message);
			window.location.href="${basePath}/u/login.shtml";
		}
	},'json');	
		
}

</script>
</html>