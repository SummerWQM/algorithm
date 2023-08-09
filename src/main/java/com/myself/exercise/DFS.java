package com.myself.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 深度搜索
 * 1、思路
 * -  构建多个树，多叉树.
 * </p>
 */
public class DFS {

    private static Integer result = Integer.MIN_VALUE;

    /**
     * 数组中的数，能组成小于 target 的 最大数
     *
     * @param nums
     * @param target
     * @return
     */
    public static void maxNum(int[] nums, List<Integer> path, int target) {

        int sum = sum(path);
        if (sum < target) {
            result = Math.max(result, sum);
        } else {
            return;
        }
        int len = nums.length;
        // 能重复使用, 所以每次从 0 开始
        for (int num : nums) {
            path.add(num);
            maxNum(nums, path, target);
            path.remove(path.size() - 1);
        }

    }

    public static int sum(List<Integer> list) {
        int r = 0;
        for (Integer integer : list) {
            r = r * 10 + integer;
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 9};
        int target = 2533;
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        maxNum(nums, path, target);
        System.out.println(result);
    }
}
