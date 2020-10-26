package com.exercise.dancebyte;

import java.util.Arrays;

public class Candy {

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;

        int n = ratings.length;

        int[] candy_nums = new int[n];

        Arrays.fill(candy_nums, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy_nums[i] = candy_nums[i - 1] + 1;
            }
        }

        for (int i = n - 1; i > 0; i--) {

            // 这里 递减 序列 要 取 最大值 因为 递增的值 可能 大于  递减序列 + 1 的值。

            // 1 2 3 5 4 3  2  1

            if (ratings[i - 1] > ratings[i]) {
                candy_nums[i - 1] = Math.max(candy_nums[i - 1], candy_nums[i] + 1);
            }
        }

        int re = 0;
        for (int i = 0; i < n; i++) re += candy_nums[i];

        return re;
    }

}
