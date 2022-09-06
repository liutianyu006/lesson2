package charpter01;

/**
 * 设置相同功能的多个线程
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        //3、new一个对象
        MyThread m1 = new MyThread();
        //4、调用start()方法启动线程，这时候调用的是Thread的start方法，
        //然后start调用Thread的run方法，由于子类重写了run方法，那么就调用子类的run方法
        m1.start();

        //这里就是主线程
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + " 主线程输出" + i);
            }
        }

        //5、再new一个对象，然后启动第二个线程
        MyThread m2 = new MyThread();
        m2.start();
    }
}

//1、创建Thread的子类
class MyThread extends Thread {
    //2、重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " 子线程输出" + i);
            }
        }
    }
}
