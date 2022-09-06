package charpter02;

import org.testng.annotations.Test;
import java.util.Arrays;

public class ComparableTest {
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","FF","CC","ZZ"};
        //String重写了compareTo(obj)方法, Arrays.sort(obj)实际上也是调用的具体数据类型的compareTo方法做比较
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods[] goods = new Goods[4];
        goods[0] = new Goods(70,"apple");
        goods[1] = new Goods(16,"xiaomi");
        goods[2] = new Goods(65,"huawei");
        goods[3] = new Goods(16,"dell");

        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));

    }
}
class Goods implements Comparable{
    private int price;
    private String name;

    public Goods() {
    }

    public Goods(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public String toString() {
        return "Goods{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            //方法一：
//            return Integer.compare(price,goods.price);

            //方法二：
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else {
//                return 0;
                //比较完价格，再来比较名称
                return this.name.compareTo(goods.name);
            }
        }
        throw new RuntimeException(" 传入的数据类型不一致！ ");
    }
}

