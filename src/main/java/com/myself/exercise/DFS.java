package com.myself.exercise;

import java.util.*;

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
     * 岛屿数量  695. 岛屿的最大面积 类似解答
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
//        //将陆地改为海洋，防止重复陆地重复遍历。
//        grid[i][j] =0;
//        //遍历上方元素，每遍历一次陆地就加一
//        sum += dfs(grid,i+1,j);
//        //遍历下方元素
//        sum +=dfs(grid,i-1,j);
//        //遍历右边元素
//        sum +=dfs(grid,i,j+1);
//        //遍历左边元素
//        sum += dfs(grid,i,j-1);
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


    static final int SEG_COUNT = 4;
    static List<String> ans = new ArrayList<String>();
    static int[] segments = new int[SEG_COUNT];

    public static List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    public static void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            // 0 - 255
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }

    /**
     * 22. 括号对生成, 回溯法, 类似 全排列写法， 添加不同递归条件
     *
     * @param
     */

    public static List<String> dfsBracket(int n) {
        StringBuilder depth = new StringBuilder();
        ArrayList<String> ans = new ArrayList<>();
        doBracket(ans, depth, 0, 0, n);
        return ans;
    }

    public static void doBracket(List<String> ans, StringBuilder depth, int open, int close, int max) {
        if (depth.length() == max * 2) {
            ans.add(depth.toString());
            return;
        }
        if (open < max) {
            depth.append("(");
            doBracket(ans, depth, open + 1, close, max);
            depth.deleteCharAt(depth.length() - 1);
        }
        if (close < open) {
            depth.append(")");
            doBracket(ans, depth, open, close + 1, max);
            depth.deleteCharAt(depth.length() - 1);
        }
    }

    /**
     * 子集 && 全排列
     *
     * @param
     */
    public static List<List<Integer>> subset(int[] nums) {

        List<List<Integer>> ans = new LinkedList<>();
        doSubset(nums, new LinkedList<>(), nums.length, new boolean[nums.length], ans);
        return ans;
    }

    public static void doSubset(int[] nums, Deque<Integer> depth, int len, boolean[] used, List<List<Integer>> ans) {
        // 入口就 添加，是自己
        ans.add(new ArrayList<>(depth));
        if (depth.size() == len) {
            //递归到结束才保存记录，是全排列¬
            //ans.add(new ArrayList<>(depth));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            depth.addLast(nums[i]);
            doSubset(nums, depth, len, used, ans);
            used[i] = false;
            depth.removeLast();
        }
    }

    /**
     * 32. 组合总和为目标值
     *
     * @param combine list
     */
    public static void dfsSumTarget(int[] nums, int target, List<List<Integer>> ans, Deque<Integer> combine, int depth) {
        if (depth == nums.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        // 直接走到最后, 非 循环写法
        dfsSumTarget(nums, target, ans, combine, depth + 1);
        if (target - nums[depth] >= 0) {
            combine.addLast(nums[depth]);
            // 这里注意 depth 不迭代，代表一直减当前数
            dfsSumTarget(nums, target - nums[depth], ans, combine, depth);
            combine.removeLast();
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 4, 9};
//        int target = 2533;
//        List<Integer> path = new ArrayList<>();
//        Arrays.sort(nums);
//        maxNum(nums, path, target);
//        System.out.println(result);
//        char[][] islands = new char[][]{
//                {'1', '0', '1'},
//                {'1', '1', '0'},
//                {'1', '0', '1'},
//        };
        //List<String> re = restoreIpAddresses("15525511135");
        int[] nums = new int[]{1,2,3};

        List<List<Integer>> ans = new LinkedList<>();
        //dfsSumTarget(nums, 7, ans, new LinkedList<>(), 0);
        //System.out.println(searchIsland(islands));
        System.out.println(Arrays.toString(subset(nums).toArray()));
        //System.out.println(dfsBracket(5));
    }
}
