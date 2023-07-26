package com.dc.concurrency.test.chapter6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author DCZhang
 * @title LockConditionTest
 * @date 2023/7/26 10:55
 * @description 测试 ReentrantLock.Condition
 */
public class LockConditionTest {

    static class TestA{
        private static ReentrantLock reentrantLock = new ReentrantLock();
        private static Condition condition = reentrantLock.newCondition();

        public static void main(String[] args) {
            new Thread(() -> {
                reentrantLock.lock();
                try {
                    System.out.println("线程1获取锁成功");
                    // 将该线程加入到条件队列当中,等待其他线程唤醒
                    condition.await();
                    System.out.println("线程1被唤醒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }).start();

            new Thread(() -> {
                reentrantLock.lock();
                try {
                    System.out.println("线程2获取锁成功");
                    // 将条件队列中的线程唤醒,将其加入到阻塞队列中,等待获取锁
                    condition.signal();
                    System.out.println("线程2执行完");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }).start();
        }
    }
}
