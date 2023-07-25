package com.dc.concurrency.test.chapter3;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author DCZhang
 * @title ThreadLocalRandomTest
 * @date 2023/7/25 11:37
 * @description ThreadLocalRandom 是在JUC包下新增的生成随机数的生成器
 * 1.7中Random是通过CAS操作修改种子数来实现的,在多线程下会有性能问题
 * 1.8中ThreadLocalRandom是通过ThreadLocal来维护变量,每个线程都有一个种子变量,在多线程下性能更好
 *
 * Random类及其局限性
 * todo Random类及其局限性
 * 局限性: Random在多线程的情况下,多个线程会同时根据一个老种子计算新的种子,当一个线程计算出新的种子之后,
 * 其他种子要丢弃当前的计算结果(使用CAS 操作去更新老种子,失败重新计算),使用最先计算出来的种子进行计算新种子,以此轮推
 *
 * ThreadLocalRandom的实现原理:
 * 1.首先每个线程都有一个种子变量,种子变量的初始值是通过调用Unsafe的static方法生成的
 *
 */
public class ThreadLocalRandomTest {
    // 进行种子初始化
    ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

}
