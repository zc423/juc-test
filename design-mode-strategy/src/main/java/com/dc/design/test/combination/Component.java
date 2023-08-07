package com.dc.design.test.combination;

import lombok.Data;

/**
 * @author DCZhang
 * @title Component
 * @date 2023/8/7 14:33
 * @description TODO
 */
@Data
public abstract class Component {

    private String name;

    Component(String name){
        this.name = name;
    }

    public void add(Component component){
        throw new UnsupportedOperationException("不支持添加操作");
    }

    public void remove(Component component){
        throw new UnsupportedOperationException("不支持删除操作");
    }

    abstract void display();
}
