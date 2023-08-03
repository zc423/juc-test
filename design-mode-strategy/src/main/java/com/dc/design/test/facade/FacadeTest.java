package com.dc.design.test.facade;

/**
 * @author DCZhang
 * @title FacadeTest
 * @date 2023/8/1 13:59
 * @description 外观模式
 * 为子系统中的一组接口提供一个一致的界面，此模式定义了一个高层接口，这个接口使得这一子系统更加容易使用
 *
 * 使用场景:
 * 1. 设计初期，有意识的将不同的两个层分离，层与层之间建立外观Facade 如三层架构
 * 2. 开发阶段，子系统很复杂，增加外观模式提供一个简单的接口，减少他们之间的依赖
 * 3. 维护阶段，有大量的遗留代码，使用外观模式，新系统开发外观类，提供设计粗糙或高度复杂的遗留代码的比较清晰的简单的接口，让新系统与Facade对象交互，Facade与遗留代码交互所有复杂的工作
 */
public class FacadeTest {
    public static void main(String[] args) {
        // 通过外观模式，客户端可以不需要知道子系统的实现细节，而只需要与外观类交互即可
        Facade facade = new Facade();
        facade.run();
    }


    static class Facade {
        private SubSystemA subSystemA;
        private SubSystemB subSystemB;
        private SubSystemC subSystemC;

        public Facade() {
            subSystemA = new SubSystemA();
            subSystemB = new SubSystemB();
            subSystemC = new SubSystemC();
        }

        public void run() {
            subSystemA.methodA();
            subSystemB.methodB();
            subSystemC.methodC();
        }

    }

    static class SubSystemA {
        public void methodA() {
            System.out.println("子系统A的方法A");
        }
    }

    static class SubSystemB {
        public void methodB() {
            System.out.println("子系统B的方法B");
        }
    }

    static class SubSystemC {
        public void methodC() {
            System.out.println("子系统C的方法C");
        }
    }
}
