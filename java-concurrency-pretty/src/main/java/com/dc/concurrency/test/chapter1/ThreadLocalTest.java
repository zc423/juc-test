package com.dc.concurrency.test.chapter1;

/**
 * @author DCZhang
 * @title ThreadLocalTest
 * @date 2023/7/24 14:26
 * @description ThreadLocal
 * ThreadLocal是一个线程内部的数据结构,可以理解为一个map,其中key是线程,而value是线程的变量副本
 * 如果你创建了一个ThreadLocal变量,那么访问这个变量的每个线程都会有这个变量的一个本地副本,每次操作操作的自己本地内存里面的副本
 *
 * 实现原理:
 * 每个Thread中有两个变量 threadLocals 和 inheritableThreadLocals,这两个变量都是ThreadLocalMap类型的变量
 * 默认为空,当当前线程第一次调用 ThreadLocal 的 set 或者 get 方法的时候,会进行初始化,并且会将当前 ThreadLocal 的变量存储到对应的map中
 * 之后每次调用get或者set方法的时候,都会访问当前线程的ThreadLocalMap变量,然后进行对应的操作
 * 之所以使用ThreadLocalMap是因为每个线程都有自己的ThreadLocalMap,所以不会出现线程安全问题
 *
 * 具体请查看get() set() remove()源码
 *
 *
 * get()实现:
 * 1. 获取当前线程
 * 2. 根据当前线程去获取对应额度线程变量
 * 3. 当获取到为空的时候进行创建 createMap(t, value);
 *
 * 优点: 每个线程有独立的备份,但是不支持继承
 *
 */public class ThreadLocalTest {

    static void print(){
        System.out.println(threadLocal.get());
    }

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) throws InterruptedException {
        threadLocal.set("Hello World");

        Thread threadA = new Thread(() -> {
            threadLocal.set("Thread A");
            // 打印的是Thread A
            print();
        });
        threadA.start();

        threadA.join();

        // 打印的是Hello World
        print();
        // 清除本地缓存
        threadLocal.remove();
        print();
    }
}
