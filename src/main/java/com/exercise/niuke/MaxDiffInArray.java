package com.exercise.niuke;

/**
 * int 数组中 元素 差值最大，贪心，或者排序
 */
public class MaxDiffInArray {


    public static int maxDiffInArray(int[] arr) {

        int max = 0;

        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int diff = arr[i] - min;

            if (diff > max) {
                max = diff;
            }

            if (arr[i] < min) {
                min = arr[i];
            }

        }
        return max;
    }
}
