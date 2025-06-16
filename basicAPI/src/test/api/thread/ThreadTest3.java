package test.api.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 使用Callable接口来创建线程。
 * Callable接口可以返回结果，并且可以抛出异常。
 * 需要子类实现call()方法，返回值类型为T。
 * Callable接口的实现类可以通过FutureTask来执行，或者直接在ExecutorService中提交任务。
 */
public class ThreadTest3 implements Callable<String> {

    @Override
    public String call() throws Exception {
        // 执行任务并返回结果
        return "Callable thread result";
    }

    public static void main(String[] args) {
        ThreadTest3 callableTask = new ThreadTest3();
        try {
            // 创建线程并执行callable任务
            String result = callableTask.call();
            System.out.println("Callable task completed with result: " + result);
        } catch (Exception e) {
            e.printStackTrace(); // 捕获并打印异常信息
        }
        // 还可以使用FutureTask来执行Callable任务
        FutureTask<String> futureTask = new FutureTask<>(callableTask);
        Thread thread = new Thread(futureTask);
        thread.start(); // 启动线程

        // 等待线程执行完成并获取结果
        try {
            String futureResult = futureTask.get(); // 获取Callable任务的结果
            System.out.println("FutureTask completed with result: " + futureResult);
        } catch (Exception e) {
            e.printStackTrace(); // 捕获并打印异常信息
        }


    }
}
