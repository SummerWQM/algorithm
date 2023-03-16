package com.exercise.leetcode;

import java.util.Arrays;
import java.util.Stack;


public class Array {

    // 右边第一个大于当前数的值
    public static int[] find(int[] array) {
        if (array == null) {
            return array;
        }
        int size = array.length;
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int index = 1;

        while (index < size) {
            if (!stack.isEmpty() && array[index] > array[stack.peek()]) {
                result[stack.pop()] = array[index];
            } else {
                stack.push(index);
                index++;
            }
        }

        if (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        return result;
    }

    public static void main(String[] avg) {
        int[] nums = new int[]{8, 2, 5, 4, 3, 9, 7, 2, 5};
        System.out.println(Arrays.toString(find(nums)));
    }


}
