package com.myself.exercise.leetcode;

import java.util.*;

/**
 * https://leetcode.cn/problems/combination-sum-ii/submissions/
 * <p>
 * 组合数、组合数二
 */
public class Combination {


    // 不重复的组合
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Deque<Integer> path = new LinkedList<>();

        List<List<Integer>> ans = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        dfs(candidates, 0, target, path, ans);
        return ans;
    }

    public void dfs(int[] nums, int begin, int target, Deque<Integer> path, List<List<Integer>> ans) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < nums.length; i++) {

            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);

            dfs(nums, i + 1, target - nums[i], path, ans);
            path.removeLast();
        }
    }


    /**
     * 组合数，可以重复使用,得到目标值组合
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Deque<Integer> path = new LinkedList<>();

        List<List<Integer>> ans = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        dfs2(candidates, 0, target, path, ans);
        return ans;
    }

    public void dfs2(int[] nums, int begin, int target, Deque<Integer> path, List<List<Integer>> ans) {

        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            path.addLast(nums[i]);
            dfs2(nums, i, target - nums[i], path, ans);
            path.removeLast();
        }


    }



    public int searchV2(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }


}
