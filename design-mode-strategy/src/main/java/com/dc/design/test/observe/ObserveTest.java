package com.dc.design.test.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DCZhang
 * @title ObserveTest
 * @date 2023/8/3 9:50
 * @description 观察者模式
 *
 * 当一个对象改变的时候需要同时修改其他几个对象的时候,可以使用观察者模式
 * 让耦合的双方都依赖于抽象,而不是直接依赖于具体,使得在双方改变的同时不会影响对方
 *
 *
 * 1. 对通知者进行抽象,拥有观察者名单,通知观察者的方法
 * 2. 对观察者进行抽象,拥有更新方法
 * 3. 通知者添加观察者,在状态变更之后通知所有订阅的观察者
 */

/**
 * 实际应用可以参考
 * @see java.util.Observable
 * @see java.util.Observer
 */
public class ObserveTest {

    public static void main(String[] args) {
        ObserveB observeB = new ObserveB();
        ObserveA observeA = new ObserveA();
        SubjectA subjectA = new SubjectA();
        subjectA.addObserve(observeA);
        subjectA.addObserve(observeB);
        subjectA.setState("1");
    }



    static abstract class Subject{
        private List<Observe> observes = new ArrayList<>();
        private String state;
        public void addObserve(Observe observe){
            observes.add(observe);
        }

        public void removeObserve(Observe observe){
            observes.remove(observe);
        }

        public void notifyObserve(){
            for (Observe observe : observes) {
                observe.update();
            }
        }

        public void setState(String state){
            this.state = state;
            notifyObserve();
        }
    }

    static class SubjectA extends Subject{
    }

    /**
     * 实际实现过程中,可以使用接口不使用抽象类
     */
    static abstract class Observe{
       public abstract void update();
    }


    static class ObserveA extends Observe{

        @Override
        public void update() {
            System.out.println("观察者A收到通知");
        }
    }

    static class ObserveB extends Observe{


        @Override
        public void update() {
            System.out.println("观察者B收到通知");
        }
    }

}
