package com.exercise.leetcode;

/**
 * 二分搜索
 */
public class Search {


    /**
     * @param arr    有序数据map
     * @param target 目标数字
     * @return 数组下标
     */
    public int find(float[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (target > arr[middle]) {
                left = middle + 1;
            } else if (target < arr[middle]) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

}
