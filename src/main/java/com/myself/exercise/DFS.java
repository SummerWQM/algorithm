package com.myself.exercise;

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

    /**
     * 岛屿数量
     * nums = {
     * {'1','0','1','0','0'},
     * {'1','0','1','0','0'},
     * {'1','0','1','0','0'},
     * }
     */
    // 深度标记
    public static void dfsMark(char[][] grid, int r, int c) {
        int rn = grid.length, cn = grid[0].length;
        // 递归出口
        if (r < 0 || c < 0 || r >= rn || c >= cn || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        //上
        dfsMark(grid, r - 1, c);
        // 下
        dfsMark(grid, r + 1, c);
        // 左
        dfsMark(grid, r, c - 1);
        dfsMark(grid, r, c + 1);
    }

    public static int searchIsland(char[][] grid) {
        int r = grid.length, c = grid[0].length;
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfsMark(grid, i, j);
                }
            }
        }
        return count;
    }

    /**
     * 组成最大数
     *
     * @param nums
     * @return
     */
    public static String mergeBigNum(int[] nums) {
        return "";
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 4, 9};
//        int target = 2533;
//        List<Integer> path = new ArrayList<>();
//        Arrays.sort(nums);
//        maxNum(nums, path, target);
//        System.out.println(result);
        char[][] islands = new char[][]{
                {'1', '0', '1'},
                {'1', '1', '0'},
                {'1', '0', '1'},
        };
        System.out.println(searchIsland(islands));
    }
}
