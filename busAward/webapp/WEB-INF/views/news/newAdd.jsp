<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%--shiro 标签 --%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>系统管理 - 发布资讯</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
	<link rel="icon" href="<%=basePath%>}/favicon.ico" type="image/x-icon" />
	<link rel="shortcut icon" href="<%=basePath%>/favicon.ico" />
	<link href="<%=basePath%>/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet" />
	<link href="<%=basePath%>/css/common/base.css?${_v}" rel="stylesheet" />
	<script src="<%=basePath%>/js/common/jquery/jquery-3.2.1.js"></script>
	<script src="<%=basePath%>/js/common/layer/layer.js"></script>
	<script src="<%=basePath%>/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>/js/shiro.demo.js"></script>
	<script src="<%=basePath%>/js/wangEditor.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#btnPublish").click(function() {
				 var newsTittle = $("#txtTitle").val(),
				 	 newsContent = editor.txt.html(),
				 	 newsAuthor = $("#author").val(),
				 	 category = $("#selType").val()
				 	 push = $("#push").val();
				 if(newsTittle == "" || newsContent ==""){
					 layer.msg('要发布什么呢，总不能为空吧');
					 return false;
				 }
				$.post('<%=basePath%>/news/addNews.shtml',{newsTittle:newsTittle,newsContent:newsContent,newsAuthor:newsAuthor,category:category,push:push},function(result){
					
					if(result && result.status != 200){
							layer.msg(result.message);
							return false;
						}
						layer.msg('添加成功。');
						window.location.href="<%=basePath%>/news/index.shtml?category=";
					},'json');	
				 
			});
		});
	</script>
</head>

<body data-target="#one" data-spy="scroll">
<jsp:include page="../common/config/top.jsp"></jsp:include>
<div class="container" style="padding-bottom: 15px; min-height: 300px; margin-top: 40px;">
	<div class="row">
	<div id="one" class="col-md-2">
	<ul data-spy="affix" class="nav nav-list nav-tabs nav-stacked bs-docs-sidenav dropdown affix"
		style="top: 100px; z-index: 100;">
		<li class="">
		<a href="<%=basePath%>/sys/index.shtml">
			<i class="glyphicon glyphicon-chevron-right"></i>系统设置
		</a>
			<ul class="dropdown-menu" aria-labelledby="dLabel" style="margin-left: 160px; margin-top: -40px;">
				<li><a href="<%=basePath%>/sys/index.shtml">学期设置</a></li>
				<li><a href="<%=basePath%>/sys/award.shtml">奖励系数</a></li>
				<li><a href="<%=basePath%>/sys/tchUp.shtml">教师信息</a></li>
				<li><a href="<%=basePath%>/class/classUp.shtml">班级信息</a></li>
			</ul></li>
		<li class="active dropdown">
			<a href="<%=basePath%>/news/manageNews.shtml"> 
			<i class="glyphicon glyphicon-chevron-right"></i>资讯管理
		</a></li>
		<li class="">
			<a href="<%=basePath%>/sys/alotSubject.shtml">
			<i class="glyphicon glyphicon-chevron-right"></i>科目管理
		</a></li>	
	</ul>
	</div>
		<div class="col-md-10">
		<h3>发布资讯</h3>
		<hr />
		<div class="title-box">
             <input type="text" id="txtTitle" maxlength="100" placeholder="输入文章标题" class="form-control">
        </div>
		<div >
			<div style="width:970px" id="txtdEditor"></div>
         </div>
         <button id="btn1">获取html</button>
			<button id="btn2">获取text</button>
		<div>
            <label class="labTitle col-form-label">资讯类型：</label>
              <div class="txt-box">
                 <select id="selType" class="form-control">
                      <option value="通知公告">通知公告</option>
                      <option value="校园快讯">校园快讯</option>
                      <option value="大事记">大事记</option>
                      <option value="周工作安排">周工作安排</option>
                  </select>
             </div>
        </div>
         <div>
            <label class="labTitle col-form-label">发布者：</label>
              <div class="txt-box">
                 <select id="author" class="form-control">
                      <option value="政教办">政教办</option>
                      <option value="教务办">教务办</option>
                      <option value="后勤办">后勤办</option>
                  </select>
             </div>
        </div>
        <div>
            <label class="labTitle col-form-label">是否通知：</label>
              <div class="txt-box">
                 <select id="push" class="form-control">
                 	  <option value="否">否</option>
                      <option value="是">是</option>
                  </select>
             </div>
        </div>              
		<div>
           <label class="labTitle col-form-label"></label>
             <div class="txt-box">
               <input id="btnPublish" type="button" class="btn btn-outline-danger" value="发布资讯" title="发布资讯" >
               <input id="btnCancel" type="button"  title="返回列表页" value="返回">
          </div>
       </div>
	</div>
	</div>


</div>
</div>
</body>
<script type="text/javascript">
	var E = window.wangEditor
	var editor = new E('#txtdEditor')
	//隐藏“网络图片”tab
	editor.customConfig.showLinkImg = false;
	editor.customConfig.uploadImgShowBase64 = true;  // 使用 base64 保存图片
	editor.customConfig.menus = [
		'head',  // 标题
	    'bold',  // 粗体
	    'fontSize',  // 字号
	    'fontName',  // 字体
	    'italic',  // 斜体
	    'underline',  // 下划线
	    'strikeThrough',  // 删除线
	    'foreColor',  // 文字颜色
	    'backColor',  // 背景颜色
	    'link',  // 插入链接
	    'list',  // 列表
	    'justify',  // 对齐方式
	    'quote',  // 引用
	    'emoticon',  // 表情
	    'image',  // 插入图片
	    'table',  // 表格
	    //'video',  插入视频
	   	// 'code',   插入代码
	    'undo',  // 撤销
	    'redo'  // 重复
    ]
	// 将图片大小限制为 3M
	editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;
	// 限制一次最多上传 5 张图片
	editor.customConfig.uploadImgMaxLength = 5;
	editor.create();

</script>
</html>