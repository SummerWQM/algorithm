package com.thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadNote {

    public static void main(String[] args) {

        LinkedBlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(300);

        AtomicInteger atom = new AtomicInteger(0);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                20,
                60,
                TimeUnit.SECONDS,
                queue
        );

//        LockSupport.park();


//        executor.submit(() -> {
//            for (int i = 0; i < 320; i++) {
//                System.out.println(atom.addAndGet(1) + "-" + Thread.currentThread().getName());
//            }
//        });
//
//
//        ReentrantLock reentrantLock = new ReentrantLock();

        t2();
    }


    public static void t() {

        char[] cha1 = "1234567".toCharArray();

        char[] char2 = "abcedfg".toCharArray();


        Object o = new Object();


        Thread t1 = new Thread(new Runnable() {


            @Override
            public void run() {

                synchronized (o) {
                    for (char a : cha1) {
                        System.out.print(a);
                        try {

                            o.notify();
                            o.wait();
                        } catch (InterruptedException e) {
                            //ignore
                        }

                    }
                    o.notify();
                }
            }
        });

        t1.start();


        Thread t2 = new Thread(() -> {
            synchronized (o) {
                for (char a : char2) {
                    System.out.print(a);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        //ignore
                    }
                }
                o.notify();
            }
        });


        t2.start();


    }


    public static void t2() {

        char[] cha1 = "1234567".toCharArray();

        char[] char2 = "abcedfg".toCharArray();


        Lock lock = new ReentrantLock();


        //= 一个队列
        Condition condition = lock.newCondition();

        // 队列2
        Condition condition1 = lock.newCondition();


        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                for (char a : cha1) {
                    System.out.print(a);
                    try {

                        condition1.signal(); // notify
                        condition.await();// await
                    } catch (InterruptedException e) {
                        //ignore
                    }

                }
                condition1.signal();
            } finally {
                lock.unlock();
            }
        }
        );

        t1.start();


        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                for (char a : char2) {
                    System.out.print(a);
                    try {
                        condition.signal();
                        condition1.await();
                    } catch (InterruptedException e) {
                        //ignore
                    }
                }
                condition.signal();
            } finally {

                lock.unlock();
            }
        });


        t2.start();


    }

}
