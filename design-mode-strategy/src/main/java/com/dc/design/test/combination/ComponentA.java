package com.dc.design.test.combination;

/**
 * @author DCZhang
 * @title ComponentA
 * @date 2023/8/7 14:36
 * @description TODO
 */
public class ComponentA extends Component{
    ComponentA(String name) {
        super(name);
    }

    @Override
    void display() {
        System.out.println("ComponentA");
    }
}
