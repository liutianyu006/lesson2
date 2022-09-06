package charpter02;

public class ThreadComExam {
    public static void main(String[] args) {
        //店员对象
        Clerk c1 = new Clerk();

        //生产者线程
        Producer p1 = new Producer(c1);
        Thread t1 = new Thread(p1,"生产者");
        t1.start();

        //消费者线程
        Consumer cc1 = new Consumer(c1);
        Thread t2 = new Thread(cc1,"消费者");
        t2.start();
    }
}

class Clerk{
    private int productCount;
    // 2个同步代码块共用一把锁，就是Clerk的实例c1
    public void consumerProduct() {
        synchronized (this){
            if(productCount > 0){
                System.out.println(Thread.currentThread().getName()+"：正在消费"+ productCount);
                productCount --;
                notify();
            }else {
                try {
                    wait(); //产品数量为0就等待
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public void produceProduct() {
        synchronized (this){
            if(productCount < 20){
                productCount ++;
                System.out.println(Thread.currentThread().getName()+"正在生产"+ productCount);
                notify();
            }else {
                try {
                    wait();  //超过20个就不生产
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class Producer implements Runnable{
    private Clerk clerk;
    public Producer() {
    }
    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            clerk.produceProduct();
        }
    }
}

class Consumer implements Runnable{
    private Clerk clerk;
    public Consumer() {
    }
    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true){
            clerk.consumerProduct();
        }
    }
}