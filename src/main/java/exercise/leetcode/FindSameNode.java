package exercise.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 * 寻找 二叉树中 两个数的相同节点并输出
 */
public class FindSameNode {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        if (original == null) return null;

        if (original == target) {
            return cloned;
        }
        TreeNode res = getTargetCopy(original.left, cloned.left, target);
        if (res != null) {
            return res;
        }

        TreeNode resr = getTargetCopy(original.right, cloned.right, target);

        if (resr != null) {
            return resr;
        }
        return null;
    }


    // 非递归解答

    // linked List 在最后添加新节点 和 取出 第一个节点 复杂度 都是O(1) 因为源代码数据结构  保存了 last  fist 的指针
    public final TreeNode getTargetCopy1(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        Deque<TreeNode> stack = new LinkedList<>();

        Deque<TreeNode> clonedStack = new LinkedList<>();

        TreeNode node = original;
        TreeNode cloneTarget = cloned;

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                if (node == target) {
                    return cloneTarget;
                }
                // 保存队列之前 处理了 这个left 节点。
                // 把当前节点存入队列 是为了 取右节点。
                // 所以 非递归 解决的问题是 右节点的 存储和取出问题。
                // node 为空的情况 就是 left 节点结束的时候。
                // 这里判断了当前节点 和处理 left 节点
                stack.push(node);
                node = node.left;
                clonedStack.push(cloneTarget);
                cloneTarget = cloneTarget.left;
                // 先到达所有的左边节点 node.left 最后节点 肯定为 null. 这个时候node 为空。

            } else {
                node = stack.pop();
                //弹出第一个进入对列的 取 右边节点 再进行判断
                node = node.right; // 取右边节点 因为 左边和 当前node 节点已经处理过
                cloneTarget = clonedStack.pop();
                cloneTarget = cloneTarget.right;
            }
        }
        return null;
    }


}
