package com.myself.thread;

import org.apache.tomcat.jni.Time;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class T {


    static {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(getRunnable(), 1, 2, TimeUnit.SECONDS);
    }


    public static Runnable getRunnable() {


        return () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ignored) {

            }
            System.out.println(System.currentTimeMillis() + " : " + Thread.currentThread().getId());
        };

    }

}
