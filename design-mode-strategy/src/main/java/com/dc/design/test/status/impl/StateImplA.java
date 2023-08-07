package com.dc.design.test.status.impl;

import com.dc.design.test.status.Context;
import com.dc.design.test.status.State;

/**
 * @author DCZhang
 * @title StateImplA
 * @date 2023/8/7 13:30
 * @description TODO
 */
public class StateImplA implements State {
    @Override
    public void handle(Context context) {
        System.out.println("StateImplA");
        // 进入下一个状态
        // 具体实现需要针对性的进行修改,比如针对时间进行修改或者其他进行判断
        context.setState(new StateImplB());
    }
}
