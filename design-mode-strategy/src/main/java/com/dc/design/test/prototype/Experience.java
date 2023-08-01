package com.dc.design.test.prototype;

import lombok.Data;

/**
 * @author DCZhang
 * @title Experience
 * @date 2023/8/1 13:35
 * @description TODO
 */
@Data
public class Experience implements Cloneable{
    private String company;

    private String duration;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
