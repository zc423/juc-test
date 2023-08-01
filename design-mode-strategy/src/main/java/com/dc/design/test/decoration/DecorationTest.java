package com.dc.design.test.decoration;

import com.dc.design.test.decoration.impl.DressA;
import com.dc.design.test.decoration.impl.DressB;
import com.dc.design.test.decoration.impl.Person;

/**
 * @author DCZhang
 * @title DecorationTest
 * @date 2023/8/1 9:13
 * @description 装饰模式
 * 1. 为已有的功能动态的添加功能的一种方式
 * 2.
 */
public class DecorationTest {
    public static void main(String[] args) {
        IPerson person = new Person("小明");
        DressA dressA = new DressA();
        DressB dressB = new DressB();
        dressA.dress(person);
        dressB.dress(dressA);

        dressB.show();
    }
}
