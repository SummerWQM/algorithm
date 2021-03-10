package com.exercise.leetcode;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * <p>
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) throws InterruptedException {

        int x = -1, y = -1;

        if (nums.length == 0) {
            return new int[]{x, y};
        }
        int left = 0, mid = 0, right = nums.length - 1;

        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                break;
            }
        }

        if (nums[mid] != target) {
            return new int[]{x, y};
        }
        x = mid;
        y = mid;
        for (int i = mid; i >= 0; i--) {

            if (nums[i] == target) {
                x = i;

            }
            else {
                break;
            }
        }

        for (int j = mid; j < nums.length; j++) {
            if (nums[j] == target) {
                y = j;

            }else {
                break;
            }
        }

        return new int[]{x, y};

    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println(Arrays.toString(
                new SearchRange().searchRange(new int[]{1}, 1)));
    }


}
