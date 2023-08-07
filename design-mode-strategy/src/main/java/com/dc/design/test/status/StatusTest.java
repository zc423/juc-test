package com.dc.design.test.status;

import com.dc.design.test.status.impl.StateImplA;

/**
 * @author DCZhang
 * @title StatusTest
 * @date 2023/8/3 14:01
 * @description 状态模式
 * 当一个对象的行为取决于它的状态,并且它必须在运行时根据状态改变它的行为时,就可以考虑使用状态模式
 */
public class StatusTest {
    public static void main(String[] args) {
        // 设置当前状态的下一个状态
        // 当前案例当中的下一个状态为B
        // B状态的下一个状态为A,因此进行多次请求状态会循环
        Context context = new Context(new StateImplA());
        context.request();
        context.request();
        context.request();
        context.request();
        context.request();
        context.request();
    }
}
