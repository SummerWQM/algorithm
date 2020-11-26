package com.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

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

}