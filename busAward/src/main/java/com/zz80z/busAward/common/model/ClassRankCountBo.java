package com.zz80z.busAward.common.model;

import net.sf.json.JSONObject;

public class ClassRankCountBo {

	private String examName;

	private Integer semesterId;

	private String classMark;

	private Integer rank10Count;

	private String rank10names;

	private Integer rank20Count;

	private String rank20names;

	private Integer rank50Count;

	private String rank50names;

	private Integer rank100Count;

	private String rank100names;

	private Integer rank150Count;

	private String rank150names;

	private Integer rank200Count;

	private String rank200names;

	private Integer rank300Count;

	private String rank300names;

	public ClassRankCountBo() {
		super();
	}


	public ClassRankCountBo(String examName, Integer semesterId, String classMark, Integer rank10Count,
			String rank10names, Integer rank20Count, String rank20names, Integer rank50Count, String rank50names,
			Integer rank100Count, String rank100names, Integer rank150Count, String rank150names, Integer rank200Count,
			String rank200names, Integer rank300Count, String rank300names) {
		super();
		this.examName = examName;
		this.semesterId = semesterId;
		this.classMark = classMark;
		this.rank10Count = rank10Count;
		this.rank10names = rank10names;
		this.rank20Count = rank20Count;
		this.rank20names = rank20names;
		this.rank50Count = rank50Count;
		this.rank50names = rank50names;
		this.rank100Count = rank100Count;
		this.rank100names = rank100names;
		this.rank150Count = rank150Count;
		this.rank150names = rank150names;
		this.rank200Count = rank200Count;
		this.rank200names = rank200names;
		this.rank300Count = rank300Count;
		this.rank300names = rank300names;
	}


	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public Integer getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(Integer semesterId) {
		this.semesterId = semesterId;
	}

	public String getClassMark() {
		return classMark;
	}

	public void setClassMark(String classMark) {
		this.classMark = classMark;
	}

	public Integer getRank10Count() {
		return rank10Count;
	}

	public void setRank10Count(Integer rank10Count) {
		this.rank10Count = rank10Count;
	}

	public String getRank10names() {
		return rank10names;
	}

	public void setRank10names(String rank10names) {
		this.rank10names = rank10names;
	}

	public Integer getRank20Count() {
		return rank20Count;
	}

	public void setRank20Count(Integer rank20Count) {
		this.rank20Count = rank20Count;
	}

	public String getRank20names() {
		return rank20names;
	}

	public void setRank20names(String rank20names) {
		this.rank20names = rank20names;
	}

	public Integer getRank50Count() {
		return rank50Count;
	}

	public void setRank50Count(Integer rank50Count) {
		this.rank50Count = rank50Count;
	}

	public String getRank50names() {
		return rank50names;
	}

	public void setRank50names(String rank50names) {
		this.rank50names = rank50names;
	}

	public Integer getRank100Count() {
		return rank100Count;
	}

	public void setRank100Count(Integer rank100Count) {
		this.rank100Count = rank100Count;
	}

	public String getRank100names() {
		return rank100names;
	}

	public void setRank100names(String rank100names) {
		this.rank100names = rank100names;
	}

	public Integer getRank150Count() {
		return rank150Count;
	}

	public void setRank150Count(Integer rank150Count) {
		this.rank150Count = rank150Count;
	}

	public String getRank150names() {
		return rank150names;
	}

	public void setRank150names(String rank150names) {
		this.rank150names = rank150names;
	}

	public Integer getRank200Count() {
		return rank200Count;
	}

	public void setRank200Count(Integer rank200Count) {
		this.rank200Count = rank200Count;
	}

	public String getRank200names() {
		return rank200names;
	}

	public void setRank200names(String rank200names) {
		this.rank200names = rank200names;
	}

	public Integer getRank300Count() {
		return rank300Count;
	}

	public void setRank300Count(Integer rank300Count) {
		this.rank300Count = rank300Count;
	}

	public String getRank300names() {
		return rank300names;
	}

	public void setRank300names(String rank300names) {
		this.rank300names = rank300names;
	}

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}
