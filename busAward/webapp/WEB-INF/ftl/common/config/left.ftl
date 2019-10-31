<#macro user index>
<div id="one" class="col-md-2">
	<ul data-spy="affix"
		class="nav nav-list nav-tabs nav-stacked bs-docs-sidenav dropdown affix"
		style="top: 100px; z-index: 100;">
		<li class="${(index==1)?string('active',' ')} dropdown"><a
			href="${basePath}/news/index.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>校园资讯
		</a></li>
		<li class="${(index==2)?string('active',' ')}"><a
			href="${basePath}/user/index.shtml">个人资料</a> </a>
			<ul class="dropdown-menu" aria-labelledby="dLabel"
				style="margin-left: 160px; margin-top: -40px;">
				<li><a href="${basePath}/user/resetPwd.shtml">密码重置</a></li>
				<li><a href="${basePath}/user/updatePswd.shtml">密码修改</a></li>
			</ul></li>
	</ul>
</div>
</#macro> <#macro sys index> <@shiro.hasAnyRoles name='校长,政教处'>
<div id="one" class="col-md-2">
	<ul data-spy="affix"
		class="nav nav-list nav-tabs nav-stacked bs-docs-sidenav dropdown affix"
		style="top: 100px; z-index: 100;">
		<li class="${(index==1)?string('active',' ')}"><a
			href="${basePath}/sys/index.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>系统设置
		</a>
			<ul class="dropdown-menu" aria-labelledby="dLabel"
				style="margin-left: 160px; margin-top: -40px;">
				<li><a href="${basePath}/sys/index.shtml">学期设置</a></li>
				<li><a href="${basePath}/sys/award.shtml">奖励系数</a></li>
				<li><a href="${basePath}/sys/tchUp.shtml">教师信息</a></li>	
			</ul></li>
		<li class="${(index==2)?string('active',' ')} dropdown"><a
			href="${basePath}/news/manageNews.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>资讯管理
		</a></li>
		<li class="${(index==3)?string('active',' ')} dropdown"><a
			href="${basePath}/sys/alotSubject.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>科目管理
		</a></li>
		<li class="${(index==4)?string('active',' ')} dropdown"><a
			href="${basePath}/classs/classUp.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>班级管理
		</a></li>	
	</ul>
</div>
</@shiro.hasAnyRoles> </#macro> <#macro role index> <@shiro.hasAnyRoles
name='校长,政教处'>
<div id="one" class="col-md-2">
	<ul data-spy="affix"
		class="nav nav-list nav-tabs nav-stacked bs-docs-sidenav dropdown affix"
		style="top: 100px; z-index: 100;">
		<li class="${(index==1)?string('active',' ')}"><a
			href="${basePath}/role/index.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>角色列表
		</a></li>
		<li class="${(index==2)?string('active',' ')}"><a
			href="${basePath}/role/allotRole.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>角色分配
		</a></li>
		<li class="${(index==3)?string('active',' ')} dropdown"><a
			href="${basePath}/permission/index.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>权限列表
		</a></li>
		<li class="${(index==4)?string('active',' ')} dropdown"><a
			href="${basePath}/permission/allotPermission.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>权限分配
		</a></li>
	</ul>
</div>
</@shiro.hasAnyRoles> </#macro> <#macro stu index> <@shiro.hasAnyRoles
name='校长,政教处,班主任'>
<div id="one" class="col-md-2">
	<ul data-spy="affix"
		class="nav nav-list nav-tabs nav-stacked bs-docs-sidenav dropdown affix"
		style="top: 100px; z-index: 100;">
		<li class="${(index==1)?string('active',' ')}"><a
			href="${basePath}/student/stu.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>学生列表
		</a></li>
		<li class="${(index==2)?string('active',' ')} dropdown"><a
			href="${basePath}/studay/stuDay.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>日常管理
		</a></li>
		<li class="${(index==4)?string('active',' ')} dropdown"><a
			href="${basePath}/StuDayChart/returnStuDayChart.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>日常统计
		</a></li>
	</ul>
</div>
</@shiro.hasAnyRoles> </#macro> <#macro class index> <@shiro.hasAnyRoles
name='校长,政教处'>
<div id="one" class="col-md-2">
	<ul data-spy="affix"
		class="nav nav-list nav-tabs nav-stacked bs-docs-sidenav dropdown affix"
		style="top: 100px; z-index: 100;">
		<li class="${(index==1)?string('active',' ')} dropdown"><a
			href="${basePath}/classs/classsDay.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>班级日常
		</a></li>
		<li class="${(index==2)?string('active',' ')}"><a
			href="${basePath}/classs/classChart.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>班级日常统计
		</a></li>
	</ul>
</div>
</@shiro.hasAnyRoles> </#macro> <#macro score index> <@shiro.hasAnyRoles
name='校长,政教处,教务处,任课教师'>
<div id="one" class="col-md-2">
	<ul data-spy="affix"
		class="nav nav-list nav-tabs nav-stacked bs-docs-sidenav dropdown affix"
		style="top: 100px; z-index: 100;">
		<li class="${(index==1)?string('active',' ')}">
		<a href="${basePath}/score/index.shtml">
			<i class="glyphicon glyphicon-chevron-right"></i>成绩列表
		</a></li>
		
		<li class="${(index==2)?string('active',' ')} dropdown"><a
			href="${basePath}/score/showScore.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>成绩分析
		</a>
			<ul class="dropdown-menu" aria-labelledby="dLabel" style="margin-left: 160px; margin-top: -40px;">
				<li><a href="${basePath}/score/showScore.shtml">各科成绩对比</a></li>
				<li><a href="${basePath}/score/firstCount.shtml">进步状元人数</a></li>
				<li><a href="${basePath}/score/rankCount.shtml">各名次段人数波动</a></li>
				<li><a href="${basePath}/score/everyScore.shtml">个人成绩对比</a></li>
				<li><a href="${basePath}/score/everyScoreByYear.shtml">个人三年成绩对比</a></li>
				<li><a href="${basePath}/score/everyGroup.shtml">小组成绩对比</a></li>
			</ul></li>
		
		
		<@shiro.hasPermission name="/score/myScore.shtml">
		<li class="${(index==3)?string('active',' ')} dropdown"><a
			href="${basePath}/score/myScore.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>我的成绩
		</a></li> </@shiro.hasPermission>
	</ul>
</div>
</@shiro.hasAnyRoles> </#macro> <#macro coin index> <@shiro.hasAnyRoles
name='学生,班主任,政教处,教务处'>
<div id="one" class="col-md-2">
	<ul data-spy="affix"
		class="nav nav-list nav-tabs nav-stacked bs-docs-sidenav dropdown affix"
		style="top: 100px; z-index: 100;">
		<@shiro.hasPermission name="/coin/allotSCoin.shtml">
		<li class="${(index==1)?string('active',' ')} dropdown"><a
			href="${basePath}/coin/allotSCoin.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>巴士币(学生)
		</a></li> </@shiro.hasPermission> <@shiro.hasPermission
		name="/coin/allotCCoin.shtml">
		<li class="${(index==2)?string('active',' ')} dropdown"><a
			href="${basePath}/coin/allotCCoin.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>巴士币(班级)
		</a></li> </@shiro.hasPermission> <@shiro.hasPermission
		name="/score/allotScoreCoin.shtml">
		<li class="${(index==3)?string('active',' ')} dropdown"><a
			href="${basePath}/score/allotScoreCoin.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>巴士币(成绩)
		</a></li>  </@shiro.hasPermission> <@shiro.hasPermission
		name="/coin/myCoin.shtml">
		<li class="${(index==5)?string('active',' ')}"><a
			href="${basePath}/coin/index.shtml.shtml"> <i
				class="glyphicon glyphicon-chevron-right"></i>我的巴士币
		</a></li> </@shiro.hasPermission>
	</ul>
</div>
</@shiro.hasAnyRoles> </#macro>
