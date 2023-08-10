package com.myself.exercise;

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

    public static void main(String[] args) {

        int[] prices = new int[]{1, 2, 3, 1, 6};

        System.out.println(byStockOne(prices));


    }
}
