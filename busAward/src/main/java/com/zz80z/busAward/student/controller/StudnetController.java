package com.zz80z.busAward.student.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.sql.visitor.functions.Length;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zz80z.busAward.common.controller.BaseController;
import com.zz80z.busAward.common.model.BRecord;
import com.zz80z.busAward.common.model.Classs;
import com.zz80z.busAward.common.model.Grade;
import com.zz80z.busAward.common.model.Student;
import com.zz80z.busAward.common.model.User;
import com.zz80z.busAward.common.model.UserRole;
import com.zz80z.busAward.common.utils.ExcelUtils;
import com.zz80z.busAward.core.mybatis.page.Pagination;
import com.zz80z.busAward.core.shiro.token.manager.TokenManager;
import com.zz80z.busAward.student.service.StudentService;
import com.zz80z.busAward.user.manager.UserManager;

@Controller
@RequestMapping("student")
public class StudnetController extends BaseController{
	@Autowired
	StudentService studentService;
	/**
	 * 查询学生列表
	 */
	@RequestMapping("stu")
	public ModelAndView pduerList(@RequestParam(defaultValue="",required=false) String findContent,@RequestParam(defaultValue="1",required=false) String classId,@RequestParam(value = "pn", defaultValue = "1") Integer pn){		
	
		//获取当前用户id
		TokenManager tokenManager=new TokenManager();	
		int userid=tokenManager.getUserId();
		System.out.println(userid+"$$$$$$$$$$$$$$$$#############");
		//获取当前用户职位
		String position=studentService.selectPositionByUserId(userid);
		System.out.println(position+"********************************");
		//获取班级列表
	    List<Classs> classLists=studentService.selectClasssList();
	    //获取年级列表
	    List<Grade> gradeList = studentService.selectGrade();
	    Map<String,String> gradeMap = new HashMap<String,String>();
	    for (Grade grade : gradeList) {
			gradeMap.put(String.valueOf(grade.getGradeId()), grade.getGradeName());
		}
	    //Map stuAndClass=classNameAndClassList();
	    Map stuAndClass = new HashMap<>();
	    //@RequestParam注解 接收classId出现缓存问题  有多个值并且是以逗号分割的  暂未找到原因  咱做处理
	  /*  if(classId.length()>1){
	    	   String [] classIds=classId.split(",");
	    	   classId=classIds[classIds.length];
	    }*/
	    Map sqlMap=new HashMap<>();
		//判断用户权限
		if(position.equals("政教处")|| position.equals("班主任")){
			System.out.println(findContent+classId+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			sqlMap.put("jurisdiction", "1");
			sqlMap.put("findContent", findContent);
			sqlMap.put("classId", classId);
			//Pagination<Student> page =studentService.findStudentAndClassPage(resultMap, pageNo, pageSize);
			//设置分页参数
			PageHelper.startPage(pn, 8);
			List<Student> students=studentService.selectFromStudent(sqlMap);
			PageInfo pageInfo = new PageInfo(students);
			stuAndClass.put("pageInfo",pageInfo);
			stuAndClass.put("classLists",classLists);
			stuAndClass.put("classId", classId);
			stuAndClass.put("gradeMap", gradeMap);
			return new ModelAndView("stu/index","stuAndClass",stuAndClass);
		}else{
			sqlMap.put("jurisdiction", "0");
			sqlMap.put("userId",String.valueOf(userid));
			/*List<Student>stuList=studentService.selectList(userid);					
			Map <String,List>stuAndClass=classNameAndClassList();	*/	
			Pagination<Student> page =studentService.findStudentAndClassPage(resultMap, pageNo, pageSize);
			stuAndClass.put("page", page);
			stuAndClass.put("classId", classId);
			return new ModelAndView("stu/index","stuAndClass",stuAndClass);
		}
	}
	/**
	 * @author Feng
	 * 
	 * 导入excel文件
	 * 并插入到数据库
	 * 流程： 1.解析excel文件数据封装Map对象
	 * 		 2.根据excel表头为键值  获取对应数据
	 * 		 3.封装数据  装入List<Student>列表
	 * 		 4.根据学生学籍号创建用户对象 装入List<User>列表
	 * 		 5.分别执行 insert操作插入数据库
	 */
	@RequestMapping("upfile")
	@ResponseBody 
	public Map upfile(@RequestParam("file") MultipartFile file,HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("application/json;chartset=utf-8");
		Map result=new HashMap<>();
		List<Map<String, String>> list = ExcelUtils.readExcel(file);
		List<Student> stuList=new ArrayList<Student>();	
		List<User> userLiset=new ArrayList<User>();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int num=0;
	try {
		for(Map map:list){
			if(map==null||map.isEmpty()){
				break;
			}
			Student student=new Student();
			User user=new User();
			//设置学籍号
			student.setstuNo(String.valueOf(map.get("学籍号")));
			//设置姓名
			student.setrealName(String.valueOf(map.get("姓名")));
			//设置性别
			student.setstuSex(String.valueOf(map.get("性别")));
			//设置身份证件号码
			student.setNumberId(String.valueOf(map.get("身份证号")));
			//设置民族
			student.setNation(String.valueOf(map.get("民族")));
			//设置学生状态
			student.setStuState(String.valueOf(map.get("学生状态")));
			//设置问题类型
			student.setProblemType(String.valueOf(map.get("问题类型")));
			//设置错误类型
			student.setErroeType(String.valueOf(map.get("错误类型")));
			//设置地址
			//student.setstuAddress(String.valueOf(map.get("地址"))); 暂未提供
			//设置生日 出现问题excel生日格式解析成从1900年至今的天数  加上解决代码
			String birthday=String.valueOf(map.get("出生年月"));
//			Calendar calendar = new GregorianCalendar(1900,0,-1);  
//			Date d = calendar.getTime();  
//		    Date dd = DateUtils.addDays(d,Integer.valueOf(birthday)); 
//			student.setstuBirthday(sdf.parse(sdf.format(birthday)));
			if(birthday!=null && birthday!=""){
				 String yes=birthday.substring(0,4);
				 String moth=birthday.substring(4,6);
				 String day=birthday.substring(6,8);
				 String birthdays=yes+"-"+moth+"-"+day;
				 student.setstuBirthday(sdf.parse(birthdays));
			}
			//设置年级
			String  gradeAndName=String.valueOf(map.get("班级名称"));
			//截取年级名称
			String gradeName=gradeAndName.substring(0,3);
			//截取班级名称
			String className=gradeAndName.substring(3,gradeAndName.length());
			int flag=0;
			switch (gradeName) {
			case "七年级":
				flag=1;
				break;
			case "八年级":
				flag=2;
				break;
			case "九年级":
				flag=3;
				break;
			}
			Classs classs=new Classs();
			//设置年级  班级
			classs.setGradeName(flag);
			classs.setClassName(className);
			//根据年级和班级查询班级信息
			classs=studentService.selectClassByClassNameAndGradeName(classs);
			student.setclassId(classs.getClassId());
			student.setstuClassMark(classs.getStuClassMark());
			
			student.setstuGroup(String.valueOf(map.get("小组名称"))); //暂未提供
			//添加List列表
			stuList.add(student);
			//设置用户
			user.setType("A");
			user.setUserName(student.getstuNo());
			user.setUserPwd("123456");
			user.setSatus(1);
			UserManager.md5Pswd(user);
			userLiset.add(user);
			System.out.println("21");
		}
	} catch (Exception e) {
		logger.error("模板于现有班级不符合");
		result.put("results", "模板于现有班级不符合，请检查模板后重试");
		return result;
	}
		try {
			
			System.out.println(userLiset);
			System.out.println(stuList);
			studentService.StudentExcelInsert(stuList);
			result.put("results", "添加成功");
			for (User user : userLiset) {
				studentService.creatStuUser(user);
				int userId=user.getUserId();
				UserRole userRole=new UserRole();
				userRole.setUserId(userId);
				userRole.setRoleId(6);
				studentService.insertUserRole(userRole);
			}
			return result;
		} catch (Exception e) {
			result.put("results", "添加失败，请检查数据后重试");
			return result;
		}
	}
	/**
	 * 添加学生
	 * 判断学号
	 */
	@RequestMapping("insert")
	@ResponseBody
	public Map insertStudent(Student stu,HttpServletResponse response){	
		Map resultMap = new HashMap<>();
		response.setContentType("application/json;charset=utf-8");
		if(studentService.pdStuNo(stu.getstuNo())!=null){
			resultMap.put("result", "学号已经存在");
			return resultMap;
		}else{
		stu.setstuClassMark(studentService.selectCmark(stu.getclassId()));	
		stu.setReserve("1");
		studentService.insertStu(stu);
		User user=new User();
		user.setType("A");
		user.setUserName(stu.getstuNo());
		user.setUserPwd("123456");
		user.setSatus(1);
		User md5user=UserManager.md5Pswd(user);
		studentService.creatStuUser(md5user);
		int userId=user.getUserId();
		UserRole userRole=new UserRole();
		userRole.setUserId(userId);
		userRole.setRoleId(6);	
		studentService.insertUserRole(userRole);
		resultMap.put("result", "添加成功");
		return resultMap;	
		}
	}
	/**
	 * ajax获取年级下的班级列表
	 */
	@RequestMapping("gradeselect")
	@ResponseBody
	public List<Classs> gradeselect(@RequestBody int gradename){	
		List<Classs> classList=studentService.selectClasssByclassgrade(gradename);
		return classList;		
	}
	
   /**
    * 学生信息管理
    */
	@RequestMapping("show")
	public ModelAndView studentShow(){
		TokenManager tokenManager=new TokenManager();
		int userid=tokenManager.getUserId();
		//查询所有学生列表
		List<Student>stuList=studentService.selectList(userid);	
		return new ModelAndView("stu/show","stuList",stuList);
	}
	/**
	 * 根据id删除学生
	 */
	@RequestMapping("deleteStudent")
	@ResponseBody
	public void deleteStudent(@RequestBody int stuid){
		studentService.StudentDeleteByStuId(stuid);	
	}
	/**
	 * 修改学生前
	 */
	@RequestMapping("updateStudent")
	@ResponseBody
	public Map updateStudent(@RequestBody int stuid){
		Student student=studentService.selectStudentByStuId(stuid);
		Map resultMap = new HashMap<>();
		resultMap.put("student", student);
		return resultMap;	
	}
	/**
	 * 修改学生
	 */
	@RequestMapping("updateStus")
	@ResponseBody
	public Map updateSudents(Student stu,HttpServletResponse response){
		response.setContentType("application/json;charset=utf-8");
		Map resultMap = new HashMap<>();
		try {
			studentService.updateStu(stu);
			resultMap.put("result", "修改成功");
			return resultMap;
		} catch (Exception e) {
			resultMap.put("result", "修改失败");
			return resultMap;
		}
		
		
	}
	/**
	 * 年级名字去重和班级列表存放Map对象
	 */
//	public Map<String,List> classNameAndClassList(){
//		List<Classs> classList=studentService.selectClasssList();
//		//考虑到有多个重复年级 把所有班级姓名放入classname 用hashset去重复
//		List<Integer>gradeName=new ArrayList<Integer>();
//		for(Classs cla:classList){
//			gradeName.add(cla.getGradeName());
//		}
//		   HashSet<Integer> h  =  new  HashSet<Integer>(gradeName);   
//		   gradeName.clear();   
//		   gradeName.addAll(h);   
//		Map <String,List>stuAndClass=new HashMap<String,List>();
//		stuAndClass.put("gradeName", gradeName);
//		stuAndClass.put("classList", classList);
//		return stuAndClass;	
//	}
	
	/**
	 * 根据学生姓名或学号查询学生信息
	 */
	@RequestMapping("seleceByStuName")
	@ResponseBody
	public List seleceByStuName(String stu){
		Student student=new Student();
		student.setrealName(stu);
		student.setstuNo(stu);
		List<Student> stuList=studentService.selectByStu(student);
		return stuList;	
		}
	/**
	 * 创建Excel导入模板
	 */
	@RequestMapping(value = "creatStudentExcel", method = RequestMethod.GET)
	public void creatStudentExcel(HttpServletRequest request,HttpServletResponse response){
		ExcelUtils excel=new ExcelUtils();
		String fileName = "学生信息表模板.xls";
		String header="学生信息模板";
		List<String> columns=new ArrayList<String>();
		columns.add("学籍号");
		columns.add("姓名");
		columns.add("身份证号");
		columns.add("班级名称");
		columns.add("小组名称");
		columns.add("性别");
		columns.add("民族");
		columns.add("出生年月");
		columns.add("学生状态");
		columns.add("问题类型");
		columns.add("错误类型");
		try {
			excel.creatExcel(response, request, fileName, header, columns);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	/**
	 * 我的巴士币
	 */
	@RequestMapping("myCoin")
	public ModelAndView retrunMyCoin(){
		//获取当前用户id
		TokenManager tokenManager=new TokenManager();	
		int userId=tokenManager.getUserId();
		List<BRecord> bRecordList=studentService.selectRecordByUserId(userId);
		int team=0;
		int star=0;
		int flexible=0;
		int numberOne=0;
		int promotion=0;
		for (BRecord bRecord : bRecordList) {
			String coinType=bRecord.getCoinType();
			if(coinType.equals("团队币")){
				team+=bRecord.getPoints();
			}else if(coinType.equals("星级币")){
				star+=bRecord.getPoints();
			}else if(coinType.equals("灵活币")){
				flexible+=bRecord.getPoints();
			}else if(coinType.equals("状元币")){
				numberOne+=bRecord.getPoints();
			}else if(coinType.equals("晋升币")){
				promotion+=bRecord.getPoints();
			}
		}
		Map<String, Integer> countCoinTyep=new HashMap<String, Integer>();
		countCoinTyep.put("team", team);
		countCoinTyep.put("star", star);
		countCoinTyep.put("flexible", flexible);
		countCoinTyep.put("numberOne", numberOne);
		countCoinTyep.put("promotion", promotion);
		return new ModelAndView("stu/myCoin","countCoinTyep",countCoinTyep);
	}
	}
