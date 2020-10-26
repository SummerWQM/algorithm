package com.exercise.dancebyte;

import com.helper.ListNode;

// K 个一组 翻转链表
public class ReverseNode {
    //    public ListNode reverseKGroup(ListNode head, int k) {
//
//        Deque<ListNode> stack = new ArrayDeque<ListNode>();
//        ListNode dummy = new ListNode(0);
//        ListNode p = dummy;
//
//        while (true) {
//            int count = 0;
//            ListNode tmp = head;
//            while (tmp != null && count < k) {
//                stack.add(tmp);
//                tmp = tmp.next;
//                count++;
//            }
//            if (count != k) {
//                p.next = head;
//                break;
//            }
//            while (!stack.isEmpty()) {
//                p.next = stack.pollLast();
//                p = p.next;
//            }
//            p.next = tmp;
//            head = tmp;
//        }
//        return dummy.next;
//    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // 翻转一个链表
    public ListNode reverses(ListNode head) {
        if (head == null) return null;

        ListNode newList = null, node;

        while (head != null) {
            node = head;
            head = head.next;

            node.next = newList;
            newList = node;
        }
        return newList;
    }

}
