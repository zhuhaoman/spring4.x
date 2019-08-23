package com.zhuhaoman.aop;

import org.apache.tools.ant.util.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @ClassName TimeZoneTest
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/21 15:05
 **/
public class TimeZoneTest {
    @Test
    public void test1() {
        Date time = new Date(1566371378498L);

        SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //北京
        bjSdf.setTimeZone(TimeZone.getTimeZone("CTT"));

        SimpleDateFormat bj2Sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //北京
        bj2Sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));

        SimpleDateFormat tokyoSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 东京
        tokyoSdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));  // 设置东京时区

        SimpleDateFormat londonSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 伦敦
        londonSdf.setTimeZone(TimeZone.getTimeZone("Europe/London"));

        System.out.println(time.getTime()+":" + bjSdf.format(time));
        System.out.println(time.getTime()+":" + bj2Sdf.format(time));
        System.out.println(time.getTime()+":" + tokyoSdf.format(time));
        System.out.println(time.getTime()+":" + londonSdf.format(time));

    }

    @Test
    public void test2() throws ParseException {
        SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //北京
        bjSdf.setTimeZone(TimeZone.getTimeZone("America/Chicago"));

        Date bjDate = bjSdf.parse("2019-01-01 08:00:00");
        System.out.println(bjDate);
    }

    @Test
    public void test3() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date time = format.parse("2019-12-21");

        System.out.println(time);
        System.out.println(new Date(time.getTime()));
//        long oneDay = 1000 * 60 * 60 * 24;
//        System.out.println(new Date(time.getTime() + oneDay-1));
//        System.out.println(format.parse(time.toInstant().toString() + " 00:00:00"));
    }

}
