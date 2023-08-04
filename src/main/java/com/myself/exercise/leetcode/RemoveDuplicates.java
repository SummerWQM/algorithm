package com.myself.exercise.leetcode;

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
            // 如果想等  0  1 1  1
            // 移动 q 快指针 知道找到不同的。

            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;

    }
}
