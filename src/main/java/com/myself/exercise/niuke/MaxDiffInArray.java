package com.myself.exercise.niuke;

import java.util.Deque;
import java.util.LinkedList;

/**
 * int 数组中 元素 差值最大，贪心，或者排序
 */
public class MaxDiffInArray {


    public static int maxDiffInArray(int[] arr) {

        int max = 0;

        int min = arr[0];

        for (int j : arr) {
            int diff = j - min;

            if (diff > max) {
                max = diff;
            }

            if (j < min) {
                min = j;
            }

        }
        return max;
    }

    public static Integer t() {
        return 0;
    }


    public static void main(String[] a) {



        Deque<Integer> deque = new LinkedList<>();
    }
}
