package com.dc.design.test.adapter;

/**
 * @author DCZhang
 * @title Adapter
 * @date 2023/8/7 13:50
 * @description 适配器
 */
public class Adapter implements TargetMethod {
    private Adaptee adaptee = new Adaptee();

    public void request(){
        adaptee.adapteeRequest();
    }
}
