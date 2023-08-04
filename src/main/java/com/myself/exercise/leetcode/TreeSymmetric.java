package com.myself.exercise.leetcode;

/**
 * 对称二叉树
 */
public class TreeSymmetric {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode treeNode) {
        return symmetric(treeNode, treeNode);
    }

    /**
     * 判断 左树的左子树=右树的 右子树
     * 左数的右子树=有树的左子树
     *
     * @param tree1
     * @param tree2
     * @return
     */
    protected boolean symmetric(TreeNode tree1, TreeNode tree2) {

        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;

        return (tree1.val == tree2.val) && symmetric(tree1.left, tree2.right)
                && symmetric(tree1.right, tree2.left);

    }
}
