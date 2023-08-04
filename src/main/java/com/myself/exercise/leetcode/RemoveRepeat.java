package com.myself.exercise.leetcode;

/**
 * @link https://leetcode-cn.com/problems/remove-element/solution/yi-chu-yuan-su-by-leetcode/
 */
public class RemoveRepeat {

    // 双指针
    // @ 4
    // [0,1,3,4,4]
    // 空间复杂度O(1)

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

}