package com.dc.design.test.adapter;

import lombok.Data;

/**
 * @author DCZhang
 * @title Adaptee
 * @date 2023/8/7 13:49
 * @description 需要被适配的对象
 */
public class Adaptee {
    public void adapteeRequest(){
        System.out.println("被适配者的方法");
    }
}
