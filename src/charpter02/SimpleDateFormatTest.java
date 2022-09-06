package charpter02;

import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    @Test
    public void test1() throws ParseException {
        Date d1 = new Date();  // Mon Sep 05 16:57:52 CST 2022
        System.out.println(d1);

        //创建实例，使用默认构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //将Date实例对象格式化：将Date类型转换成String类型
        String date_str = sdf.format(d1);
        System.out.println(date_str); //2022/9/5 下午4:57

        //对String对象进行解析：格式化的逆过程，将String类型转换成Date类型
        Date d2 = sdf.parse("2021/8/5 下午2:34");
        System.out.println(d2);  //Thu Aug 05 14:34:00 CST 2021

        //****************************************************
        System.out.println("************************");

        Date d3 = new Date();
        System.out.println(d1);

        //带参构造器
        SimpleDateFormat sdf2 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");

        //格式化成pattern的格式
        String date_str2 = sdf2.format(d1);
        System.out.println(date_str2);

        //解析也只能解析pattern的格式
        String date_str3 = "周一, 3 9月 2012 17:03:46 +0800";
        System.out.println(sdf2.parse(date_str3));

        //****************************************************
        System.out.println("************************");
        String s1 = "2020-09-08";
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sd.parse(s1);
        java.sql.Date jsd = new java.sql.Date(date1.getTime());


    }
}
