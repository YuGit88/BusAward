package com.zz80z.busAward.common.utils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

  
public class WeekUtils {  
	 public static void main(String[] args) {
		 WeekUtils wek=new WeekUtils();
		Map map= wek.getThisMothBeginAndEndTime();
		List<Map> list = new ArrayList<Map>();
		for(Map ma : list) {
			System.out.println(ma);
		}
	}
        /** 
         * get first date of given month and year 
         * @param year 
         * @param month 
         * @return 
         */  
        public String getFirstDayOfMonth(int year,int month){  
            String monthStr = month < 10 ? "0" + month : String.valueOf(month);  
            return year + "-"+monthStr+"-" +"01";  
        }  
          
        /** 
         * get the last date of given month and year 
         * @param year 
         * @param month 
         * @return 
         */  
        public String getLastDayOfMonth(int year,int month){  
            Calendar calendar = Calendar.getInstance();  
            calendar.set(Calendar.YEAR , year);  
            calendar.set(Calendar.MONTH , month - 1);  
            calendar.set(Calendar.DATE , 1);  
            calendar.add(Calendar.MONTH, 1);  
            calendar.add(Calendar.DAY_OF_YEAR , -1);  
            return calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" +  
                   calendar.get(Calendar.DAY_OF_MONTH);  
        }  
          
        /** 
         * get Calendar of given year 
         * @param year 
         * @return 
         */  
        private Calendar getCalendarFormYear(int year){  
            Calendar cal = Calendar.getInstance();  
            cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);        
            cal.set(Calendar.YEAR, year);  
            return cal;  
        }  
          
        /** 
         * get start date of given week no of a year 
         * @param year 
         * @param weekNo 
         * @return 
         */  
        public String getStartDayOfWeekNo(int year,int weekNo){  
            Calendar cal = getCalendarFormYear(year);  
            cal.set(Calendar.WEEK_OF_YEAR, weekNo);  
            return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" +  
                   cal.get(Calendar.DAY_OF_MONTH);      
              
        }  
          
        /** 
         * get the end day of given week no of a year. 
         * @param year 
         * @param weekNo 
         * @return 
         */  
        public String getEndDayOfWeekNo(int year,int weekNo){  
            Calendar cal = getCalendarFormYear(year);  
            cal.set(Calendar.WEEK_OF_YEAR, weekNo);  
            cal.add(Calendar.DAY_OF_WEEK, 6);  
            return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" +  
                   cal.get(Calendar.DAY_OF_MONTH);      
        }  
        /**
         * 获取上周的时间段
         * @return
         */
        public Map getLastTimeInterval() {  
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar1 = Calendar.getInstance();  
            Calendar calendar2 = Calendar.getInstance();  
            int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) -1;  
            int offset1 = 1 - dayOfWeek;  
            int offset2 = 7 - dayOfWeek;  
            calendar1.add(Calendar.DATE, offset1 - 7);  
            calendar2.add(Calendar.DATE, offset2 - 7);  
            String lastBeginDate = sdf.format(calendar1.getTime());  
            String lastEndDate = sdf.format(calendar2.getTime());  
            Map<String, String> counDate=new HashMap<String, String>();
            counDate.put("lastBeginDate", lastBeginDate);
            counDate.put("lastEndDate", lastEndDate);
            return counDate;  
       }
        
        /**
         * 	获取前N周的时间段
         * @return
         */
        public Map getNTimeInterval(Integer n) {  
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar1 = Calendar.getInstance();  
            Calendar calendar2 = Calendar.getInstance();  
            int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) -1;  
            int offset1 = 1 - dayOfWeek;  
            int offset2 = 7 - dayOfWeek;  
            calendar1.add(Calendar.DATE, offset1 - n*7);  
            calendar2.add(Calendar.DATE, offset2 - n*7);  
            String lastBeginDate = sdf.format(calendar1.getTime());  
            String lastEndDate = sdf.format(calendar2.getTime());  
            Map<String, String> counDate=new HashMap<String, String>();
            counDate.put("beginTime", lastBeginDate);
            counDate.put("endTime", lastEndDate);
            return counDate;  
       }
        
        public Map getThisMothBeginAndEndTime(){
    		WeekUtils weekUtils=new WeekUtils();
    		Date date=new Date();
    		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    		String dates=sdf.format(date);
    		String [] ymd=dates.split("-");
    		int year=Integer.parseInt(ymd[0]);
    		int month=Integer.parseInt(ymd[1]);
    		Map map=new HashMap();
    		map.put("beginTime", weekUtils.getFirstDayOfMonth(year, month));
    		map.put("endTime", weekUtils.getLastDayOfMonth(year, month));
			return map;
        }
        
        /**
         * 获取N周的时间段
         * @return
         */
        public Map getTimeInterval(Integer n) {  
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar1 = Calendar.getInstance();  
            Calendar calendar2 = Calendar.getInstance();  
            int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) -1;  
            int offset1 = 1 - dayOfWeek;  
            int offset2 = 7 - dayOfWeek;  
            calendar1.add(Calendar.DATE, offset1);  
            calendar2.add(Calendar.DATE, offset2);  
            String lastBeginDate = sdf.format(calendar1.getTime());  
            String lastEndDate = sdf.format(calendar2.getTime());  
            Map<String, String> counDate=new HashMap<String, String>();
            counDate.put("lastBeginDate", lastBeginDate);
            counDate.put("lastEndDate", lastEndDate);
            return counDate;  
       }
    }  