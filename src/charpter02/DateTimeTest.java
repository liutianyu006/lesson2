package charpter02;

import java.util.Date;

public class DateTimeTest {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(time);

        //1、默认创建的就是当前时间对应的Date对象
        Date t2 = new Date();
        System.out.println(t2); //toString方法显示年月日时分秒
        System.out.println(t2.getTime());//getTime方法，获取对象（距离1970年1月1日0时0分0秒）对应的毫秒数（时间戳）

        //2、创建指定毫秒数的Date对象
        Date t3 = new Date(166236181732L);
        System.out.println(t3);
        System.out.println(t3.getTime());

        java.sql.Date jd1 = new java.sql.Date(166236181732L);
        System.out.println(jd1);

        Date t4 = new Date();
//        java.sql.Date jd2 = (java.sql.Date)t4; // 强转会报错，因为不满足instance of条件
        //正确方式
        java.sql.Date jd3 = new java.sql.Date(t4.getTime());
        System.out.println(jd3.getTime());



    }
}
