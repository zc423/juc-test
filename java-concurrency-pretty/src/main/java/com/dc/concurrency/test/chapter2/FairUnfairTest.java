package com.dc.concurrency.test.chapter2;

/**
 * @author DCZhang
 * @title FairUnfairTest
 * @date 2023/7/25 11:31
 * @description
 * <>2.1</>
 * 公平锁与非公平锁
 * 公平锁: 公平锁是指多个线程按照申请锁的顺序来获取锁,类似排队打饭,先来后到
 * 非公平锁: 非公平锁是指在多个线程申请锁的时候,先来后到并不一定能获取锁,有可能后申请锁的线程比先申请锁的线程先获取锁
 *
 * 独占锁和共享锁
 * 独占锁: 比如synchronized和ReentrantLock,在一段时间内只能有一个线程持有锁,其他线程想要获取锁就必须等待
 * 共享锁: 比如ReentrantReadWriteLock,在一段时间内可以有多个线程持有锁,并且可以实现读读共享,读写互斥,写写互斥
 *
 * 可重入锁:
 * 可重入锁: 可重入锁是指在同一个线程在外层方法获取锁的时候,在进入内层方法会自动获取锁(前提锁对象得是同一个对象或者class)
 * synchronized和ReentrantLock都是可重入锁,在内部有一个计数器,每次重入的时候计数器+1,直到完全解锁,计数器变为0
 *
 * 自旋锁:
 * 自旋锁: 自旋锁是指当一个线程尝试获取锁的时候,如果锁已经被其他线程获取,则一直循环等待,直到获取到锁为止
 * 自旋锁的好处是减少线程上下文切换的消耗,缺点是循环等待会消耗CPU
 * 默认自旋10次,可以通过-XX:PreBlockSpin来更改
 * 自旋锁的实现有: synchronized,ReentrantLock,AtomicInteger等
 */
public class FairUnfairTest {
}
