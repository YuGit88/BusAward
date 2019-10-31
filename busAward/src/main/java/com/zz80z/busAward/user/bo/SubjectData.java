package com.zz80z.busAward.user.bo;


import net.sf.json.JSONObject;

public class SubjectData {
	
	private String subjectName;
	
	private double avgScore;
	
	private double passRate;
	
	private double excellentRate;


	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

	public double getPassRate() {
		return passRate;
	}

	public void setPassRate(double passRate) {
		this.passRate = passRate;
	}

	public double getExcellentRate() {
		return excellentRate;
	}

	public void setExcellentRate(double excellentRate) {
		this.excellentRate = excellentRate;
	}

	public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}
