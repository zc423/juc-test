package com.dc.design.test.combination;

/**
 * @author DCZhang
 * @title ComponentB
 * @date 2023/8/7 14:37
 * @description TODO
 */
public class ComponentB extends Component{
    ComponentB(String name) {
        super(name);
    }

    @Override
    void display() {
        System.out.println("ComponentB");
    }
}
