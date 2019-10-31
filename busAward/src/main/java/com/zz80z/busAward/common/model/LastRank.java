package com.zz80z.busAward.common.model;

public class LastRank {
  
    @Override
	public String toString() {
		return "LastRank [id=" + id + ", className=" + className + ", gradeName=" + gradeName + ", stuClassMark="
				+ stuClassMark + ", stuGroup=" + stuGroup + ", total=" + total + ", week=" + week + ", rank=" + rank
				+ ", prank=" + prank + "]";
	}


	private Integer id;

    private String className;
    
    private String  gradeName;
    
    public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public String getGradeName() {
		return gradeName;
	}


	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}


	private String stuClassMark;

  
    private String stuGroup;


	private Double total;

 
    private Integer week;

   
    private Integer rank;
    //进步名次
    private Integer prank;
    
    public Integer getPrank() {
		return prank;
	}


	public void setPrank(Integer prank) {
		this.prank = prank;
	}


	public Integer getId() {
        return id;
    }

   
    public void setId(Integer id) {
        this.id = id;
    }

   
    public String getStuClassMark() {
        return stuClassMark;
    }

   
    public void setStuClassMark(String stuClassMark) {
        this.stuClassMark = stuClassMark;
    }

  
    public String getStuGroup() {
        return stuGroup;
    }

 
    public void setStuGroup(String stuGroup) {
        this.stuGroup = stuGroup;
    }

  
    public Double getTotal() {
        return total;
    }

  
    public void setTotal(Double total) {
        this.total = total;
    }

  
    public Integer getWeek() {
        return week;
    }

   
    public void setWeek(Integer week) {
        this.week = week;
    }

  
    public Integer getRank() {
        return rank;
    }

 
    public void setRank(Integer rank) {
        this.rank = rank;
    }
}