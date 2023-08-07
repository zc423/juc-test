package com.dc.design.test.notes;

import lombok.Data;

/**
 * @author DCZhang
 * @title Originator
 * @date 2023/8/7 14:08
 * @description TODO
 */
@Data
public class Originator {
    private String state;

    /**
     * 对当前需要备份的信息进行备份
     * @return
     */
    public Notes createMemento(){
        return new Notes(state);
    }

    /**
     * 通过备份信息进行状态的恢复
     * @param memento
     */
    public void restoreMemento(Notes memento){
        this.state = memento.getState();
    }
}
