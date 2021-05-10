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

            pre = Math.max(pre + x, x); // 计算子序列的和，如何 +x 后 大于了 pre+x 从x 开始计算新的子序列。

            max = Math.max(max, pre);// 计算这些 子序列中 最大的一个子序列。
        }


        return max;
    }

}

