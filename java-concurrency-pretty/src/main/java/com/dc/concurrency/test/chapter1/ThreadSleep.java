package com.dc.concurrency.test.chapter1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author DCZhang
 * @title ThreadSleep
 * @date 2023/7/21 11:21
 * @description sleep方法测试
 * 1. sleep的过程中不会释放独占锁,只会等待sleep结束代码执行unlock后释放锁
 * 2. 在sleep的过程中,当前线程被中断,那么会抛出InterruptedException异常,并且会清除中断标志位
 */
public class ThreadSleep {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        new Thread(() -> {
            reentrantLock.lock();
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Total time:" + (endTime - startTime));
        }).start();

        new Thread(() -> {
            reentrantLock.lock();
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Total time:" + (endTime - startTime));
        }).start();
    }
}
