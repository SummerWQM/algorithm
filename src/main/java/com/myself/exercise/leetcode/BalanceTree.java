package com.myself.exercise.leetcode;

/**
 * 检查二叉树是否平衡 （任意节点的两个子树高度相差不超过1）
 * https://leetcode-cn.com/problems/check-balance-lcci/submissions/
 */
public class BalanceTree {

    boolean isBalance = true;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;


        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        DFS(root);
        return isBalance;
    }

    protected int DFS(TreeNode root) {
        if (!isBalance) return 0;

        if (root == null) return 0;

        int left = DFS(root.left);
        int right = DFS(root.right);

        if (Math.abs(left - right) > 1) {
            isBalance = false;
        }

        return Math.max(left, right) + 1;
    }


}
