package charpter02;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

public class DateTimeFormaterTest {
    @Test
    public void test(){
    // 方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();

        // 格式化 : 日期 --> 字符串
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);
        // 解析：字符串 --> 日期
        TemporalAccessor parse = formatter.parse("2022-09-05T19:24:24.292645");
        System.out.println(parse);

    // 方式二：
        // 本地化相关的格式。如：ofLocalizedDateTime()
        // FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于 LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        // 格式化
        System.out.println(formatter1.format(LocalDateTime.now()));


        // 本地化相关的格式。如：ofLocalizedDate()
        // FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT: 适用于 LocalDate
        DateTimeFormatter formatter2 = DateTimeFormatter.
                ofLocalizedDate(FormatStyle.MEDIUM);
        // 格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);

    // 重点：方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.
                ofPattern("yyyy-MM-dd hh:mm:ss");
        // 格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);
        // 解析
        TemporalAccessor accessor = formatter3.
                parse("2020-05-10 06:26:40");
        System.out.println(accessor);
    }
}
