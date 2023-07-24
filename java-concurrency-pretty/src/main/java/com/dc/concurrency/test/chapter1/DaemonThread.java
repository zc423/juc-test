package com.dc.concurrency.test.chapter1;

/**
 * @author DCZhang
 * @title DeamonThread
 * @date 2023/7/24 13:57
 * @description 守护线程
 * 线程分为两类,一个是用户线程,一个是守护线程
 * 守护线程不会影响jvm的退出,也就是当所有的用户线程结束以后会直接退出jvm
 * 守护线程的应用场景:例如垃圾回收线程
 * 守护线程的设置必须在线程启动之前,否则会抛出异常
 *
 * 当main方法执行完毕之后,会启动一个叫DestroyJavaVM的线程,这个线程会等待所有的用户线程执行完毕之后,然后退出jvm
 *
 * Tomcat 中实现Nio的接受线程和处理线程就是守护线程
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true){

            }
        });
        // 设置为守护线程
        thread.setDaemon(true);
        thread.start();

        System.out.println("Main Thread is over");
    }
}
