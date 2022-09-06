package charpter02;

/**
 * 创建2个线程轮流打印0～100
 * 基本原理就是第一个线程执行完之后，先wait()住，让它没法跟另一个线程竞争，
 * 另一个线程抢到锁之后释放第一个的wait(),然后再自己wait()，依此循环
 */

public class ThreadCom {
    public static void main(String[] args) {
        NumberPrint n1 = new NumberPrint();
        Thread t1 = new Thread(n1,"线程一");
        Thread t2 = new Thread(n1,"线程二");
        t1.start();
        t2.start();
    }
}
class NumberPrint implements Runnable{
    int num;
    @Override
    public void run() {
        while (true){
            synchronized (this){
                this.notify();  //唤醒在wait()的线程
                if(num <=100){
                    System.out.println(Thread.currentThread().getName()+"打印："+num);
                    num ++;
                    try {
                        this.wait();  //wait()会释放同步锁
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    break;
                }
            }
        }
    }
}