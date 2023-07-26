package com.dc.concurrency.test.chapter7;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author DCZhang
 * @title ConcurrentLinkedQueueTest
 * @date 2023/7/26 16:17
 * @description 7.1 ConcurrentLinkedQueue 并发队列
 */
public class ConcurrentLinkedQueueTest {

    private static ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

    // todo 源码分析
    public static void main(String[] args) {
        queue.offer("a");
    }
}
