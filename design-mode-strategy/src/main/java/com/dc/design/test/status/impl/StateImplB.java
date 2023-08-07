package com.dc.design.test.status.impl;

import com.dc.design.test.status.Context;
import com.dc.design.test.status.State;

/**
 * @author DCZhang
 * @title StateImplA
 * @date 2023/8/7 13:30
 * @description TODO
 */
public class StateImplB implements State {

    @Override
    public void handle(Context context) {
        System.out.println("StateImplB");
        context.setState(new StateImplA());
    }

}
