package com.myself.exercise.leetcode;

class Help {

public static void main(String[] avg) {
        ListNode node = buildNodes(5);
        System.out.println(printNode(node));
        System.out.println(printNode(reverseKGroup(node, 2)));

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] rever = reverse(head, tail);
            head = rever[0];
            tail = rever[1];

            pre.next = head;
            tail.next = next;
            pre = tail;

            head = next;
        }

        return hair.next;

    }

    public static ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode p = head;
        while (pre != tail) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return new ListNode[]{tail, head};
    }


    public static class ListNode {
        ListNode next;
        int val;

        ListNode(int v) {
            val = v;
        }
    }

    public static ListNode buildNodes(int k) {
        ListNode head = new ListNode(k--);
        ListNode cur = head;
        while (k > 0) {
            cur.next = new ListNode(k--);
            cur = cur.next;
        }
        return head;
    }

    public static String printNode(ListNode head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            if (head.next != null) {
                builder.append(head.val).append("->");
            } else {
                builder.append(head.val);
            }
            head = head.next;
        }
        return builder.toString();
    }



}
