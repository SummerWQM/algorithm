////package com;
////
////
////import com.alibaba.csp.sentinel.Entry;
////import com.alibaba.csp.sentinel.SphU;
////import com.alibaba.csp.sentinel.slots.block.BlockException;
////import com.alibaba.csp.sentinel.slots.block.RuleConstant;
////import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
////import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
////import com.service.impl.SmsImpl1;
////import org.springframework.boot.SpringApplication;
////import org.springframework.context.annotation.AnnotationConfigApplicationContext;
////
////import java.util.ArrayList;
////import java.util.List;
////import java.util.concurrent.CountDownLatch;
////import java.util.concurrent.locks.ReentrantReadWriteLock;
////
////public class AlgorithmApp {
////
////    public static void main(String[] args) {
////
////
//////        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//////
//////        ctx.scan("com.service.impl");
//////
//////        ctx.refresh();
//////
//////        SmsImpl1 sms = ctx.getBean(SmsImpl1.class);
//////
//////        sms.getT();
////
////        initFlowRules();
////        while (true) {
////            Entry entry = null;
////            try {
////                entry = SphU.entry("HelloWorld");
////                /*您的业务逻辑 - 开始*/
////                System.out.println("hello world");
////                /*您的业务逻辑 - 结束*/
////            } catch (BlockException e1) {
////                /*流控逻辑处理 - 开始*/
////                System.out.println("block!");
////                /*流控逻辑处理 - 结束*/
////            } finally {
////                if (entry != null) {
////                    entry.exit();
////                }
////            }
////        }
////
//////        ThreadLocal<String> local = new ThreadLocal<>();
//////
//////        ThreadLocal<String> local2 = new ThreadLocal<>();
//////
//////
//////        LinkedList<String> linkedList = new LinkedList<>();
//////
//////        linkedList.add("a");
//////        linkedList.add("ab");
//////        linkedList.add("abc");
//////        linkedList.add("abcd");
//////        for (int i = 0; i < linkedList.size(); i++) {
//////
//////            linkedList.remove(linkedList.get(i));
//////        }
//////
//////        linkedList.forEach(System.out::println);
////
////
//////        local.set("user");
//////
//////        local2.set("local2");
//////
//////        System.out.println(local.get());
//////
//////        System.out.println(local2.get());
//////
//////        local2.remove();
//////
//////        System.out.println("local2:move" + local2.get());
//////
//////        System.out.println("local1:get()" + local.get());
//////
//////
//////        LinkedList<Integer> linkList = new LinkedList<>();
//////
//////        linkList.forEach(System.out::println);
//////        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 2, 30,
//////                TimeUnit.SECONDS,
//////                new LinkedBlockingQueue<>(20));
//////
//////        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
//////
//////
//////        reentrantReadWriteLock.readLock().lock();
//////
//////
//////        reentrantReadWriteLock.writeLock().lock();
//////
//////
//////        CountDownLatch latch = new CountDownLatch(3);
//////
//////        latch.countDown();
////
////
////        CountDownLatch latch = new CountDownLatch(3);
////
////        latch.countDown();
////
////        SpringApplication.run(AlgorithmApp.class, args);
////
//////        int[] dp = new int[10];
//////        int max = 1;
//////
//////        Arrays.fill(dp, max);
//////
//////        for (int i = 0; i < dp.length; i++) {
//////            System.out.println(dp[i]);
//////        }
//////
//////        //Collections.swap();
//////
////        //  SpringApplication.run(AlgorithmApp.class, args);
////
////
//////        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
//////
//////
//////        ctx.registerShutdownHook();
////    }
////
////    private static void initFlowRules() {
////        List<FlowRule> rules = new ArrayList<>();
////        FlowRule rule = new FlowRule();
////        rule.setResource("HelloWorld");
////        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
////        // Set limit QPS to 20.
////        rule.setCount(20);
////        rules.add(rule);
////        FlowRuleManager.loadRules(rules);
////    }
////
//////    class Context {
////    //  private Long pid = Thread.currentThread().getId();
////
////    // public Long pid() {
////    //     return pid;
//////        }
//////    }
////}
////
////// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
//////
//////import java.util.Scanner;
//////
//////public class AlgorithmApp {
//////    public static void main(String[] args) {
//////        Scanner in = new Scanner(System.in);
//////        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//////            int a = in.nex();
//////            int b = in.nextInt();
//////            System.out.println(a + b);
//////        }
//////    }
//////}
////
////
//////import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//////import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//////
//////import java.util.Arrays;
//////import java.util.HashMap;
//////import java.util.Scanner;
//////import java.util.Stack;
////
//////public class AlgorithmApp {
//////
//////    public static void main(String[] args) {
//////
//////        double sum = 15.0;
//////
////
//////
//////
//////
//////
//
//package com.myself;
//
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//
//import com.alibaba.csp.sentinel.Entry;
//import com.alibaba.csp.sentinel.SphU;
//import com.alibaba.csp.sentinel.slots.block.BlockException;
//import com.alibaba.csp.sentinel.slots.block.RuleConstant;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import java.lang.instrument.Instrumentation;
//
//@SpringBootApplication
//public class AlgorithmApp {
//
//
//
//    /*
//     * Bean 加载过程
//     *
//     *  加载类 ->  选择构造函数(@Autowire 指定) -> 普通对象 -> (属性赋值)依赖注入
//     *
//     *           -> 初始化（前 postConstruct） -> 初始化(@InitializingBean) -> 初始化后（执行AOP)）
//     *
//     *           -> 代理对象 - (没有对代理对象的依赖注入，从容器拿出来的代理对象，没有依赖值)-->
//     *
//     *           -> 放入MAP单例池 -> Bean对象
//     *
//     * @param args
//     *
//     *
//     *
//     */
//
//
//<<<<<<< HEAD:src/main/java/com/myself/AlgorithmApp.java
//    public static void main(String[] args) throws ClassNotFoundException {
//
//
//
//
//        new SpringApplicationBuilder().sources(AlgorithmApp.class).web(WebApplicationType.NONE).run(args);
//
////
////        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
////        OrderService orderService = (OrderService) context.getBean("orderService");
////        orderService.init();
//=======
//    public static void main(String[] args) {
//
//        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        List<FlowRule> rules = new ArrayList<>();
//        FlowRule rule = new FlowRule();
//        rule.setResource("HelloWorld");
//        // set limit qps to 20
//        rule.setCount(10);
//        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        rules.add(rule);
//        FlowRuleManager.loadRules(rules);
//        for (int i = 0; i < 10000; i++) {
//            try (Entry entry = SphU.entry("HelloWorld")) {
//                // Your business logic here.
//                System.out.println("hello world");
//            } catch (BlockException e) {
//                // Handle rejected request.
//                e.printStackTrace();
//            }
//        }
//
//    }
//
////
////    static class User {
////
////        public void test() {
////        }
////
////    }
//
//    /*
//     *  AOP -> 创建代理对象，赋值 target 对象 （普通对象） =》 放入Map单例池容器
//     */
////    static class UserProxy extends User {
////
////        User target;
////
////        public void test() {
////            //@Before
////            // super.test()
////            //切面逻辑
////            target.test();
////        }
////    }
////
////    public static void premain(String agentArgs, Instrumentation inst) {
////        System.out.println("MyAgent: premain method called with args: " + agentArgs);
////        System.out.println("MyAgent: Instrumentation instance = " + inst);
////    }
//
//
//}
