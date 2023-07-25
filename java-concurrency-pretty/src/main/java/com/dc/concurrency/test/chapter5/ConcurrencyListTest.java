package com.dc.concurrency.test.chapter5;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author DCZhang
 * @title ConcurrencyList
 * @date 2023/7/25 14:34
 * @description CopyOnWriteArrayList
 * 内部使用ReentrantLock进行加锁,在写的时候会进行复制,在复制的时候会加锁,在复制完成之后,会将原来的数组指向新的数组
 */
public class ConcurrencyListTest {
    private static CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();

    public static void main(String[] args) {
        copyOnWriteArrayList.add("1");
        copyOnWriteArrayList.add("2");
        copyOnWriteArrayList.add("3");
        copyOnWriteArrayList.add("4");
        // 由于内部实现是先获取数组,然后进行获取对应下标
        // 当获取数组之后有其他操作对该对象进行修改,会进行复制修改
        // 导致若一致性
        System.out.println(copyOnWriteArrayList.get(0));

        copyOnWriteArrayList.set(0, "5");

    }
}
