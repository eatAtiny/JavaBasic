package test.api.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSynTest2 {

    /**
     * 可以使用lock给代码块加锁，确保同一时刻只有一个线程可以执行被锁定的代码块。
     */
    public void ThreadSynDemo1() {

        // 使用Lock接口和ReentrantLock类来实现线程同步
        Lock lock = new ReentrantLock(); // Lock是一个接口类，要通过具体的实现类来实例化，这里使用ReentrantLock类
        lock.lock(); // 获取锁
        try {
            // 线程安全的代码块
            System.out.println("ThreadSynDemo: 执行线程安全的代码块");
        } finally {
            lock.unlock(); // 确保释放锁
        }


    }
}
