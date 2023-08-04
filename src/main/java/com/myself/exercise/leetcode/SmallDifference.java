package com.myself.exercise.leetcode;

import java.util.Arrays;

public class SmallDifference {

    /**
     * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
     */

    public int smallestDifference(int[] a, int[] b) {

        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;
        long min = Integer.MAX_VALUE;

        while (i < a.length && j < b.length) {

            if (a[i] == b[j]) return 0;

            if (a[i] > b[j]) {
                min = Math.min(min, (long) a[i] - (long) b[j]);
                j++;
            } else {
                min = Math.min(min, (long) b[j] - (long) a[i]);
                i++;
            }
        }

        return (int) min;

    }

}
