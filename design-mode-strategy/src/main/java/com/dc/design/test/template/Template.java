package com.dc.design.test.template;

/**
 * @author DCZhang
 * @title Template
 * @date 2023/8/1 13:51
 * @description TODO
 */
public abstract class Template {
    public void run(){
        System.out.println("模板方法");

        method1();
        method2();
    }

    abstract void method1();

    abstract void method2();
}
