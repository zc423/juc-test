package com.dc.concurrency.test.chapter6;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author DCZhang
 * @title ReentrantReadWriteLock
 * @date 2023/7/26 14:12
 * @description 6.4 ReentrantReadWriteLock
 *
 * ReentrantReadWriteLock读写锁: 读写锁维护了一对锁,一个读锁和一个写锁,通过分离读锁和写锁,使得并发性相比一般的排它锁有了很大提升
 * 读写锁同时依赖于一个Sync类,该类继承了AQS类,内部有两个内部类,分别是NonfairSync和FairSync
 * 读写锁的读锁和写锁都是通过AQS的state变量来控制的,读锁的state的高16位表示读锁的数量,低16位表示写锁的数量
 *
 * 读写操作可以由两个不同的线程执行
 */
public class ReentrantReadWriteLockTest {

    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        // 读锁
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        /**
         * 读锁的获取与释放
         * 读锁的获取与释放与ReentrantLock的获取与释放一样,都是通过AQS的acquire和release方法来实现的
         * 先判断32位的state是不是等于0
         * 如果不等于0 那么把1左移16位-1得到b
         * 然后结果 a&b 得出低16位是否有数
         */
        readLock.lock();
        readLock.unlock();

//        reentrantReadWriteLock.writeLock().lock();
        System.out.println(Integer.toBinaryString((1 << 16) - 1));
    }
}
