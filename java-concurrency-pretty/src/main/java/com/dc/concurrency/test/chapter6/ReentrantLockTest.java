package com.dc.concurrency.test.chapter6;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author DCZhang
 * @title ReentranLockTest
 * @date 2023/7/26 11:14
 * @description ReentrantLock 6.3
 * ReentrantLock 内部有一个Sync类,Sync类继承了AQS类,Sync类中有两个内部类,分别是NonfairSync和FairSync
 * 这里的state是一个int类型的变量,用于表示锁的状态,默认是0,表示锁没有被占用,当一个线程获取到锁时,会将state+1,释放锁时会将state-1
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        // 默认是非公平锁
        ReentrantLock reentrantLock = new ReentrantLock(false);
        /**
         * 非公平锁的不公平在于
         * nonfairTryAcquire方法中,先获取state,如果A进来时候是1,则放入AQS阻塞队列
         * 但是当B线程进来此时state被其持有线程修改释放,此时state为0,则B线程可以直接获取锁
         */
        reentrantLock.lock();
        reentrantLock.unlock();

        ReentrantLock fair = new ReentrantLock(true);
        /**
         * 非公平锁的不公平在于
         * nonfairTryAcquire方法中,先获取state,如果A进来时候是1,则放入AQS阻塞队列
         * 但是当B线程进来此时state被其持有线程修改释放,此时state为0
         * 公平处理:
         * 当state为0 的时候进行hasQueuedPredecessors判断当前线程之前是否有线程到来,如果有,阻塞当前线程
         */
        fair.lock();

        /**
         * 如果不是当前线程持有锁,会抛出异常
         * 如果是当前线程持有锁,会将state-1,如果state结果为0,会放弃锁的持有
         */
        fair.unlock();

//        try {
        // 该方法与上面的lock方法一样,只是该方法可以被中断,当其他线程调用了当前线程的interrupt方法时,会抛出异常
//            fair.lockInterruptibly();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } finally {
//            fair.unlock();
//        }

        // 注意: tryLock方法是非阻塞的,如果获取不到锁,会直接返回false
        // 该方法可以传入参数,表示获取锁的超时时间,当到达超时时间之后依旧没有获取到锁,会返回false
//       fair.tryLock(1000, TimeUnit.MILLISECONDS);
//       fair.unlock();

    }
}
