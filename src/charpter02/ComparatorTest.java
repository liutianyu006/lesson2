package charpter02;

import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    @Test
    public void test1() {
        String[] arr = new String[] { "AA", "CC", "GG", "JJ", "DD" };
        /**下面关于Comparator调用的是这个方法:
         *     public static <T> void sort(T[] a, Comparator<? super T> c) {
         *         if (c == null) {
         *             sort(a);
         *         } else {
         *             if (LegacyMergeSort.userRequested)
         *                 legacyMergeSort(a, c);
         *             else
         *                 TimSort.sort(a, 0, a.length, c, null, 0, 0);
         *         }
         *     }
         */
        Arrays.sort(arr, new Comparator() {
            // 按照字符串从大到小的顺序排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                } // return 0;
                throw new RuntimeException(" 输入的数据类型不 一致 ");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods1[] arr = new Goods1[4];
        arr[0] = new Goods1("lenovoMouse", 34);
        arr[1] = new Goods1("huaweiMouse", 65);
        arr[2] = new Goods1("huaweiMouse", 224);
        arr[3] = new Goods1("microsoftMouse", 43);
        Arrays.sort(arr, new Comparator() {
            // 指明商品比较大小的方式 : 按照产品名称从低到高排序 ,再按照价格从高到低排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods1 && o2 instanceof Goods1)
                {
                    Goods1 g1 = (Goods1) o1;
                    Goods1 g2 = (Goods1) o2;
                    if (g1.getName().equals(g2.getName())) {
                        return -Double.compare(g1.getPrice(), g2.getPrice());
                    } else {
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException(" 输入的数据类型不 一致 ");
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}

class Goods1 implements Comparable {
    private int price;
    private String name;

    public Goods1() {
    }

    public Goods1(String name,int price) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
        if (o instanceof Goods1) {
            Goods1 goods = (Goods1) o;
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