package com.exercise;

class StockSolution {
    /*
     * 股票类
     */
// 交易一次， 一天买，另一天卖
    public static void main(String[] avg) {
        int[] prices = new int[]{1, 2, 3, 4};

        System.out.println(by(prices));
    }

    public static int by(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int ans = 0, min = prices[0];
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                ans = Math.max(price - min, ans);
            }
        }
        return ans;
    }


    // 可多次买卖
    public static int by2(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - nums[i]);
        }

        return dp[n - 1][0];
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

}