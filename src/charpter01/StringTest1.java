package charpter01;

public class StringTest1 {
    public static void main(String[] args) {
        String b = new String("xiaohuang");
        String a = "xiaohuang";
        Person1 p1 = new Person1("xiaohuang");
        Person2 p2 = new Person2("xiaohuang");
        Person2 p3 = new Person2(a); //这里p3.name地址等于 p2.name，因为都是直接指向字符常量池
        Person2 p4 = new Person2(b); //这里p4.name地址不等于 p2.name，因为p4.name要先指向String实例，然后String实例的value指向常量池

        System.out.println(p1.name == p2.name); //ture
        System.out.println(a == p1.name);  //true
        System.out.println(p3.name == p2.name); //true
        System.out.println(p4.name == p2.name); //false
    }
}
class Person1{
    String name;
    public Person1(String name) {
        this.name = name;
    }
}
class Person2{
    String name;

    public Person2(String name) {
        this.name = name;
    }
}