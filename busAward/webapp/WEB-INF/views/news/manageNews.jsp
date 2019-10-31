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
	<script src="<%=basePath%>/js/common/jquery/jquery1.8.3.min.js"></script>
	<script src="<%=basePath%>/js/common/layer/layer.js"></script>
	<script src="<%=basePath%>/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>/js/shiro.demo.js"></script>
	<script src="<%=basePath%>/ueditor/ueditor.config.js"></script>
	<script src="<%=basePath%>/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=basePath%>/ueditor/ueditor.all.min.js"></script>
</head>

<body data-target="#one" data-spy="scroll">

<jsp:include page="../common/config/top.jsp"></jsp:include>
<div class="container" style="padding-bottom: 15px; min-height: 300px; margin-top: 40px;">
	<div class="row">
		<div id="one" class="col-md-2"><ul data-spy="affix" class="nav nav-list nav-tabs nav-stacked bs-docs-sidenav dropdown affix" style="top: 100px; z-index: 100;">
		<li class=""><a
			href="<%=basePath%>/sys/index.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>系统设置
		</a>
			<ul class="dropdown-menu" aria-labelledby="dLabel"
				style="margin-left: 160px; margin-top: -40px;">
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
		<h3>校园快讯</h3>
		<a class="btn btn-primary" href="<%=basePath%>/news/newAdd.shtml">发布资讯</a>
		<hr />
		<table class="table ">
			<c:choose>
				<c:when test="${page != null && fn:length(page.list) gt 0}">
					<c:forEach items="${page.list}" var="it">
						<tr>
							<td><input value="${it.newsId}" check='box' type="checkbox" /></td>
							<td><a href="<%=basePath%>/news/showNews.shtml?newsId=${it.newsId}">${it.newsTittle}</a></td>
							<td>${it.newsCreate}</td>
							<td>
								<button class="btn btn-large btn-primary" type="button" onclick ="updateById(${it.newsId});">编辑</button>
  								<button class="btn btn-large" type="button" onclick = "deleteById(${it.newsId});">删除</button>
							</td>
					</tr>
				</c:forEach>
					</c:when>
					<c:otherwise>
					<tr>
						<td class="text-center danger" colspan="6">没有找到资讯信息</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
		
		</div>
		</div>
</div>


<!-- 新闻编辑模态框 -->
	<div id="new_update_modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="subject_add_modalLabel" aria-hidden="">
	  <div class="modal-dialog" role="document">
	  <div class="modal-content">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="myModalLabel">更新新闻</h3>
	  </div>
	  <div style="display: none;">
	  	<input type="text" id="newsId"/>
	  </div>
	  <div class="modal-body">
		<div class="control-group">
			<label class="control-label" for="inputSubjectName">资讯标题：</label>
			<div class="controls">
			     <input type="text" class="form-control" id="newsTittle" />
			</div>
		</div>
	  </div>
	  <div class="modal-body">
		<div class="control-group">
		<label class="control-label" >资讯内容：</label>
			<div class="controls">
			     <input type="text" class="form-control" id="newsContent"  style="height:300px;"/>
			 </div>
		</div>
        </div>
	  	<div class="modal-body">
	  		<div class="control-group">
            <label class="control-label">资讯类型：</label>
                 <select id="selType" class="form-control">
                      <option value="通知公告">通知公告</option>
                      <option value="校园快讯">校园快讯</option>
                      <option value="大事记">大事记</option>
                      <option value="周工作安排">周工作安排</option>
                  </select>
             </div>
        	</div>
         <div class="modal-body">
          <div class="control-group">
            <label class="labTitle col-form-label">发布者：</label>
                 <select id="author" class="form-control">
                      <option value="政教办">政教办</option>
                      <option value="教务办">教务办</option>
                      <option value="后勤办">后勤办</option>
                  </select>
             </div>
        </div>
	  <div class="modal-footer">
	    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	    <button class="btn btn-primary" onclick="updateNews();">更新</button>
	  </div>
	  </div>
	</div>
	</div>
</body>
<script type="text/javascript">
	function deleteById(obj){
		var index = layer.confirm("确定这删除这条资讯？",function(){
			var load = layer.load();
			$.post('<%=basePath%>/news/deleteNewsById.shtml',{newsId:obj},function(result){
				layer.close(load);
				if(result && result.status != 200){
					layer.msg(result.message);
					return false;
				}else{
					layer.msg(result.resultMsg);
					location.reload();
				}
			},'json');
		});
	}
	function updateById(obj){
		$.post("<%=basePath%>/news/showNew.shtml?newsId="+obj,{newsId:obj},function(result){
			$("#newsTittle").val(result.news.newsTittle);
			$("#newsContent").val(result.news.newsContent);
			$("#selType").val(result.news.category);
			$("#author").val(result.news.newsAuthor);
			$("#newsId").val(result.news.newsId);
		})
		$('#new_update_modal').modal();
	}
	function updateNews(){
		var newsTittle = $("#newsTittle").val(),
	 	 	 newsContent = $("#newsContent").val(),
	 	 	newsAuthor = $("#author").val(),
	 	 	category = $("#selType").val();
	 	 
		 if(newsTittle == "" || newsContent ==""){
			 layer.msg('不能为空');
			 return false;
		 }
	 	$.post('<%=basePath%>/news/updateNew.shtml',{newsId:$("#newsId").val(),newsTittle:newsTittle,newsContent:newsContent,newsAuthor:newsAuthor,category:category},function(result){
			
			if(result && result.status != 200){
					layer.msg(result.message);
					return false;
				}
				layer.msg('更新成功。');
				location.reload();
			},'json');	
		
	}
</script>
</html>