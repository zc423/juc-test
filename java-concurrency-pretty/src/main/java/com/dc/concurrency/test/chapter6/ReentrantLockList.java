package com.dc.concurrency.test.chapter6;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author DCZhang
 * @title ReentrantLockList
 * @date 2023/7/26 14:02
 * @description 6.3.4 ReentrantLock实现的线程安全的List
 */
public class ReentrantLockList {

    private ArrayList arrayList = new ArrayList();

    private volatile ReentrantLock lock = new ReentrantLock();


    public void add(Object e) {
        lock.lock();
        try {
            arrayList.add(e);
        } finally {
            lock.unlock();
        }
    }

    public void remove(Object e) {
        lock.lock();
        try {
            arrayList.remove(e);
        } finally {
            lock.unlock();
        }
    }

    public Object get(int index) {
        lock.lock();
        try {
            return arrayList.get(index);
        } finally {
            lock.unlock();
        }
    }


}
