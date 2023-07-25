package com.dc.concurrency.test.chapter5;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author DCZhang
 * @title ConcurrencyList
 * @date 2023/7/25 14:34
 * @description CopyOnWriteArrayList
 * 内部使用ReentrantLock进行加锁,在写的时候会进行复制,在复制的时候会加锁,在复制完成之后,会将原来的数组指向新的数组
 *
 * CopyOnWriteArrayList迭代器的弱一致性
 * CopyOnWriteArrayList 的迭代器虽然是指向原来的数组,但是在迭代的时候,如果有其他线程对数组进行修改,会进行复制,导致迭代器的弱一致性
 * 即: 当原始数据被修改的时候是相当于快照,迭代器的数据是不会变的
 */
public class ConcurrencyListTest {
    private static CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();

    public static void main(String[] args) throws InterruptedException {
        copyOnWriteArrayList.add("1");
        copyOnWriteArrayList.add("2");
        copyOnWriteArrayList.add("3");
        copyOnWriteArrayList.add("4");
        // 由于内部实现是先获取数组,然后进行获取对应下标
        // 当获取数组之后有其他操作对该对象进行修改,会进行复制修改
        // 导致弱一致性
        System.out.println(copyOnWriteArrayList.get(0));

        copyOnWriteArrayList.set(0, "5");

        // 迭代器的弱一致性
        System.out.println("迭代器的弱一致性测试");
        Iterator iterator = copyOnWriteArrayList.iterator();
        Thread thread = new Thread(() -> {
            copyOnWriteArrayList.set(0, "6");
        });
        thread.start();
        // 等待子线程执行完
        thread.join();
        while (iterator.hasNext()) {
            // 此处打印结果没有6,因为在迭代的时候,数组已经被复制了,迭代器指向的是原来的数组
            System.out.println(iterator.next());
        }

    }
}
