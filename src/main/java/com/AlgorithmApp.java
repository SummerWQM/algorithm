package com;

import com.exercise.leetcode.IsHappy;
import com.exercise.leetcode.RemoveRepeat;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

public class AlgorithmApp {

    public static void main(String[] arg) {

        RemoveRepeat r = new RemoveRepeat();

        int[] a = new int[]{
                3, 2, 2, 3
        };


        System.out.println(r.removeElement(a, 3));

        System.out.println(Arrays.toString(a));
    }
}
