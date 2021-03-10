package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class AlgorithmApp {


    private static final ThreadPoolExecutor pool;

    static {
        pool = new ThreadPoolExecutor(
                2,
                100,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(100));

    }


    public static void main(String[] args) {

    }
    
}