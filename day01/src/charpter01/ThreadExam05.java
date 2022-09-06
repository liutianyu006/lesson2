package charpter01;

/**
 * Thread类的子类，创建3个窗口线程卖票，一共100张
 * 用同步方法解决线程安全问题
 */

public class ThreadExam05 {
    public static void main(String[] args) {
        Window02 w01 = new Window02();
        w01.setName("窗口1");

        Window02 w02 = new Window02();
        w02.setName("窗口2");

        Window02 w03 = new Window02();
        w03.setName("窗口3");

        w03.start();
        w01.start();
        w02.start();
    }
}
class Window02 extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while (true){
            show();
        }
    }
    public static void show(){  //这种情况下监视器是当前类Window02
        synchronized (Window02.class) {
            if(ticket > 0){
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"卖票，票号为："+ticket);
                ticket --;
            }
        }
    }
}