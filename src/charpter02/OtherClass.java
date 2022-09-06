package charpter02;

import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class OtherClass {
    @Test
    public void test1(){
        BigInteger a = new BigInteger("-453453590909774283472847283472");
        BigInteger b = new BigInteger("48985934859834959");
        System.out.println(a);
        System.out.println(a.abs()); // 453453590909774283472847283472
        System.out.println(a.add(b));  //-453453590909725297537987448513
        System.out.println(Arrays.toString(a.divideAndRemainder(b))); //[-9256812025885, -34793135311369757]
        System.out.println(a.pow(32));

    }

    @Test
    public void test2(){
        BigDecimal a = new BigDecimal("32.3243434343434342313");
        BigDecimal b = new BigDecimal("3.34342313");

        System.out.println(a.subtract(b));

    }
}
