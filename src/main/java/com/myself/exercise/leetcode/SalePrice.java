package com.myself.exercise.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 股票的最佳卖出点
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class SalePrice {
    public static int maxProfit(int[] prices) {
        int min = prices[0];

        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }

        return max;


    }

    public static void main(String[] avg) {
        int[] prices = new int[]{1, 2};

        Map<String, Integer> map = new HashMap<>();

        map.put("1", 1);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.forEach((k, v) -> {
            if (v ==4) {
                return;
            }
            System.out.println(v);
        });

        //System.out.println(SalePrice.maxProfit(prices));
    }

    /*
     *https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     * 可以交易多次的麦盖股票
     *
     * 贪心算法
     */

    public int max(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {

            int dif = prices[i] - prices[i - 1];
            if (dif > 0) {
                ans += dif;
            }
        }

        return ans;

    }




}
