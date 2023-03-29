package com.exercise.leetcode.tree;

public class BinTree {


    BinTree left;
    BinTree right;

    int val;

    BinTree(int val) {
        this.val = val;
    }

    /**
     * 包含  1-n 个值的搜索二叉树
     *
     * @param
     * @return
     */
    public static BinTree buildTree(int[] arr, int left, int right) {

        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;

        BinTree root = new BinTree(arr[mid]);
        root.left = buildTree(arr, left, mid - 1);
        root.right = buildTree(arr, mid + 1, right);

        return root;
    }

}
