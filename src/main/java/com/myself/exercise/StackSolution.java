package com.myself.exercise;

import java.util.*;

/**
 * 使用堆栈解决的问题
 * 1、二叉树层序遍历，右视图 ，左视图，
 * 2、数组中右边第一个 小于自己的
 * 3、字符串四则运算 etc.
 */
public class StackSolution {

    private static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
    }

    /**
     * 括号是否有效
     */
    public static boolean logicStr(String str) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            // 是右括号就和栈顶比较， 弹出栈
            if (map.containsKey(str.charAt(i))) {
                // 弹出括号对
                char ele = stack.isEmpty() ? '#' : stack.pop();
                if (!map.get(str.charAt(i)).equals(ele)) {
                    return false;
                }
            } else {
                // 压入栈
                stack.push(str.charAt(i));
            }
        }
        //有效括号， 栈为空
        return stack.isEmpty();
    }

    /**
     * 最小栈，
     * 用一个两个 栈，其中一个栈 是最小值，push 一个元素时，同时 计算一个  最小值 压入最小栈
     *
     * @param
     */
    public static void minStack() {
        int x = 1;
        Deque<Integer> xStack = new LinkedList<>();

        Deque<Integer> minStack = new LinkedList<>();

        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));

        xStack.pop();
        minStack.pop();


    }

    /**
     * 239 滑动窗口最大值
     * 使用栈，维护一个递增区间， 并累计窗口K 当为k 时，存储最大值
     *
     * @param nums k
     */

    public static int[] slidMax(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length, i = 0;
        int[] ans = new int[n - k + 1];
        int r = 0;
        while (i < n) {
            // 维护递增序列, while 改成 if 写法 ，看起来是O(N) 写法
            if (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            } else {
                // 移除最大的 窗口外的，超过窗口就一处， 后续 取下一个窗口
                if (!deque.isEmpty() && deque.peek() <= i - k) {
                    deque.pop();
                }
                // 不要使用push  双端队列 push 是放在头
                deque.addLast(i);
                if (!deque.isEmpty() && i >= k - 1) {
                    ans[r++] = nums[deque.peek()];
                }
                i++;
            }
        }

        return ans;
    }



    public static void main(String[] args) {
        int[] re = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(slidMax(re, 3)));
    }
}
