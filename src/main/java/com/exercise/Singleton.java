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
}
