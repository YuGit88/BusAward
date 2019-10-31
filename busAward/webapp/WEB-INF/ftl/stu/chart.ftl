<head>
		<meta charset="utf-8" />
		<title>学生日常-统计</title>
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
		<link   rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
		<link   rel="shortcut icon" href="${basePath}/favicon.ico" />
		<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet"/>
		<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet"/>
		<script  src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
		<script  src="${basePath}/js/common/layer/layer.js"></script>
		<script  src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script  src="${basePath}/js/shiro.demo.js"></script>
		 <script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>
		
	</head>
	 <style>
           *{
               margin: 0px;
               padding: 0px;
           }
           .pull-down{
               margin-left: 800px;

           }
       </style>
	<script>
		function flagChart(){
		var classMark=$("#classs").val();
				$.ajax({
					type:"POST",
					url:"${basePath}/StuDayChart/returnStuDayChart.shtml",
					contentType:"application/json;charset=utf-8",
					data:classMark,
					success:function(data){
					alert(data);
					}
					})
			}
		</script>
	<body data-target="#one" data-spy="scroll">
		<@_top.top 4/>
		<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 40px;">
			<div class="row">
				<@_left.stu 4/>
				<div class="col-md-10">
					<h2>学生统计图表</h2>
					<hr>
					<@shiro.hasAnyRoles name='班主任,政教处'>
					  <#assign classList= stuChartMap["classList"]/>	
						  <#assign classId= stuChartMap["classId"]/>
						  <#assign stuDayCharts= stuChartMap["stuDayCharts"]/>
					<form method="post" action="" id="formId" class="form-inline">
						<div clss="well" >
					      <div class="form-group">
						
						 <h3>日常统计</h3>
						<h5>各学生、每天、每月、每学期统计对比</h5>
						   	班级：
					        <select class="form-control" onchange="getClassId(this.value)" id="classs" name="classMark">
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
					           <#if classId??>
					        <script>					      
					        $("#classs").val(${classId});
					        </script>
					        </#if>
					        </select>&nbsp;&nbsp;&nbsp;&nbsp;
					          <div id="container1"
							style="width: 900px; height: 500px; margin: 0"></div>
				        </form>
				        <form method="post" action="" id="formId" class="form-inline">
						<div clss="well" >
					      <div class="form-group">
						<hr>
						<hr />
						<h5>每个小组当周、卫生、纪律、作业的平均分及排名  </h5>
						   	班级：
					        <select class="form-control" onchange="getClassIdTwo(this.value)" id="classsTwo" name="classMark">
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
					           <#if classId??>
					        <script>					      
					        $("#classsTwo").val(${classId});
					        </script>
					        </#if>
					        </select>&nbsp&nbsp&nbsp&nbsp;
					        <div id="container2"
							style="width: 900px; height: 500px; margin: 0"></div>
					      </div>
					      <hr>
						<hr />
						<h5>每个小组当月、卫生、纪律、作业的平均分及排名  </h5>
						   	班级：
					        <select class="form-control" onchange="getClassIdThree(this.value)" id="classsThree" name="classMark">
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
					           <#if classId??>
					        <script>					      
					        $("#classsThree").val(${classId});
					        </script>
					        </#if>
					        </select>&nbsp&nbsp&nbsp&nbsp;
					        <div id="container3"
							style="width: 900px; height: 500px; margin: 0"></div>
							  <hr>
						<hr />
						<h5>每个小组当学期、卫生、纪律、作业的平均分及排名  </h5>
						   	班级：
					        <select class="form-control" onchange="getClassIdFour(this.value)" id="classsFour" name="classMark">
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
					           <#if classId??>
					        <script>					      
					        $("#classsFour").val(${classId});
					        </script>
					        </#if>
					        </select>&nbsp&nbsp&nbsp&nbsp;
					        <div id="container4"
							style="width: 900px; height: 500px; margin: 0"></div>
					      </div>
				        </div>     
				        </form>
				        <div>
<script type="text/javascript">
   var dom = document.getElementById("container1");
   var myChart = echarts.init(dom);
 
  
  
   var app = {};
   option = null;
   app.title = '折柱混合';
   option = {
   tooltip: {
   trigger: 'axis',
   axisPointer: {
   type: 'cross',
   crossStyle: {
   color: '#999'
   }
   }
   },
   toolbox: {
   feature: {
   dataView: {show: true, readOnly: false},
   magicType: {show: true, type: ['line', 'bar']},
   restore: {show: true},
   saveAsImage: {show: true}
   }
   },
   legend: {
   data:['当天','当周','当月','当学期','天名次','周名次','月名次','学期名次']
   },
   xAxis: [
   {
   type: 'category',
   data: [],
   axisPointer: {
   type: 'shadow'
   }
   }
   ],
   yAxis: [
   {
   type: 'value',
   name: '分数',
   min: 0,
   max: 2500,
   interval: 150,
   axisLabel: {
   formatter: '{value}'
   }
   },


   ],
    series: [

       {
           name:'当天',
           type:'bar',
           stack: '',
           color: 'red',
           data:[]
       },
       {
       name:'当周',
       type:'bar',
           stack: '',
       data:[]
       },
       {
       name:'当月',
       type:'bar',
           stack: '',
       data:[]
       },
       {
           name:'当学期',
           type:'bar',
           stack: '',
           data:[]
       },
       {
           name:'名次',
           type:'bar',
           stack: '',
            color: 'red',
           data:[]
       },

   ]
   };
   if (option && typeof option === "object") {
   myChart.setOption(option, true);
   }
 
    var arr=[];
    var dayTotal=[];
    var weekDayTotal=[];
    var mothDayTotal=[];
    var semestDayTotal=[];
    
    var dayRank=[];
    var weekDayRank=[];
    var mothDayRank=[];
    var semestDayRank=[];
   	var data=1;
   	function getClassId(str){
   	data=str;
   	 $.getJSON("${basePath}/StuDayChart/studentDayCharts.shtml",{data:data},function(result,textStatus,jqXHR){
    		    arr.splice(0,arr.length);
    		     dayTotal.splice(0,dayTotal.length);
    		      weekDayTotal.splice(0,weekDayTotal.length);
    		       mothDayTotal.splice(0,mothDayTotal.length);
    		        semestDayTotal.splice(0,semestDayTotal.length);
    		           dayRank.splice(0,dayRank.length);
    		      weekDayRank.splice(0,weekDayRank.length);
    		       mothDayRank.splice(0,mothDayRank.length);
    		        semestDayRank.splice(0,semestDayRank.length);
    		        
    		    $.each(result,function(data,values){
               	arr.push(values.stuDayCharts.realName);
               	dayTotal.push(values.stuDayCharts.total);
              	dayRank.push(values.stuDayCharts.rank);
               	weekDayTotal.push(values.stuWeekCharts.total);
               	weekDayRank.push(values.stuWeekCharts.rank);
    		  
         		mothDayTotal.push(values.stuMothCharts.total);
         		mothDayRank.push(values.stuMothCharts.rank);
         		
         		semestDayTotal.push(values.stuSemesterCharts.total);
         		semestDayRank.push(values.stuSemesterCharts.rank);
         		
               	})
               	
              
               	   myChart.setOption({        
                        xAxis: {
                            data: arr
                        },
                        
                 series: [
		        {
		            name:'当天',
		            type:'bar',
		            data:dayTotal
		        },
       {
       name:'当周',
       type:'bar',
           stack: '',
       data:weekDayTotal
       },
       {
       name:'当月',
       type:'bar',
           stack: '',
       data:mothDayTotal
       },
       {
           name:'当学期',
           type:'bar',
           stack: '',
           data:semestDayTotal
       },
       {
		            name:'天名次',
		            type:'bar',
		            data:dayRank
		        },
       {
       name:'周名次',
       type:'bar',
           stack: '',
       data:weekDayRank
       },
       {
       name:'月名次',
       type:'bar',
           stack: '',
       data:mothDayRank
       },
       {
           name:'学期名次',
           type:'bar',
           stack: '',
           data:semestDayRank
       },
		   			 ]
         
                        
                    }); 
			});
   	}
   	
  $.getJSON("${basePath}/StuDayChart/studentDayCharts.shtml",{data:data},function(result,textStatus,jqXHR){
  				
    		    $.each(result,function(data,values){
    		   
  				
  					arr.push(values.stuDayCharts.realName);
               	dayTotal.push(values.stuDayCharts.total);
               	dayRank.push(values.stuDayCharts.rank);
               	
               	weekDayTotal.push(values.stuWeekCharts.total);
               	weekDayRank.push(values.stuWeekCharts.rank);
               	
         		mothDayTotal.push(values.stuMothCharts.total);
         		mothDayRank.push(values.stuMothCharts.rank);
         		
         		semestDayTotal.push(values.stuSemesterCharts.total);
         		semestDayRank.push(values.stuSemesterCharts.rank);
  				
               
         		
               	})
               	
               	   myChart.setOption({        
                        xAxis: {
                            data: arr
                        },
                        
                 series: [
		        {
		            name:'当天',
		            type:'bar',
		            data:dayTotal
		        },
       {
       name:'当周',
       type:'bar',
           stack: '',
       data:weekDayTotal
       },
       {
       name:'当月',
       type:'bar',
           stack: '',
       data:mothDayTotal
       },
       {
           name:'当学期',
           type:'bar',
           stack: '',
           data:semestDayTotal
       },  {
		            name:'天名次',
		            type:'bar',
		            data:dayRank
		        },
       {
       name:'周名次',
       type:'bar',
           stack: '',
       data:weekDayRank
       },
       {
       name:'月名次',
       type:'bar',
           stack: '',
       data:mothDayRank
       },
       {
           name:'学期名次',
           type:'bar',
           stack: '',
           data:semestDayRank
       },
		   			 ]
         
                        
                    }); 
			});
			
   </script>
   
   </div>
   <div >
   <script type="text/javascript">
   
   var groupName=[];
   
   var weekHealth=[];
     var weekDiscipline=[];
     var weekTask=[];
      var weekRank=[];
      var weekDisciplineRank=[];
      var weekTaskRank=[];
      

  
 
   
   var data=1;
    function getClassIdTwo(str){
   	data=str;
   	  $.getJSON('${basePath}/StuDayChart/stuGroupCharts.shtml',{data:data},function(result,textStatus,jqXHR){
   		groupName.splice(0,groupName.length);
   		weekHealth.splice(0,weekHealth.length);
   		weekDiscipline.splice(0,weekDiscipline.length);
   		weekTask.splice(0,weekTask.length);
   		weekRank.splice(0,weekRank.length);
   		weekDisciplineRank.splice(0,weekDisciplineRank.length);
   		weekTaskRank.splice(0,weekTaskRank.length);
   			$.each(result,function(data,values){
   			groupName.push(values.stuHealthWeek.stuGroup);
   			weekHealth.push(values.stuHealthWeek.total);
   			weekDiscipline.push(values.stuDisciplineWeek.total);
   			weekTask.push(values.stuTaskWeek.total);
   			weekRank.push(values.stuHealthWeek.rank);
   			weekDisciplineRank.push(values.stuDisciplineWeek.rank);
   			weekTaskRank.push(values.stuTaskWeek.rank);
   			})
   			   stuGroup.setOption({        
                        xAxis: {
                            data:groupName
                        },
                        series: [
       
        {
           name:'周卫生',
           type:'bar',
           color: 'red',
           data:weekHealth
       },
       {
       name:'周纪律',
       type:'bar',
       data:weekDiscipline
       },
       {
       name:'周作业',
       type:'bar',
       data:weekTask
       },{
           name:'周卫生排名',
           type:'bar',
           data:weekRank
       },{
           name:'周纪律排名',
           type:'bar',
           data:weekDisciplineRank
       },{
           name:'周作业排名',
           type:'bar',
           data:weekTaskRank
       },
       
   ]
                        })
			});
   }
   $.getJSON('${basePath}/StuDayChart/stuGroupCharts.shtml',{data:data},function(result,textStatus,jqXHR){
   				$.each(result,function(data,values){
   			groupName.push(values.stuHealthWeek.stuGroup);
   			weekHealth.push(values.stuHealthWeek.total);
   			weekDiscipline.push(values.stuDisciplineWeek.total);
   			weekTask.push(values.stuTaskWeek.total);
   			weekRank.push(values.stuHealthWeek.rank);
   			weekDisciplineRank.push(values.stuDisciplineWeek.rank);
   			weekTaskRank.push(values.stuTaskWeek.rank);
   			})
   			   stuGroup.setOption({        
                        xAxis: {
                            data:groupName
                        },
                        series: [
       
        {
           name:'周卫生',
           type:'bar',
           color: 'red',
           data:weekHealth
       },
       {
       name:'周纪律',
       type:'bar',
       data:weekDiscipline
       },
       {
       name:'周作业',
       type:'bar',
       data:weekTask
       },{
           name:'周卫生排名',
           type:'bar',
           data:weekRank
       },{
           name:'周纪律排名',
           type:'bar',
           data:weekDisciplineRank
       },{
           name:'周作业排名',
           type:'bar',
           data:weekTaskRank
       },
       
   ]
                        })
   	
			});
   
   var dom = document.getElementById("container2");
   var stuGroup = echarts.init(dom);
   var app = {};
   option = null;
   app.title = '折柱混合';

   option = {
   tooltip: {
   trigger: 'axis',
   axisPointer: {
   type: 'cross',
   crossStyle: {
   color: '#999'
   }
   }
   },
   toolbox: {
   feature: {
   dataView: {show: true, readOnly: false},
   magicType: {show: true, type: ['line', 'bar']},
   restore: {show: true},
   saveAsImage: {show: true}
   }
   },
   legend: {
   data:['周卫生','周纪律','周作业','周卫生排名','周纪律排名','周作业排名']
   },

   xAxis: [
   {
   type: 'category',
   data: [],
   axisPointer: {
   type: 'shadow'
   }
   }
   ],
   yAxis: [
   {
   type: 'value',
   name: '分数',
   min: 0,
   max:110,
   interval: 10,
   axisLabel: {
   formatter: '{value} '
   }
   },

   ],
   series: [
       
        {
           name:'周卫生',
           type:'bar',
           color: 'red',
           data:[]
       },
       {
       name:'周纪律',
       type:'bar',
       data:[]
       },
       {
       name:'周作业',
       type:'bar',
       data:[]
       },{
           name:'周排名',
           type:'bar',
           data:[]
       },{
           name:'周卫生排名',
           type:'bar',
           data:[]
       },{
           name:'周纪律排名',
           type:'bar',
           data:[]
       },{
           name:'周作业排名',
           type:'bar',
           data:[]
       },
       
   ]
   };
   if (option && typeof option === "object") {
   stuGroup.setOption(option, true);
   }
   </script>
   </div>
   
   <div >
   <script type="text/javascript">
   
   var groupNameMoth=[];
   
   var mothHealth=[];
    var mothDiscipline=[];
     var mothTask=[];
       var mothHealthRank=[];
       var mothDisciplineRank=[];
       var mothTaskRank=[];
   var data=1;
    function getClassIdThree(str){
   	data=str;
   	  $.getJSON('${basePath}/StuDayChart/stuGroupCharts.shtml',{data:data},function(result,textStatus,jqXHR){
   		groupNameMoth.splice(0,groupNameMoth.length);
   		mothHealth.splice(0,mothHealth.length);
   		mothDiscipline.splice(0,mothDiscipline.length);
   		mothTask.splice(0,mothTask.length);
   		mothHealthRank.splice(0,mothHealthRank.length);
   		mothDisciplineRank.splice(0,mothDisciplineRank.length);
   		mothTaskRank.splice(0,mothTaskRank.length);
   			$.each(result,function(data,values){
   			groupNameMoth.push(values.stuHealthMoth.stuGroup);
   			mothHealth.push(values.stuHealthMoth.total);
   			mothDiscipline.push(values.stuDisciplineMoth.total);
   			mothTask.push(values.stuTaskMoth.total);
   			
   			mothHealthRank.push(values.stuHealthMoth.rank);
   			mothDisciplineRank.push(values.stuDisciplineMoth.rank);
   			mothTaskRank.push(values.stuTaskMoth.rank);
   			
   			})
   			   stuGroupMoth.setOption({        
                        xAxis: {
                            data:groupNameMoth
                        },
                        series: [
       
        {
           name:'月卫生',
           type:'bar',
           color: 'red',
           data:mothHealth
       },
       {
       name:'月纪律',
       type:'bar',
       data:mothDiscipline
       },
       {
       name:'月作业',
       type:'bar',
       data:mothTask
       },{
           name:'月卫生名次',
           type:'bar',
           data:mothHealthRank
       },{
           name:'月纪律名次',
           type:'bar',
           data:mothDisciplineRank
       },{
           name:'月作业名次',
           type:'bar',
           data:mothTaskRank
       },
       
   ]
                        })
			});
   }
   $.getJSON('${basePath}/StuDayChart/stuGroupCharts.shtml',{data:data},function(result,textStatus,jqXHR){
   			$.each(result,function(data,values){
   			
   			groupNameMoth.push(values.stuHealthMoth.stuGroup);
   			mothHealth.push(values.stuHealthMoth.total);
   			mothDiscipline.push(values.stuDisciplineMoth.total);
   			mothTask.push(values.stuTaskMoth.total);
   			
   			mothHealthRank.push(values.stuHealthMoth.rank);
   			mothDisciplineRank.push(values.stuDisciplineMoth.rank);
   			mothTaskRank.push(values.stuTaskMoth.rank);
   			})
   			   stuGroupMoth.setOption({        
                        xAxis: {
                            data:groupNameMoth
                        },
                        series: [
       
        {
           name:'月卫生',
           type:'bar',
           color: 'red',
           data:mothHealth
       },
       {
       name:'月纪律',
       type:'bar',
       data:mothDiscipline
       },
       {
       name:'月作业',
       type:'bar',
       data:mothTask
       },{
           name:'月卫生名次',
           type:'bar',
           data:mothHealthRank
       },{
           name:'月纪律名次',
           type:'bar',
           data:mothDisciplineRank
       },{
           name:'月作业名次',
           type:'bar',
           data:mothTaskRank
       },
       
   ]
            })
			});
   
   var dom = document.getElementById("container3");
   var stuGroupMoth = echarts.init(dom);
   var app = {};
   option = null;
   app.title = '折柱混合';

   option = {
   tooltip: {
   trigger: 'axis',
   axisPointer: {
   type: 'cross',
   crossStyle: {
   color: '#999'
   }
   }
   },
   toolbox: {
   feature: {
   dataView: {show: true, readOnly: false},
   magicType: {show: true, type: ['line', 'bar']},
   restore: {show: true},
   saveAsImage: {show: true}
   }
   },
   legend: {
   data:['月卫生','月纪律','月作业','月卫生名次','月纪律名次','月作业名次']
   },

   xAxis: [
   {
   type: 'category',
   data: [],
   axisPointer: {
   type: 'shadow'
   }
   }
   ],
   yAxis: [
   {
   type: 'value',
   name: '分数',
   min: 0,
   max:110,
   interval: 10,
   axisLabel: {
   formatter: '{value} '
   }
   },

   ],
   series: [
       
        {
           name:'月卫生',
           type:'bar',
           color: 'red',
           data:[]
       },
       {
       name:'月纪律',
       type:'bar',
       data:[]
       },
       {
       name:'月作业',
       type:'bar',
       data:[]
       },{
           name:'月卫生名次',
           type:'bar',
           data:[]
       },{
           name:'月纪律名次',
           type:'bar',
           data:[]
       },{
           name:'月作业名次',
           type:'bar',
           data:[]
       },
       
   ]
   };
   if (option && typeof option === "object") {
   stuGroupMoth.setOption(option, true);
   }
   </script>
   </div>
   
    <div >
   <script type="text/javascript">
   
   var groupNameSemester=[];
   
  var semesterHealth=[];
   var semesterDiscipline=[];
   var semesterTask=[];
   var semesterHealthRank=[];
   var semesterDisciplineRank=[];
   var semesterTaskRank=[];
   var data=1;
    function getClassIdFour(str){
    alert(123);
   	data=str;
   	  $.getJSON('${basePath}/StuDayChart/stuGroupCharts.shtml',{data:data},function(result,textStatus,jqXHR){
   		groupNameSemester.splice(0,groupNameSemester.length);
   		semesterHealth.splice(0,semesterHealth.length);
   		semesterDiscipline.splice(0,semesterDiscipline.length);
   		semesterTask.splice(0,semesterTask.length);
   		semesterHealthRank.splice(0,semesterHealthRank.length);
   		semesterDisciplineRank.splice(0,semesterDisciplineRank.length);
   		semesterTaskRank.splice(0,semesterTaskRank.length);
   		
   			$.each(result,function(data,values){
   			
   			groupNameSemester.push(values.stuHealthSemester.stuGroup);
   			semesterHealth.push(values.stuHealthSemester.total);
   			semesterDiscipline.push(values.stuDisciplineSemester.total);
   			semesterTask.push(values.stuTaskSemester.total);
   			
   			semesterHealthRank.push(values.stuHealthSemester.rank);
   			semesterDisciplineRank.push(values.stuDisciplineSemester.rank);
   			semesterTaskRank.push(values.stuTaskSemester.rank);
   			})
   			
   			   stuGroupsemester.setOption({        
                        xAxis: {
                            data:groupNameSemester
                        },
                        series: [
       
        {
           name:'学期卫生',
           type:'bar',
           color: 'red',
           data:semesterHealth
       },
       {
       name:'学期纪律',
       type:'bar',
       data:semesterDiscipline
       },
       {
       name:'学期作业',
       type:'bar',
       data:semesterTask
       },{
           name:'学期卫生名次',
           type:'bar',
           data:semesterHealthRank
       },{
           name:'学期纪律名次',
           type:'bar',
           data:semesterDisciplineRank
       },{
           name:'学期作业名次',
           type:'bar',
           data:semesterTaskRank
       },
       
   ]
                        })
			});
   }
   $.getJSON('${basePath}/StuDayChart/stuGroupCharts.shtml',{data:data},function(result,textStatus,jqXHR){
   		$.each(result,function(data,values){
   			groupNameSemester.push(values.stuHealthSemester.stuGroup);
   			semesterHealth.push(values.stuHealthSemester.total);
   			semesterDiscipline.push(values.stuDisciplineSemester.total);
   			semesterTask.push(values.stuTaskSemester.total);
   			
   			semesterHealthRank.push(values.stuHealthSemester.rank);
   			semesterDisciplineRank.push(values.stuDisciplineSemester.rank);
   			semesterTaskRank.push(values.stuTaskSemester.rank);
   			})
   			   stuGroupsemester.setOption({        
                        xAxis: {
                            data:groupNameSemester
                        },
                        series: [
       
        {
           name:'学期卫生',
           type:'bar',
           color: 'red',
           data:semesterHealth
       },
       {
       name:'学期纪律',
       type:'bar',
       data:semesterDiscipline
       },
       {
       name:'学期作业',
       type:'bar',
       data:semesterTask
       },{
           name:'学期卫生名次',
           type:'bar',
           data:semesterHealthRank
       },{
           name:'学期纪律名次',
           type:'bar',
           data:semesterDisciplineRank
       },{
           name:'学期作业名次',
           type:'bar',
           data:semesterTaskRank
       },
       
   ]
                        })
   	
			});
   
   var dom = document.getElementById("container4");
   var stuGroupsemester = echarts.init(dom);
   var app = {};
   option = null;
   app.title = '折柱混合';

   option = {
   tooltip: {
   trigger: 'axis',
   axisPointer: {
   type: 'cross',
   crossStyle: {
   color: '#999'
   }
   }
   },
   toolbox: {
   feature: {
   dataView: {show: true, readOnly: false},
   magicType: {show: true, type: ['line', 'bar']},
   restore: {show: true},
   saveAsImage: {show: true}
   }
   },
   legend: {
   data:['学期卫生','学期纪律','学期作业','学期卫生名次','学期纪律名次','学期作业名次']
   },

   xAxis: [
   {
   type: 'category',
   data: [],
   axisPointer: {
   type: 'shadow'
   }
   }
   ],
   yAxis: [
   {
   type: 'value',
   name: '分数',
   min: 0,
   max:110,
   interval: 10,
   axisLabel: {
   formatter: '{value} '
   }
   },

   ],
   series: [
       
        {
           name:'学期卫生',
           type:'bar',
           color: 'red',
           data:[]
       },
       {
       name:'学期纪律',
       type:'bar',
       data:[]
       },
       {
       name:'学期作业',
       type:'bar',
       data:[]
       },{
           name:'学期卫生名次',
           type:'bar',
           data:[]
       },{
           name:'学期纪律名次',
           type:'bar',
           data:[]
       },{
           name:'学期作业名次',
           type:'bar',
           data:[]
       },
       
   ]
   };
   if (option && typeof option === "object") {
   stuGroupsemester.setOption(option,true);
   }
   </script>
   </div>
					<hr>
						</@shiro.hasAnyRoles>

	</body>
