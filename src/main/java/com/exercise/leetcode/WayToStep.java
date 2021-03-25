package com.exercise.leetcode;


/**
 * 假设有n个台阶：
 * <p>
 * 当 n=0，即没有台阶时 走法为0
 * 当 n=1，台阶为1时 走法为1
 * 当 n=2，台阶为2时 走法为2：一步一步 ， 两步
 * <p>
 * 第 n 阶 =   n-1 一步走到 n 获取 n-2 两阶走到 n
 * d(n) = d(n-1) + d(n-2)
 */
public class WayToStep {

    public int waysToStep(int n) {

        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < n + 1; i++) {
            //取模，对两个较大的数之和取模再对整体取模，防止越界（这里也是有讲究的）
            //假如对三个dp[i-n]都 % 1000000007，那么也是会出现越界情况（导致溢出变为负数的问题）
            //因为如果本来三个dp[i-n]都接近 1000000007 那么取模后仍然不变，但三个相加则溢出
            //但对两个较大的dp[i-n]:dp[i-2],dp[i-3]之和mod 1000000007，那么这两个较大的数相加大于 1000000007但又不溢出
            //取模后变成一个很小的数，与dp[i-1]相加也不溢出
            //所以取模操作也需要仔细分析
            dp[i] = (dp[i - 1] + (dp[i - 2] + dp[i - 3]) % 1000000007) % 1000000007;
        }
        return dp[n];

    }


    public static void main(String[] a) {

        WayToStep way = new WayToStep();


        System.out.println(way.waysToStep(2));

    }
}
