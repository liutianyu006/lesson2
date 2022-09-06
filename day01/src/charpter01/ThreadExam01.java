package charpter01;

/**
 * 创建不同功能的多个线程
 */

public class ThreadExam01 {
    public static void main(String[] args) {
        ThreadDemo01 t1 = new ThreadDemo01();
        t1.start();

        ThreadDemo02 t2 = new ThreadDemo02();
        t2.start();

        //也可以创建匿名子类的匿名对象，再调用方法
//        new Thread(){
//            @Override
//            public void run() {
//                for(int i=0;i<100;i++){
//                    if(i % 2 ==0){
//                        System.out.println(Thread.currentThread().getName()+" "+i);
//                    }
//
//                }
//            }
//        }.start();
    }

}

class ThreadDemo01 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i %2 ==0){
                System.out.println(Thread.currentThread().getName()+" "+i);
            }

        }
    }
}

class ThreadDemo02 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i %2 !=0){
                System.out.println(Thread.currentThread().getName()+" "+i);
            }

        }
    }
}
