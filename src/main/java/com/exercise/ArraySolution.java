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

    public static void main(String[] avg) {

        int[] nums = new int[]{8, 2, 3, 4, 5, 1, 3, 9, 0};

        Stack<Integer> stack = new Stack<>();

        System.out.println(Arrays.toString(find(nums)));

    }

    // 找出数组 右边第一个 大于自己的数
    public static int[] find(int[] nums) {

        int[] re = new int[nums.length];

        int index = 0, size = nums.length;

        Stack<Integer> stack = new Stack<>();
        while (index < size) {
            // 如索引果入栈的元素  大于栈顶， 就 自选把栈 里的小于自己的 都压入栈
            if (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                re[stack.pop()] = nums[index];
            } else {
                stack.push(index++);
            }

        }
        // 最后都没 出栈的 说明后边没有大于自己的。
        while (!stack.isEmpty()) {
            re[stack.pop()] = -1;
        }

        return re;

    }


}