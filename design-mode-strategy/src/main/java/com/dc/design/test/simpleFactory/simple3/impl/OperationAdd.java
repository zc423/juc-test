package com.dc.design.test.simpleFactory.simple3.impl;

import com.dc.design.test.simpleFactory.simple3.Operation;

/**
 * @author DCZhang
 * @title OperationAdd
 * @date 2023/7/31 15:21
 * @description TODO
 */
public class OperationAdd implements Operation {
    @Override
    public double getResult(double number1, double number2) {
        return number1 + number2;
    }
}
