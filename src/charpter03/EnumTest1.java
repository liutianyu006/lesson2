package charpter03;

/**
 * 使用 enum 关键字定义枚举类。
 * 说明：定义的枚举类默认继承于 java.lang.Enum 类，且java.lang.Enum 类重写了toString方法
 */


public class EnumTest1 {
    public static void main(String[] args) {
        int num1 = 20; //不添加@SuppressWarnings，num1就是灰色的，表示未使用

        @SuppressWarnings("unused")
        int num = 10;

        Season1.AUTUMN.show();
        Season1.WINTER.show();
    }
}

interface Info1{
    void show();
}
@MyAnnotation("hello")
enum Season1 implements Info1{
    // 1. 提供当前枚举类的多个对象,多个对象用","分开，末尾用";"
    SPRING (" 春天 ", " 万物复苏 "){
        @Override
        public void show() {
            System.out.println("这是春天的样子");
        }
    },
    SUMMER (" 夏天 ", " 烈日炎炎 "){
        @Override
        public void show() {
            System.out.println("这是夏天的样子");
        }
    },
    AUTUMN (" 秋天 ", " 秋高气爽 "){
        @Override
        public void show() {
            System.out.println("秋天的样子");
        }
    },
    WINTER (" 冬天 ", " 白雪皑皑 "){
        @Override
        public void show() {
            System.out.println("冬天的样子");
        }
    };

    // 2. 声明 Season 对象的属性 :private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    // 3. 私有化类的构造器 , 并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //4、其他诉求：获取枚举类的对象属性(由于属性是final的，所以没有setter)
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

}
