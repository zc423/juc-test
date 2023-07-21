package com.dc.concurrency.test.chapter1;

/**
 * @author DCZhang
 * @title ThreadJoin
 * @date 2023/7/21 11:15
 * @description 线程的Join方法
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Thread1 begin");
            try {
                // 子线程睡眠两秒
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread1 end");
        }, "Thread1");
        thread.start();
        // 在此处主线程等待子线程执行完毕(可以注释掉此处,观察输出结果变化)
        thread.join();
        System.out.println("Main Thread end");
    }
}
