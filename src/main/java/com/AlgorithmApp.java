package com;

import com.exercise.leetcode.IsHappy;
import com.exercise.leetcode.RemoveRepeat;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

@SpringBootApplication
public class AlgorithmApp {

    public static void main(String[] arg) {


        Queue<Integer> queue = new ArrayBlockingQueue<>(10);

        for (int i = 10; i > 0; i--) {

            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
