package com.dc.design.test.strategy.strategy2;

import com.dc.design.test.strategy.strategy1.Strategy;
import com.dc.design.test.strategy.strategy1.impl.DiscountService;
import com.dc.design.test.strategy.strategy1.impl.FullReductionService;
import com.dc.design.test.strategy.strategy1.impl.NormalService;

import java.math.BigDecimal;

/**
 * @author DCZhang
 * @title StrategyContext
 * @date 2023/7/31 15:58
 * @description TODO
 */
public class StrategyContext {
    public static Strategy getStrategy(String type) {
        switch (type) {
            case "normal":
                return new NormalService();
            case "discount":
                return new DiscountService(0.8);
            case "fullReduction":
                return new FullReductionService(100.0, 20.0);
        }
        throw new RuntimeException("不支持的类型");
    }

    public static BigDecimal getResult(Strategy strategy, BigDecimal price, Integer num) {
        return strategy.getDiscountPrice(price, num);
    }
}
