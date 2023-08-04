package com.myself.exercise.leetcode;


/**
 * 删除倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd {


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }
        ListNode h1 = head;
        ListNode h2 = head;
        ListNode pre = head;

        for (int i = 0; i < n; i++) {
            h1 = h1.next;
        }

        while (h1 != null) {
            h1 = h1.next;
            pre = h2;
            h2 = h2.next;
        }
        if (pre == h2) {
            return h2.next;
        }
        pre.next = h2.next;
        return head;
    }


    public ListNode removeV2(ListNode head, int n) {

        ListNode pre = new ListNode(0, head);

        ListNode first = head;
        ListNode second = pre;

        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return pre.next;
    }

}