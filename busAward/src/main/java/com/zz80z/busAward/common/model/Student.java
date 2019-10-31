package com.zz80z.busAward.common.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import freemarker.cache.StrongCacheStorage;


public class Student {
	/**
	 * 主键
	 */
    private Integer stuId;
    /**
     * 学籍号
     */
    private String stuNo;
    /**
     * 真实姓名
     */
	private String realName;
	/**
	 * 性别
	 */
    private String stuSex;
    /**
     * 学生地址
     */
    private String stuAddress;
    /**
     * 学生生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stuBirthday;
    /**
     * 班级id
     */
    private Integer classId;
    /**
     * 学生小组
     */
    private String stuGroup;
    /**
     * 班级标识
     */
    private String stuClassMark;
    /**
     * 校园状态
     */
    private String reserve;
    /**
     * 民族
     */
    private String nation;
    /**
     * 身份证号
     */
    private String numberId;
    /**
     * 学生状态
     */
    private String stuState;
    /**
     * 问题类型
     */
    private String problemType;
    /**
     * 错误类型
     */
    private String erroeType;
    /**
     * 对应的班级类
     */
    private Classs classs;
    /**
     * 对应的成绩列表
     */
    private List<Score> scores;

    public Student() {
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	public Classs getClasss() {
		return classs;
	}

	public void setClasss(Classs classs) {
		this.classs = classs;
	}

	public Integer getstuId() {
        return stuId;
    }

    public void setstuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getNumberId() {
		return numberId;
	}

	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}

	public String getstuNo() {
        return stuNo;
    }

    public void setstuNo(String stuNo) {
        this.stuNo = stuNo == null ? null : stuNo.trim();
    }

    public String getrealName() {
        return realName;
    }

    public void setrealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getstuSex() {
        return stuSex;
    }

    public void setstuSex(String stuSex) {
        this.stuSex = stuSex == null ? null : stuSex.trim();
    }

    public String getstuAddress() {
        return stuAddress;
    }

    public void setstuAddress(String stuAddress) {
        this.stuAddress = stuAddress == null ? null : stuAddress.trim();
    }

    public Date getstuBirthday() {
        return stuBirthday;
    }

    public void setstuBirthday(Date stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}


	public String getStuState() {
		return stuState;
	}

	public void setStuState(String stuState) {
		this.stuState = stuState;
	}

	public String getProblemType() {
		return problemType;
	}

	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}

	public String getErroeType() {
		return erroeType;
	}

	public void setErroeType(String erroeType) {
		this.erroeType = erroeType;
	}

	public Integer getclassId() {
        return classId;
    }

    public void setclassId(Integer classId) {
        this.classId = classId;
    }

    public String getstuGroup() {
        return stuGroup;
    }

    public void setstuGroup(String stuGroup) {
        this.stuGroup = stuGroup == null ? null : stuGroup.trim();
    }

    public String getstuClassMark() {
        return stuClassMark;
    }

    public void setstuClassMark(String stuClassMark) {
        this.stuClassMark = stuClassMark == null ? null : stuClassMark.trim();
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve == null ? null : reserve.trim();
    }

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuNo=" + stuNo + ", realName=" + realName + ", stuSex=" + stuSex
				+ ", stuAddress=" + stuAddress + ", stuBirthday=" + stuBirthday + ", classId=" + classId + ", stuGroup="
				+ stuGroup + ", stuClassMark=" + stuClassMark + ", reserve=" + reserve + ", nation=" + nation
				+ ", numberId=" + numberId + ", stuState=" + stuState + ", problemType=" + problemType
				+ ", erroeType=" + erroeType + ", classs=" + classs + ", scores=" + scores + "]";
	}
}