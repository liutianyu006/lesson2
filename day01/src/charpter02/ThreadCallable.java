package charpter02;

/**
 * Callable接口创建线程
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadCallable {
    public static void main(String[] args) {
        //3、创建Callable实现类的对象
        NumPrint n1 = new NumPrint();

        //4、将Callable实现类的实例对象作为参数，传递到FutureTask构造器，创建实例对象
        FutureTask futureTask1 = new FutureTask(n1);  //将Callable类型n1(多态)的数据赋给实例的callable属性

        //5、将FutureTask的对象作为参数传递到Thread构造器，创建Thread对象，并start
        //        new Thread(futureTask1,"线程一").start();
        Thread t1 = new Thread(futureTask1,"线程一");
        t1.start();
        /**
         * FutureTask实现了Runnable接口,所以futureTask1是Runnable类型，将此实例赋给target属性
         * Thread类中是t1.start()调用t1.run，然后target.run()方法，此时target = futureTask1
         * FutureTask类中是futureTask1.run()方法调用callable.call()方法，此时callable = n1，也就是callable接口的实现类实例
         * 最终实现线程执行实现类中call()方法的效果
         */

        //6、接收返回值
        try {
            System.out.println("返回值："+futureTask1.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


        //7、创建多个线程
        FutureTask futureTask2 = new FutureTask(n1);
        new Thread(futureTask2,"线程二").start();
    }
}

//1、创建一个Callable的实现类
class NumPrint implements Callable {
    private int sum ;
    //2、重写call方法，线程执行的内容放在call()方法中
    @Override
    public Object call() throws Exception {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"输出"+i);
                sum += i;
            }
        }
//        return null; //如果可以不需要返回值，可以返回null
        return sum;    //自动装箱
    }
}