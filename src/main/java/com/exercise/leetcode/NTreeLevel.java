package com.exercise.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N 叉树程序便利
 */
/*
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public List<Node> children;
 * <p>
 * public Node() {}
 * <p>
 * public Node(int _val) {
 * val = _val;
 * }
 * <p>
 * public Node(int _val, List<Node> _children) {
 * val = _val;
 * children = _children;
 * }
 * };
 */


public class NTreeLevel {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<Integer>();
            int curLevelLen = queue.size();
            for (int i = 1; i <= curLevelLen; ++i) {
                Node node = queue.poll();
                curLevel.add(node.val);
                // 多叉树 吧 同一层的儿子 全部添加进去 完事。
                queue.addAll(node.children);
            }
            res.add(curLevel);
        }
        return res;
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};