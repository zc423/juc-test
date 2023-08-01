package com.dc.design.test.template;

/**
 * @author DCZhang
 * @title TempleteTest
 * @date 2023/8/1 13:44
 * @description 模板方法: 将不变的行为抽象到父类当中,去除子类的重复代码
 */
public class TemplateTest {
    public static void main(String[] args) {
        Template templateB = new TemplateB();
        templateB.run();
        System.out.println("---------------");
        Template templateA = new TemplateA();
        templateA.run();
    }
}
