package com.exercise.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 深度优先遍历 计算
 * ((( )))
 * n 个合法括号的不同排列
 */
class ValidBracket {
    List<String> result;

    public List<String> generateParenthesis(int n) {
        this.result = new ArrayList<>();
        this.DFS(n, n, "");


        return this.result;
    }

    protected void DFS(int left, int right, String s) {

        if (left == 0 && right == 0) {
            this.result.add(s);
            return;
        }
        if (left > 0) {
            DFS(left - 1, right, s + "(");
        }
        if (right > left) {
            DFS(left, right - 1, s + ")");
        }
    }


    public static void main(String[] avg) {

        System.out.println(strStr("abcc","ccc")  );
    }


    public static int strStr(String s, String p) {

        int n = s.length(), m = p.length();

        char[] s1 = s.toCharArray(), p1 = p.toCharArray();

        for (int i = 0; i <= n - m; i++) {

            int start = i, find = 0;

            while (find < m  && s1[start] == p1[find]) {
                start++;
                find++;
            }

            if (find == m) {
                return i;
            }


        }

        return -1;


    }

}