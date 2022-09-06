package charpter02;

import org.testng.annotations.Test;

import java.time.*;

public class LocalDateTimeTest {
    @Test
    public void test1() {
    // now(): 获取当前的日期、时间、日期 + 时间，这3个类都是static方法调用构造器
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        System.out.println("*******************************************");

    // of(): 设置指定的年、月、日、时、分、秒，这里就是具体的时间点，不是偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1);

    // getXxx()：获取相关的属性，跟calendar类似
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());

    // 体现不可变性：原有实例不变，返回新的实例对象
    // withXxx(): 设置相关的属性，返回新的对象，不修改原有对象
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);


        System.out.println("**************************************");

        // 构造器一：now(): 获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant); // 2022-09-05T11:00:00.071576Z

        // 添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));// 东八区
        System.out.println(offsetDateTime); //实际时间是2022-09-05T19:00:00.071576+08:00

        // toEpochMilli(): 获取自 1970年1月1日0时0分0秒（UTC）开始的毫秒数 ---> Date 类的 getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        // 构造器二：ofEpochMilli(): 通过给定的毫秒数，获取Instant实例；等同于Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1550475314878L);
        System.out.println(instant1); // 2019-02-18T07:35:14.878Z
    }
}
