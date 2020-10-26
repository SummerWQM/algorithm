package com;

import com.exercise.leetcode.IsHappy;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class AlgorithmApp {

    public static void main(String[] arg) {

        IsHappy isHappy = new IsHappy();


        System.out.println(isHappy.isHappy(29));
    }
}
