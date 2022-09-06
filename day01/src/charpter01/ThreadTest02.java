package charpter01;

/**
 * 设置线程名
 */

public class ThreadTest02 {
    public static void main(String[] args) {
        SubThread1 s1 = new SubThread1();
//        SubThread1 s2 = new SubThread1("线程N");

        //子线程实例.setName设置线程名
        s1.setName("线程一");
        s1.start();

        //设置主线程名
        Thread.currentThread().setName("主线程");
        for(int i=0;i<100;i++){
            if(i%2!=0){
                System.out.println(Thread.currentThread()+" "+i);
            }
        }
    }
}

class SubThread1 extends Thread{
    public SubThread1() {
    }
    public SubThread1(String name) {
        super(name);
    }

    @Override
    public void run() {
//        super.setName("线程一");
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(this.getName() +" "+i);
            }
        }
    }
}
