package com.wyq.competition._11lanqiao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: algorithm-practice
 * @description: 纪念日
 * @author: Mr.Wang
 * @create: 2021-05-01 17:25
 **/
public class _01_B纪念日 {
    public static void main(String[] args) throws ParseException {
        /*
        * 在java的api说明中，只能返回1970以前的时间，但是现在1921年却是可以正常进行计算的
        * */
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        Date begin = format.parse("1321-7-23 12:00:00");
        Date end = format.parse("2020-7-1 12:00:00");
        long time = end.getTime()-begin.getTime();
        System.out.println(time/(1000*60));
    }
}
