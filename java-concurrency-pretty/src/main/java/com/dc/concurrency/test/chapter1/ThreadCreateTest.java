package com.dc.concurrency.test.chapter1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author DCZhang
 * @title ThreadCreateTest
 * @date 2023/7/21 9:59
 * @description 线程创建测试类
 */
public class ThreadCreateTest {
    /**
     * 继承Thread类
     * 缺点:不能继承其他类
     */
    public static class ExtendThread extends Thread {
        @Override
        public void run() {
            System.out.println("ExtendThread start");
        }
    }

    /**
     * 实现Runnable接口
     * 缺点: 没有返回值
     */
    public static class ImplementRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("ImplementRunnable start");
        }
    }

    /**
     * 实现Callable接口
     */
    public static class ImplementCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("ImplementCallable start");
            return "ImplementCallable return";
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        // 继承测试
        new ExtendThread().start();

        // 实现runnable测试
        new Thread(new ImplementRunnable()).start();

        // 实现callable测试
        FutureTask<String> futureTask = new FutureTask<>(new ImplementCallable());
        new Thread(futureTask).start();
        String s = null;
        try {
            s = futureTask.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(s);

        // lambda测试
        new Thread(() -> System.out.println("lambda start")).start();

    }
}
