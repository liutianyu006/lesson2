package charpter01.StringBuilder;

public class StringBuilderTest {
    public static void main(String[] args) {
        //1、String构造器
        String str1 = new String(); // char[] value = new char[0]
        String str2 = new String("abc");  // char[] value = new char[]{'a','b','c'};

        //2、StringBuffer空参构造器
        StringBuffer str3 = new StringBuffer(); // char[] value = new char[16],默认创建的是一个长度为16的char型数组
        /**构造器代码为：
         *     @IntrinsicCandidate
         *     public StringBuffer() {
         *         super(16);
         *     }
         */
        str3.append('a'); // value[0] = 'a';
        System.out.println(str3);

        //3、StringBuffer带参构造器
        StringBuffer str4 = new StringBuffer("hello"); //这里相当于是创建了长度为str4.length+16的char型数组
        System.out.println(str4.length());  //输出是实际长度5而不是21

        //4、StringBuffer的扩容问题：如果原有的数组一直append超过了创建的长度，就会自动扩容数组长度
        //默认情况下，扩容为原有容量的2倍+2，同时将原有数组元素拷贝到新的数组之中
        str4.append("apple");

        //5、如果事先知道String大概长度，StringBuffer创建对象时可以指定数组长度，这样就不用自动扩容了
        StringBuffer str5 = new StringBuffer(96);

    }
}

