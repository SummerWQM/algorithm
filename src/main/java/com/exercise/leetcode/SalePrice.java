package com.exercise.leetcode;

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


        System.out.println(SalePrice.maxProfit(prices));
    }

}
