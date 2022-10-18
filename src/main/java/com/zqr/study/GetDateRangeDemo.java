package com.zqr.study;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Kendric
 * @className GetDateRangeDemo
 * @description 获取日期范围，如，ThisMonth，LastMonth，last 3 Month...
 * @createTime 2021/9/2 10:30
 */
public class GetDateRangeDemo {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws Exception {
        //获取当月日期范围（截至今天）
        String thisMonth = getThisMonth();
        System.out.println(thisMonth);
        //获取前num个月日期范围
        int num = 6;
        String lastMonth = getLastNumMonth(num);
        System.out.println(lastMonth);
    }

    public static String getThisMonth() {
        try {
            Date now = new Date();

            String firstDay = getFirstDay(now);
            String lastDay = getLastDay(now);
            return firstDay + "-" + lastDay;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public static String getLastNumMonth(int num) {
        try {
            Date nowDate = new Date();
            //获得上个月的Date
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(nowDate);
            calendar.add(Calendar.MONTH, -1);
            Date lastDate = calendar.getTime();
            calendar.add(Calendar.MONTH, -num+1);
            Date firstDate = calendar.getTime();

            String firstDay = getFirstDay(firstDate);
            String lastDay = getLastDay(lastDate);
            return firstDay + "-" + lastDay;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }


    public static String getFirstDay(Date start_time) {
//        String date = "";
//        Calendar cale = Calendar.getInstance();
//        // 获取当月的第一天
//        cale = Calendar.getInstance();
//        cale.setTime(start_time);
//        cale.add(Calendar.MONTH, 0);
//        cale.set(Calendar.DAY_OF_MONTH, 1);
//        date = format.format(cale.getTime());

        return new SimpleDateFormat("yyyy-MM-01").format(start_time);
    }

    public static String getLastDay(Date start_time) {
        String date = "";
        Calendar cale = Calendar.getInstance();
        // 获取当月的最后一天
        cale = Calendar.getInstance();
        cale.setTime(start_time);
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        date = format.format(cale.getTime());
        return date;
    }
}
