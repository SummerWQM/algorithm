package com.exercise.leetcode;

/**
 * 1000 个苹果随机装箱 10个，使得 每个任意 1000 以内的苹果数量
 * 都能用 每个箱子的组合相加 或者 单个箱子的数量而来。
 * <p>
 * 1 2  4 8 16 32 64  刚好是 1 + 2 ~ 2 ^ 10 - 24  这个数列满足要求。
 * <p>
 * 计算出满足条件的装箱方式
 */
public class RandomPut {

    public int[] packageApple(int[] A) {
        if((A[i]&1)!=1) {
            while((A[j]&1)==0) {
                j+=2;
            }
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }

    }

}

