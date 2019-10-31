package com.zz80z.busAward.common.model;

public class StudentChart {

	private int stuId;
	
	private String realName;
	
	private String classMark;
	
	private String stuGroup;
	
	private int gradeName;
	
	private String className;
	
	private double total;
	
	private int rank;

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getClassMark() {
		return classMark;
	}

	public void setClassMark(String classMark) {
		this.classMark = classMark;
	}

	public String getStuGroup() {
		return stuGroup;
	}

	public void setStuGroup(String stuGroup) {
		this.stuGroup = stuGroup;
	}

	public int getGradeName() {
		return gradeName;
	}

	public void setGradeName(int gradeName) {
		this.gradeName = gradeName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "StudentChart [stuId=" + stuId + ", realName=" + realName + ", classMark=" + classMark + ", stuGroup="
				+ stuGroup + ", gradeName=" + gradeName + ", className=" + className + ", total=" + total + ", rank="
				+ rank + "]";
	}

	
}
