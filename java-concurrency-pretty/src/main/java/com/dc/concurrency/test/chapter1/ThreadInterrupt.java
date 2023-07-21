package com.dc.concurrency.test.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * @author DCZhang
 * @title ThreadInterrupt
 * @date 2023/7/21 10:48
 * @description 两种情况下的中断
 */
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        // 当子线程调用sleep方法的时候
//        Thread thread = new Thread(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        thread.start();
//        thread.interrupt();

        // 当子线程调用wait方法的时候
        Object o = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized (o) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();
        TimeUnit.SECONDS.sleep(1);
        thread1.interrupt();

    }
}
