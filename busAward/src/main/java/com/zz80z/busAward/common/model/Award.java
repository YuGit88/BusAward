package com.zz80z.busAward.common.model;

import net.sf.json.JSONObject;

public class Award {
    private Integer awardId;

    private Integer advancedGroup;

    private Integer progressGroup;

    private Integer level;

    private Integer firstBest;

    private Integer firstBetter;

    private Integer firstSubject;

    private Integer progressGrade;

    private Integer progressClass;

    private Integer advancedClass;

    private Integer activiytDuty;

    private Integer activiytFirst;

    private Integer activiytSecond;

    private Integer activiytThird;

    private Integer weekCoin;

    public Award() {
		super();
	}

	public Award(Integer awardId, Integer advancedGroup, Integer progressGroup, Integer level, Integer firstBest,
			Integer firstBetter, Integer firstSubject, Integer progressGrade, Integer progressClass,
			Integer advancedClass, Integer activiytDuty, Integer activiytFirst, Integer activiytSecond,
			Integer activiytThird, Integer weekCoin) {
		super();
		this.awardId = awardId;
		this.advancedGroup = advancedGroup;
		this.progressGroup = progressGroup;
		this.level = level;
		this.firstBest = firstBest;
		this.firstBetter = firstBetter;
		this.firstSubject = firstSubject;
		this.progressGrade = progressGrade;
		this.progressClass = progressClass;
		this.advancedClass = advancedClass;
		this.activiytDuty = activiytDuty;
		this.activiytFirst = activiytFirst;
		this.activiytSecond = activiytSecond;
		this.activiytThird = activiytThird;
		this.weekCoin = weekCoin;
	}

	public Integer getAwardId() {
        return awardId;
    }

    public void setAwardId(Integer awardId) {
        this.awardId = awardId;
    }

    public Integer getAdvancedGroup() {
        return advancedGroup;
    }

    public void setAdvancedGroup(Integer advancedGroup) {
        this.advancedGroup = advancedGroup;
    }

    public Integer getProgressGroup() {
        return progressGroup;
    }

    public void setProgressGroup(Integer progressGroup) {
        this.progressGroup = progressGroup;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getFirstBest() {
        return firstBest;
    }

    public void setFirstBest(Integer firstBest) {
        this.firstBest = firstBest;
    }

    public Integer getFirstBetter() {
        return firstBetter;
    }

    public void setFirstBetter(Integer firstBetter) {
        this.firstBetter = firstBetter;
    }

    public Integer getFirstSubject() {
        return firstSubject;
    }

    public void setFirstSubject(Integer firstSubject) {
        this.firstSubject = firstSubject;
    }

    public Integer getProgressGrade() {
        return progressGrade;
    }

    public void setProgressGrade(Integer progressGrade) {
        this.progressGrade = progressGrade;
    }

    public Integer getProgressClass() {
        return progressClass;
    }

    public void setProgressClass(Integer progressClass) {
        this.progressClass = progressClass;
    }

    public Integer getAdvancedClass() {
        return advancedClass;
    }

    public void setAdvancedClass(Integer advancedClass) {
        this.advancedClass = advancedClass;
    }

    public Integer getActiviytDuty() {
        return activiytDuty;
    }

    public void setActiviytDuty(Integer activiytDuty) {
        this.activiytDuty = activiytDuty;
    }

    public Integer getActiviytFirst() {
        return activiytFirst;
    }

    public void setActiviytFirst(Integer activiytFirst) {
        this.activiytFirst = activiytFirst;
    }

    public Integer getActiviytSecond() {
        return activiytSecond;
    }

    public void setActiviytSecond(Integer activiytSecond) {
        this.activiytSecond = activiytSecond;
    }

    public Integer getActiviytThird() {
        return activiytThird;
    }

    public void setActiviytThird(Integer activiytThird) {
        this.activiytThird = activiytThird;
    }

    public Integer getWeekCoin() {
        return weekCoin;
    }

    public void setWeekCoin(Integer weekCoin) {
        this.weekCoin = weekCoin;
    }
    public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}