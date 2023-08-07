package com.dc.design.test.combination;

/**
 * @author DCZhang
 * @title CombinationTest
 * @date 2023/8/7 14:14
 * @description 组合模式
 * 何时使用组合模式
 * 需要体现整体与部分的层次结构时候,虚妄用户可以忽略组合对象与单个对象的不同,统一的使用组合结构中的所有对象时候
 */
public class CombinationTest {
    public static void main(String[] args) {
        ComponentMain main = new ComponentMain("main");
        ComponentA a = new ComponentA("a");
        ComponentB b = new ComponentB("b");
        main.add(a);
        main.add(b);
        main.display();
    }
}
