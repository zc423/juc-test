package com.dc.concurrency.test.chapter1;

/**
 * @author DCZhang
 * @title ThreadDeadLock
 * @date 2023/7/24 13:48
 * @description 死锁
 * 死锁的条件
 * 1. 互斥
 * 2. 占有且等待
 * 3. 不可抢占
 * 4. 循环等待: A->B->C->A 即环路等待
 */
public class ThreadDeadLock {
    private static  Object resourceA = new Object();
    private static  Object resourceB = new Object();

    /**
     * 注意此方法的死锁条件
     * AB两个资源分别被两个线程占用,并且互相等待对方释放资源
     * (同时请求AB资源,但是AB两个资源获取的顺序不同,因此死锁的一种线上解决办法是获取ABC资源按照一定的顺序获取)
     * @param args
     */
    public static void main(String[] args) {
        new Thread(() ->{
           synchronized (resourceA){
               System.out.println(Thread.currentThread() + "get resourceA");
               try {
                   // 此处睡眠是为了让另一个线程获取到另一个资源
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread() + "waiting get resourceB");
               synchronized (resourceB){
                   System.out.println(Thread.currentThread() + "get resourceB");
               }
           }
        }).start();

        new Thread(() ->{
            synchronized (resourceB){
                System.out.println(Thread.currentThread() + "get resourceB");
                try {
                    // 此处睡眠是为了让另一个线程获取到另一个资源
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resourceA");
                synchronized (resourceA){
                    System.out.println(Thread.currentThread() + "get resourceA");
                }
            }
        }).start();
    }
}
