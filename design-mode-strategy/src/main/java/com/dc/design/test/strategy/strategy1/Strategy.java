package com.dc.design.test.strategy.strategy1;

import java.math.BigDecimal;

public interface Strategy {
    /**
     * 获取折扣后价格
     */
    BigDecimal getDiscountPrice(BigDecimal price, Integer num);
}
