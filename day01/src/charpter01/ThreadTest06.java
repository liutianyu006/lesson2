package charpter01;

/**
 * Runnable接口创建线程，给线程命名
 * 1、构造器命名
 * 2、实例.setName()方法命名
 */

public class ThreadTest06 {
    public static void main(String[] args) {
        RunnableThread1 r1 = new RunnableThread1();
        //线程命名1
        Thread t1 = new Thread(r1,"线程一");
        t1.start();

        //线程命名2
        Thread t2 = new Thread(r1);
        t2.setName("线程二");
        t2.start();
    }
}

class RunnableThread1 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}

