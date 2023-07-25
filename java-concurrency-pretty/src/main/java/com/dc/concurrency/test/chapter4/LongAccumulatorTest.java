package com.dc.concurrency.test.chapter4;

import java.util.concurrent.atomic.LongAccumulator;

/**
 * @author DCZhang
 * @title LongAccumulator
 * @date 2023/7/25 14:19
 * @description TODO
 */
public class LongAccumulatorTest {
    LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x + y, 0);
}
