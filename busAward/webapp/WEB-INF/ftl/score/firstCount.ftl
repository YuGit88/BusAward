<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8" http-equiv="Content-Type" content="multipart/form-data" ;/>
<title>成绩列表—成绩信息</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
<link rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="${basePath}/favicon.ico" />
<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet" />
<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet" />
<script src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
<script src="${basePath}/js/common/layer/layer.js"></script>
<script src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="${basePath}/js/shiro.demo.js"></script>
<script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#condition").change(function(){
			if( $(this).val()=='1'){
				$("#subjectByClazz").css("display","block");
				$("#subjectByCategory").css("display","none");
				$("#subjectByGrade").css("display","none");
				
			}else if($(this).val()=='2'){
				$("#subjectByClazz").css("display","none");
				$("#subjectByCategory").css("display","block");
				$("#subjectByGrade").css("display","none");
			
			}else{
				$("#subjectByClazz").css("display","none");
				$("#subjectByCategory").css("display","none");
				$("#subjectByGrade").css("display","block");
			
			}
		});
	});

</script>
</head>
<body data-target="#one" data-spy="scroll"onload="selectByCondition()">
<@_top.top 6/>
<div class="container" style="padding-bottom: 15px; min-height: 300px; margin-top: 40px;">
	<div class="row">
	<@_left.score 2/>
		<div class="col-md-10">
			<h3>成绩分析</h3>
			<hr />
			<h5>状元人数，进步人数波动图展示</h5>
			<div clss="well">
				<div class="form-group">
					<label class="control-label">请选择条件:</label>
					<select class="" data-style="btn-primary"  id="condition">
							<option value="1">按班级查看</option>
							<option value="2">按班级类别查看</option>
							<option value="3">按年级查看</option>
						</select>
				</div>
				
				<div class="form-group" id="subjectByClazz">
					<label class="control-label">班级:</label>
						<select class="" data-style="btn-primary"  id="classMark">
						<#if classMarks??>
						<#list classMarks as it>
							<option value="${it}">${it}</option>
						</#list>
						</#if>
						</select>
						<select class="" data-style="btn-primary"  id="timeByMark">
							<option value="本学期">本学期</option>
							<option value="本学年">本学年</option>
							<option value="三年">三年</option>
						</select>
				</div>
				<div class="form-group"style="display:none" id="subjectByCategory">
					<label class="control-label">班级:</label>
						<select class="" data-style="btn-primary"  id="gradeByCategory">
							<option value="1">七年级</option>
							<option value="2">八年级</option>
							<option value="3">九年级</option>
						</select>
						<select class="" data-style="btn-primary"  id="category">
							<option value="A">实验班</option>
							<option value="B">重点班</option>
							<option value="C">平行班</option>
						</select>
						<select class="" data-style="btn-primary"  id="timeByCategory">
							<option value="本学期">本学期</option>
							<option value="本学年">本学年</option>
							<option value="三年">三年</option>
						</select>
				</div>
				
			</div>
			
			<span class="">
				<button type="submit" class="btn btn-primary" onclick = "selectByCondition()">查看</button>
			</span>
			<div id="firstCount" style="width: 900px; height: 500px; margin: 0"></div>
				
		</div>
	</div>
</div>	
</body>
<script type="text/javascript">
	var firstCountChart = echarts.init(document.getElementById('firstCount'));
          // 显示标题，图例和空的坐标轴
          firstCountChart.setOption({
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
		        data:['状元人数','进步人数']
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
		            name: '人数',
		            min: 0,
		            max: 50,
		            interval: 5,
		            axisLabel: {
		                formatter: '{value} '
		            }
		        }
		    ],
		    series: [
		        {
		            name:'状元人数',
		            type:'bar',
		            data:[]
		        },
		        {
		            name:'进步人数',
		            type:'bar',
		            data:[]
		        }
		    ]
          });

        subScoreChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
		function selectByCondition(){
			var semester=[];    
		    var firstCounts=[];    
		    var progressCounts=[]; 
			
			$.ajax({
		         type : "post",
		         async : true,           
		         url : "${basePath}/score/firstCountInfo.shtml",    
		         data : {class:$("#classMark").val(),timeByMark:$("#timeByMark").val(),
		         		gradeByCategory:$("#gradeByCategory").val(),category:$("#category").val(),
		         		timeByCategory:$("#timeByCategory").val(),condition:$("#condition").val() },
		         dataType : "json",        
		         success : function(result) {
		             
		             if (result) {
		                    for(var i=0;i<result.subjectInfo.length;i++){  
		                       subjectNames.push(result.subjectInfo[i].subjectName);  
		                       
		                    }
		                   
		                    for(var i=0;i<result.subjectInfo.length;i++){ 
		                        passRates.push(result.subjectInfo[i].passRate);   
		                    }
		                    for(var i=0;i<result.subjectInfo.length;i++){       
		                        excellentRates.push(result.subjectInfo[i].excellentRate);   
		                    }
		                    for(var i=0;i<result.subjectInfo.length;i++){       
		                        averages.push(result.subjectInfo[i].avgScore);    
		                    }
		                    subScoreChart.hideLoading();  
		                    subScoreChart.setOption({ 
		                        xAxis: {
		                            data: subjectNames
		                        },
		                        series: [{
		                            name: '及格率',
		                            data: passRates
		                        },{
		                        	name: '优秀率',
		                            data: excellentRates
		                        },{
		                            name: '平均分',
		                            data: averages
		                        }]
		                    }); 
		                   
		             }
		         },
		         error : function(errorMsg) {
		         alert("图表请求数据失败!");
		         subScoreChart.hideLoading();
		         }
		    	})
		}
    
</script>
</html>
