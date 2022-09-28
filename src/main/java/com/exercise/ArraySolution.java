package com.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class ArraySolution {

    public static void fns(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                swap(nums, i, p1);
            } else if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                p0++;
                p1++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] avg) {
        int[] nums = new int[]{2, 2, 1, 0, 0, 1, 2};
        fns(nums);
        System.out.println(Arrays.toString(nums));
    }


    // 递增数组 和为K
    public static ArrayList<Integer> findPair(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < j) {
            if (nums[i] + nums[j] < k) {
                i++;
            } else if (nums[i] + nums[j] > k) {
                j--;
            } else {
                list.add(nums[i]);
                list.add(nums[j]);
            }
        }
        return list;
    }

// 先递增再递减 不重复的元素个数

    public int diffnum(int[] nums) {
        int n = nums.length;
        if (n == 0 || nums == null) {
            return 0;
        }
        int left = 0;
        int right = n - 1;
        int sum = 0;
        while (left <= right) {
            if (nums[left] == nums[right]) {
                sum++;
                int temp = nums[left];
                while (left <= right && nums[right] == temp)
                    right--;
                while (left <= right && nums[left] == temp)
                    left++;
            } else if (nums[left] < nums[right]) {
                sum++;
                int temp = nums[left];
                while (left <= right && nums[left] == temp)
                    left++;
            } else {
                sum++;
                int temp = nums[right];
                while (left <= right && nums[right] == temp)
                    right--;
            }
        }
        return sum;
    }

    public int[] findMaxRightWithStack(int[] array) {
        if(array == null) {
            return array;
        }
        int size = array.length;
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        int index = 1;
        while(index < size) {
            if(!stack.isEmpty() && array[index] > array[stack.peek()]) {
                result[stack.pop()] = array[index];
            } else {
                stack.push(index);
                index++;
            }
        }

        if(!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        return result;
    }




}