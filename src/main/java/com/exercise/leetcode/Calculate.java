package com.exercise.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/basic-calculator/solution/ji-ben-ji-suan-qi-by-leetcode-solution-jvir/
 */
public class Calculate {
    public static int calculate(String s) {

        Deque<Integer> ops = new LinkedList<>();

        ops.push(1);

        int sign = 1;

        int ret = 0;

        int n = s.length();

        int i = 0;
//1+(1-3)
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
                // 这里是做运算的展开 符号变化， - 负负 为正，
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign); // 记录符号 方便展开每个数字
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                // 数字字符串转int
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }

        return ret;
    }

    public static void main(String[] a) {
        //  System.out.println( calculate("1+2-(3+8-3)"));


        System.out.println((repackInt(78919)));
    }

    public static int repackInt(int num) {

        int re = 0;
        while (num != 0) {
            int cur = num % 10;
            re = re * 10 + cur;
            num = num / 10;
        }

        return re;
    }


}
