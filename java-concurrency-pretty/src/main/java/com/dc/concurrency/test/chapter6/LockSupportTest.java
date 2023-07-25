package com.dc.concurrency.test.chapter6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author DCZhang
 * @title LockSupportTest
 * @date 2023/7/25 16:34
 * @description LockSupport
 * 1.8中新增的类,用于创建锁和其他同步类的基本线程阻塞原语
 * park()方法用于阻塞当前线程,unPark(Thread thread)方法用于唤醒指定线程
 */
public class LockSupportTest {
    static class Test{
        // 该方法执行只会输出begin park!，然后阻塞，不会输出end park!
        public static void main(String[] args) {
            System.out.println("begin park!");

            LockSupport.park();

            System.out.println("end park!");
        }
    }

    static class TestA{
        // 该方法执行会输出begin park!和end park!
        public static void main(String[] args) {
            System.out.println("begin park!");

            LockSupport.unpark(Thread.currentThread());

            LockSupport.park();

            System.out.println("end park!");
        }
    }


    static class TestB{
        // 该方法
        public static void main(String[] args) throws InterruptedException {
            Thread thread = new Thread(() -> {
                System.out.println("child thread begin park!");

                LockSupport.park();

                System.out.println("child thread end park!");
            });
            thread.start();

            TimeUnit.SECONDS.sleep(1);
            LockSupport.unpark(thread);
            System.out.println("main thread end!");
        }
    }


    static class TestC{
        // 该方法
        public static void main(String[] args) throws InterruptedException {
            Thread thread = new Thread(() -> {
                System.out.println("child thread begin park!");

                while (!Thread.currentThread().isInterrupted()){
                    LockSupport.park();
                }

                System.out.println("child thread end park!");
            });
            thread.start();

            TimeUnit.SECONDS.sleep(1);
            // 中断会触发unPark方法,使得再上次循环park之后不会阻塞,因此可以输出 "child thread end park"
            thread.interrupt();

            System.out.println("main thread end!");
        }
    }
}
