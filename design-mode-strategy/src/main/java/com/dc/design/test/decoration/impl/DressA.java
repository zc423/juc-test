package com.dc.design.test.decoration.impl;

import com.dc.design.test.decoration.IPerson;

/**
 * @author DCZhang
 * @title DressA
 * @date 2023/8/1 9:18
 * @description TODO
 */
public class DressA extends Dress{
    @Override
    public void show() {
        System.out.println("穿上了裙子");
        super.show();
    }
}
