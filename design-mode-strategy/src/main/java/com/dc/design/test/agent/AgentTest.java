package com.dc.design.test.agent;

/**
 * @author DCZhang
 * @title AgentTest
 * @date 2023/8/1 9:35
 * @description TODO
 */
public class AgentTest {
    public static void main(String[] args) {
        Pursued pursued = new Pursued("小红");

        Agent agent = new Agent(pursued);

        agent.sendGift();
    }
}
