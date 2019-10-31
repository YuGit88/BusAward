1<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<title>郑州市第八十中学</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
<link rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
<!-- CSS -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="${basePath}/js/common/html5shiv.js"></script>
        <![endif]-->
<style>

.one img {
	width: 100%;
	height: 650px;
}

.form {
	width: 330px;
	height: 200px;
	text-align: center;
	border-radius: 3%;
	<!-- border: 1px solid #125314;  -->
	margin: 0 auto;
	background-color: #EEF3FA;
	position: absolute;
	top:40%;
	right: 37%;
}

.z {
	position: absolute;
	color: white;
	top: 3px;
	left: 5px;
	z-index: 99;
	font-size: 1.2em;
}

#t {
	color: red;
}

.form_t {
	height: 100px;
}

.form_t img {
	width: 348px;
	height: 100px;
	border-top-left-radius: 3%;
	border-top-right-radius: 3%;
	position: relative;
}

.logo {
	position: absolute;
	top: -90px;
	left: -30px;
}

.inp_a {
	width: 200px;
	height: 30px;
	line-height: 30px;
}

#j_pw {
	margin-top: 10px;
}

#dl {
	margin-top: 6px;
	width: 80px;
}

.wapr {
	width: 1170px;
	height: 50px;
	background: red;
}

.font {
	margin-top: 10px;
	text-align: center;
	display: block;
	top: 50px;
}
.oa{
width: 70px;
}
.ob{
width:280px;
}
.oe{
margin-top: -50px;

}
</style>
</head>

<body>
	<div class="one">
		<img src="${basePath}/images/dl.png" alt="">
	</div>
	<form id="_form" action="" method="post">
		<div class="form" style="opacity:0.7;">
			<div class="logo">
				<img src="${basePath}/images/logo.png" alt="">
			</div>
			<div class="form_t">
				<#--<img src="${basePath}/images/2345.jpg" alt="">-->
				<p class="z">管理系统登录</p>
			</div>
			<div class="oe">
				<#--<img src="${basePath}/images/du.png" alt=""> <input type="text" name="account" class="username" placeholder="工号/学号"
					class="inp_a"> <br>
				<p></p>
				<img src="${basePath}/images/mim.png" alt=""> <input
					type="password" name="password" class="password" placeholder="密码"
					class="inp_a"> <br>-->
					<div class="input-group">
					<span  style="color:#333333" class="input-group-addon">
					用户名
					</span>
					<input type="text" class="form-control" name="account" id="username" placeholder="工号/学号"
					class="inp_a">
				</div></br><!-- /input-group -->
	
				<div class="input-group">
					<span class="input-group-addon oa" style="color:#333333">
						 密&nbsp; &nbsp;码
					</span>
					<input style="width:260px;background:white;"
					type="password" class="form-control" name="password" id="password" placeholder="密码"
					class="inp_a ob">
				</div><!-- /input-group -->
				<lable>
				<!-- <input type="checkbox" id="rememberMe" style="width: 10px; height: 10px;">记住密码</lable>  -->
				<p id="t">"公共场所谨慎选择"</p>
			</div>
			<button type="button" id="login" style="background: ;">登录</button>
			<button type="button" id="resetPwd" class="register" >忘记密码？</button>

		</div>
	</form>
	<!--<br>-->
	<div></div>
	<!--<p class="font">
		地址：河南省郑州市金水区 电话:0371-4697886 <br> <span>@2016河南省郑州第八十中学</span>
	</p>-->
	<!-- Javascript -->
	<script src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
	<script src="${basePath}/js/common/MD5.js"></script>
	<script src="${basePath}/js/common/layer/layer.js"></script>
	<script>
			jQuery(document).ready(function() {
				try{
					var _href = window.location.href+"";
					if(_href && _href.indexOf('?kickout')!=-1){
						layer.msg('您已经被踢出，请重新登录！');
					}
				}catch(e){
					
				}
				//回车事件绑定
				document.onkeydown=function(event){
					var e = event || window.event || arguments.callee.caller.arguments[0];
					if(e && e.keyCode==13){ 
						$('#login').click();
					}
				}; 
			
				//登录操作
			    $('#login').click(function(){
			        var username = $('#username').val();
			        var password = $('#password').val();
			        if(username == '') {
			            $('.error').fadeOut('fast', function(){
			                $('.error').css('top', '27px').show();
			            });
			            $('.error').fadeIn('fast', function(){
			                $('#username').focus();
			            });
			            return false;
			        }
			        if(password == '') {
			            $('.error').fadeOut('fast', function(){
			                $('.error').css('top', '96px').show();
			            });
			            $(this).find('.error').fadeIn('fast', function(){
			                $('.password').focus();
			            });
			            return false;
			        }
			        var pswd = MD5(username +"#" + password),
			        	data = {userPwd:pswd,userName:username,rememberMe:$("#rememberMe").is(':checked')};
			        var load = layer.load();
			        console.log(pswd);
			        $.ajax({
			        	url:"${basePath}/u/submitLogin.shtml",
			        	data:data,
			        	type:"post",
			        	dataType:"json",
			        	beforeSend:function(){
			        		layer.msg('开始登录');
			        	},
			        	success:function(result){
				        	layer.close(load);
				    		if(result && result.status != 200){
				    			layer.msg(result.message,function(){});
				    			$('.password').val('');
				    			return;
				    		}else{
				    			layer.msg('登录成功！');
				    			setTimeout(function(){
				    				//登录返回
					    			window.location.href= result.back_url || "${basePath}/";
				    			},1000)
				    		}
			        	},
			        	error:function(e){
			        		console.log(e,e.message);
			        		layer.msg('请看后台Java控制台，是否报错，确定已经配置数据库和Redis',new Function());
			        	}
			        });
			    });
			    $('.page-container form .username, .page-container form .password').keyup(function(){
			        $(this).parent().find('.error').fadeOut('fast');
			    });
			    //密码重置
			    $("#resetPwd").click(function(){
			    	window.location.href="${basePath}/u/resetPwd.shtml";
			    });
			});
        </script>
</body>

</html>

