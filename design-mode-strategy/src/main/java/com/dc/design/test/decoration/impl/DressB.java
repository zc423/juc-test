package com.dc.design.test.decoration.impl;

/**
 * @author DCZhang
 * @title DressA
 * @date 2023/8/1 9:18
 * @description TODO
 */
public class DressB extends Dress{
    @Override
    public void show() {
        System.out.println("穿上了裤子");
        super.show();
    }
}
