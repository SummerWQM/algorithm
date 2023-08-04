package com.myself.exercise.leetcode;

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

 public static void main(String[] arg) {
        int[] nums = new int[]{4, 5, 1, 2, 3};

        System.out.println(find(nums, 5));
    }

    // 旋转数组的二分查找
    public static int find(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return target;
            }
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }


        }
        return -1;
    }

}
