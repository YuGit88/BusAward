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
		$("#classMark").click(function(){
			var classMark = $("#classMark").val();
			$.ajax({
		         type : "post",
		         async : true,           
		         url : "${basePath}/score/selecStutByClass.shtml",    
		         data : {classMark:classMark },
		         dataType : "json",        
		         success : function(result) {
		             	//遍历加入学生信息
		        	 $("#studentInfo").empty();
				  		$.each(result.stuInfos,function(){
				  			var stuOption = $("<option></option>").append(this.stuNo+this.realName).attr("value",this.stuId);
				  			stuOption.appendTo("#studentInfo");
				  		});
				  		
				  	//遍历加入学期信息
				  	$("#semesterInfo").empty();
				  		$.each(result.semesters,function(){
				  			var semOption = $("<option></option>").append(this.semesterName).attr("value",this.semesterId);
				  			semOption.appendTo("#semesterInfo");
				  		});
				  
				  		
				  	//加入每次考试
				  	$("#examInfo").empty();
		  			var examOption1 = $("<option></option>").append("月考一").attr("value","月考一");
		  			var examOption2 = $("<option></option>").append("期中考试").attr("value","期中考试");
		  			var examOption3 = $("<option></option>").append("月考二").attr("value","月考二");
		  			var examOption4 = $("<option></option>").append("期末考试").attr("value","期末考试");
		  			examOption1.appendTo("#examInfo");
		  			examOption2.appendTo("#examInfo");
		  			examOption3.appendTo("#examInfo");
		  			examOption4.appendTo("#examInfo");
		         },
		         error : function(errorMsg) {
		         alert("暂无信息");
		         }
		    	})
		
		});
	});

</script>
</head>
<body data-target="#one" data-spy="scroll">
<@_top.top 6/>
<div class="container" style="padding-bottom: 15px; min-height: 300px; margin-top: 40px;">
	<div class="row">
	<@_left.score 2/>
		<div class="col-md-10">
			<h3>成绩分析</h3>
			<hr />
			<h5>每位学生个人每次考试成绩对比</h5>
			
			<div clss="well">
				
				<div class="form-group" id="subjectByClazz">
					<label class="control-label">班级:</label>
						<select class="" data-style="btn-primary"  id="classMark">
						<#if classMarks??>
						<#list classMarks as it>
							<option value="${it}">${it}</option>
						</#list>
						</#if>
						</select>
						
						<select class="" data-style="btn-primary"  id="studentInfo"></select>
						<select class="" data-style="btn-primary"  id="semesterInfo"></select>
						<select class="" data-style="btn-primary"  id="examInfo"></select>
				</div>
			</div>
			
			<span class="">
				<button type="submit" class="btn btn-primary" onclick="selectStuByCondition();">查看</button>
			</span>
			
			<div id="everyScoreCount" style="width: 900px; height: 500px; margin: 0"></div>
				
		</div>
	</div>
</div>	
</body>
<script type="text/javascript">
	var subScoreChart = echarts.init(document.getElementById('everyScoreCount')); 
	subScoreChart.setOption({
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
	      data:['当次成绩','去年成绩','前年成绩']
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
	          max: 100,
	          interval: 10,
	          axisLabel: {
	              formatter: '{value} '
	          }
	      },
	      {
	          type: 'value',
	          name: '分数',
	          min: 0,
	          max: 100,
	          interval: 10,
	          axisLabel: {
	              formatter: '{value} '
	          }
	      },
	  ],
	  series: [
	      {
	          name:'当次成绩',
	          type:'line',
	          data:[]
	      },
	      {
	          name:'去年成绩',
	          type:'line',
	          data:[]
	      },
	      {
	          name:'前年成绩',
	          type:'line',
	          yAxisIndex: 1,
	          data:[]
	      }
	  ]
	});
	
	function selectStuByCondition(){
		//准备集合
		var score = [];
		var score2 = [];
		var score3 = [];
		
		$.ajax({
	       type : "post",
	       async : true,           
	       url : "${basePath}/score/everyScoreInfo2.shtml",  
	       data : {stuId:$("#studentInfo").val(),semesterId:$("#semesterInfo").val(),examInfo:$("#examInfo").val()},
	       dataType : "json",        
	       success : function(result) {
	           if (result) {
	        	   console.log(result.scores);
                   //每次课考试成绩
                  
                   if(result.scores){  
                	   score.push(result.scores.chineseScore);
                	   score.push(result.scores.mathScore);
                	   score.push(result.scores.englishScore);
                	   score.push(result.scores.politicsScore);
                	   score.push(result.scores.historyScore);
                	   score.push(result.scores.geographyScore);
                	   score.push(result.scores.physicsScore);
                	   score.push(result.scores.chemistryScore);
                	   score.push(result.scores.biologyScore);
                   }
	                  
                   if(result.scores2){  
                	   score2.push(result.scores2.chineseScore);
                	   score2.push(result.scores2.mathScore);
                	   score2.push(result.scores2.englishScore);
                	   score2.push(result.scores2.politicsScore);
                	   score2.push(result.scores2.historyScore);
                	   score2.push(result.scores2.geographyScore);
                	   score2.push(result.scores2.physicsScore);
                	   score2.push(result.scores2.chemistryScore);
                	   score2.push(result.scores2.biologyScore);
                   }
                   
                   if(result.scores3){  
                	   score3.push(result.scores3.chineseScore);
                	   score3.push(result.scores3.mathScore);
                	   score3.push(result.scores3.englishScore);
                	   score3.push(result.scores3.politicsScore);
                	   score3.push(result.scores3.historyScore);
                	   score3.push(result.scores3.geographyScore);
                	   score3.push(result.scores3.physicsScore);
                	   score3.push(result.scores3.chemistryScore);
                	   score3.push(result.scores3.biologyScore);
                   }
	                  
	                  subScoreChart.hideLoading();  
	                  subScoreChart.setOption({ 
	                      xAxis: {
	                          data: result.subject
	                      },
	                      series: [{
	                          name: '当次成绩',
	                          data: score
	                      },{
	                      	name: '去年成绩',
	                          data:	 [12,10,40,54,42,78,46,43,67,78,67,43,67] 				// score2	
	                      },{
	                          name: '前年成绩',
	                          data:  [10,34,99,87,67,54,87,65,98,76,31,56,32,12]  		//score3	
	                      }]
	                  });
	                 
	           }
	       },
	      
	       error : function(errorMsg) {
	       alert("图表请求数据失败!");
	       subScoreChart.hideLoading();
	       }
	  	});
	}

</script>
</html>
