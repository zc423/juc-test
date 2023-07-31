package com.dc.design.test.strategy.strategy1.impl;

import com.dc.design.test.strategy.strategy1.Strategy;

import java.math.BigDecimal;

/**
 * @author DCZhang
 * @title DiscountService
 * @date 2023/7/31 15:36
 * @description TODO
 */
public class DiscountService implements Strategy {

    private Double rate;

    public DiscountService(Double rate) {
        if (rate > 1 || rate < 0) {
            throw new RuntimeException("折扣率不合法");
        }
        this.rate = rate;
    }

    @Override
    public BigDecimal getDiscountPrice(BigDecimal price, Integer num) {
        return price.multiply(new BigDecimal(num)).multiply(BigDecimal.valueOf(rate));
    }
}
