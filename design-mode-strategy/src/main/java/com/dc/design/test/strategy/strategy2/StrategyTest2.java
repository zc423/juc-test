package com.dc.design.test.strategy.strategy2;

import java.math.BigDecimal;
/**
 * @author DCZhang
 * @title StrategyTest2
 * @date 2023/7/31 16:00
 * @description 策略模式
 *
 * 1. 对一系列的算法进行封装,算法实现不同但是实现的目标一致
 * 2. 有利于单元测试
 * 3. 有利于代码复用
 * 4. 有利于代码扩展,新增策略不需要修改原有代码,继承原有的策略接口即可
 *
 * 缺点:
 * 1. 新增策略类需要修改StrategyContext策略工厂类,违反了开闭原则
 */public class StrategyTest2 {
    public static void main(String[] args) {
        BigDecimal discount = StrategyContext.getResult(StrategyContext.getStrategy("discount"), new BigDecimal("10"), 10);
        System.out.println(discount);
    }
}
