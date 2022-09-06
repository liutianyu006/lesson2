package charpter01;

/**
 * Runnable接口创建线程
 * 这种方法，线程对象就是Thread类的实例
 */

public class ThreadTest05 {
    public static void main(String[] args) {
        //3、造一个实现类的实例
        RunnableThread r1 = new RunnableThread();
        //4、将实例作为参数，构造一个Thread类的实例
        Thread t1 = new Thread(r1);  // 这里的构造器给Thread的属性target赋值 Runnable target = new RunnableThread();
        //5、执行start方法
        t1.start(); //执行Thread的start,然后start会调用Thread的run，然后target.run(),此时target = r1
        /** Thread的run方法
         *     public void run() {
         *         if (target != null) {
         *             target.run();
         *         }
         *     }
         */

        //6、再起一个线程,做一样的事情
        Thread t2 = new Thread(r1);
        t2.start();
    }
}


//1、创建接口的实现类
class RunnableThread implements Runnable{
    @Override
    //2、重写run方法
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}

