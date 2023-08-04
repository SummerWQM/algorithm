package com.myself.exercise.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/submissions/
 * 爬楼梯
 */
public class ClimbStairs {



    public static int climStairs(int n) {
        HashMap<Object, Object> a = new HashMap<>();

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

    // 最小路径和 最多路径
    public static int minRoad(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < columns; i++) {
            dp[0][i] = dp[i - 1][0] + grid[0][i];
        }

        for (int i = 1; i < rows; i++) {

            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[rows - 1][columns - 1];
    }


    /**
     * 输出频率最高且最先出现的字符
     *
     * @param s
     * @return
     */
    public static char pd(String s) {

        int maxCount = 1;

        char res = s.charAt(0);

        LinkedHashMap<Character, Integer> ans = new LinkedHashMap<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            int count = ans.getOrDefault(s.charAt(i), 0) + 1;

            ans.put(s.charAt(i), count);

            if (count > maxCount) {
                maxCount = count;
                res = s.charAt(i);
            }
        }

        return res;

    }

    public static void main(String[] avg) {

        System.out.println(pd("abcabcdeftc"));
    }
}
