package com.dc.design.test.agent;

/**
 * @author DCZhang
 * @title Agent
 * @date 2023/8/1 9:40
 * @description TODO
 */
public class Agent implements IGift{

    private Suitor suitor;

    public Agent(Pursued pursued) {
        this.suitor = new Suitor(pursued);
    }

    @Override
    public void sendGift() {
        suitor.sendGift();
    }
}
