package com.dc.design.test.decoration.impl;

import com.dc.design.test.decoration.IPerson;
import lombok.Data;

/**
 * @author DCZhang
 * @title Dress
 * @date 2023/8/1 9:18
 * @description TODO
 */
@Data
public class Dress implements IPerson {
    private IPerson person;

    public void dress(IPerson person) {
        this.person = person;
    }

    @Override
    public void show() {
        person.show();
    }
}
