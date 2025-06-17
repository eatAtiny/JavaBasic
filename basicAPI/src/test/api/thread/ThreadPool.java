package test.api.thread;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadPool {

    @Test
    public void ThreadPoolDemo1() {
        // 使用ThreadPoolExecutor来创建线程池
        // 这个类需要7个参数来配置线程池的行为：
        // 1. 核心线程数：线程池中始终保持的线程数量
        // 2. 最大线程数：线程池中允许的最大线程数量
        // 3. 空闲线程存活时间：当线程池中的线程超过核心线程数时，空闲线程在多长时间后被回收
        // 4. 时间单位：空闲线程存活时间的单位
        // 5. 阻塞队列：用于存放等待执行的任务
        // 6. 线程工厂：用于创建新线程的工厂
        // 7. 拒绝策略：当线程池满时，如何处理新提交的任务
        ThreadPoolExecutor threads = new ThreadPoolExecutor(
                2, // 核心线程数
                4, // 最大线程数
                60, // 空闲线程存活时间
                java.util.concurrent.TimeUnit.SECONDS, // 时间单位
                new java.util.concurrent.ArrayBlockingQueue<>(10), // 阻塞队列，存放等待执行的任务
                Executors.defaultThreadFactory(), // 线程工厂，用于创建新线程
                new ThreadPoolExecutor.AbortPolicy() // 拒绝策略，当线程池满时，抛出异常
        );
        // 其他拒绝策略
        // new ThreadPoolExecutor.CallerRunsPolicy() // 调用者运行策略，直接在主线程中执行任务
        // new ThreadPoolExecutor.DiscardPolicy() // 丢弃策略，直接丢弃新提交的任务，不建议
        // new ThreadPoolExecutor.DiscardOldestPolicy() // 丢弃最旧的任务，尝试重新提交新任务


        // 提交任务到线程池
        Runnable threadTask = () -> {
            System.out.println(Thread.currentThread().getName() + " is executing a task");
        };
        threads.execute(threadTask);
        threads.execute(threadTask); // 提交多个任务到线程池
        threads.execute(threadTask); // 因为线程池中只有两个线程，所会等待前面的线程完成之后，复用前面的线程
        threads.execute(threadTask);

        Future<String> f1 = threads.submit(() -> {
            return Thread.currentThread().getName() + " is executing a submitted task"; // submit方法可以返回结果
        });
        System.out.println(f1); // 直接打印f1会返回future对象的状态
        try {
            System.out.println(f1.get()); // 获取提交任务的结果，get()方法会阻塞直到任务完成
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


        // threads.shutdown(); // 会等待线程池中已提交的任务完成之后，销毁线程池
        // threads.shutdownNow(); // 立即销毁线程池，不会等待已提交的任务完成


    }


    @Test
    public void ThreadPoolDemo2() {
        // 使用Executors来创建线程池
        // Executors提供了多种工厂方法来创建不同类型的线程池

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4); // 创建一个固定大小的线程池，线程数为4

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool(); // 创建一个可缓存的线程池，线程数不固定，根据需要创建新线程

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor(); // 创建一个单线程的线程池，只有一个线程执行任务，当任务提交时，会等待前一个任务完成后再执行下一个任务

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2); // 创建一个定时任务线程池，线程数为2，可以执行定时任务

        Runnable threadTask = () -> {
            System.out.println(Thread.currentThread().getName() + " is executing a task");
        };

        fixedThreadPool.execute(threadTask); // 提交任务到固定大小的线程池
        cachedThreadPool.execute(threadTask); // 提交任务到可缓存的线程池
        singleThreadExecutor.execute(threadTask); // 提交任务到单线程的线程池
        scheduledThreadPool.schedule(threadTask, 5, TimeUnit.SECONDS); // 提交一个定时任务，5秒后执行
        scheduledThreadPool.scheduleAtFixedRate(threadTask, 0, 10, TimeUnit.SECONDS); // 提交一个定时任务，立即执行，然后每10秒执行一次
        // 线程池没有join方法所以需要其他手段来控制并发

        // 注意：使用完线程池后，应该调用shutdown()方法来关闭线程池，释放资源
        fixedThreadPool.shutdown(); // 关闭固定大小的线程池
        cachedThreadPool.shutdown(); // 关闭可缓存的线程池
        singleThreadExecutor.shutdown(); // 关闭单线程的线程池
        scheduledThreadPool.shutdown(); // 关闭定时任务线程池

    }
}
