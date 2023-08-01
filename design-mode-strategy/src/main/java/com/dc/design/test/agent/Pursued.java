package com.dc.design.test.agent;

import lombok.Data;

/**
 * @author DCZhang
 * @title Pursued
 * @date 2023/8/1 9:44
 * @description 被追求者
 */
@Data
public class Pursued {
    private String name;

    public Pursued(String name) {
        this.name = name;
    }

}
