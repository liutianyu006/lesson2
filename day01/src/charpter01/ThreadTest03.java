package charpter01;

/**
 * Thread类相关方法的使用
 */

public class ThreadTest03 {
    public static void main(String[] args) {
        SubThread s1 = new SubThread();
        s1.setName("线程一");
        s1.start();

        //设置主线程名
        Thread.currentThread().setName("主线程");
        for(int i=0;i<100;i++){
            if(i%2!=0){
                System.out.println(Thread.currentThread()+" "+i);
            }

            //join方法，在主线程执行到9时，join s1这个线程
            if(i==9){
                try{
                    s1.join();
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class SubThread extends Thread{
    public SubThread() {
    }
    @Override
    public void run() {
        //静态sleep方法
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(this.getName() +" "+i);
            }
        }
    }
}
