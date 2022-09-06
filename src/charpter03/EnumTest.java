package charpter03;

/**
 * 自定义枚举类
 */

public class EnumTest {
    public static void main(String[] args) {
        Season.WINTER.show();
        Season.SPRING.show();

    }
}

interface Info{
    void show();
}
//自定义枚举类
class Season implements Info{
    // 1. 声明 Season 对象的属性 :private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    // 2. 私有化类的构造器 , 并给对象属性赋值
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    // 3. 提供当前枚举类的多个对象,定义为类的静态常量
    public static final Season SPRING = new Season(" 春天 ", " 万物复苏 ");
    public static final Season SUMMER = new Season(" 夏天 ", " 烈日炎炎 ");
    public static final Season AUTUMN = new Season(" 秋天 ", " 秋高气爽 ");
    public static final Season WINTER = new Season(" 冬天 ", " 白雪皑皑 ");


    //4、其他诉求：获取枚举类的对象属性(由于属性是final的，所以没有setter)
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    //5、其他诉求：提供toString方法
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

    @Override
    public void show() {
        System.out.println("这是一个美丽的季节");
    }
}
