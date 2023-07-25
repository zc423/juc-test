package com.dc.concurrency.test.chapter2;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author DCZhang
 * @title AtomTest
 * @date 2023/7/25 10:12
 * @description 2.7 原子性
 * <p>
 * 1.原子性:一个操作或者多个操作,要么全部执行并且执行过程不会被任何因素打断,要么就都不执行
 * 2.原子性的实现:1.使用锁 2.使用原子变量
 * <p>
 * 常见问题: ++value, value++ 不是原子性操作
 * @description 2.8 CAS
 * 1. CAS: Compare And Swap, 比较并交换,是jdk提供的非阻塞原子性操作
 * JDK中Unsafe类提供了硬件级别的原子操作,Unsafe类中的compareAndSwapInt方法可以实现原子性的更新基本类型的变量
 * <p>
 * 2. ABA问题: 一个变量原来是A,变成了B,又变成了A,那么使用CAS进行检查时会发现变量的值没有发生变化,但是实际上却变化了
 * JDK在解决该问题时给每一个变量配备了时间戳
 * <p>
 * <p>
 * 2.11 伪共享
 * 为了解决计算机内存访问速度与CPU运算速度不匹配的问题,计算机会在CPU与内存之间加入高速缓存cache
 * 为了提高CPU与内存之间的数据传输效率,cache会将CPU需要的数据读取到cache中,当CPU需要写入数据时,cache会将数据写入到内存中
 * 当cpu访问某个变量的时候,会先从cache中读取,如果cache中没有,则从内存中读取,当cpu修改某个变量的时候,会先修改cache中的值,然后再写入到内存中
 * <p>
 * <p>
 * 解决伪共享:
 * 1.使用缓存行填充,缓存行的大小为64字节,可以使用7个long类型的变量填充一个缓存行
 * 2.使用sun.misc.Contended注解,该注解可以在JDK8中使用,在JDK9中被废弃
 */
public class AtomTest {
    /**
     * 实现1:
     * 问题: 1.效率低下 2.容易产生死锁
     */
    private static class Count {
        private int num = 0;

        public synchronized void add() {
            num++;
        }

        public synchronized int getNum() {
            return num;
        }
    }

    /**
     * 实现2: 使用非阻塞CAS原子变量
     */
    private static class Count2 {
        private AtomicLong num = new AtomicLong(0);

        public void add() {
            num.incrementAndGet();
        }

        public Long getNum() {
            return num.get();
        }
    }


}
