package com.dc.concurrency.test.chapter6;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author DCZhang
 * @title AQSTest
 * @date 2023/7/26 9:20
 * @description AQS 6.2
 * AQS是JUC包中的一个基础组件,在JUC包中的很多类都是基于AQS实现的
 * AQS是一个抽象类,其中定义了一些基本的方法,子类可以通过继承AQS来实现自己的同步器
 * AQS是一个双向队列,其中有一个head节点和一个tail节点,head节点是一个线程,当线程获取锁失败的时候,会将线程封装成一个Node节点,并将其加入到队列的尾部
 *
 * AQS中的state变量是用来表示锁的状态的,表示锁是获取状态,通过CAS操作来修改state的值
 *
 * 设计:
 * 1.使用一个volatile变量来表示锁的状态,0表示锁没有被占用,1表示锁已经被占用
 * 2.使用一个FIFO的队列来存储获取锁失败的线程
 * 3.使用一个变量来表示当前获取锁的线程
 * 4.使用一个变量来表示当前获取锁的线程的重入次数
 * 5. acquire方法:获取锁的方法,如果获取锁成功,则直接返回,如果获取锁失败,则将当前线程封装成一个Node节点,并将其加入到队列的尾部,然后将当前线程park
 * 6. release方法:释放锁的方法,如果当前线程是获取锁的线程,则将重入次数减1,如果重入次数为0,则将当前线程设置为null,并将队列中的下一个线程唤醒
 *
 * !!!! 注意子类的state变量的含义,子类的state变量的含义是子类的同步状态,子类的state变量的值是通过CAS操作来修改的
 * 比如ReentrantLock中的state变量的值是通过CAS操作来修改的,表示锁的重入次数
 *
 *
 * 代码实现 继承 AbstractQueuedSynchronizer 共享锁和独占锁的实现 NonReentrantLock
 */
public class NonReentrantLock implements Lock, Serializable {

    /**
     * 内部帮助类
     */
    private static class Sync extends AbstractQueuedSynchronizer{
        // 判断是否已经被持有
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        // 如果state为0,则尝试获取锁
        public boolean tryAcquire(int acquires) {
            assert acquires == 1; // Otherwise unused
            // 如果当前状态为0,则通过CAS操作将其修改为1,表示获取锁成功
            if (compareAndSetState(0, 1)) {
                // 设置当前获取锁的线程
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        // 尝试释放锁,将state设置为0
        protected boolean tryRelease(int releases) {
            assert releases == 1; // Otherwise unused
            // 如果当前线程不是获取锁的线程,则抛出异常
            if (getState() == 0) throw new IllegalMonitorStateException();
            // 设置当前获取锁的线程为null
            setExclusiveOwnerThread(null);
            // 设置state为0
            setState(0);
            return true;
        }

        // 返回一个Condition,每个Condition都包含了一个Condition队列
        Condition newCondition() { return new ConditionObject(); }
    }

    private final Sync sync = new Sync();

    @Override
    public void lock() {
        // 调用AQS的acquire方法
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        // 调用AQS的acquireInterruptibly方法
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        // 调用AQS的tryAcquire方法
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        // 调用AQS的tryAcquireNanos方法
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        // 调用AQS的release方法
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        // 调用AQS的newCondition方法
        return sync.newCondition();
    }
}
