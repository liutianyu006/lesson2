package charpter01;

/**
 * Thread类的子类，创建3个窗口线程卖票，一共100张
 * 用同步代码块解决线程安全问题
 */

public class ThreadExam04 {
    public static void main(String[] args) {
        Window01 w01 = new Window01();
        w01.setName("窗口1");

        Window01 w02 = new Window01();
        w02.setName("窗口2");

        Window01 w03 = new Window01();
        w03.setName("窗口3");

        w03.start();
        w01.start();
        w02.start();
    }
}
class Window01 extends Thread{
    private static int ticket = 100;
//    private static Object obj = new Object();
    @Override
    public void run() {
        while (true){
//            synchronized (obj){   //这样也可以
            synchronized (Window01.class){
            if(ticket > 0){
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(this.getName()+"卖票，票号为："+ticket);
                ticket --;
            }else {
                break;
            }
        }
        }
    }
}