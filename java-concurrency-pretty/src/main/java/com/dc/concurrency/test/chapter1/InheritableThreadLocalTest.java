package com.dc.concurrency.test.chapter1;

/**
 * @author DCZhang
 * @title InheritableThreadLocalTest
 * @date 2023/7/25 9:14
 * @description InheritableThreadLocal 可以让子线程获取父线程的ThreadLocal变量
 * <p>
 * 子线程可以获取到父线程设置的值,但是子线程设置的值不会同步到父线程当中
 * 这是因为在Thread 的构造方法中有这么一段代码
 * if (inheritThreadLocals && parent.inheritableThreadLocals != null)
 *      this.inheritableThreadLocals = ThreadLocal.createInheritedMap(parent.inheritableThreadLocals);
 * inheritThreadLocals在构造方法中默认是 true, 当父线程的 inheritableThreadLocals不为空的时候会传递给子线程
 */
public class InheritableThreadLocalTest {
    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        inheritableThreadLocal.set("Hello World");
        threadLocal.set("Hello World");
        Thread thread = new Thread(() -> {
            System.out.println("child print inheritableThreadLocal: " + inheritableThreadLocal.get());
            System.out.println("child print threadLocal: " + threadLocal.get());
            inheritableThreadLocal.set("Thread A");
            threadLocal.set("Thread A");
        });
        thread.start();
        thread.join();
        System.out.println("main print inheritableThreadLocal: " + inheritableThreadLocal.get());
        System.out.println("main print threadLocal: " + threadLocal.get());
    }
}
