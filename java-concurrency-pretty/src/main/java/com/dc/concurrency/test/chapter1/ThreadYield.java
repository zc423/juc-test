package com.dc.concurrency.test.chapter1;

/**
 * @author DCZhang
 * @title ThreadYield
 * @date 2023/7/21 11:28
 * @description yield 会让出当前线程剩余的时间片,重新竞争CPU资源
 */
public class ThreadYield implements Runnable {

    public static void main(String[] args) {
        new ThreadYield();
        new ThreadYield();
        new ThreadYield();
    }


    ThreadYield(){
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getId() + ":" + i);
            Thread.yield();
        }
    }
}
