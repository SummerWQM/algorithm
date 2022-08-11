package com.exercise;

/**
 * 双从校验锁，获取单例
 * 01. 第一次校验，为了提高性能，如果已经赋值不为空了，那么直接返回
 * 02. 加锁后，仍校验，也是为了提高性能， 如果 获取锁有  已经被上一个获取锁的 更新为 不为空了，那么直接返回。
 */
public class Singleton {

    private static volatile Singleton singleton;

    public static Singleton getUniqueSingle() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] avg) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Singleton.getUniqueSingle().hashCode());
            }).start();
        }
    }

    /**
     * springboot启动时，是依靠启动类的main方法来进行启动的，而main方法中执行的是
     * SpringApplication.run() 方法，而 SpringApplication.run() 方法中会创建spring的容器，并且刷新容器
     * 。而在刷新容器的时候就会去解析启动类，然后就会去解析启动类上的 @SpringBootApplication 注解，而这个注解是个复合注解，这个注解中有一个 @EnableAutoConfiguration 注解，这个注解就是开启自动配置，这个注解中又有 @Import 注解引入了一个 AutoConfigurationImportSelector 这个类，这个类会进过一些核心方法，然后去扫描我们所有jar包下的 META-INF 下的 spring.factories 文件，而从这个配置文件中取找key为 EnableAutoConfiguration 类的全路径的值下面的所有配置都加载，这些配置里面都是有条件注解的，然后这些条件注解会根据你当前的项目依赖的jar包以及是否配置了符合这些条件注解的配置来进行装载的。
     *
     * 这就是springboot自动配置的过程。
     */
}
