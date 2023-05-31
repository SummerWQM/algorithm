package com.thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

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

        t();
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


}
