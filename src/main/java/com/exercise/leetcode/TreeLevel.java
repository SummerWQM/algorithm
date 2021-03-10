package com.exercise.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 二叉树 层序遍历
 */
public class TreeLevel {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    public List<List<Integer>> levelOrder(TreeNode root) {
//
//        List<List<Integer>> result = new ArrayList<>();
//
//        if (root == null) {
//            return result;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            List<Integer> level = new ArrayList<>();
//            int size = queue.size();
//
//            for (int i = 0; i < size; i++) {
//                TreeNode head = queue.poll();
//                level.add(head.val);
//                if (head.left != null) {
//                    queue.offer(head.left);
//                }
//                if (head.right != null) {
//                    queue.offer(head.right);
//                }
//
//            }
//            result.add(level);
//        }
//
//        return result;
//
//    }


    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<List<Integer>> re = new ArrayList<>();

        if (root == null) {
            return re;
        }

        Queue<TreeNode> queue = new LinkedBlockingDeque<>();


        queue.offer(root);

        while (!queue.isEmpty()) {

            List<Integer> item = new ArrayList<>();

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                item.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            re.add(item);
        }
        return re;


    }

}


