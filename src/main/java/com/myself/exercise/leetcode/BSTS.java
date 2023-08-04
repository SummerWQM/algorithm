package com.myself.exercise.leetcode;


/**
 * https://leetcode-cn.com/problems/successor-lcci/submissions/
 * <p>
 * 寻找中序遍历的后继节点
 */
public class BSTS {

    public static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;

        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        }
        TreeNode left = inorderSuccessor(root.left, p);

        return left != null ? left : root;
    }
}
