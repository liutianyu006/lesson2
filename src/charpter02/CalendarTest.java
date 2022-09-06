package charpter02;

import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    @Test
    public void test2(){
        Calendar calendar1 = Calendar.getInstance();

        //get方法
        /**
         * calendar1中的fields[]存放日历信息，然后calendar1.get方法查fields[]中的第几个索引
         * Calendar.DAY_OF_YEAR是固定值6,DAY_OF_MONTH是固定值5 等等.......
         * 后面的add set方法是一个意思
         */
        int days = calendar1.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);
        //set方法
        calendar1.set(Calendar.DAY_OF_MONTH,20);
        int days2 = calendar1.get(Calendar.DAY_OF_MONTH);
        System.out.println(days2);
        //add方法
        calendar1.add(Calendar.DAY_OF_MONTH,10);
        int days3 = calendar1.get(Calendar.DAY_OF_MONTH);
        System.out.println(days3);

        // getTime(): 日历类 ---> Date
        Date date = calendar1.getTime();
        System.out.println(date); // Tue May 19 17:12:06 CST 2020

        // setTime():将Date实例的时间属性赋给Calendar类实例
        Date date1 = new Date();
        calendar1.setTime(date1);
        int days4 = calendar1.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);  //5


    }
}
