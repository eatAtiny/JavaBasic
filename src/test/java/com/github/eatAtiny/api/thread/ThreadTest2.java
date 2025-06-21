package com.github.eatAtiny.api.thread;

/** 通过实现Runnable接口来创建线程。 实现Runnable接口的方式可以避免Java单继承的限制，但是在创建线程的时候除了子类外还需要额外的创建一个Thread对象。 */
public class ThreadTest2 implements Runnable {

  @Override
  public void run() {
    System.out.println("run a thread");
  }

  public static void main(String[] args) {
    ThreadTest2 thread = new ThreadTest2();
    Thread t = new Thread(thread); // 创建线程对象，传入Runnable实现类
    t.start(); // 启动线程，调用run()方法
    System.out.println("main thread");

    // 还可以使用Lambada表达式来简化线程创建
    new Thread(
            () -> {
              System.out.println("run a thread using lambda");
            })
        .start(); // 因为Runnable接口只有一个抽象方法，所以可以使用Lambda表达式来简化代码，这个函数体就是run函数的实现
  }
}
