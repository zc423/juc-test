package com.dc.design.test.strategy.strategy1.impl;

import com.dc.design.test.strategy.strategy1.Strategy;

import java.math.BigDecimal;

/**
 * @author DCZhang
 * @title NormalService
 * @date 2023/7/31 15:39
 * @description TODO
 */
public class NormalService implements Strategy {
    @Override
    public BigDecimal getDiscountPrice(BigDecimal price, Integer num) {
        return price.multiply(new BigDecimal(num));
    }
}
