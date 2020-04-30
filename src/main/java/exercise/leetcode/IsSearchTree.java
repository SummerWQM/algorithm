package exercise.leetcode;

/**
 * @ https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/submissions/
 * 是二分搜索树判断
 * <p>
 * 核心:
 * 中序遍历数，判断左右节点
 * <p>
 * 左边的值 一定小于 右边的值
 * <p>
 * 判断顺序 保留 最大的值  分别和  中间节点、 有节点 比较  都必须是大约 pre 前边的值。
 * <p>
 * <p>
 * 这不能中等难度的题了  这么一想 太简单了。
 */
public class IsSearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean isBalance = true;

    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        DFS(root);
        return isBalance;
    }

    protected void DFS(TreeNode root) {
        if (!isBalance) return;

        if (root == null) return;

        DFS(root.left);
        if (root.val > pre) {
            pre = root.val;
        } else {
            isBalance = false;
        }
        DFS(root.right);
    }

    protected void preDFS(TreeNode treeNode) {

        if (treeNode == null) return;
        System.out.println(treeNode.val);
        preDFS(treeNode.left);
        preDFS(treeNode.right);
    }

    protected void lastDFS(TreeNode treeNode) {
        if (treeNode == null) return;
        preDFS(treeNode.left);
        preDFS(treeNode.right);
        System.out.println(treeNode.val);
    }



}
