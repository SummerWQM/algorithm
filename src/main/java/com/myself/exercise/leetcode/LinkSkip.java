package com.myself.exercise.leetcode;

import java.util.Stack;

// 返回倒数第 K 个节点 开始的链表
public class LinkSkip {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode getKthFromEnd(ListNode head, int k) {

        Stack<ListNode> stack = new Stack<>();

        ListNode tmp = head;

        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        for (int i = 1; i <= k; i++) {
            ListNode node = stack.pop();
            if (i == k) {
                return node;
            }
        }
        return null;
    }

    public ListNode getKthFromEndV2(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode head1 = head;

        int i = 0;

        while (head1.next != null) {
            head1 = head1.next;
            i++;
            if (i >= k) {
                head = head.next;
            }
        }
        return head;

    }

    public ListNode getKthFromEndV3(ListNode head, int k) {
        ListNode former = head, latter = head;

        // 先走 k 步
        for (int i = 0; i < k; i++) {
            if (former == null) return null;
            former = former.next;
        }

        // 再一起走
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }

        return latter;

    }

}
