package charpter01;

/**
 * 设置线程的优先级
 */

public class ThreadTest04 {
    public static void main(String[] args) {
        SubThread2 s1 = new SubThread2();
        s1.start();

        Thread.currentThread().setName("主线程");
        //设置主线程优先级
//        Thread.currentThread().setPriority(8);
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for(int i=0;i<100;i++){
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+"优先级"+Thread.currentThread().getPriority()+" "+i);
            }

        }
    }
}

class SubThread2 extends Thread{
    public SubThread2() {
    }
    @Override
    public void run() {
        super.setName("线程一");
        //设置子线程优先级
        this.setPriority(MAX_PRIORITY);
//        this.setPriority(9);
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(this.getName() +"优先级"+this.getPriority()+" "+i);
            }
        }
    }
}
