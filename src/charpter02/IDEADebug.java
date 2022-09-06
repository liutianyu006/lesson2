package charpter02;

public class IDEADebug {
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb1 = new StringBuffer();
        sb1.append(str);

        System.out.println(sb1.length()); //4
        System.out.println(sb1); //"null"

        StringBuffer sb2 = new StringBuffer(str); //报空指针异常
        System.out.println(sb2);
    }
}
