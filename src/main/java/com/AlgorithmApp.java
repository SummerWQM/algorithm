package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@SpringBootApplication
public class AlgorithmApp {

    public static void main(String[] args) {

        ThreadLocal local = new ThreadLocal();


        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 2, 30,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(20));


        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        reentrantReadWriteLock.readLock().lock();

        reentrantReadWriteLock.writeLock().lock();


        CountDownLatch latch = new CountDownLatch(3);

        latch.countDown();



        SpringApplication.run(AlgorithmApp.class, args);


    }
}

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
//
//import java.util.Scanner;
//
//public class AlgorithmApp {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int a = in.nex();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
//    }
//}


//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Scanner;
//import java.util.Stack;

//public class AlgorithmApp {
//
//    public static void main(String[] args) {
//
//        double sum = 15.0;
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(sum += sum * 0.1);
//        }
//    }
//
//
//}