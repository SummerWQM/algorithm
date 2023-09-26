package com.myself.service.impl;

public class A extends T {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("free");
    }


}
