package test.api.thread;

/**
 * 创建线程需要继承Thread类或者实现Runnable接口。
 * 在子类中需要重写run()方法，
 * 继承Thread的多线程创建只用实例化一个Thread子类对象，但是缺点是只能继承一个类，
 */

public class ThreadTest1 extends Thread{

    @Override
    public void run() {
        System.out.println("run a thread");
    }

    public static void main(String[] args) {
        ThreadTest1 thread = new ThreadTest1();
        thread.start(); // 启动线程，调用run()方法
        try {
            thread.join(); // 等待线程执行完成，主线程会阻塞在这里，直到thread线程执行完毕
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main thread");
    }
}
