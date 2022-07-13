package com.service.impl;

public class A extends T {


    public Integer add() {
        return 0;
    }

    A() {

    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("free");
    }


}
