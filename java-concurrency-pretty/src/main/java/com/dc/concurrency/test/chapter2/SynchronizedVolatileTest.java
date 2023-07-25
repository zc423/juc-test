package com.dc.concurrency.test.chapter2;

/**
 * @author DCZhang
 * @title SyncTest
 * @date 2023/7/25 9:32
 * @description synchronized volatile 测试
 * 当一个线程操作共享变量的时,首先从主内存复制变量到自己的工作内存,然后对工作内存里面的变量进行处理,处理完成之后再写回到主内存中
 * <p>
 * synchronized 是java提供的一种内置的监视器锁,同一时刻只能有一个线程持有锁,当一个线程获取锁之后,其他线程只能等待
 * 当当前同步代码块正常退退出,抛出异常,或者线程执行了同步代码块中的wait方法,都会释放锁,否则其他线程将持续等待
 * 由于java中的线程与操作系统的线程是一一对应的,当阻塞一个线程的时候需要从用户态切换到内核态执行阻塞操作
 * synchronized会导致上下文切换
 * <p>
 * synchronized的内存语义:
 * 进入同步代码块之前需要将线程本地的缓存清除,这样就不会从内存中获取,结束使用将该变量刷新到主内存中
 * <p>
 * volatile: 当一个变量被声明为 volatile,变量被修改以后不会把值缓存在寄存器或者其他地方,而是直接刷新到主内存中
 * 当其他线程需要读取该变量的时候,会从主内存中读取最新的值,而不是从线程的工作内存中读取
 * 当线程读取的时候相当于进入了同步代码块,当线程写入的时候相当于退出了同步代码块
 * 同时volatile也禁止了指令重排序,
 * 写: 可以确保volatile写之前的操作不会被编译器重排序到volatile写之后
 * 读: 可以确保volatile读之后的操作不会被编译器重排序到volatile读之前
 */
public class SynchronizedVolatileTest {

    /**
     * 以下A B两个同步方式等价
     */

    public static class ClassA{
        private int a = 1;

        public synchronized int getA() {
            return a;
        }

        public synchronized void setA(int a) {
            this.a = a;
        }
    }

    public static class ClassB{
        private volatile int a = 1;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }

}
