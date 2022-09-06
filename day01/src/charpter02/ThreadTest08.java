package charpter02;

/**
 * 线程安全的懒汉式实例创建（使用同步方法）
 */
public class ThreadTest08 {
}

class Order{
    private Order() {
    }

    private static Order orderInstance = null;
    //同步方法一，但是效率不够高，因为实际上不需要每个线程都进入同步方法
//    public static synchronized Order getInstance(){
//        if(orderInstance == null){
//            orderInstance = new Order();
//        }
//        return orderInstance;
//    }

    //同步方法二，如果为空就不进入同步方法
    public static Order getInstance(){
        if(orderInstance == null){
            synchronized (Order.class) {
                if(orderInstance == null){
                    orderInstance = new Order();
                }
            }
        }
        return orderInstance;
    }
}