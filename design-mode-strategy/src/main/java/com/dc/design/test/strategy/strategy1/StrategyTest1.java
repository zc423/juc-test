package com.dc.design.test.strategy.strategy1;

import java.math.BigDecimal;

/**
 * @author DCZhang
 * @title Strategy1
 * @date 2023/7/31 15:33
 * @description TODO
 */
public class StrategyTest1 {
    public static void main(String[] args) {
        // 测试满减100-20
        BigDecimal discount = StrategyFactory.getStrategy("discount").getDiscountPrice(new BigDecimal("10"), 10);
        discount = discount.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(discount);
    }
}
