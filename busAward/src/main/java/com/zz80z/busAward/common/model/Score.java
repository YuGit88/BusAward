package com.zz80z.busAward.common.model;

import net.sf.json.JSONObject;

public class Score {
    private Integer scoreId;

    private Integer scoreStu;
    private Student student;

    private Integer scoreSubject;
    private Subject subject;

    private Double scoreNum;

    private Integer scoreSemester;
    private Semester semester;

    private String examName;
    
    public Score() {
	}
    
	public Score(Integer scoreStu, Integer scoreSubject, Double scoreNum, Integer scoreSemester, String examName) {
		this.scoreStu = scoreStu;
		this.scoreSubject = scoreSubject;
		this.scoreNum = scoreNum;
		this.scoreSemester = scoreSemester;
		this.examName = examName;
	}


	public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public Integer getScoreStu() {
        return scoreStu;
    }

    public void setScoreStu(Integer scoreStu) {
        this.scoreStu = scoreStu;
    }

    public Integer getScoreSubject() {
        return scoreSubject;
    }

    public void setScoreSubject(Integer scoreSubject) {
        this.scoreSubject = scoreSubject;
    }

    public Double getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(Double scoreNum) {
        this.scoreNum = scoreNum;
    }

    public Integer getScoreSemester() {
        return scoreSemester;
    }

    public void setScoreSemester(Integer scoreSemester) {
        this.scoreSemester = scoreSemester;
    }

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	
	public String getExamName() {
		return examName;
	}


	public void setExamName(String examName) {
		this.examName = examName;
	}


	public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}