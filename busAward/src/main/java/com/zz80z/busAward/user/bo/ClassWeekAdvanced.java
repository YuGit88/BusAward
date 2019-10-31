package com.zz80z.busAward.user.bo;

public class ClassWeekAdvanced {

	@Override
	public String toString() {
		return "ClassWeekAdvanced [classId=" + classId + ", gradeName=" + gradeName + ", className=" + className
				+ ", total=" + total + ", ClassMark=" + ClassMark + ", rank=" + rank + "]";
	}
	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassMark() {
		return ClassMark;
	}

	public void setClassMark(String classMark) {
		ClassMark = classMark;
	}
	private int classId;
	
	private int gradeName;
	
	private String className;
	
	private double total;
	
	private String ClassMark;
	

	public String getStuClassMark() {
		return ClassMark;
	}

	public void setStuClassMark(String stuClassMark) {
		this.ClassMark = stuClassMark;
	}

	private int rank;

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
}
