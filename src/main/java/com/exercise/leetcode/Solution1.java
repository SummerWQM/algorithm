package com.exercise.leetcode;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
 * 动态规划
 */
public class Solution1 {

    public int maxSubArray(int[] nums) {

        int pre = 0, max = nums[0];

        for (int x : nums) {

            pre = Math.max(pre + x, x);

            max = Math.max(max, pre);
        }


        return max;
    }

}

