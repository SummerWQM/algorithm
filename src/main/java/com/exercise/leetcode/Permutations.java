package com.exercise.leetcode;


import com.google.gson.Gson;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 全排列
 * https://leetcode.cn/problems/permutations/
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];

        dfs(nums, len, 0, path, used, res);
        return res;
    }


    private void dfs(int[] nums, int len, int depath, Deque<Integer> path, boolean[] used
            , List<List<Integer>> res) {

        if (depath == len) {
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depath + 1, path, used, res);

            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] avg) {


        Permutations per = new Permutations();


        int[] nums = new int[]{1, 2, 3};


        List<List<Integer>> res = per.permute(nums);

        res.forEach(
                (i) -> {

                    Gson gson = new Gson();
                    System.out.println(gson.toJson(i));

                }
        );

    }

}
