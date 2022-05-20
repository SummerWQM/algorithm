package com.exercise.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/submissions/
 * 爬楼梯
 */
public class ClimbStairs {

    public static void main(String[] avg) {

    }


    public static int climStairs(int n) {

        if (n <= 3) {
            return n;
        }
        if (n == 4) {
            return n + 1;
        }
        int[] p = new int[n + 1];
        p[0] = 0;
        p[1] = 1;
        p[2] = 2;
        p[3] = 3;
        p[4] = 5;
        for (int i = 5; i < p.length; i++) {
            p[i] = p[i - 1] + p[i - 2];
        }

        return p[n];


    }

}
