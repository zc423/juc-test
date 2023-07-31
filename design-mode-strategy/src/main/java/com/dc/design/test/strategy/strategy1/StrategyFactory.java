package com.dc.design.test.strategy.strategy1;

import com.dc.design.test.strategy.strategy1.impl.DiscountService;
import com.dc.design.test.strategy.strategy1.impl.FullReductionService;
import com.dc.design.test.strategy.strategy1.impl.NormalService;

/**
 * @author DCZhang
 * @title StrategyFactory
 * @date 2023/7/31 15:46
 * @description TODO
 */
public class StrategyFactory {
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
}
