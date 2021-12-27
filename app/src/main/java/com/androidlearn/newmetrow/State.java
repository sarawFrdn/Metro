package com.androidlearn.newmetrow;

public enum State {

    TRUE(1) , FALSE(0);
    private int state;
    private State(Integer state){

     this.state = state ;
    }

    public int getState(){
        return  state;
    }
}
