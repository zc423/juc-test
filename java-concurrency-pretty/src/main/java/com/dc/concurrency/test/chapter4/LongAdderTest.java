package com.dc.concurrency.test.chapter4;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author DCZhang
 * @title LongAdderTest
 * @date 2023/7/25 13:45
 * @description LongAdder
 * 1.8中新增的原子类,在AtomicLong的基础上进行了优化
 * 1.8中AtomicLong的实现是通过CAS操作,多个线程尝试更新一个值,在高并发的情况下,会有大量线程进行自旋,导致性能下降
 * LongAdder的实现是通过分段的思想,将一个值分成多个段,每个段有一个值,多个线程更新的时候,会随机选择一个段进行更新,这样就减少了自旋的情况
 * 在获取的时候,会将所有段的值进行累加,得到最终的值
 *
 * todo LongAdder的实现原理源码
 */
public class LongAdderTest {
    LongAdder longAdder = new LongAdder();
}
