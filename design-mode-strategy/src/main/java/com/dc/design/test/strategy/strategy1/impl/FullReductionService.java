package com.dc.design.test.strategy.strategy1.impl;

import com.dc.design.test.strategy.strategy1.Strategy;

import java.math.BigDecimal;

/**
 * @author DCZhang
 * @title FullReductionService
 * @date 2023/7/31 15:37
 * @description TODO
 */
public class FullReductionService implements Strategy {
    /**
     * 满
     */
    private Double fullPrice;
    /**
     * 减
     */
    private Double reducePrice;

    public FullReductionService(Double fullPrice, Double reducePrice) {
        if (fullPrice < reducePrice) {
            throw new RuntimeException("满减金额不合法");
        }
        if (fullPrice < 0 || reducePrice < 0) {
            throw new RuntimeException("满减金额不合法");
        }

        this.fullPrice = fullPrice;
        this.reducePrice = reducePrice;
    }


    @Override
    public BigDecimal getDiscountPrice(BigDecimal price, Integer num) {
        BigDecimal multiply = price.multiply(new BigDecimal(num));
        if (multiply.doubleValue() < fullPrice) {
            return multiply;
        }
        return multiply.subtract(BigDecimal.valueOf(reducePrice));
    }
}
