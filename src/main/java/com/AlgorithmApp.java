package com;


import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.service.impl.SmsImpl1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmApp {

    public static void main(String[] args) {


//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//
//        ctx.scan("com.service.impl");
//
//        ctx.refresh();
//
//        SmsImpl1 sms = ctx.getBean(SmsImpl1.class);
//
//        sms.getT();

        initFlowRules();
        while (true) {
            Entry entry = null;
            try {
                entry = SphU.entry("HelloWorld");
                /*您的业务逻辑 - 开始*/
                System.out.println("hello world");
                /*您的业务逻辑 - 结束*/
            } catch (BlockException e1) {
                /*流控逻辑处理 - 开始*/
                System.out.println("block!");
                /*流控逻辑处理 - 结束*/
            } finally {
                if (entry != null) {
                    entry.exit();
                }
            }
        }

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

<<<<<<< HEAD
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        reentrantReadWriteLock.readLock().lock();



        reentrantReadWriteLock.writeLock().lock();



        CountDownLatch latch = new CountDownLatch(3);

        latch.countDown();

        SpringApplication.run(AlgorithmApp.class, args);
=======
//        int[] dp = new int[10];
//        int max = 1;
//
//        Arrays.fill(dp, max);
//
//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(dp[i]);
//        }
//
//        //Collections.swap();
//
        //  SpringApplication.run(AlgorithmApp.class, args);
>>>>>>> 82ae2909dcef9b711b2088c09b290a1d9ba4ed42


//        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
//
//
//        ctx.registerShutdownHook();
    }

    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
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
//
//