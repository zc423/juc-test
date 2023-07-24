package com.dc.concurrency.test.chapter1;

/**
 * @author DCZhang
 * @title ThreadInterrupt2
 * @date 2023/7/24 13:30
 * @description TODO
 */
public class ThreadInterrupt2 {
    public static void main(String[] args) throws InterruptedException {
        // 测试interrupted方法
        // 此方法会进入死循环,因为interrupted方法会清除中断标志位
//        interruptedTest();

        System.out.println("====================================");

        interruptedTest1();

    }

    public static void interruptedTest1() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()){

            }
            System.out.println("Thread1 isInterrupted:" + Thread.currentThread().isInterrupted());
        });

        thread.start();
        // interrupt中断线程,中断的是指定的线程
        thread.interrupt();

        thread.join();

        System.out.println("Main Thread is over");
    }


    public static void interruptedTest() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true){

            }
        });

        thread.start();
        // interrupt中断线程,中断的是指定的线程
        thread.interrupt();
        // isInterrupted判断线程是否被中断,判断的是指定的线程 true
        System.out.println("isInterrupted:" + thread.isInterrupted());
        // interrupted判断线程是否被中断,判断的是当前线程 false
        System.out.println("isInterrupted:" + thread.interrupted());
        // isInterrupted判断线程是否被中断,判断的是当前线程 false
        System.out.println("isInterrupted:" + Thread.interrupted());
        // isInterrupted判断线程是否被中断,判断的是指定的线程 true
        System.out.println("isInterrupted:" + thread.isInterrupted());

        thread.join();
    }
}
