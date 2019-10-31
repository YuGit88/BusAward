package com.zz80z.busAward.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewWeekUtils {

	 public static void main(String[] args) {
		NewWeekUtils newWeekUtils = new  NewWeekUtils();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			int [] test =newWeekUtils.selectWeekNum(dateFormat.parse("2018-09-01"),dateFormat.parse("2019-01-03"));
		System.out.println(test[0]+","+test[1]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
     * 查询一个时间段的总周数和查询当前时间是第几周
     * @param start
     * @param end
     * @return
     */
    public int[] selectWeekNum(Date start,Date end){
        java.util.Calendar now = java.util.Calendar.getInstance();
        java.util.Calendar c_total = java.util.Calendar.getInstance();
        java.util.Calendar c_begin =  java.util.Calendar.getInstance();
        java.util.Calendar c_end = java.util.Calendar.getInstance();
        int count = 0;
        int weekTotal = 0;
        try {
            c_begin.setTime(start);
            c_end.setTime(end);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            now.setTime(sdf.parse(sdf.format(new Date())));
            int begin = c_begin.get(java.util.Calendar.WEEK_OF_YEAR);
            int over =c_end.get( java.util.Calendar.WEEK_OF_YEAR);
            int z = now.get( java.util.Calendar.WEEK_OF_YEAR);
            if (c_begin.getWeekYear() != c_end.getWeekYear()) {
                Date totalYear = new SimpleDateFormat("yyyy-MM-dd").parse(c_begin.getWeekYear() + "-12-31");
                c_total.setTime(totalYear);
                int x = c_total.get(java.util.Calendar.WEEK_OF_YEAR);
                while(x==1){
                    c_total.add(java.util.Calendar.DAY_OF_MONTH, -1);
                    x = c_total.get(java.util.Calendar.WEEK_OF_YEAR);
                }
                //如果结束时间刚好是星期天则不加1
                int weekNum  = this.dayForWeek(new SimpleDateFormat("yyyy-MM-dd").format(end));
                int duoyu = 0;
                if(weekNum==7) {
                     duoyu = x - begin+1;
                }else{
                    duoyu = x - begin + 1+1;
                }
                weekTotal = over + duoyu;
            } else {
                //如果结束时间刚好是星期天则不加1
                int weekNum  = this.dayForWeek(new SimpleDateFormat("yyyy-MM-dd").format(end));
                if(weekNum==7){
                    weekTotal = over - begin;
                }else{
                    weekTotal = over - begin + 1;
                }
            }
            if (c_begin.getWeekYear() != now.getWeekYear()) {
                //计算总周数
                int x = c_total.get(java.util.Calendar.WEEK_OF_YEAR);
                while(x==1){
                    c_total.add(java.util.Calendar.DAY_OF_MONTH, -1);
                    x = c_total.get(java.util.Calendar.WEEK_OF_YEAR);
                }
                int weekNum  = this.dayForWeek(new SimpleDateFormat("yyyy-MM-dd").format(start));
                int duoyu =0;
                if(weekNum==7){
                    duoyu = x - begin + 1+1;
                }else{
                    duoyu = x - begin + 1;
                }
                count = duoyu + z;
            } else {
                int weekNum  = this.dayForWeek(new SimpleDateFormat("yyyy-MM-dd").format(start));
                if(weekNum==7){
                    count = (z - begin + 1)+1;
                }else{
                    count = (z - begin + 1);
                }
            }
            if (c_end.getTime().getTime() < now.getTime().getTime() || count < 0) {
                //如果当前时间大于学期结束时间，默然显示第一周
                count = 1;
            }
          //下拉框默认显示的东西可根据实际情况删除或保留
//            if (week != 0 && flag == 1) {
//                count = week;
//            }
        }  catch (Exception e) {
              e.printStackTrace();
        }
        return new int[]{count,weekTotal};
    }
/**
     * 判断当前日期是星期几
     *
     * @param pTime 修要判断的时间
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */
    public int dayForWeek(String pTime) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util. Calendar c =  java.util. Calendar.getInstance();
        c.setTime(format.parse(pTime));
        int dayForWeek = 0;
        if(c.get( java.util. Calendar.DAY_OF_WEEK) == 1){
            dayForWeek = 7;
        }else{
            dayForWeek = c.get( java.util. Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }
 /**
     * 查询一周的开始时间和结束时间
     * @param date
     * @return
     */
    private Map<String,Date>  onceWeek(Date date){
       java.util.Calendar currentDate = new GregorianCalendar();
        currentDate.setTime(date);
        currentDate.setFirstDayOfWeek( java.util.Calendar.MONDAY);
        currentDate.set( java.util.Calendar.HOUR_OF_DAY, 0);
        currentDate.set( java.util.Calendar.MINUTE, 0);
        currentDate.set( java.util.Calendar.SECOND, 0);
        currentDate.set( java.util.Calendar.DAY_OF_WEEK,  java.util.Calendar.MONDAY);
        Date dBegin = (Date) currentDate.getTime().clone();

        currentDate.setFirstDayOfWeek( java.util.Calendar.MONDAY);
        currentDate.set( java.util.Calendar.HOUR_OF_DAY, 23);
        currentDate.set( java.util.Calendar.MINUTE, 59);
        currentDate.set( java.util.Calendar.SECOND, 59);
        currentDate.set( java.util.Calendar.DAY_OF_WEEK,  java.util.Calendar.SUNDAY);

        Date dEnd =(Date) currentDate.getTime().clone();

        //返回星期天和一个星期的日期和周几
        Map<String,Date> map = new HashMap<>();
        map.put("dBegin",dBegin);
        map.put("dEnd",dEnd);
        return map;
    }									
 
}
