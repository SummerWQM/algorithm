package com.myself.exercise.leetcode;

/**
 * <p>
 * 摩尔投票的解法
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例1:
 * <p>
 * <p>
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * <p>
 * 输出: 2
 * 限制：
 * <p>
 * <p>
 * <p>
 * 1 <= 数组长度 <= 50000
 */
public class MolVote {

    public int getNum(int[] arr) {

        int num = arr[0];
        int p = 1;
        for (int i = 1; i < arr.length; i++) {
            if (num == arr[i]) {
                p++;
            } else {
                p--;
                if (p <= 0) {
                    p = 1;
                    num = arr[i];
                }
            }
        }
        return num;
    }

    public static void main(String[] avg) {

        MolVote m = new MolVote();

        int[] arr = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};

        System.out.println(m.getNum(arr));
    }
}



