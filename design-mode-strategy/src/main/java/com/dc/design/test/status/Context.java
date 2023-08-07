package com.dc.design.test.status;

/**
 * @author DCZhang
 * @title Context
 * @date 2023/8/7 13:30
 * @description TODO
 */
public class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }


    public Context(State state) {
        this.state = state;
    }

    public void request(){
        state.handle(this);
    }

}
