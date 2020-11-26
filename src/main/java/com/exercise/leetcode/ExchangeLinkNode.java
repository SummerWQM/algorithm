package com.exercise.leetcode;

class ExchangeLinkNode {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }
        // Nodes to be swapped
        ListNode secondNode = head.next;

        // Swapping
        head.next = swapPairs(secondNode.next);
        secondNode.next = head;

        // Now the head is the second node
        return secondNode;
    }

}

