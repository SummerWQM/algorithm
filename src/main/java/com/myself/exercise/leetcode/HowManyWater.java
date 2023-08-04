package com.myself.exercise.leetcode;

/**
 * 42. 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * <p>
 * 输出: 6
 */
public class HowManyWater {
public static Integer maxWater(int[] container) {
        if (container == null || container.length == 0) {
            return 0;
        }

        int[] leftMax = new int[container.length];
        int[] rightMax = new int[container.length];
        int len = container.length - 1;
        int rightM = container[len];
        for (int i = len; i >= 0; i--) {
            if (container[i] > rightM) {
                rightM = container[i];
            }
            rightMax[i] = rightM;
        }
        int leftM = container[0];
        for (int i = 0; i < container.length; i++) {
            if (container[i] > leftM) {
                leftM = container[i];
            }
            leftMax[i] = leftM;
        }
        int sum = 0;
        for (int k = 0; k < container.length; k++) {
            if (leftMax[k] == 0 || rightMax[k] == 0) {
                continue;
            }

            int min = Math.min(leftMax[k], rightMax[k]);
            if (min > container[k]) {
                sum += min - container[k];
            }
        }

        return sum;

    }
}

