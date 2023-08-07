package com.dc.design.test.notes;

/**
 * @author DCZhang
 * @title NotesTest
 * @date 2023/8/7 14:07
 * @description 备忘录模式
 * 将要保存的细节进行封装, 保存到备忘录中, 通过备忘录进行状态的恢复
 */
public class NotesTest {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("A");
        System.out.println("初始状态:" + originator.getState());
        Notes memento = originator.createMemento();
        originator.setState("B");
        System.out.println("修改后状态:" + originator.getState());
        originator.restoreMemento(memento);
        System.out.println("恢复后状态:" + originator.getState());
    }
}
