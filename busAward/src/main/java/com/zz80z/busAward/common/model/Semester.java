package com.zz80z.busAward.common.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zz80z.busAward.common.utils.NewWeekUtils;

public class Semester {
    private Integer semesterId;

    private String semesterName;

    private Date creatTime;

    private Date recessTime;

    private String reserve;
    
    private int whatWeek;

    
    public int getWhatWeek() {
    	
//    	Calendar cal = Calendar.getInstance();
//		cal.setFirstDayOfWeek(Calendar.MONDAY);
//		int i = cal.get(Calendar.WEEK_OF_YEAR);
    	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//		cal.setTime(creatTime);
//		int j = cal.get(Calendar.WEEK_OF_YEAR);
    	NewWeekUtils newWeekUtils = new NewWeekUtils();
    	
    	try {
			int [] cw = newWeekUtils.selectWeekNum(sf.parse(sf.format(creatTime)),sf.parse(sf.format(recessTime)));
			whatWeek=cw[0];
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//whatWeek=i-j;
		return whatWeek;
	}

	public Semester() {
		super();
	}

	public Semester(String semesterName, Date creatTime, Date recessTime) {
		super();
		this.semesterName = semesterName;
		this.creatTime = creatTime;
		this.recessTime = recessTime;
	}

	public void setWhatWeek(int whatWeek) {
		this.whatWeek = whatWeek;
	}

	public Integer getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Integer semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName == null ? null : semesterName.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getRecessTime() {
        return recessTime;
    }

    public void setRecessTime(Date recessTime) {
        this.recessTime = recessTime;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve == null ? null : reserve.trim();
    }

	@Override
	public String toString() {
		return "Semester [semesterId=" + semesterId + ", semesterName=" + semesterName + ", creatTime=" + creatTime
				+ ", recessTime=" + recessTime + ", reserve=" + reserve + ", whatWeek=" + whatWeek + "]";
	}
}