package com.myself.exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * DP 动态规划类
 * <p>
 * 1、股票买卖收益
 * 2、支付串 A B字符串的，最长公共子序列
 */
public class DP {

    public static int byStockOne(int[] prices) {
        int min = prices[0];
        int re = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                re = Math.max(re, price - min);
            }
        }
        return re;
    }

    public static int byStockOneDp(int[] prices) {
        return 0;
    }

    /**
     * !!!
     * 数组最长上升子序列长度
     *
     * @param nums
     * @return
     */
    //[10,9,2,5,3,7,101,18]  //贪心 + 二分搜索， 不断更新 d[] 数组 ，大于 末尾才 ++ , 否则 不断更新最小值，
    // 最长上升子序列
    // 知道更新完最后一个， 再递增数组d 长度len， 略微向 摩尔投票的思想
    public static int lengthOfLIS(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0]; // // d[1] = 10
        for (int i = 1; i < n; ++i) {
            // d[2] = 9;
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                // 在 d 中 有序的组中， 找 pos  找小于i 的
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，
                // 此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

    /**
     * 动态规划写法， 最长上升子序列
     */
    public static int dpFindUp(int[] nums) {

        int maxLen = 1, n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 取当前节点  或 前一个数最大的 序列 + 1
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    /**
     * 零钱兑换 322
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];

        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // 便利 面值

            for (int coin : coins) {
                if (coin <= i) {
                    // 取 i 个面值，或者 i 减 （1、2、5） 减一个 面值的最小个数 + 1

                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // 72. 最小编辑距离
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;

        // 第一列
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(
                        // 前一个字符， 替换，删除、插入 取最小  + 1
                        Math.min(dp[i - 1][j - 1], dp[i][j - 1]),
                        dp[i - 1][j]
                ) + 1;
            }
        }
        return dp[n1][n2];
    }

    // 64. 最小路径和
    public int minRoad(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length, column = grid[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < column; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][column - 1];
    }

    /**
     * 139 单词拆分
     * <p>
     * dp 思路 判断s 中的每个字符组成的单词是否在 字典中
     */
    public static boolean workBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * 122  买卖股票，多次交易
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：持有现金
        // 1：持有股票
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
        int[][] dp = new int[len][2];
        // 持有现金
        dp[0][0] = 0;
        // 持有股票
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 这两行调换顺序也是可以的
            // 今天持有现金 = 昨天持有现金  昨天持有股票 + 今天卖出价格
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 今天持有股票
            //昨天持有现金  与 昨天持有现金 - 今天持有股票的价格
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    /**
     * 198 打家劫舍 相邻不能偷
     *
     * @param
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 5};

        System.out.println(lengthOfLIS(nums));
        System.out.println(coinChange(nums, 11));

    }

}
