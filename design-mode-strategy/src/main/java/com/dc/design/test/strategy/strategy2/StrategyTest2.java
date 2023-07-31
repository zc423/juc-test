package com.dc.design.test.strategy.strategy2;

import java.math.BigDecimal;

/**
 * @author DCZhang
 * @title StrategyTest2
 * @date 2023/7/31 16:00
 * @description TODO
 */
public class StrategyTest2 {
    public static void main(String[] args) {
        BigDecimal discount = StrategyContext.getResult(StrategyContext.getStrategy("discount"), new BigDecimal("10"), 10);
        System.out.println(discount);
    }
}
