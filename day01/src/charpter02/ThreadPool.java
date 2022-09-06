package charpter02;
/**
 * 线程池创建线程
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void main(String[] args) {

        //1、提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        /**
         * 这里类的关系：Executor.newFixedThreadPool调用ThreadPoolExecutor构造器，ThreadPoolExecutor类继承
         * AbstractExecutorService抽象类，AbstractExecutorService抽象类实现了ExecutorService接口，ExecutorService接口继承
         * 了Executor接口
         */

        //设置线程池的属性
        // service1.setCorePoolSize(15);
        // service1.setKeepAliveTime();

        // 2. 执行指定的线程的操作。需要提供实现 Runnable 接口或 Callable 接口实现类的对象
        service.execute(new TheP());
//        service.submit(Callable callable); //适用于Callable接口类型

        //3、关闭连接池
        service.shutdown();
    }
}

class TheP implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+"输出："+i);
        }
    }
}