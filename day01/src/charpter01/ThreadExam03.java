package charpter01;

/**
 * Runnable接口，创建3个窗口线程卖票，一共100张
 * 仍然存在线程安全问题
 */

public class ThreadExam03 {
    public static void main(String[] args) {
        RunThread r1 = new RunThread();
        Thread t1 = new Thread(r1,"窗口一");
        t1.start();

        Thread t2 = new Thread(r1,"窗口二");
        t2.start();

        Thread t3 = new Thread(r1,"窗口三");
        t3.start();

    }
}

class RunThread implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                //加一个sleep，就更加容易出现一个线程在执行共享数据的时候，另一个线程也进来执行共享数据的问题
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"卖票，票号为：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}