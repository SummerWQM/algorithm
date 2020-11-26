package com.exercise.leetcode;


/**
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class Palindrome {

    public boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;

        // 当 x < = 则已经反转一半 停止 反转 避免越界

        while (x > revertedNumber) {

            revertedNumber = revertedNumber * 10 + x % 10;

            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }

}
