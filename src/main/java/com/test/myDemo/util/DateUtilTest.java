package com.test.myDemo.util;

import org.apache.commons.compress.utils.Lists;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.*;

/**
 * @author liang.gu
 * @date 2021/1/19
 */
public class DateUtilTest {

    public static final DateTimeFormatter FILE_DIRECTORY = DateTimeFormatter.ofPattern("'Folder 'yyyy'/Folder Disbursement file/fold 'MMMM'/folder 'yyyyMMdd",Locale.ENGLISH);


    public static void main(String[] args) throws Exception{
        Lists.newArrayList();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("'Folder 'yyyy'/Folder Disbursement file/fold 'MMMM'/folder 'yyyyMMdd", Locale.ENGLISH);
//        System.out.println(dateFormat.format(new Date()));
//        String fullName = "GINA INDRI YANTI SOLIHAT";
//        String fullName = "YANTI SOLIHAT";

//        System.out.println(fullName.substring(0,fullName.indexOf(" ")));
//        System.out.println(fullName.substring(fullName.indexOf(" "),fullName.lastIndexOf(" ")));
//        System.out.println(fullName.substring(fullName.lastIndexOf(" "),fullName.length()));
//
//        System.out.println(DateUtilTest.getResidentialStaySinceYear("2019-12"));
//
//        System.out.println(FILE_DIRECTORY.format(LocalDateTime.now()));

        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat2.parse("2021-02-20 00:00:00");
        System.out.println(date.getTime());
        Date date2 = dateFormat2.parse("2021-02-18 23:59:59");
        System.out.println(date2.getTime());

         //WUS_ARTOS  5e1fd86312aef63309285219
        /**
         * 10.21 - 11.20    49040045382.0000        20266263993.0000
         * 11.21 - 12.20    82484464959.0000        43726859286.0000
         * 12.21 - 1.20     218487048884.0000        79392464043.0000
         */
        //VCC_JAGO   5feda61412aef62091b4e113
        /**
         *1.1 - 1.20    3542385774.0000   3542385774.0000
         */
//        long a1 = 49040045382L,b1 = 20266263993L;
//        System.out.println("a1==="+(a1 - b1));
//        long a2 = 82484464959L,b2 = 43726859286L;
//        System.out.println("a2==="+(a2 - b2));
//        long a3 = 218487048884L,b3 = 79392464043L;
//        System.out.println("a3==="+(a3 - b3));
//
//        long a4 = 3542385774L,b4 = 3542385774L;
//        System.out.println("a4==="+(a4 - b4));

    }

    private String get(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        while (!isWorkDay(cal)) {
            cal.add(DAY_OF_WEEK, -1);
        }
        return "";
    }

    static boolean isWeekend(Calendar cal) {
        int dayOfWeek = cal.get(DAY_OF_WEEK);
        return (dayOfWeek == SATURDAY || dayOfWeek == SUNDAY);
    }

    static boolean isWorkDay(Calendar cal) {
        return !isWeekend(cal) ;
    }

    /**
     * 转换用户出生日期
     * @param residentialStaySince
     * @return
     */
    public static String getResidentialStaySinceYear(String residentialStaySince)throws Exception{
        if(residentialStaySince == null){
            return "00";
        }
        Date residentialDate = (new SimpleDateFormat("yyyy-MM")).parse(residentialStaySince);
        Calendar date = Calendar.getInstance();
        date.setTime(residentialDate);
        int diff = Calendar.getInstance().get(Calendar.YEAR) -  date.get(Calendar.YEAR);
        if(diff <= 0){
            return "00";
        }
        else if(diff < 10){
            return "0"+diff;
        }
        else{
            return ""+diff;
        }
    }

}
