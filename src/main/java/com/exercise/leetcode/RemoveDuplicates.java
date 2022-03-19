package com.exercise.leetcode;

/**
 * 原地删除重复的有序数组
 */
public class RemoveDuplicates {


    /**
     * 返回新数组长度
     */
    public int remove(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int p = 0;
        int q = 1;

        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;

        }
        return p + 1;

    }
}
