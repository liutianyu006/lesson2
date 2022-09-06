package charpter01;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadExam06 {
    public static void main(String[] args) {
        Customer c1 = new Customer(new BankAccount());
        Thread t1 = new Thread(c1,"储户一");
        Thread t2 = new Thread(c1,"储户二");
        t1.start();
        t2.start();
    }
}
class BankAccount{
    private ReentrantLock lock = new ReentrantLock();
//    private ReentrantLock lock = new ReentrantLock(true); 这里构造器参数加上true，则可以实现轮流存钱

    private int accountSum;
    public void deposit(int amount){
        if(amount > 0){
            try{
                lock.lock();
                accountSum += amount;
                System.out.println(Thread.currentThread().getName()+"存钱成功，余额为"+accountSum);
            }finally {
                lock.unlock();
            }

        }
    }

}

class Customer implements Runnable{
    private BankAccount acc;

    public Customer() {
    }
    public Customer(BankAccount acc) {
        this.acc = acc;
    }
    @Override
    public void run() {
        for(int i=0;i<3;i++){
            acc.deposit(1000);
        }
    }
}