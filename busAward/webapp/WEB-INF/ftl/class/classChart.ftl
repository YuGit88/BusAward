<head>
		<meta charset="utf-8" />
		<title>班级日常-统计</title>
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
		<@_top.top 5/>
		<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 40px;">
			<div class="row">
				<@_left.class 2/>
				<div class="col-md-10">
					<h2>班级日常统计</h2>
					<hr>
					<@shiro.hasAnyRoles name='班主任,政教处'>
						<form method="post" action="" id="formId" class="form-inline">
						<div clss="well" >
					      <div class="form-group">
						
						 <h3>日常统计</h3>
						<h5>各班卫生、纪律、活动得分、当学期对比</h5>
					       
					          <div id="container1"
							style="width: 900px; height: 500px; margin: 0"></div>
				        </form>
					<hr>
					
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
   data:['卫生','纪律','团队活动','义务活动']
   },


   xAxis: [
   {
   type: 'category',
   data: ['A','B','C'],
   axisPointer: {
   type: 'shadow'
   }
   }
   ],
   yAxis: [
   {
   type: 'value',
   name: '分数/排名',
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
           name:'卫生',
           type:'bar',
           color: 'red',
           data:[1, 2,3]
       },
       {
       name:'纪律',
       type:'bar',
       data:[2.6, 8.9, 5 ]
       },{
       name:'团队活动',
       type:'bar',
       data:[2.6, 8.9, 5 ]
       },{
       name:'义务活动',
       type:'bar',
       data:[2.6, 8.9, 5 ]
       },
       
   ]
   };
   if (option && typeof option === "object") {
   myChart.setOption(option, true);
   }
   	var className=[];
   	var classHealth=[];
   	var classDiscipline=[];
   	var classTeamActivity=[];
   	var classDutyActivity=[];
   $.getJSON('${basePath}/classs/classChats.shtml',{data:""},function(result,textStatus,jqXHR){
   			result.forEach(function(item){
   			var classGroup="";
   			if(item.gradeName=='1'){
   			classGroup='七年级'; 
   			}else if(item.gradeName=='2'){
   			classGroup='八年级'; 
   			}else if(item.gradeName=='3'){
   			classGroup='九年级'; 
   			}
   			className.push(classGroup+item.className);
   			classHealth.push(item.health);
   			classDiscipline.push(item.discipline);
   			classTeamActivity.push(item.teamActivity);
   			classDutyActivity.push(item.dutyActivity);
   			})
   					   myChart.setOption({        
                        xAxis: {
                            data:className
                        },
                        series: [
       
       {
           name:'卫生',
           type:'bar',
           color: 'red',
           data:classHealth
       },
       {
       name:'纪律',
       type:'bar',
       data:classDiscipline
       },{
       name:'团队活动',
       type:'bar',
       data:classTeamActivity
       },{
       name:'义务活动',
       type:'bar',
       data:classDutyActivity
       },
       
   ]
                        })
			
			});
   </script>
   
   </div>
					</@shiro.hasAnyRoles>
					
					
		</div>

	</body>
