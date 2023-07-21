package com.dc.concurrency.test.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * @author DCZhang
 * @title ThreadNotifyAll
 * @date 2023/7/21 11:07
 * @description 测试notifyAll
 * 测试结论: 当A B两个线程同时阻塞在一个共享资源的时候,调用notifyAll会唤醒所有的线程,而不是随机唤醒一个
 * 调用notify方法只会唤醒一个,前提是 A B两个线程执行以后没有对共享资源调用notify方法
 */
public class ThreadNotifyAll {
    public static void main(String[] args) throws InterruptedException {
        Object resource = new Object();

        new Thread(() ->{
            synchronized (resource) {
                System.out.println("Thread1 get resource lock");
                try {
                    System.out.println("Thread1 begin wait");
                    resource.wait();
                    System.out.println("Thread1 end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread1").start();

        new Thread(() ->{
            synchronized (resource) {
                System.out.println("Thread2 get resource lock");
                try {
                    System.out.println("Thread2 begin wait");
                    resource.wait();
                    System.out.println("Thread2 end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread2").start();
        // 等待两个线程都wait
        TimeUnit.SECONDS.sleep(1);

        new Thread(() ->{
            synchronized (resource) {
                // 随机唤醒一个
//                resource.notify();
                // 唤醒两个线程都进入等待状态进行锁竞争,当先抢占到锁的方法执行完以后另外一个直接进行抢占锁,不用进行notify
                resource.notifyAll();
            }
        }, "Thread3").start();
    }
}
