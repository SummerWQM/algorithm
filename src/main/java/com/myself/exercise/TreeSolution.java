package com.myself.exercise;

import java.util.*;

public class TreeSolution {

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int value) {
            val = value;
        }
    }


    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        // 左指针大于右指针 越界 返回空
        if (preorder_left > preorder_right) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点
        // 前序遍历 第一个节点 获取根节点值
        int inorder_root = indexMap.get(preorder[preorder_left]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_left]);

        // 得到左子树中的节点数目 （中序遍历 左边 就是左子树）
        int size_left_subtree = inorder_root - inorder_left;

        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree,
                inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right,
                inorder_root + 1, inorder_right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public static TreeNode build(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;

    }

    /**
     * 锯齿，层序遍历二叉树
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> loopLevel(TreeNode root) {
        Queue<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> arr = new LinkedList<>();
        deque.offer(root);
        // 控制从左到右，从右到左
        boolean isLeftOrder = false;
        while (!deque.isEmpty()) {
            Deque<Integer> level = new LinkedList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node == null) {
                    continue;
                }
                // 当前层 从左边后添加， 从前边添加
                if (isLeftOrder) {
                    level.offerLast(node.val);
                } else {
                    level.offerFirst(node.val);
                }
                // 添加下一层 节点 到接下来的层
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            isLeftOrder = !isLeftOrder;
            arr.add(new ArrayList<>(level));
        }
        return arr;
    }

    public static TreeNode buildTree(int[] arr, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = buildTree(arr, left, mid - 1);
        root.right = buildTree(arr, mid + 1, right);
        return root;
    }

    /**
     * 124 路径最大和
     *
     * @param args
     */
    public static int maxRoad = 0;

    public static int maxRoad(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxRoad(root.left), 0);
        int right = Math.max(maxRoad(root.right), 0);
        int pMax = root.val + left + right;
        // 这里记录 全局最大值
        maxRoad = Math.max(maxRoad, pMax);
        // 这里只是返回，最大值的子树 右或左 变最大的。
        return root.val + Math.max(left, right);

    }

    /**
     * 110 平衡二叉树
     *
     * @param
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    /**
     * 101 对称
     * 左1=右2
     * 右1=左2
     *
     * @param
     */
    public static boolean isSymmetric(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;

        return (tree1.val == tree2.val) && isSymmetric(tree1.left, tree2.right)
                && isSymmetric(tree1.right, tree2.left);
    }

    /**
     * 129 根到叶子节点的和
     *
     * @param root
     */
    public static int sumLeafToRoot(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        return dfsRoot(root, 0);
    }

    private static int dfsRoot(TreeNode node, int preSum) {
        if (node == null) {
            return 0;
        }
        int sum = preSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }
        return dfsRoot(node.left, sum) + dfsRoot(node.right, sum);

    }

    /**
     * 543 二叉树直径
     *
     * @param args
     */
    static int ans;

    public static int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public static int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        // 更新数的最大值  + 1 是当前节点
        ans = Math.max(ans, L + R + 1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }

    /**
     * 113 到叶子节点等于目标值
     *
     * @param node
     * @param
     * @param target
     * @param ans
     * @param path
     */
    private static void dfsRoot(TreeNode node, int target, List<List<Integer>> ans, Deque<Integer> path) {
        if (node == null) {
            return;
        }
        path.addLast(node.val);
        target -= +node.val;
        if (node.left == null && node.right == null && target == 0) {
            ans.add(new ArrayList<>(path));
        }
        dfsRoot(node.left, target, ans, path);
        dfsRoot(node.right, target, ans, path);
        path.removeLast();
    }

    /**
     * 112 迭代写法 目标和
     *
     * @param
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //22
        int[] arr = new int[]{5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 5, 1};
        TreeNode root = buildTree(arr, 0, arr.length - 1);
//        Deque<Integer> path = new LinkedList<>();
//        List<List<Integer>> ans = new ArrayList<>();
//        dfsRoot(root, 0, 14, ans, path); 5,4,11,2
        System.out.println(Arrays.toString(loopLevel(root).toArray()));
    }

}
