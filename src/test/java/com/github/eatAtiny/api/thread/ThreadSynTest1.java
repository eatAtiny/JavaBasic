package com.github.eatAtiny.api.thread;

/**
 * 线程同步： 1. 使用synchronized关键字来修饰方法或代码块，确保同一时刻只有一个线程可以执行被修饰的方法或代码块。 2.
 * 使用Lock接口和ReentrantLock类来实现更灵活的锁机制，可以实现公平锁和非公平锁。
 */
public class ThreadSynTest1 {

  public void ThreadSynDemo1() {
    // 使用synchronized修饰方法
    synchronized (this) { // synchronized(this)表示锁定当前对象
      // 线程安全的代码块
      System.out.println("ThreadSynDemo: 执行线程安全的代码块");
    }
  }

  public static synchronized void
      ThreadSynDemo2() { // 这里隐式使用了synchronized修饰静态方法 synchronized(ClassName.class)
    // 使用synchronized修饰静态方法
    // 静态方法锁定的是类的Class对象
    // 线程安全的代码块
    System.out.println("ThreadSynDemo: 执行线程安全的静态方法");
  }

  public synchronized void ThreadSynDemo3() { // 这里隐式使用了synchronized修饰实例方法 synchronized(this)
    // 使用synchronized修饰实例方法
    // 线程安全的代码块
    System.out.println("ThreadSynDemo: 执行线程安全的实例方法");
  }
}
