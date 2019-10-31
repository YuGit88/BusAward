package com.zz80z.busAward.common.model;

import net.sf.json.JSONObject;

public class Classs {
	/**
	 * 主键
	 */
	private Integer classId;
	/**
	 * 班级名称
	 */
	private String className;
	/**
	 * 年级名称
	 */
	private Integer gradeName;
	/**
	 * 年级对象
	 */
	private Grade grade;
	/**
	 * 班级类型（实验班、平行班、重点班）
	 */
	private String classCategory;
	/**
	 * 班主任Id
	 */
	private Integer headTch;
	/**
	 * 班级唯一标识
	 */
	private String stuClassMark;
	/**
	 * 班级状态
	 */
	private String reserve;
	/**
	 * 教师对象
	 */
	private Teacher teacher;
	/**
	 * 班级备注 用来标注这个班级是 某某年
	 */
	private String remark;
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className == null ? null : className.trim();
	}

	public Integer getGradeName() {
		return gradeName;
	}

	public void setGradeName(Integer gradeName) {
		this.gradeName = gradeName;
	}

	public String getClassCategory() {
		return classCategory;
	}

	public void setClassCategory(String classCategory) {
		this.classCategory = classCategory == null ? null : classCategory.trim();
	}

	public Integer getHeadTch() {
		return headTch;
	}

	public void setHeadTch(Integer headTch) {
		this.headTch = headTch;
	}

	public String getStuClassMark() {
		return stuClassMark;
	}

	public void setStuClassMark(String stuClassMark) {
		this.stuClassMark = stuClassMark == null ? null : stuClassMark.trim();
	}

	public String getReserve() {
		return reserve;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public void setReserve(String reserve) {
		this.reserve = reserve == null ? null : reserve.trim();
	}

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}