package charpter02;

/**
 * ReentrantLock实例解决线程安全 -- JDK5.0新增
 */

import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest008 {
    public static void main(String[] args) {
        Window001 w1 = new Window001();
        Thread t1 = new Thread(w1,"窗口一");
        Thread t2 = new Thread(w1,"窗口二");
        Thread t3 = new Thread(w1,"窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window001 implements Runnable{
    private int ticket = 100;
    //1、实例化 ReentrantLoc
    private ReentrantLock lock = new ReentrantLock(true); //构造器参数设置成fair，表示会让多个线程轮流抢到锁
    @Override
    public void run() {
        while (true){
            try{
                // 2、调用锁定方法
                lock.lock();
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName()+"卖票，票号为："+ticket);
                    ticket --;
                }else {
                    break;
                }
            }finally {
                //3、调用解锁方法
                lock.unlock();
            }

        }

    }
}