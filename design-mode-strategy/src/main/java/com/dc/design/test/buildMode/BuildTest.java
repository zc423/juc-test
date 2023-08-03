package com.dc.design.test.buildMode;

/**
 * @author DCZhang
 * @title BulidTest
 * @date 2023/8/3 9:26
 * @description 建造者模式
 * 模板方法模式和建造者模式是两种常用的设计模式，它们有一些区别和适用场景。
 *
 *     模板方法模式（Template Method Pattern）：
 *         定义了一个算法的骨架，将一些步骤的实现延迟到子类中，以便子类可以重新定义特定步骤的实现。
 *         提供了一个模板方法来定义算法的结构，该方法调用了一系列抽象方法或具体方法，这些方法在父类中定义，以完成算法的各个步骤。
 *         主要用于定义算法的框架，而具体的步骤的实现由子类来完成。
 *
 *     建造者模式（Builder Pattern）：
 *         将一个复杂对象的构建过程与其表示分离，使得同样的构建过程可以创建不同的表示。
 *         将对象的构建过程分解为一系列步骤，通过不同的步骤组合可以构建出不同的对象表现形式。
 *         主要用于创建复杂对象，将对象的构建过程进行解耦，使得构建过程更加灵活可配置。
 *
 * 区别：
 *
 *     功能上的区别：
 *         模板方法模式关注的是算法的框架，定义了算法的骨架，具体实现由子类提供。
 *         建造者模式关注的是创建对象的过程，将对象的构建过程与其表示分离，通过不同的步骤组合可以构建出不同的对象。
 *
 *     实现上的区别：
 *         模板方法模式使用继承机制，将可变的行为留给子类实现。
 *         建造者模式使用组合关系，将构建过程委托给具体的建造者对象。
 *
 * 使用场景：
 *
 *     模板方法模式适用于以下情况：
 *         在一个算法中有一些通用的步骤，而这些步骤的具体实现可能会有所不同。
 *         需要在运行时决定算法中的某些部分，以实现灵活性。
 *     建造者模式适用于以下情况：
 *         当对象的构建过程比较复杂，包含多个步骤或者涉及到多个部件的组装时。
 *         希望通过不同的步骤或者部件组合来构建不同的对象，以满足变化的需求。
 */
public class BuildTest {
    public static void main(String[] args) {
        DrawPeople drawPeopleImplA = new DrawPeopleImplA();
        drawPeopleImplA.draw();
        DrawPeople drawPeopleImplB = new DrawPeopleImplB();
        drawPeopleImplB.draw();
    }


    /**
     * 抽象类
     */
    static abstract class DrawPeople{
        public void draw(){
            drawA();
            drawB();
            drawC();
            drawD();
        }
        public abstract void drawA();
        public abstract void drawB();
        public abstract void drawC();
        public abstract void drawD();
    }

    static class DrawPeopleImplA extends DrawPeople{
        @Override
        public void drawA() {
            System.out.println("A: " + this.getClass().getSimpleName());
        }
        @Override
        public void drawB() {
            System.out.println("B: " + this.getClass().getSimpleName());
        }
        @Override
        public void drawC() {
            System.out.println("C: " + this.getClass().getSimpleName());
        }
        @Override
        public void drawD() {
            System.out.println("D: " + this.getClass().getSimpleName());
        }
    }

    static class DrawPeopleImplB extends DrawPeople{
        @Override
        public void drawA() {
            System.out.println("A: " + this.getClass().getSimpleName());
        }
        @Override
        public void drawB() {
            System.out.println("B: " + this.getClass().getSimpleName());
        }
        @Override
        public void drawC() {
            System.out.println("C: " + this.getClass().getSimpleName());
        }
        @Override
        public void drawD() {
            System.out.println("D: " + this.getClass().getSimpleName());
        }
    }
}
