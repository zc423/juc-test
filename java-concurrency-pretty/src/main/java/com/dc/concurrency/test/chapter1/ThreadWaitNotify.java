package com.dc.concurrency.test.chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author DCZhang
 * @title ThreadWaitNotify
 * @date 2023/7/21 10:18
 * @description 线程的等待与唤醒
 * notify唤醒的是在该共享变量下的其他的线程,当有多个线程等待的时候进行的是随机唤醒
 * 只有在获取到该共享变量的锁的时候才能进行wait和notify操作,否则会抛出异常
 */
public class ThreadWaitNotify {

    public static void main(String[] args) throws InterruptedException {
        // 等待唤醒测试
//        waitAndNotify();
        // wait超时测试
        waitTimeout();
    }

    public static void waitTimeout() throws InterruptedException {
        Object o = new Object();
        new Thread(()->{
            synchronized (o){
                try {
                    o.wait(1000);
                    // 1000毫秒 10 纳秒
//                    o.wait(1000, 10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        TimeUnit.SECONDS.sleep(2);
    }

    /**
     * 主要实现生产者生产一个，消费者消费一个,交替进行,执行完操作让出锁
     */
    public static void waitAndNotify(){
        List<String> finalObject = new ArrayList<>();
        // 生产者
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (finalObject) {
                    while (finalObject.size() != 0){
                        try {
                            System.out.println("1 wait");
                            finalObject.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("1 add");
                    finalObject.add("1");
                    // 让出锁通知消费者消费
                    finalObject.notify();
                }
            }
        }).start();

        // 消费者
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (finalObject) {
                    // 当finalObject为空时，消费者等待
                    while (finalObject.size() == 0) {
                        System.out.println("2 wait");
                        try {
                            finalObject.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("2 remove");
                    finalObject.remove("1");
                    // 通知生产者生产
                    finalObject.notify();
                }
            }
        }).start();
    }
}
