package com.dc.concurrency.test.chapter4;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author DCZhang
 * @title AtomicLongTest
 * @date 2023/7/25 13:35
 * @description TODO
 */
public class AtomicLongTest {
    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong();
        /**
         * getAndIncrement()方法的实现
         * 1.7 通过在AtomicLong 中进行自旋 CAS 操作更新值
         * 1.8 通过Unsafe类的getAndAddLong()方法进行更新,unsafe中将自旋进行内置,因此不需要在AtomicLong中进行自旋
         */
        atomicLong.getAndIncrement();
    }
}
