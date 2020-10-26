package com.exercise.leetcode;


import java.util.Stack;

public class LinkReversePrint {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public int[] reversePrint(ListNode head) {

        if (head == null) {
            return new int[]{};
        }
        if (head.next == null) {
            return new int[]{head.val};
        }

        int[] val = reversePrint(head.next);
        int[] re = new int[val.length + 1];

        System.arraycopy(val, 0, re, 0, val.length);
        re[re.length - 1] = head.val;

        return re;
    }

    // 栈是线程安全的操作，通过如栈出栈，来控制打印顺序;
    public int[] reversPrintV2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode tmp = head;

        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }

        int[] re = new int[stack.size()];

        for (int i = 0; i < re.length; i++) {
            re[i] = stack.pop().val;
        }
        return re;
    }

}
