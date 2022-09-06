package charpter01;

/**
 * 创建3个窗口卖票，一共100张
 * 静态变量：我们创建了类的多个对象，多个对象共享同一个静态变量。当通过静态变量去修改某一个变量时，会导致其他对象调用此静态变量时，是修改过的
 * 会有线程安全问题
 */
public class ThreadExam02 {
    public static void main(String[] args) {
        Window w1 = new Window();
        w1.setName("窗口1");

        Window w2 = new Window();
        w2.setName("窗口2");

        Window w3 = new Window();
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
class Window extends Thread{
    //设置票数为static属性，这样多个线程对象共享这一个变量，不会出现各有一个100的情况
    private static int ticket = 100;
    @Override
    public void run() {
        while (true){
            if(ticket > 0){
                System.out.println(this.getName()+"卖票，票号为："+ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}