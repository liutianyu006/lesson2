package charpter01;

/**
 * 使用同步方法解决Runnable接口实现类创建的线程安全问题
 */

public class ThreadTest07 {
    public static void main(String[] args) {
        RunningThread r1 = new RunningThread();
        Thread t1 = new Thread(r1,"窗口一");
        t1.start();

        Thread t2 = new Thread(r1,"窗口二");
        t2.start();

        Thread t3 = new Thread(r1,"窗口三");
        t3.start();

    }
}

class RunningThread implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            this.show();
        }
    }
    public synchronized void show() { //默认监视器是this
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"卖票，票号为：" + ticket);
            ticket--;
        }
    }
}