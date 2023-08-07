package com.dc.design.test.combination;

import java.util.List;

/**
 * @author DCZhang
 * @title ComponentMain
 * @date 2023/8/7 14:36
 * @description TODO
 */
public class ComponentMain extends Component{

    List<Component> components = new java.util.ArrayList<>();

    ComponentMain(String name) {
        super(name);
    }

    @Override
    void display() {
        for (Component component : components) {
            component.display();
        }
    }

    @Override
    public void add(Component component){
        components.add(component);
    }

    @Override
    public void remove(Component component){
        components.remove(component);
    }
}
