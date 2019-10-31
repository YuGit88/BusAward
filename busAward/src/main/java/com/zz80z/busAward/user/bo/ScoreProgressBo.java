package com.zz80z.busAward.user.bo;

public class ScoreProgressBo {

	private Integer stuId;
	
	private Integer score;
	
	private Integer lastScore;
	
	private Integer progress;

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getLastScore() {
		return lastScore;
	}

	public void setLastScore(Integer lastScore) {
		this.lastScore = lastScore;
	}

	public Integer getProgress() {
		progress = lastScore-score;
		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}
	
	
	
}
