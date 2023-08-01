package com.dc.design.test.agent;

import lombok.Data;

/**
 * @author DCZhang
 * @title Suitor
 * @date 2023/8/1 9:42
 * @description 追求者
 */
@Data
public class Suitor implements IGift {

    private Pursued pursued;

    public Suitor(Pursued pursued) {
        this.pursued = pursued;
    }

    @Override
    public void sendGift() {
        System.out.println("Suitor给" + pursued.getName() + "送礼物");
    }
}
