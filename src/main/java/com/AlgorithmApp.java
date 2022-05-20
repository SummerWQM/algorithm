package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

@SpringBootApplication
@Resource
public class AlgorithmApp {

    public static void main(String[] args) {

//        ThreadLocal<String> local = new ThreadLocal<>();
//
//        ThreadLocal<String> local2 = new ThreadLocal<>();
//
//
//        LinkedList<String> linkedList = new LinkedList<>();
//
//        linkedList.add("a");
//        linkedList.add("ab");
//        linkedList.add("abc");
//        linkedList.add("abcd");
//        for (int i = 0; i < linkedList.size(); i++) {
//
//            linkedList.remove(linkedList.get(i));
//        }
//
//        linkedList.forEach(System.out::println);


//        local.set("user");
//
//        local2.set("local2");
//
//        System.out.println(local.get());
//
//        System.out.println(local2.get());
//
//        local2.remove();
//
//        System.out.println("local2:move" + local2.get());
//
//        System.out.println("local1:get()" + local.get());
//
//
//        LinkedList<Integer> linkList = new LinkedList<>();
//
//        linkList.forEach(System.out::println);
//        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 2, 30,
//                TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>(20));
//
//        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
//
//
//        reentrantReadWriteLock.readLock().lock();
//
//
//        reentrantReadWriteLock.writeLock().lock();
//
//
//        CountDownLatch latch = new CountDownLatch(3);
//
//        latch.countDown();

        int[] dp = new int[10];
        int max = 1;

        Arrays.fill(dp, max);

        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }

        //Collections.swap();

        //  SpringApplication.run(AlgorithmApp.class, args);


    }

//    class Context {
    //  private Long pid = Thread.currentThread().getId();

    // public Long pid() {
    //     return pid;
//        }
//    }
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

//
//
//}