package com.dc.design.test.decoration.impl;

import com.dc.design.test.decoration.IPerson;
import lombok.Data;

/**
 * @author DCZhang
 * @title Person
 * @date 2023/8/1 9:15
 * @description
 */
@Data
public class Person implements IPerson {
    public Person(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public void show() {
        System.out.println("---------------------");
        System.out.println("以上是" + name + "穿搭  ");
    }
}
