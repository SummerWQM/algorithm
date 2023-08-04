package com.myself.exercise.leetcode;

import com.myself.helper.ListNode;

import java.util.HashSet;


public class Solution2 {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode pre = new ListNode(0);

        ListNode cur = pre;

        HashSet<Integer> hashSet = new HashSet<>();


        while (head != null) {

            ListNode next = head.next;

            if (hashSet.add(head.val)) {
                cur.next = head;
                head.next = null;
                cur = head;
            }
            head = next;
        }

        return pre.next;
    }
}
