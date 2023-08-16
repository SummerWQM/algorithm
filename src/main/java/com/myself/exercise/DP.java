package com.myself.exercise;

import java.util.Arrays;

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
                price = min;
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


    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 5};

        System.out.println(lengthOfLIS(nums));
        System.out.println(coinChange(nums, 11));

    }

}
