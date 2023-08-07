package com.dc.design.test.adapter;

/**
 * @author DCZhang
 * @title AdapterTest
 * @date 2023/8/7 13:42
 * @description 适配器模式
 */
public class AdapterTest {
    public static void main(String[] args) {
        // 使用简单的继承方式实现适配器模式
        // 调用方根据固定模板进行调用,使用适配器类作为中间层进行适配,调用方并不需要直接依赖于被适配者
        TargetMethod targetMethod = new Adapter();
        targetMethod.request();
    }
}
